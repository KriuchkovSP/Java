import java.util.Scanner;

// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения:
// Реализуйте метод, принимающий в качестве аргументов два целочисленных
// массива, и возвращающий новый массив, каждый элемент которого равен 
// разности элементов двух входящих массивов в той же ячейке. Если длины
//  массивов не равны, необходимо как-то оповестить пользователя.
// * Реализуйте метод, принимающий в качестве аргументов два целочисленных
// массива, и возвращающий новый массив, каждый элемент которого равен 
// частному элементов двух входящих массивов в той же ячейке. Если длины
// массивов не равны, необходимо как-то оповестить пользователя. 
// Важно: При выполнении метода единственное исключение,
// которое пользователь может увидеть - RuntimeException, т.е. ваше.
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        int[] array1 = {10, 15, 0, 58, 95, 14};
        int[] array2 = {17, 19, 10, 7, 5, 33};
        Scanner sc = new Scanner(System.in);
        int[] array3 = null;
        int[] array4 = null;
        while (array3 == null) {
            try {
                array3 = inputData("Введите через пробел целые числа, для формирования первого массива", sc);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Введены некорректные данные, повторите ввод");
            }
            
        }
        while (array4 == null) {
            try {
                array4 = inputData("Введите через пробел целые числа, для формирования второго массива", sc);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Введены некорректные данные, повторите ввод");
            }
        }
        sc.close();
        try {
            System.out.println("Начало выполнения защищенного участка кода с вычислением разности 2 элементов массивов");
            int[] resDiffArr = diffNum(array1, array2);
            System.out.print("Выполнение метода прошло успешно, результат: ");
            arrPrint(resDiffArr);
        } catch (RuntimeException e) {
            System.out.print("Поймали какое то исключение и выводим его: ");
            System.out.println(e.getMessage());
            System.out.println("Стек вызовов:");
            e.printStackTrace();
        } finally {
            System.out.println("Конец вычислений метода diffNum");
        }

        try {
            System.out.println("Начало выполнения защищенного участка кода с вычислением частного 2 элементов массивов");
            double[] resDiffArr = divNum(array3, array4);
            System.out.print("Выполнение метода прошло успешно, результат: ");
            arrPrint(resDiffArr);
        } catch (RuntimeException e) {
            System.out.print("Поймали какое то исключение и выводим его: ");
            System.out.println(e.getMessage());
            System.out.println("Стек вызовов:");
            e.printStackTrace();
        } finally {
            System.out.println("Конец вычислений метода divNum");
        }
    }

    public static int[] diffNum(int[] a, int[] b) {
        if (a.length != b.length) throw new RuntimeException("Массивы разной длины");
        int[] result = new int[b.length];
        for (int i = 0; i < b.length; i++) { // Чтобы словить исключение исправить < на <=
            if (i >= a.length || i >= b.length) throw new RuntimeException("Выход за пределы массива");
            result[i] = a[i] - b[i];
        }
        return result;
    }

    public static double[] divNum(int[] a, int[] b) {
        double[] result;
        if (a.length != b.length) throw new RuntimeException("Массивы разной длины");
        result = new double[b.length];
        for (int i = 0; i < b.length; i++) { // Чтобы словить исключение исправить < на <=
            if (i >= a.length || i >= b.length) throw new RuntimeException("Выход за пределы массива");
            if (a[i] == 0) throw new RuntimeException("Деление на ноль не допустимо");
            result[i] = (double)b[i] / (double)a[i];
        }
        return result;
    }

    static void arrPrint(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    static void arrPrint(double[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    static int[] inputData(String text, Scanner sc) {
        System.out.println(text);
       
        String str = sc.nextLine();
        if (str.isEmpty()) {
            throw new RuntimeException("Пришла пустая строка");
        } 
        int[] array = parseStringArr(str, " ");
        return array;
    }

    static int[] parseStringArr( String str, String delim ) throws RuntimeException {
        if (delim != " ") throw new RuntimeException("Указан не правильный разделитель строки");
        String[] strArr = str.trim().split(delim);
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String num = strArr[i].trim();
            try {
                intArr[i] = Integer.parseInt(num);
            } catch (Exception e) {
                throw new RuntimeException("Сработало исключение в методе parseInt");
            }
            
        }
        return intArr;
    }
}
    