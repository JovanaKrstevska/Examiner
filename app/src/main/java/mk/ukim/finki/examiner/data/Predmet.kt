package mk.ukim.finki.examiner.data

data class Predmet(
    val prasanje:String,
    val odgovor1:String,
    val odgovor2:String,
    val odgovor3:String,
    val tocenOdgovor:String? = ""
)