package ContactHandling;

/* have a class that represents the contact being created or interacted with */
public class Contact {

    int id;
    String firstName;
    String lastName;
    String phone;
    String address;
    String email;


    //Constructor
    public Contact (int id,String givenFirstName, String givenLastName,
                         String givenPhone, String givenAddress,
                         String givenEmail) {

        this.id=id;
        this.firstName = givenFirstName;
        this.lastName = givenLastName;
        this.phone = givenPhone;
        this.address = givenAddress;
        this.email = givenEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        id = id;
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
                "Id: " + id +
                        "First name: " + firstName + ", " +
                        "Last name: " + lastName + ", " +
                        "Phone: " + phone + ", " +
                        "Address: " + address + ", " +
                        "Email: " + email
        );
    }
}
