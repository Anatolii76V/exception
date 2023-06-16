package lesson2;

import java.util.Scanner;

public class FloatInput {
    public static void main(String[] args) {
        float floatNumber = getFloatInput();
        System.out.println("Введенное число: " + floatNumber);
    }

    public static float getFloatInput() {
        Scanner scanner = new Scanner(System.in);
        float number;

        while (true) {
            try {
                System.out.print("Введите дробное число: ");
                number = Float.parseFloat(scanner.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введено некорректное значение. Пожалуйста, введите дробное число.");
            }
        }
    }
}
