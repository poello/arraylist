package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contactList = new ArrayList<Contact>();

    public void printContactsList() {
        System.out.println("You have " + this.contactList.size() +
                " Contact on your list.");
        for(int i = 0; i < this.contactList.size(); i++) {
            System.out.println((i+1) + ". " +
                    this.contactList.get(i).getName() + ", " +
                    this.contactList.get(i).getPhoneNumber());
        }
    }

    public void addContactToList(Contact contact) {
        if(findContact(contact) >= 0) {
            System.out.println("The contact already exists");
        } else {
            contactList.add(contact);
            System.out.println("The contact added successfully");
        }
    }

    public void updateContactInList(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        int check = findContact(newContact);
        if(position >= 0 && check == -1) {
            updateContactInList(position, newContact);
        } else {
            System.out.println("There is no such a contact or any contact has this name");
        }
    }

    private void updateContactInList(int position, Contact contact) {
        this.contactList.set(position, contact);
        System.out.println("The contact on position " + (position+1) +
                " has been changed.");
    }

    public void removeContactFromList(Contact contact) {
        int position = findContact(contact);
        if(position >= 0){
            removeContactFromList(position);
            System.out.println(contact.getName() + " deleted");
        } else {
            System.out.println("There is no such a contact");
        }
    }

    private void removeContactFromList(int position) {
        this.contactList.remove(position);
    }

    private int findContact(Contact contact) {
        for(int i = 0; i < this.contactList.size(); i++) {
            if(this.contactList.get(i).getName().equals(contact.getName())) {
                return i;
            }
        }

        return -1;
    }
    

    public boolean searchContactInList(Contact contact) {
        return findContact(contact) >= 0;
    }
}
