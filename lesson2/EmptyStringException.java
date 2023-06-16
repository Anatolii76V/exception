package lesson2;

import java.util.Scanner;

public class EmptyStringException {
    public static void main(String[] args) {
        try {
            String userInput = getStringInput();
            System.out.println("Введенная строка: " + userInput);
        } catch (Exception e) {
            System.out.println("Ошибка: Пустые строки вводить нельзя.");
        }
    }

    public static String getStringInput() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            throw new Exception();
        }

        return input;
    }
}
