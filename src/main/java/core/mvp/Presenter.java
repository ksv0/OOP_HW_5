package core.mvp;

import core.Config;
import core.phonebook.contact.Contact;

import java.util.Scanner;

public class Presenter {
    private Model model;
    private View view;

    public Presenter(View view, String fileName) {
        this.view = view;
        model = new Model(fileName);
        Config.fileName = fileName;
    }

    public void loadFromFile() {
        if (model.currentBook().count() > 0) {
            model.setCurrentIndex(0);
            contactToView(model.currentContact());
        }
    }

    public void add() {
        model.currentBook().add(
                new Contact(view.getFirstName(),
                        view.getLastName(),
                        view.getCellphoneNumber(),
                        view.getEmail(),
                        view.getAddress()));
    }

    public void remove() {
        model.currentBook().deleteContact(model.getCurrentIndex());

        if (model.currentBook().count() < -1) {
            model.setCurrentIndex(-1);

            view.setFirstName("");
            view.setLastName("");
            view.setCellphoneNumber("");
            view.setEmail("");
            view.setAddress("");
        } else {
            model.setCurrentIndex(model.getCurrentIndex() - 1);
            if (model.getCurrentIndex() < 0) {
                model.setCurrentIndex(0);
                contactToView(model.currentContact());
            }
            contactToView(model.currentContact());
        }
    }

    public void contactToView(Contact contact) {
        Contact temp = model.currentContact();
        view.setFirstName(temp.getFirstName());
        view.setLastName(temp.getLastName());
        view.setCellphoneNumber(temp.getCellphoneNumber());
        view.setEmail(temp.getEmail());
        view.setAddress(temp.getAddress());
    }

    public void saveToFile() {
        model.save();
    }

    public void next() {
        if (model.getCurrentIndex() + 1 < model.currentBook().count()) {
            model.setCurrentIndex(model.getCurrentIndex() + 1);
        }
        contactToView(model.currentContact());
    }

    public void prev() {
        if (model.currentBook().count() > 0) {
            if (model.getCurrentIndex() - 1 > -1) {
                model.setCurrentIndex(model.getCurrentIndex() - 1);
            }
            contactToView(model.currentContact());
        }

    }

    public void changeFile() {
        String fileName = view.getString();
        model = new Model(fileName);
    }

    public void changeParameter(Scanner in) {
        try  {
            System.out.println("""
                    Что меняем?
                    1. Имя
                    2. Фамилию
                    3. Телефон            
                    4. Email
                    5. Адрес                              
                    """);
            String key = in.next();
            switch (key) {
                case "1" -> {
                    model.currentContact().setFirstName(view.getString("Новое имя"));
                }
                case "2" -> {
                    model.currentContact().setLastName(view.getString("Новая фамилия"));
                }
                case "3" -> {
                    model.currentContact().setCellphoneNumber(view.getString("Новый телефон"));
                }
                case "4" -> {
                    model.currentContact().setEmail(view.getString("Новый email"));
                }
                case "5" -> {
                    model.currentContact().setAddress(view.getString("Новый адрес"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public Model getModel() {
        return model;
    }
}

