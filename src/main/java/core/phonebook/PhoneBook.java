package core.phonebook;

import core.phonebook.contact.Contact;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<>();
    }

    public PhoneBook(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void add(Contact contact) {
        if (!contacts.contains(contact)) {
            contacts.add(contact);
        }
    }

    public Contact takeContact(int index) {
        if (index < contacts.size()) {
            return contacts.get(index);
        }
        return null;
    }

    public void deleteContact(int index) {
        if (index < contacts.size()) {
            contacts.remove(index);
        }
    }


    public List<Contact> getContacts() {
        return contacts;
    }
    public int count() {
        return contacts.size();
    }
}
