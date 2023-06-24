package mk.ukim.finki.examiner.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    private val mutubleNameAndSurname = MutableLiveData<String>()
    private val mutubleEmail = MutableLiveData<String>()
    private val mutublePassword = MutableLiveData<String>()
    private val mutubleConfirmPassword = MutableLiveData<String>()

    val email: LiveData<String> get() = mutubleEmail
    val password: LiveData<String> get() = mutublePassword
    val confirmPassword: LiveData<String> get() = mutubleConfirmPassword
    val nameSurname: LiveData<String> get() = mutubleNameAndSurname

    fun selectEmail(email: String){
        this.mutubleEmail.value = email;
    }
    fun selectPassword(password: String){
        this.mutublePassword.value = password;
    }
    fun selectConfirmPassword(confirmPassword: String){
        this.mutubleConfirmPassword.value = confirmPassword;
    }
    fun selectNameAndSurname(nameSurname: String){
        this.mutubleNameAndSurname.value = nameSurname;
    }
}