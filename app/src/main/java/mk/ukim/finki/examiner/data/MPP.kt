package mk.ukim.finki.examiner.data

fun mppList(): MutableList<Predmet>{
    return mutableListOf(

        Predmet(
            prasanje = "doingBakground() кај AsyncTask се извршува на:",
            odgovor1 = "нов thread",  //tocen odgovor
            odgovor2 = "не постои таков метод",
            odgovor3 = "main thread",
            tocenOdgovor = "нов thread"
        ),
        Predmet(
            prasanje = "Што претставува ANR за една Android апликација",
            odgovor1 = "Application Not Responding",   //tocen odgovor
            odgovor2 = "Annoying and Not Responding",
            odgovor3 = "Application Needs Response",
            tocenOdgovor = "Application Not Responding"
        ),
        Predmet(
            prasanje = "Shared preferences се користи кога:",
            odgovor1 = "Комуникација меѓу thread-ови",
            odgovor2 = "Имаме податоци под 10MB",
            odgovor3 = "Имаме малку податоци од примитивен тип", //tocen odgovor
            tocenOdgovor = "Имаме малку податоци од примитивен тип"
        ),
        Predmet(
            prasanje = "Кои методи се покажани како најдобри при развивање на мобини апликации?",
            odgovor1 = "Метод на водопад",
            odgovor2 = "Итеративни методи",  //tocen odgovor
            odgovor3 = "Метод на broken window",
            tocenOdgovor = "Итеративни методи"
        ),
        Predmet(
            prasanje = "PrefenerceActivity претставува",
            odgovor1 = "Класа за прикажување на UI за поставки на една апликација",  //tocen odgovor
            odgovor2 = "Activity за брзи програмирање на работа со сервиси",
            odgovor3 = "Класа за менаџирање со поставки во код ",
            tocenOdgovor = "Класа за прикажување на UI за поставки на една апликација"
        ),
        Predmet(
            prasanje = "Кој метод се повикува при клик на кошче во Android?",
            odgovor1 = "onClick()",   //tocen odgovor
            odgovor2 = "OnButtonClick()",
            odgovor3 = "onClicked()",
            tocenOdgovor = "onClick()"
        ),
        Predmet(
            prasanje = "Како се работи со клик на мени копче во Android?",
            odgovor1 = "Се пополнува android:onClick атрибутот во XML",
            odgovor2 = "Се имплементира OnClickListener класа",  //tocen odgovor
            odgovor3 = "Се имплементира onOptionsItemSelected методот",
            tocenOdgovor = "Се имплементира OnClickListener класа"
        ),
        Predmet(
            prasanje = "За што се користи Context во Android?",
            odgovor1 = "Пристап до системски сервиси",  //tocen odgovor
            odgovor2 = "За цртање на кориснички интерфејс",
            odgovor3 = "Не постои Context во Android",
            tocenOdgovor = "Пристап до системски сервиси"
        ),
        Predmet(
            prasanje = "Preference Manager претставува:",
            odgovor1 = "Начин на менаџирање со постапки на апликација",  //tocen odgovor
            odgovor2 = "Начин на менаџирање со стиловите на апликацијата",
            odgovor3 = "Начин за брзо програмирање на Activity-ја",
            tocenOdgovor = "Начин на менаџирање со постапки на апликација"
        ),
        Predmet(
            prasanje = "External навигација претставува:",
            odgovor1 = "Вадење на последното Activity од back-stack",
            odgovor2 = "Корисникот навигира од една во друга апликација",  //tocen odgovor
            odgovor3 = "Влегување подлабоко во хиеархијата",
            tocenOdgovor = "Корисникот навигира од една во друга апликација"
        )
    )
}