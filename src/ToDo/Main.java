package ToDo;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            Writer w = new Writer();
            w.homeScreen();
        } else {
            ToDoApp tDA = new ToDoApp();
            tDA.appStart(args);
        }
    }
}
