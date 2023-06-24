package mk.ukim.finki.examiner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import mk.ukim.finki.examiner.viewmodels.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var btnGoToDaschboardActivity: Button
    private lateinit var auth: FirebaseAuth

    private val loginViewModel: LoginViewModel by viewModels()

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
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.writeYourEmail)
        password = findViewById(R.id.writeYourPassword)
        btnGoToDaschboardActivity = findViewById(R.id.btnGoToDaschboardActivity)
        auth = Firebase.auth

        btnGoToDaschboardActivity.setOnClickListener {
            val userEmail : String = email.text.toString()
            val userPassword : String = password.text.toString()

            loginViewModel.selectEmail(email.text.toString())
            loginViewModel.selectPassword(password.text.toString())

            if(TextUtils.isEmpty(userEmail)){
                Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(userPassword)){
                Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(applicationContext, "Login Successful.", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, DashBoardActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }

        }
        loginViewModel.email.observe(this){
            if(email.text.toString() != it){
                email.setText(it)
            }
        }
        loginViewModel.password.observe(this){
            if(password.text.toString() != it){
                password.setText(it)
            }
        }
    }
}

