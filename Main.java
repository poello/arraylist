package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {

            boolean quit = false;
            int choice;
            printInstructions();

            while(!quit) {
                System.out.println("Enter your choice: \r");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch(choice) {
                    case 0:
                        printInstructions();
                        break;
                    case 1:
                        mobilePhone.printContactsList();
                        break;
                    case 2:
                        addContact();
                        break;
                    case 3:
                        updateContact();
                        break;
                    case 4:
                        removeContact();
                        break;
                    case 5:
                        searchContact();
                        break;
                    case 6:
                        quit = true;
                        break;
                }
            }
        }

    private static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add a contact to the list.");
        System.out.println("\t 3 - To modify/update a contact in the list.");
        System.out.println("\t 4 - To remove a contact from the list.");
        System.out.println("\t 5 - To search for a contact in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    private static void addContact() {
        System.out.println("Please enter a name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter a phone number: ");
        String phoneNumber = scanner.nextLine();
        mobilePhone.addContactToList(new Contact(name, phoneNumber));
    }

    private static void updateContact() {
        System.out.println("Enter contact name to update: ");
        String oldName = scanner.nextLine();
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number: ");
        String newPhoneNumber = scanner.nextLine();
        mobilePhone.updateContactInList(new Contact(oldName, ""), new Contact(newName, newPhoneNumber));
    }

    private static void removeContact() {
        System.out.println("Please enter a name to remove: ");
        String name = scanner.nextLine();
        mobilePhone.removeContactFromList(new Contact(name, ""));
    }

    private static void searchContact() {
        System.out.println("Please enter a name: ");
        String name = scanner.nextLine();
        if(mobilePhone.searchContactInList(new Contact(name, ""))) {
            System.out.println(name + " is in the list.");
        } else {
            System.out.println("There is no such a contact.");
        }
    }
}

