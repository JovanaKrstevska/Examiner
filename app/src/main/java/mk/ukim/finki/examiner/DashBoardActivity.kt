package mk.ukim.finki.examiner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.squareup.picasso.Picasso

class DashBoardActivity : AppCompatActivity() {

    private lateinit var btnGoToLogOut: Button
    private lateinit var user: FirebaseUser
    private lateinit var userName: String
    private lateinit var image: ImageView
    private lateinit var predmetImage1: ImageView
    private lateinit var predmetImage2: ImageView
    private lateinit var predmetImage3: ImageView
    private lateinit var predmetImage4: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        btnGoToLogOut = findViewById(R.id.btnGoLogOut)
        image = findViewById(R.id.uploadPhoto)
        predmetImage1 = findViewById(R.id.predmet1)
        predmetImage2 = findViewById(R.id.predmet2)
        predmetImage3 = findViewById(R.id.predmet3)
        predmetImage4 = findViewById(R.id.predmet4)
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

        predmetImage1.setOnClickListener{
            val intent = Intent(applicationContext, AreYouReadyActivity::class.java)
            intent.putExtra("kluc", "mpp")
            startActivity(intent)
            finish()
        }
        predmetImage2.setOnClickListener{
            val intent = Intent(applicationContext, AreYouReadyActivity::class.java)
            intent.putExtra("kluc", "uip")
            startActivity(intent)
            finish()
        }
        predmetImage3.setOnClickListener{
            val intent = Intent(applicationContext, AreYouReadyActivity::class.java)
            intent.putExtra("kluc", "evlada")
            startActivity(intent)
            finish()
        }
        predmetImage4.setOnClickListener{
            val intent = Intent(applicationContext, AreYouReadyActivity::class.java)
            intent.putExtra("kluc", "biz")
            startActivity(intent)
            finish()
        }
    }
}

