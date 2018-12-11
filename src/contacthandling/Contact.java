package contacthandling;

/* have a class that represents the contact being created or interacted with */
public class Contact {

    int id;
    String firstname;
    String lastname;
    String phone;
    String address;
    String email;


    //Constructor
    public Contact (int id,String givenFirstName, String givenLastName,
                         String givenPhone, String givenAddress,
                         String givenEmail) {

        this.id=id;
        this.firstname = givenFirstName;
        this.lastname = givenLastName;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
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
                        "First name: " + firstname + ", " +
                        "Last name: " + lastname + ", " +
                        "Phone: " + phone + ", " +
                        "Address: " + address + ", " +
                        "Email: " + email
        );
    }
}
