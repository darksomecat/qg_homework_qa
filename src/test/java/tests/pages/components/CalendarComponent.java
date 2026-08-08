package tests.pages.components;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, int month, String year){
        $(byClassName("react-datepicker__month-select")).selectOption(month);
        $(byClassName("react-datepicker__year-select")).selectOption(year);
        $(".react-datepicker__day.react-datepicker__day--0" + day).click();
    }
}
