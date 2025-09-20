package util;

import java.util.Scanner;

public class Utils {
    public static Scanner scanner = new Scanner(System.in);

    public static String input(String message) {
        System.out.print(message + ": ");
        return scanner.nextLine();
    }
}
