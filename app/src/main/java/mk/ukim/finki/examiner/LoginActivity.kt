package mk.ukim.finki.examiner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var btnGoToDaschboardActivity: Button
    private lateinit var auth: FirebaseAuth

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val Intent:Intent = Intent(applicationContext, DashBoardActivity::class.java)
            startActivity(Intent)
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
                        val Intent:Intent = Intent(applicationContext, DashBoardActivity::class.java)
                        startActivity(Intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }
}

