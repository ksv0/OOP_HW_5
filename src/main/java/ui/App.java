package ui;

import core.Config;
import core.mvp.Presenter;
import core.mvp.View;

import java.util.Scanner;

public class App {
    public static void run(){
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view, Config.fileName);
        presenter.loadFromFile();
        boolean runnable = true;
        try(Scanner in = new Scanner(System.in)){
            while(runnable){
                System.out.println("""
                        
                        1. назад        3. добавить новый контакт       6. сохранить
                        2. вперед       4. изменить текущий контакт     7. сменить книгу
                                        5. удалить текущий контакт      8. выйти без сохранения
                        
                        """);
                System.out.println((presenter.getModel().getCurrentIndex()+1)+" / "+ presenter.getModel().currentBook().count());
                String key = in.next();
                switch (key){
                    case "1"->{
                        presenter.prev();
                    }
                    case "2"->{
                        presenter.next();
                    }
                    case "3"->{
                        presenter.add();
                    }
                    case "4"->{
                        presenter.changeParameter(in);
                    }
                    case "5"->{
                        presenter.remove();
                    }
                    case "6"->{
                        presenter.saveToFile();
                    }
                    case "7"->{
                        presenter.changeFile();
                    }
                    case "8"->{
                        runnable = false;
                    }
                    default -> {
                        System.out.println("Еслиб мы знали что это такое, но мы не знаем что это такое");
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
