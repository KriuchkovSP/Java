import java.util.Scanner;

// 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению
// приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

// 2. Если необходимо, исправьте данный код (задание 2
//  https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

// 3. Дан следующий код, исправьте его там, где требуется (задание 3
// https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

// 4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            Float num = inputFloat(sc);
            System.out.println(num);
            String str = inputString(sc);
            System.out.println(str);
        }

        // 2. Если необходимо, исправьте данный код (задание 2
//  https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
        try {
            int[] intArray = new int[10];
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (NullPointerException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) { // Если массив будет меньше чем индекс 8.
            System.out.println("Catching exception: " + e);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
        // Скормить строку не удастся, будет ошибка компиляции, но на всякий случай
        catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    // 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
    // и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению
    // приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
    public static Float inputFloat(Scanner sc) {
        Float result = null;
        while (result == null) {
            try {
                System.out.print("Введите дробное число: ");
                result = Float.parseFloat(sc.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Введены некорректные данные, повторите ввод");
            } 
        }
        return result;
    }

    


// 4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
    static String inputString(Scanner sc) throws RuntimeException {
        String result = null;
        while (result == null || result.length() == 0) {
            try {
                System.out.print("Введите строку: ");
                result = sc.nextLine();
                if (result.length() == 0 || result == null) {
                    throw new RuntimeException("Пустые строки вводить нельзя");
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("Введены некорректные данные, повторите ввод");
            } 
        }
        return result;
    }
}
    