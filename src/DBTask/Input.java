package DBTask;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    private static String nameInput() {
        return scanner.nextLine();
    }

    public static String getNameInput() {
        return nameInput();
    }

    private static String performanceInput() {
        return scanner.nextLine();
    }

    public static String getPerformanceInput() {
        return performanceInput();
    }
}
