package ContactHandling;

/* have a class that represents the contact being created or interacted with */
public class Contact {

    Integer Id;
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
