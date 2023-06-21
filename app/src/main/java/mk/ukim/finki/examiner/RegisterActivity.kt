package mk.ukim.finki.examiner

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class RegisterActivity : AppCompatActivity() {
    private lateinit var nameAndsurname: EditText
    private lateinit var email: EditText
    private lateinit var passord: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var photo: ImageView
    private lateinit var btnGoToDashboardActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        nameAndsurname = findViewById(R.id.writeFirstAndLastName)
        email = findViewById(R.id.writeEmail)
        passord = findViewById(R.id.writePassword)
        confirmPassword = findViewById(R.id.confirmPassword)
        photo = findViewById(R.id.uploadPhoto)
        btnGoToDashboardActivity = findViewById(R.id.btnGoToDashboardActivity)
    }

}