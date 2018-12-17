package contacthandling;

/* have a class that represents the contact being created or interacted with */

/**
 * Represent a Contact object with getters and setters
 * @author Bob
 */
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

        System.out.println("Contact id: " + this.id);

        //check last name not empty:
        if (givenLastName.length() <= 1) {
            System.err.println("ignored error: Last name shoud be more than one character");
            //throw new IllegalArgumentException();
        }

        //check first name not empty:
        if (givenFirstName.length() <= 1) {
            System.err.println("ignored error: First name should be more than one character");
            //throw new IllegalArgumentException();
        }

        //check email format: @ sign:
        if (!givenEmail.contains("@")) {
            System.err.println("ignored error: Email must include @ sign.");
            //throw new IllegalArgumentException();
        }

        //check email format: dot:
        if (!givenEmail.contains(".")) {
            System.err.println("ignored error: Email must include a dot for domain name.");
            //throw new IllegalArgumentException();
        }

        //check to see that phone number has 9 or more characters
        if (givenPhone.length() < 9) {
            System.err.println("ignored error: Phone number must have 9 or mor digits ");
            //throw new IllegalArgumentException();
        }

        //check to see that address has 5 or more characters
        if (givenAddress.length() < 5) {
            System.err.println("ignored error: Address must have 5 or mor digits ");
            //throw new IllegalArgumentException();
        }

        this.id=id;
        this.firstname = givenFirstName;
        this.lastname = givenLastName;
        this.phone = givenPhone;
        this.address = givenAddress;
        this.email = givenEmail;


    }



    //-------------------- Create Setters and Getters: ----------------

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
                        ", First name: " + firstname + ", " +
                        "Last name: " + lastname + ", " +
                        "Phone: " + phone + ", " +
                        "Address: " + address + ", " +
                        "Email: " + email
        );
    }
}
