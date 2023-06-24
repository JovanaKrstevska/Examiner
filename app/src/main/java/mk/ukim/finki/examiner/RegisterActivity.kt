package mk.ukim.finki.examiner

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import mk.ukim.finki.examiner.data.UserData
import mk.ukim.finki.examiner.viewmodels.RegisterViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var nameAndsurname: EditText
    private lateinit var email: EditText
    private lateinit var passord: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var photo: ImageView
    private lateinit var imageURL: String
    private lateinit var uri: Uri
    private lateinit var btnGoToDashboardActivity: Button
    private lateinit var auth: FirebaseAuth

    private val registerViewModel: RegisterViewModel by viewModels()

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent(applicationContext, DashBoardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        nameAndsurname = findViewById(R.id.writeFirstAndLastName)
        email = findViewById(R.id.writeEmail)
        passord = findViewById(R.id.writePassword)
        confirmPassword = findViewById(R.id.confirmPassword)
        photo = findViewById(R.id.uploadPhoto)
        btnGoToDashboardActivity = findViewById(R.id.btnGoToDashboardActivity)
        auth = Firebase.auth

        val activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val Data: Intent? = result.data
                uri = Data?.data!!
                photo.setImageURI(uri)
            } else {
                Toast.makeText(this, "No Image Selected", Toast.LENGTH_SHORT).show()
            }
        }
        photo.setOnClickListener{
            val photoPicker:Intent = Intent(Intent.ACTION_PICK)
            photoPicker.type = "image/*"
            activityResultLauncher.launch(photoPicker)
        }

        btnGoToDashboardActivity.setOnClickListener {
            registerViewModel.selectNameAndSurname(nameAndsurname.text.toString())
            registerViewModel.selectEmail(email.text.toString())
            registerViewModel.selectPassword(passord.text.toString())
            registerViewModel.selectConfirmPassword(confirmPassword.text.toString())
                CreateAccount()
                SaveData()

        }
        registerViewModel.nameSurname.observe(this){
            if(nameAndsurname.text.toString() !=it){
                nameAndsurname.setText(it)
            }
        }
        registerViewModel.email.observe(this){
            if(email.text.toString() !=it){
                email.setText(it)
            }
        }
        registerViewModel.password.observe(this){
            if(passord.text.toString() !=it){
                passord.setText(it)
            }
        }
        registerViewModel.confirmPassword.observe(this){
            if(confirmPassword.text.toString() !=it){
                confirmPassword.setText(it)
            }
        }
    }

    fun CreateAccount(){
        val userNameAndSurname: String = nameAndsurname.text.toString()
        val userEmail : String = email.text.toString()
        val userPassword : String = passord.text.toString()
        val userConfirmPassword : String = confirmPassword.text.toString()

        if(TextUtils.isEmpty(userNameAndSurname)){
            Toast.makeText(this, "Enter First and Lat name", Toast.LENGTH_SHORT).show()
        }else if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show()
        }else if(TextUtils.isEmpty(userPassword)){
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show()
        } else if(TextUtils.isEmpty(userConfirmPassword)){
            Toast.makeText(this, "Enter confirm password", Toast.LENGTH_SHORT).show()
        } else if(userPassword!=userConfirmPassword){
            Toast.makeText(this, "Confirm password not match", Toast.LENGTH_SHORT).show()
        } else {
            auth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val storageReference =
                            uri.lastPathSegment?.let {
                                FirebaseStorage.getInstance().reference.child("Android Images").child(it)
                            }
                        storageReference?.putFile(uri)?.addOnSuccessListener {
                            val uriTask: Task<Uri> = it.storage.downloadUrl
                            while (!uriTask.isComplete);
                            val urlImage: Uri? = uriTask.result
                            imageURL = urlImage.toString()
                            val profileUpdate = userProfileChangeRequest {
                                displayName = userNameAndSurname
                                photoUri = Uri.parse(imageURL)
                            }
                            val user: FirebaseUser? = auth.currentUser
                            user!!.updateProfile(profileUpdate).addOnSuccessListener {
                                Toast.makeText(this, "Account created.", Toast.LENGTH_SHORT).show()
                                val intent = Intent(applicationContext, DashBoardActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                        }
                    } else {
                        Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
      fun SaveData(){
          val password:String = passord.text.toString()
          val confirm:String = confirmPassword.text.toString()
            val storageReference =
                uri.lastPathSegment?.let {
                    FirebaseStorage.getInstance().reference.child("Android Images").child(it)
                }
          if(password!=confirm){
              return
          } else {
              storageReference?.putFile(uri)?.addOnSuccessListener {
                  val uriTask: Task<Uri> = it.storage.downloadUrl
                  while (!uriTask.isComplete);
                  val urlImage: Uri? = uriTask.result
                  imageURL = urlImage.toString()
              }
          }
    }
}