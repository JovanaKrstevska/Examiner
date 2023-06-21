package mk.ukim.finki.examiner

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class DashBoardActivity : AppCompatActivity() {

    private lateinit var btnGoToLogOut: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var user: FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        btnGoToLogOut = findViewById(R.id.btnGoLogOut)
        auth = Firebase.auth
        user = auth.currentUser!!
        if(user == null){
            val Intent: Intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(Intent)
            finish()
        }
        btnGoToLogOut.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val Intent: Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(Intent)
            finish()
        }
    }
}

