import java.lang.reflect.Array;


public class Contact {
    // (name, phone number, email (optional)).
    String name;
    String phoneNumber;
    String email;

  public  Contact (String name, String phoneNumber, String email) {
       this.name = name;
       this.phoneNumber = phoneNumber;
       this.email = email;
   }

  public Contact () {
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String toString() {
      return "\ncontact name " + name + "\nphone number - " + phoneNumber + "\nemail - " + email;
    }
}
