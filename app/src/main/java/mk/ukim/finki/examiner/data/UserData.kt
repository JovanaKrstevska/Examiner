package mk.ukim.finki.examiner.data

data class UserData(
    val nameAndSurname:String,
    val email:String,
    val password:String,
    val confirmPassword:String,
    val photoURL:String
)
