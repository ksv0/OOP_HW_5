package ui;

import core.mvp.View;

import java.util.Scanner;

public class ConsoleView implements View {
    Scanner in;
    public ConsoleView() {
        in = new Scanner(System.in);
    }
    @Override
    public String getFirstName() {
        System.out.print("Имя: ");
        return in.nextLine();
    }

    @Override
    public void setFirstName(String value) {
        System.out.printf("Имя: %s\n", value);
    }

    @Override
    public String getLastName() {
        System.out.print("Фамилия: ");
        return in.nextLine();
    }

    @Override
    public void setLastName(String value) {
        System.out.printf("Фамилия: %s\n", value);
    }

    @Override
    public String getCellphoneNumber() {
        System.out.print("Номер телефона: ");
        return in.nextLine();
    }

    @Override
    public void setCellphoneNumber(String value) {
        System.out.printf("Номер телефона: %s\n", value);
    }

    @Override
    public String getEmail() {
        System.out.print("Email: ");
        return in.nextLine();
    }

    @Override
    public void setEmail(String value) {
        System.out.printf("Email: %s\n", value);
    }

    @Override
    public String getAddress() {
        System.out.print("Адрес: ");
        return in.nextLine();
    }

    @Override
    public void setAddress(String value) {
        System.out.printf("Адрес: %s\n", value);
    }

    @Override
    public String getString() {
        System.out.print("Введи новые данные: ");
        return in.nextLine();
    }

    @Override
    public String getString(String str) {
        System.out.printf("%s: ",str);
        return in.nextLine();
    }
}
