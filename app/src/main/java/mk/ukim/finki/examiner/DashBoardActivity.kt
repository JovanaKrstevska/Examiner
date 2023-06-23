package mk.ukim.finki.examiner

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso
import mk.ukim.finki.examiner.data.UserData

class DashBoardActivity : AppCompatActivity() {

    private lateinit var btnGoToLogOut: Button
    private lateinit var user: FirebaseUser
    private lateinit var userName: String
    private lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        btnGoToLogOut = findViewById(R.id.btnGoLogOut)
        image = findViewById(R.id.uploadPhoto)
        user = FirebaseAuth.getInstance().currentUser!!
        userName = user.displayName.toString()
        Picasso.get().load(user.photoUrl).into(image)

        if(user == null){
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        btnGoToLogOut.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

