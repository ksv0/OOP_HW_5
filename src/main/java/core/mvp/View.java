package core.mvp;

public interface View {
    String getFirstName();
    void setFirstName(String value);
    String getLastName();
    void setLastName(String value);
    String getCellphoneNumber();
    void setCellphoneNumber(String value);
    String getEmail();
    void setEmail(String value);
    String getAddress();
    void setAddress(String value);
    String getString();
    String getString(String str);
}
