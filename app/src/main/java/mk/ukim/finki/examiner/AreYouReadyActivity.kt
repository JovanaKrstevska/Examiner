package mk.ukim.finki.examiner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.commit
import mk.ukim.finki.examiner.fragments.Predmet1Fragment

class AreYouReadyActivity : AppCompatActivity() {

    private lateinit var btnStart: Button
    private lateinit var btnQuit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_are_you_ready)

        btnStart = findViewById(R.id.btnGoStart)
        btnQuit = findViewById(R.id.btnGoQuit)


        btnStart.setOnClickListener {
            val intent = Intent(applicationContext, FragmentPlaceActivity::class.java)
            intent.putExtra("kluc", this.intent.extras?.getString("kluc"))
            startActivity(intent)
            finish()
        }

        btnQuit.setOnClickListener{
            val intent = Intent(applicationContext, DashBoardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}