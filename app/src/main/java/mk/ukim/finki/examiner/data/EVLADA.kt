package mk.ukim.finki.examiner.data

fun evladaList(): MutableList<Predmet>{
    return mutableListOf(

        Predmet(
            prasanje = "Извршување на проектот е дел од:",
            odgovor1 = "Управување со проектна интеграција. ",  //tocen odgovor
            odgovor2 = "Набавки за управување со проектот",
            odgovor3 = "Управување со споредување на проектот"
        ),
        Predmet(
            prasanje = "Сите наведени работи се ISO 9000 принципи освен:",
            odgovor1 = "Вклучување на засегнати страни",   //tocen odgovor
            odgovor2 = "Фокус на корисникот",
            odgovor3 = "Вклучување на луѓе"
        ),
        Predmet(
            prasanje = "Ресурсите:",
            odgovor1 = "Влијаат врз цената на проектот",
            odgovor2 = "Не влијаат многу врз проектот",
            odgovor3 = "Влијаат и врз времетраењето и цената на проектот"  //tocen odgovor
        ),
        Predmet(
            prasanje = "Цена/корист анализи се:",
            odgovor1 = "Крајно непотребни",
            odgovor2 = "Критични за успех на проектот",  //tocen odgovor
            odgovor3 = "Многу точни"
        ),
        Predmet(
            prasanje = "Распоредите (schedules) ce:",
            odgovor1 = "Ретко совршени",  //tocen odgovor
            odgovor2 = "Бескорисни",
            odgovor3 = "Лесни за правење"
        ),
        Predmet(
            prasanje = "Кога се прави поделба на работа, проектот може да биде:",
            odgovor1 = "Сите наведени одговори",   //tocen odgovor
            odgovor2 = "Главните продукти",
            odgovor3 = "Функвионални области"
        ),
        Predmet(
            prasanje = "Извршување на проектот е дел од:",
            odgovor1 = "Набавки за управување со проектот",
            odgovor2 = "Управување со проектна интеграција",  //tocen odgovor
            odgovor3 = "Управување со опфатот на проектот"
        ),
        Predmet(
            prasanje = "Кои од следните работи НЕ се ниво на Capability Maturity?",
            odgovor1 = "Подобрувачко",  //tocen odgovor
            odgovor2 = "Дефинирано",
            odgovor3 = "Иницијално"
        ),
        Predmet(
            prasanje = "Кој од следните е еден тип на трошок на квалитет?",
            odgovor1 = "Сите наведени",  //tocen odgovor
            odgovor2 = "Трошок за оценување",
            odgovor3 = "Трошок за неуспех"
        ),
        Predmet(
            prasanje = "Најдолгиот пат во мрежниот дијаграм е?",
            odgovor1 = "Критичен ланец",
            odgovor2 = "Критичен пат",  //tocen odgovor
            odgovor3 = "Мрежен пат"
        )
    )
}