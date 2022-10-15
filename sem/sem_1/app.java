/*
+На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть две команды
- команда 1 (к1): увеличить в с раза, а умножается на c
- команда 2 (к2): увеличить на d, к a прибавляется d
написать программу, которая выдаёт набор команд, позволяющий число a превратить в число b или сообщить,
 что это невозможно
Пример 1: а = 1, b = 7, c = 2, d = 1
ответ: к2, к2, к2, к2, к2, к2, k2 или к1, к1, к2, к2, к2 
Можно начать с более простого – просто подсчёта общего количества вариантов 
Пример 2: а = 11, b = 7, c = 2, d = 1
ответ: нет решения. 
*Подумать над тем, как сделать минимальное количество команд
*/

// для получения данных из консоли
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        // Scanner iScanner = new Scanner(System.in);
        // System.out.printf("Введите 4 числа (a b c d): ");
        // String numbers = iScanner.nextLine();
        // //num[0] - a
        // //num[1] - b
        // //num[2] - c
        // //num[3] - d
        // int[] num = new int[4];
        // String[] num_str = numbers.split(" ");
        // for (int i = 0; num_str.length; i++){
        //     num[i] = Integer.parseInt(num_str[i]);
        // }
        // System.out.println(num);
        System.out.println(calc(17, 54, 2, 10));

    }

    public static String calc(int a, int b, int c, int d) {
        int temp = 1;
        String result = "";
        while (a < b){
            if ((b / a) > c) {
                a = a * c;
                result += "k1 ";
            } else {
                a = a + d;
                result += "k2 ";
            }
        }
        if (result.equals("")){
            result = "Нет решения";
        }
        return result;
    }

    
}
