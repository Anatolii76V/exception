public class ExceptionExample {
    public static void main(String[] args) {
        try {
            method1();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        try {
            method2();
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }

        try {
            method3();
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        }
    }

    /**
     * Метод, генерирующий ArrayIndexOutOfBoundsException.
     * Этот метод пытается обратиться к индексу массива, выходящему за его границы.
     * Вызывает исключение ArrayIndexOutOfBoundsException, когда индекс выходит за пределы массива.
     */
    public static void method1() {
        int[] arr = {1, 2, 3};
        System.out.println(arr[3]);
    }

    /**
     * Метод, генерирующий NullPointerException.
     * Этот метод вызывает свойство или метод объекта, у которого значение null.
     * Вызывает исключение NullPointerException, когда происходит обращение к null-объекту.
     */
    public static void method2() {
        String str = null;
        System.out.println(str.length());
    }

    /**
     * Метод, генерирующий NumberFormatException.
     * Этот метод пытается преобразовать строку в число, но строка имеет некорректный формат.
     * Вызывает исключение NumberFormatException, когда строка не может быть преобразована в число.
     */
    public static void method3() {
        String str = "123abc";
        int num = Integer.parseInt(str);
        System.out.println(num);
    }
}
