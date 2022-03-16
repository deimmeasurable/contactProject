package africa.semicolon.phoneBook;

import africa.semicolon.phoneBook.controllers.ContactController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {
//    private static ContactController contactController = new ContactController();

    public static void main(String[] args) {
        //load options
        // loadOptions();

        SpringApplication.run(Main.class, args);
    }
}
