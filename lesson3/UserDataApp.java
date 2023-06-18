package lesson3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserDataApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные в формате: Фамилия Имя Отчество Дата Рождения Номер Телефона Пол");
        String userInput = scanner.nextLine();

        try {
            String[] userData = parseUserInput(userInput);
            saveUserData(userData);
            System.out.println("Данные успешно сохранены.");
        } catch (InvalidDataException | IOException e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }

        scanner.close();
    }

    private static String[] parseUserInput(String userInput) throws InvalidDataException {
        String[] userData = userInput.split(" ");
        int expectedDataLength = 6;

        if (userData.length != expectedDataLength) {
            throw new InvalidDataException("Неверное количество данных. Ожидается " + expectedDataLength);
        }

        String lastName = userData[0];
        String firstName = userData[1];
        String middleName = userData[2];
        String dateOfBirthString = userData[3];
        String phoneNumberString = userData[4];
        String genderString = userData[5];

        LocalDate dateOfBirth;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            dateOfBirth = LocalDate.parse(dateOfBirthString, formatter);
        } catch (Exception e) {
            throw new InvalidDataException("Неверный формат даты рождения.");
        }

        long phoneNumber;
        try {
            phoneNumber = Long.parseLong(phoneNumberString);
        } catch (NumberFormatException e) {
            throw new InvalidDataException("Неверный формат номера телефона.");
        }

        if (!genderString.equals("m") && !genderString.equals("f")) {
            throw new InvalidDataException("Неверное значение пола.");
        }

        return new String[]{lastName, firstName, middleName, dateOfBirthString, String.valueOf(phoneNumber), genderString};
    }

    private static void saveUserData(String[] userData) throws IOException {
        String lastName = userData[0];
        String fileName = lastName + ".txt";
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName, true);
            String userDataString = String.join(" ", userData);
            fileWriter.write(userDataString + System.lineSeparator());
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }

    static class InvalidDataException extends Exception {
        public InvalidDataException(String message) {
            super(message);
        }
    }
}
