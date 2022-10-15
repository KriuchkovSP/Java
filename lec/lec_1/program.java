package lec.lec_1;
// для получения данных из консоли
import java.util.Scanner;
import java.io.FileReader;
// для работы с файлами
import java.io.FileWriter;
// для обработки исключений
import java.io.IOException;

import java.io.*;
//import lec.lec_1.lib;
/**
 * program
 */
public class program {
    public static void main(String[] args) {
        String s = "qwer";
        System.out.println(s.charAt(3));
        int a = 123;
        a++;
        System.out.println(a);
        System.out.println(a++);
        System.out.println(a);
        System.out.println(++a);
        a = 123;
        a = a-- - --a;
        System.out.println(a);
        a = 123;
        a = --a - a--;
        System.out.println(a);
        a = 8;
        // d10 = b1000
        System.out.println(a << 1); // 10000
        a = 18;
        // d10 = b10010
        System.out.println(a >> 1); // 1001
        a = 5;
        int b = 2;
        // 101
        // 010
        // 111
        System.out.println(a | b);
        
        // 101
        // 010
        // 000
        System.out.println(a & b);
        // 101
        // 010
        // 111
        System.out.println(a ^ b);
        String str = "qwe1"; // 4, 0...3
        boolean c = str.length() >= 5 | str.charAt(3) == '1';
        System.out.println(c);
        int[] arr = new int[10];
        arr[4] = 13;
        System.out.println(arr[3]);
        System.out.println(arr[4]);
        System.out.println(arr.length); // 10
        arr = new int[] {1, 2, 3, 4, 5};
        System.out.println(arr.length); // 5
        int[] arr2[] = new int[3][5];
        int[][] arr3 = new int[3][5];
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.printf("%d ", arr2[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                System.out.printf("%d ", arr3[i][j]);
            }
            System.out.println();
        }
        //Забрать данные из терминала (сперва импорт import.util.Scanner)
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("name: ");
        String name = iScanner.nextLine();
        System.out.printf("Привет, %s!\n", name);
        System.out.printf("int num1: ");
        if (iScanner.hasNextInt()) {
            int num1 = iScanner.nextInt();
            System.out.printf("Ввели число num1 = %d\n", num1);
        } else {
            System.out.println("Введены невалидные данные");
        }
        System.out.printf("double num2: ");
        if (iScanner.hasNextDouble()) {
            double num2 = iScanner.nextDouble();
            System.out.printf("Ввели число num2 = %.2f\n", num2);
        } else {
            System.out.println("Введены невалидные данные");
        }
        iScanner.close();
        //lec.lec_1.lib.sayHi();
        a = 3;
        b = 2;
        int min = a < b ? a : b;
        System.out.println(min);

        int[] arr4 = new int[] {1, 2, 3, 4, 5, 77};
        for (int item : arr4) {
            System.out.println(item);
        }

        try (FileWriter fw = new FileWriter("file.txt", false)) {
            fw.write("line1");
            fw.append('\n');
            fw.append('2');
            fw.append('\n');
            fw.write("line 3");
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        // Чтение файла посимвольно
        // public static void main(String[] args) throws Exception {
            // FileReader fr = new FileReader("/home/secure/Nextcloud/temp/Java/lec/lec_1/file.txt");
            // int d;
            // while ((d = fr.read()) != -1) {
            //     char ch = (char) d;
            //     if (ch == '\n') {
            //         System.out.println(ch);
            //     } else {
            //         System.out.println(ch);
            //     }
            // }
            // fr.close();
        // }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println("== %s ==\n", str);
            }
            br.close();
        }

    }
}
