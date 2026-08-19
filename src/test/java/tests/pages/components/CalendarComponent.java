package tests.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(int day, String month, int year) {
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        $(".react-datepicker__year-select").selectOption(String.valueOf(year));
        String formattedDay = String.format("%03d", day);
        String selectBirthDay = ".react-datepicker__day--" + formattedDay + ":not(.react-datepicker__day--outside-month)";
        $(selectBirthDay).click();
    }
}


