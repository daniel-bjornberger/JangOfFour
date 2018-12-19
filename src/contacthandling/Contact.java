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
        this.id=id;
        setFirstname(givenFirstName);
        setLastname(givenLastName);
        setPhone(givenPhone);
        setAddress(givenAddress);
        setEmail(givenEmail);
    }

    //-------------------- Create Setters and Getters: ----------------

    /** Get contact's id */
    public Integer getId() {
        return id;
    }

    /** Set the contact's id */
    public void setId(Integer id) {
        id = id;
    }

    /** Get the contact's first name */
    public String getFirstname() {
        return firstname;
    }

    /** Check the firstname text format and set the contact's first name */
    public void setFirstname(String firstName) {
        //check first name not empty:
        if (firstName.length() <= 1) {
            //System.err.println("ignored error: First name should be more than one character");
            //throw new IllegalArgumentException();
        }
        this.firstname = firstName;
    }

    /** Get the contact's last name */
    public String getLastname() {
        return lastname;
    }

    /** Check the lastname format and set the contact's last name */
    public void setLastname(String lastName) {
        //check last name not empty:
        if (lastName.length() <= 1) {
            //System.err.println("ignored error: Last name shoud be more than one character");
            //throw new IllegalArgumentException();
        }
        this.lastname = lastName;
    }

    /** Get the contact's phone number */
    public String getPhone() {
        return phone;
    }

    /** Check phone number format and set the contact's phone number */
    public void setPhone(String phone) {
        //check to see that phone number has 9 or more characters
        if (phone.length() < 9) {
            //System.err.println("ignored error: Phone number must have 9 or mor digits ");
            //throw new IllegalArgumentException();
        }
        this.phone = phone;
    }

    /** Get the contact's address */
    public String getAddress() {
        return address;
    }

    /** Check the address format and set the contact's address */
    public void setAddress(String address) {
        //check to see that address has 5 or more characters
        if (address.length() < 5) {
            //System.err.println("ignored error: Address must have 5 or mor characters ");
            //throw new IllegalArgumentException();
        }
        this.address = address;
    }

    /** Get the email address */
    public String getEmail() {
        return email;
    }

    /** Check email address format and set the contact's email address */
    public void setEmail(String email) {
        //check email format: @ sign:
        if (!email.contains("@")) {
            //System.err.println("ignored error: Email must include @ sign.");
            //throw new IllegalArgumentException();
        }
        //check email format: dot:
        if (!email.contains(".")) {
            //System.err.println("ignored error: Email must include a dot for domain name.");
            //throw new IllegalArgumentException();
        }

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
