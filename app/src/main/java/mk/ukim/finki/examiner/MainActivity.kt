package mk.ukim.finki.examiner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import mk.ukim.finki.examiner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var btnGoToRegisterActivity: Button
    private lateinit var btnGoToLogInActivity: Button
    private lateinit var btnSignWithGoogle: ImageView
    private lateinit var client: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGoToRegisterActivity = findViewById(R.id.btnGoToRegisterActivity)
        btnGoToLogInActivity = findViewById(R.id.btnGoToLogInActivity)
        btnSignWithGoogle = findViewById(R.id.btnSignWithGoogle)


        btnGoToRegisterActivity.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        btnGoToLogInActivity.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        //Konfiguracija Google sign in
        val signInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        //Kreiranje na GoogleSignInCLient so koristenje na signInOptions
        client = GoogleSignIn.getClient(this, signInOptions)
        //Pravime signOut na client
        client.signOut()

        btnSignWithGoogle.setOnClickListener{
            val intent = client.signInIntent
            startActivityForResult(intent, 10001)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==10001){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val account = task.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener {task ->
                    if(task.isSuccessful){
                        Toast.makeText(applicationContext, "SignIn Successful.", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, DashBoardActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
    override fun onStart() {
        super.onStart()
        if(FirebaseAuth.getInstance().currentUser != null){
            val intent = Intent(this, DashBoardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}