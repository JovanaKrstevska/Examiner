package mk.ukim.finki.examiner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import android.widget.Button
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import mk.ukim.finki.examiner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var btnGoToRegisterActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGoToRegisterActivity = findViewById(R.id.btnGoToRegisterActivity)

        btnGoToRegisterActivity.setOnClickListener{
            val Intent:Intent = Intent(this, RegisterActivity::class.java)
            startActivity(Intent)
        }
    }
}