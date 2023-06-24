package mk.ukim.finki.examiner.data

fun bizList(): MutableList<Predmet>{
    return mutableListOf(

        Predmet(
            prasanje = "Извршување на проектот е дел од:",
            odgovor1 = "Управување со проектна интеграција.",  //tocen odgovor
            odgovor2 = "Набавки за управување со проектот",
            odgovor3 = "Управување со споредување на проектот",
            tocenOdgovor = "Управување со проектна интеграција."
        ),
        Predmet(
            prasanje = "Сите наведени работи се ISO 9000 принципи освен:",
            odgovor1 = "Вклучување на засегнати страни",   //tocen odgovor
            odgovor2 = "Фокус на корисникот",
            odgovor3 = "Вклучување на луѓе",
            tocenOdgovor = "Вклучување на засегнати страни"
        ),
        Predmet(
            prasanje = "Ресурсите:",
            odgovor1 = "Влијаат врз цената на проектот",
            odgovor2 = "Не влијаат многу врз проектот",
            odgovor3 = "Влијаат и врз времетраењето и цената на проектот",  //tocen odgovor
            tocenOdgovor = "Влијаат и врз времетраењето и цената на проектот"
        ),
        Predmet(
            prasanje = "Цена/корист анализи се:",
            odgovor1 = "Крајно непотребни",
            odgovor2 = "Критични за успех на проектот",  //tocen odgovor
            odgovor3 = "Многу точни",
            tocenOdgovor = "Критични за успех на проектот"
        ),
        Predmet(
            prasanje = "Распоредите (schedules) ce:",
            odgovor1 = "Ретко совршени",  //tocen odgovor
            odgovor2 = "Бескорисни",
            odgovor3 = "Лесни за правење",
            tocenOdgovor = "Ретко совршени"
        ),
        Predmet(
            prasanje = "Кога се прави поделба на работа, проектот може да биде:",
            odgovor1 = "Сите наведени одговори",   //tocen odgovor
            odgovor2 = "Главните продукти",
            odgovor3 = "Функвионални области",
            tocenOdgovor = "Сите наведени одговори"
        ),
        Predmet(
            prasanje = "Извршување на проектот е дел од:",
            odgovor1 = "Набавки за управување со проектот",
            odgovor2 = "Управување со проектна интеграција",  //tocen odgovor
            odgovor3 = "Управување со опфатот на проектот",
            tocenOdgovor = "Управување со проектна интеграција"
        ),
        Predmet(
            prasanje = "Кои од следните работи НЕ се ниво на Capability Maturity?",
            odgovor1 = "Подобрувачко",  //tocen odgovor
            odgovor2 = "Дефинирано",
            odgovor3 = "Иницијално",
            tocenOdgovor = "Подобрувачко"
        ),
        Predmet(
            prasanje = "Кој од следните е еден тип на трошок на квалитет?",
            odgovor1 = "Сите наведени",  //tocen odgovor
            odgovor2 = "Трошок за оценување",
            odgovor3 = "Трошок за неуспех",
            tocenOdgovor = "Сите наведени"
        ),
        Predmet(
            prasanje = "Најдолгиот пат во мрежниот дијаграм е?",
            odgovor1 = "Критичен ланец",
            odgovor2 = "Критичен пат",  //tocen odgovor
            odgovor3 = "Мрежен пат",
            tocenOdgovor = "Критичен пат"
        )
    )
}