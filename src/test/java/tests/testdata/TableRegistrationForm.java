package tests.testdata;

public enum TableRegistrationForm {
    STUDENT_NAME("Student Name", "-"),
    STUDENT_EMAIL("Student Email", "-"),
    GENDER("Gender", "-"),
    MOBILE("Mobile", "-"),
    DATE_OF_BIRTH("Date of Birth", "-"),
    SUBJECTS("Subjects", "-"),
    HOBBIES("Hobbies", "-"),
    PICTURE("Picture", "-"),
    ADDRESS("Address", "-"),
    STATE_AND_CITY("State and City", "-");

    private final String row;
    private final String emptyText;

    TableRegistrationForm(String row, String emptyText) {
        this.row = row;
        this.emptyText = emptyText;
    }

    public String getRow() {
        return row;
    }

    public String getEmptyText() {
        return emptyText;
    }
}
