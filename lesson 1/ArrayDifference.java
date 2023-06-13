import java.util.Arrays;

public class ArrayDifference {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};

        try {
            int[] result = calculateDifference(array1, array2);
            System.out.println(Arrays.toString(result));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Вычисляет разность элементов двух целочисленных массивов.
     *
     * @param array1 Первый массив.
     * @param array2 Второй массив.
     * @return Массив, в котором каждый элемент равен разности элементов двух входных массивов в той же ячейке.
     * @throws IllegalArgumentException Если длины массивов не равны.
     */
    public static int[] calculateDifference(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Array lengths do not match");
        }

        int[] result = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] - array2[i];
        }

        return result;
    }
}
