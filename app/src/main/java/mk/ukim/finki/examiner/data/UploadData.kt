package mk.ukim.finki.examiner.data


data class UploadData(
    val fullName: String?,
    val email: String?,
    val points: Int,
    val status: String,
    val ocenka: Int
)