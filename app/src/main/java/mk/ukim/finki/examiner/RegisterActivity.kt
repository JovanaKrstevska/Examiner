package mk.ukim.finki.examiner

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import mk.ukim.finki.examiner.viewmodels.RegisterViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var nameAndsurname: EditText
    private lateinit var email: EditText
    private lateinit var passord: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var photo: ImageView
    private lateinit var btnGoToDashboardActivity: Button
    private lateinit var auth: FirebaseAuth

//    private lateinit var registerViewModel: RegisterViewModel

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val Intent: Intent = Intent(applicationContext, DashBoardActivity::class.java)
            startActivity(Intent)
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

//        registerViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        btnGoToDashboardActivity.setOnClickListener {
//            registerViewModel.selectNameAndSurname(nameAndsurname.text.toString())
//            registerViewModel.selectEmail(email.text.toString())
//            registerViewModel.selectPassword(passord.text.toString())
//            registerViewModel.selectConfirmPassword(confirmPassword.text.toString())
            val userNameAndSurname: String = nameAndsurname.text.toString()
            val userEmail : String = email.text.toString()
            val userPassword : String = passord.text.toString()
            val userConfirmPassword : String = confirmPassword.text.toString()
            if(TextUtils.isEmpty(userNameAndSurname)){
                Toast.makeText(this, "Enter First and Lat name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(userEmail)){
                Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(userPassword)){
                Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(userConfirmPassword)){
                Toast.makeText(this, "Enter confirm password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            auth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Account created.", Toast.LENGTH_SHORT).show()
                        val Intent: Intent = Intent(applicationContext, DashBoardActivity::class.java)
                        startActivity(Intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}