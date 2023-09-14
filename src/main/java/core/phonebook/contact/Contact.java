package core.phonebook.contact;

public class Contact {
    private String firstName;
    private String lastName;
    private String cellphoneNumber;
    private String email;
    private String address;

    public Contact(String firstName,
                   String lastName,
                   String cellphoneNumber,
                   String email,
                   String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellphoneNumber = cellphoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
