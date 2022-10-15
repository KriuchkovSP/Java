// 1. Написать программу вычисления n-ого треугольного числа.

import java.util.Scanner;

public class app_hw_1 {
    public static void main(String[] args){
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите число: ");
        String result = "";
        if (iScanner.hasNextInt()) {
            int num = iScanner.nextInt();
            if (num > 0){
                int n_triang = calc_triang(num);
                result = String.format("Вычисленное треугольное число = %d", n_triang);
            } else {
                result ="Введены невалидные данные";
            }
            
        } else {
            result ="Введены невалидные данные";
        }
        System.out.println(result);
    }

    public static int calc_triang(int n) {
        int result = n * (n + 1) / 2;
        return result;
    }
}
