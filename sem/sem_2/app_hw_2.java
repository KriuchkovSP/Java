// 2. Реализовать алгоритм сортировки вставками

public class app_hw_2 {
    public static void main(String[] args) {
        int[] arr = {3, 7, 4, 9, 5, 2, 6, 1};
        System.out.println("Массив для сортировки:");
        print_arr(arr);
        int[] sort_arr = sort_insert(arr);
        print_arr(sort_arr);
    }

    public static void print_arr(int[] array) {
        for (int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.printf("\n");
    }

    public static int[] sort_insert(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    // print_arr(array); // отладочный вывод
                }
            }
            // System.out.println(); // разделение между циклами при отладке
        }
        return array;
    }
}
