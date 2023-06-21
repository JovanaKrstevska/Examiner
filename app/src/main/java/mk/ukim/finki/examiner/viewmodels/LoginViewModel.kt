package mk.ukim.finki.examiner.viewmodels

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val mutubleEmail = MutableLiveData<String>()
    private val mutublePassword = MutableLiveData<String>()

    val email: LiveData<String> get() = mutubleEmail
    val password: LiveData<String> get() = mutublePassword

    fun selectEmail(email: String){
        this.mutubleEmail.value = email;
    }
    fun selectPassword(password: String){
        this.mutublePassword.value = password;
    }
}