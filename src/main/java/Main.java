import java.util.Scanner;

public class Main {
    static Phonebook phonebook;
    Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        phonebook = new Phonebook();
        Main main = new Main();
        String selectAcitvity;


        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please select activity: ");
            System.out.println("1 - Add contact \n" +
                    "2 - Find contact \n" +
                    "3 - Update contact \n" +
                    "4 - See all contacts \n" +
                    "Quit");
            selectAcitvity = scanner.nextLine();
            switch (selectAcitvity) {
                case "1":
                    main.addContact();
                    break;
                case "2":
                    main.findContact();
                    break;
                case "3":
                    main.updateContact();
                    break;
                case "4":
                    main.seeAllContacts();
                case "Quit":
                    break;
                default:
                    System.out.println("Please select one of provided options! ");
            }
        }
        while (!selectAcitvity.equals("Quit"));

    }

    void addContact() {
        Contact contact = new Contact();
        System.out.println("Add contact:\n");

        System.out.println("Please insert contact name: ");
        String addContactName = scanner.nextLine();
        contact.setName(addContactName);

        String addContactNumber;
        String regex = "^[0-9]*$";
        do {
            System.out.println("Please insert contact phone number: ");
            addContactNumber = scanner.nextLine();

            if (addContactNumber.matches(regex)) {
                contact.setPhoneNumber(addContactNumber);
            } else {
                System.out.println("Please insert correct phone number");
            }
        } while (!addContactNumber.matches(regex));
        Scanner scanner = new Scanner(System.in);


        System.out.println("Please insert contact email: ");
        String addContactEmail = scanner.nextLine();
        contact.setEmail(addContactEmail);


        phonebook.setContact(contact);
        System.out.println("Contact added: " + contact);
    }

    public Contact findContact() {
        System.out.println("\nFind contact by name, phone number or email. ");
        System.out.println("Insert name or phone number or email: ");
        String findContactNameNumberEmail = scanner.nextLine();
        for (Contact contact : phonebook.contact) {
            if ((contact.getName().equals(findContactNameNumberEmail)) ||
                    (contact.getPhoneNumber().equals(findContactNameNumberEmail)) ||
                    (contact.getEmail().equals(findContactNameNumberEmail))) {
                System.out.println("Contact found: " + contact);
                return contact;
            }
        }
        return null;
    }

    public Contact updateContact() {
        Contact contact;
        System.out.println("Choose contact to edit.");
        do {
            contact = findContact();
            if (contact == null) {
                System.out.println("Contact not found, try once again!");
            }
        } while (contact == null);

        System.out.println(contact);
        int pos = phonebook.contact.indexOf(contact);

        System.out.println("Please choose what to update, 1 - name, 2 - phone number, 3 - email");
        String updateContactNameNumberEmail;
        do {
            updateContactNameNumberEmail = scanner.nextLine();
            switch (updateContactNameNumberEmail) {
                case "1":
                    System.out.println("Insert name");
                    String updateContactByName = scanner.nextLine();
                    contact.setName(updateContactByName);
                    phonebook.contact.set(pos, contact);
                    break;
                case "2":
                    System.out.println("Insert phone number");
                    String updateContactByPhone = scanner.nextLine();
                    String regex = "^[0-9]*$";
                    do {
                        System.out.println("Please insert contact phone number: ");
                        updateContactByPhone = scanner.nextLine();

                        if (updateContactByPhone.matches(regex)) {
                            contact.setPhoneNumber(updateContactByPhone);
                        } else {
                            System.out.println("Please insert correct phone number");
                        }
                    } while (!updateContactByPhone.matches(regex));

                    contact.setPhoneNumber(updateContactByPhone);
                    phonebook.contact.set(pos, contact);
                    break;
                case "3":
                    String updateContactByEmail;
                    String regex1 = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"; // tested email regex, but not working fully.

                    do { System.out.println("Insert email");
                         updateContactByEmail = scanner.nextLine();
                        boolean result1 = updateContactByEmail.matches(regex1);
                        if (result1) {
                            contact.setEmail(updateContactByEmail);
                            phonebook.contact.set(pos, contact);
                        } else {
                            System.out.println("Please insert correct email");
                        }
                    } while (!updateContactByEmail.matches(regex1));

                    break;
                default:
                    System.out.println("Please insert numbers 1 or 2 or 3!!!");

            }
            System.out.println("Contact edited! New contact is " + contact);
            return contact;
        } while (!updateContactNameNumberEmail.equals(1) || !updateContactNameNumberEmail.equals(2) || !updateContactNameNumberEmail.equals(3));

    }

    public void seeAllContacts() {
        System.out.println("All contacts list: ");
        for (Contact contact : phonebook.contact) {
            System.out.println(contact);
        }
    }
}
