import java.util.ArrayList;

public class Phonebook {
    ArrayList<Contact> contact;

   public Phonebook() {
       this.contact = new ArrayList<Contact>();

    }
    public ArrayList<Contact> getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact.add(contact);
    }

}
