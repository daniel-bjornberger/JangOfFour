package ContactHandling;

/* have a class that represents the contact being created or interacted with */
public class Contact {

    int Id;
    String firstName;
    String lastName;
    String phone;
    String address;
    String email;


    //Constructor
    public void Contact (String givenFirstName, String givenLastName,
                         String givenPhone, String givenAddress,
                         String givenEmail) {

        this.firstName = givenFirstName;
        this.lastName = givenLastName;
        this.phone = givenPhone;
        this.address = givenAddress;
        this.email = givenEmail;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return (
                "Id: " + Id +
                        "First name: " + firstName + ", " +
                        "Last name: " + lastName + ", " +
                        "Phone: " + phone + ", " +
                        "Address: " + address + ", " +
                        "Email: " + email
        );
    }
}
