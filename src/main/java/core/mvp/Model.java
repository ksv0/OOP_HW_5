package core.mvp;

import core.Config;
import core.phonebook.PhoneBook;
import core.phonebook.contact.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
    PhoneBook book;
    private Integer currentIndex;
    private String fileName;

    public Model(String fileName) {
        this.fileName = fileName;
        book = new PhoneBook(readFile());
        currentIndex = 0;
    }

    public Contact currentContact() {
        if (currentIndex >= 0) {
            return book.takeContact(currentIndex);
        } else {
            currentIndex = 0;
            return currentContact();
        }
    }

    public List<Contact> readFile() {
        List<Contact> contacts = new ArrayList<>();
        List<String[]> rawPersons = new ArrayList<>();
        if (fileName.endsWith(".csv")) {
            rawPersons = parserCsv();
        } else {
            if (fileName.endsWith(".xlsx")) {
                rawPersons = parserXlsx();
            } else {
                if (fileName.endsWith(".doc")) {
                    rawPersons = parserDoc();
                } else {
                    fileName = "phonebook.csv";
                    return new ArrayList<Contact>();

                }
            }
        }
        for (String[] entry : rawPersons) {
            contacts.add(new Contact(entry[0], entry[1], entry[2], entry[3], entry[4]));
        }
        return contacts;
    }


    public List<String[]> parserCsv() {
        List<String[]> lines = new ArrayList<>();
        File file = new File(Config.pathToDB, fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String row;
            while ((row = reader.readLine()) != null) {
                lines.add(row.split(","));
            }
        } catch (IOException e) {

            return new ArrayList<String[]>();
        }
        return lines;
    }


    public List<String[]> parserXlsx() {
        return null;
    }


    public List<String[]> parserDoc() {
        return null;
    }

    public void save() {
        if (fileName.endsWith(".csv")) {
            saveCsv();
        } else {
            if (fileName.endsWith(".xlsx")) {
                saveXlsx();
            } else {
                if (fileName.endsWith(".doc")) {
                    saveDoc();
                } else {
                    fileName+=".csv";
                    save();
                }
            }
        }
    }

    public void saveCsv() {
        try (FileWriter writer = new FileWriter(Config.pathToDB.concat(fileName), false)) {
            for (int i = 0; i < book.count(); i++) {
                Contact contact = book.takeContact(i);
                writer.append(String.format("%s,%s,%s,%s,%s\n",
                        contact.getFirstName(),
                        contact.getLastName(),
                        contact.getCellphoneNumber(),
                        contact.getEmail(),
                        contact.getAddress()));
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void saveXlsx() {
    }

    public void saveDoc() {
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public PhoneBook currentBook() {
        return this.book;
    }
}
