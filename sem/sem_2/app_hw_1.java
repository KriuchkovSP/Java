// 1. Написать программу, показывающую последовательность действий для игры “Ханойская башня”
// Определимся с условиями для победы: необходимо переложить все круги на последний стержень
import java.util.Scanner;

public class app_hw_1 {
    public static void main(String[] args) {
        int num_rounds = InputData();
        if (num_rounds == -1) {
            System.out.println("Введено не валидное число");
        } else {
            char a = 'A';
            char b = 'B';
            char c = 'C';
            hanoe_tower(num_rounds, a, b, c);
        }
    }

    public static int InputData() {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите число: ");
        int num = 0;
        if (iScanner.hasNextInt()) {
            num = iScanner.nextInt();
        } else {
            num = -1;
        }
        iScanner.close();
        return num;
    }

    public static void hanoe_tower(int number, char a, char b, char c) {
        if (number > 1) {
            hanoe_tower(number - 1, a, c, b);
            System.out.printf("%c переносим на %c\n", a, c);
            hanoe_tower(number - 1, b, a, c);
        }
    }
}
