package mk.ukim.finki.examiner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import android.widget.Button
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mk.ukim.finki.examiner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var btnGoToRegisterActivity: Button
    private lateinit var btnGoToLogInActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGoToRegisterActivity = findViewById(R.id.btnGoToRegisterActivity)
        btnGoToLogInActivity = findViewById(R.id.btnGoToLogInActivity)

        btnGoToRegisterActivity.setOnClickListener{
            val Intent:Intent = Intent(this, RegisterActivity::class.java)
            startActivity(Intent)
        }
        btnGoToLogInActivity.setOnClickListener{
            val Intent:Intent = Intent(this, LoginActivity::class.java)
            startActivity(Intent)
        }
    }
}