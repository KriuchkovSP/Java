public class app_hw {
    public static void main(String[] args) {
        int[] arr = {3, 7, 4, -4, 9, 5, 2, 6, 1, -5};
        System.out.println("Массив для сортировки:");
        print_arr(arr);
        qsort(arr, 0, arr.length - 1);
        print_arr(arr);
    }

    public static void print_arr(int[] array) {
        for (int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.printf("\n");
    }
    
    public static void qsort(int[] arr, int low, int high) {
        if ((arr.length == 0) || (low >= high)) {
            return;
        }
        int pos_p = pos_pivot(arr, low, high);
        int p = arr[pos_p];
        int[] part_arr = partition(arr, p, low, high); // возвращается два значения
        if (low < part_arr[1]){
            qsort(arr, low, part_arr[1]);
        }
        if (high > part_arr[0]){
            qsort(arr, part_arr[0], high);
        }
    }

    public static int pos_pivot(int[] arr, int low, int high) {
        return low + (high - low) / 2;
    }

    public static int[] partition(int[] arr, int pivot, int low, int high) {
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        int[] result = {i, j};
        return result;
    }

    public static Boolean swap(int[] arr, int a, int b) {
        if((a < arr.length) && (b < arr.length)){
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            return true;
        }
        else {
            return false;
        }
    }
}