package tests.testdata;

public enum TableTextBoxPage {
    NAME("name", "Name:"),
    EMAIL("email", "Email:"),
    CURRENT_ADDRESS("currentAddress", "Current Address :"),
    PERMANENT_ADDRESS("permanentAddress", "Permananet Address :");

    private final String id;
    private final String emptyText;

    TableTextBoxPage(String id, String emptyText) {
        this.id = id;
        this.emptyText = emptyText;
    }

    public String getId() { return id; }
    public String getEmptyText() { return emptyText; }
}
