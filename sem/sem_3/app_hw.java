import java.util.ArrayDeque;
import java.util.Deque;

// Волновой алгоритм

public class app_hw {
    public static void main(String[] args) {
        int num_in = 1;
        int num_out = 666;
        int block = 333;
        int[][] field = new int[15][15];
        // Зададим препятствие
        for (int row = 5; row < 12; row++) {
            field[6][row] = block;
            field[7][row] = block;
            field[9][row] = block;
        }
        for (int row = 8; row < 10; row++) {
            field[8][row] = block;
            field[10][row] = block;
        }
        for (int row = 3; row < 14; row++) {
            field[9][row] = block;
        }
        // Зададим выход
        field[14][5] = num_out;
        // field[9][10] = num_out;
        // Зададим точку старта
        field[0][10] = num_in;
        // Распечатаем полученное поле
        PrintField(field);
        System.out.println();
        /* Правила прохода и приоритет:
            1 - вверх;
            2 - вправо;
            3 - вниз;
            4 - влево.
        */
        int start_col = 0;
        int start_row = 0;
        boolean is_entry = false;
        Deque<Coord> deque = new ArrayDeque<Coord>(10);
        int i = 0, j = 0;
        while(!is_entry){
            if (field[i][j] == num_in){
                start_col = i;
                start_row = j;
                is_entry = true;
            }
            if (j < field[i].length){
                j++;
            } else {
                i++;
                j = 0;
            }
        }
        deque.addFirst(new Coord(start_col, start_row));
        Coord current = null;
        boolean is_exit = false;
        int result = 0;
        int min_steps = 0;
        while(((current = deque.pollLast()) != null) && !is_exit) {
            int col = current.getCol();
            int row = current.getRow();
            min_steps = field[col][row] + 1;

            // вверх
            if(CheckStep(col, row - 1, num_out, field)) {
                result = StepCounter(col, row - 1, num_out, field[col][row], field);
                if(result != 0){
                    deque.addFirst(new Coord(col, row - 1));
                }
                if (result == num_out) {
                    is_exit = true;
                }
            }
            // вправо
            if(CheckStep(col + 1, row, num_out, field) && !is_exit) {
                result = StepCounter(col + 1, row, num_out, field[col][row], field);
                if(result != 0){
                    deque.addFirst(new Coord(col + 1, row));
                }
                if (result == num_out) {
                    is_exit = true;
                }
            }
            // вниз
            if(CheckStep(col, row + 1, num_out, field) && !is_exit) {
                result = StepCounter(col, row + 1, num_out, field[col][row], field);
                if(result != 0){
                    deque.addFirst(new Coord(col, row + 1));
                }
                if (result == num_out) {
                    is_exit = true;
                }
            }
            // влево
            if(CheckStep(col - 1, row, num_out, field) && !is_exit) {
                result = StepCounter(col - 1, row, num_out, field[col][row], field);
                if(result != 0){
                    deque.addFirst(new Coord(col - 1, row));
                }
                if (result == num_out) {
                    is_exit = true;
                }
            }

        }
        if (is_exit){
            current = deque.pollFirst();
            int finish_col = current.getCol();
            int finish_row = current.getRow();
            field[finish_col][finish_row] = min_steps;
            String way = GetWay(field, finish_col, finish_row);
            PrintField(field);
            System.out.printf("Кратчайший путь, ходов - %d\n",min_steps);
            System.out.printf("Координаты выхода col = %d, row = %d\n", finish_col, finish_row);
            System.out.printf("Кратчайший путь: %s\n", way);
        } else {
            System.out.println("Нет пути");
        }
        
        
    }
    // Метод проверки возможности хода
    public static boolean CheckStep(int col, int row, int num_out, int[][] array) {
        boolean result = true;
        // Проверка границ поля
        if ((col < 0) || (row < 0) || (col >= array.length) || (row >= array[col].length)) {
            result = false;
            
        }
        // Проверка на возможность хода
        if (result && ((array[col][row] != 0) && (array[col][row] != num_out))) {
            result = false;
        }
        return result;
    }
    // Проверка нашел ли выход, или фиксирование хода
    public static int StepCounter(int col, int row, int num_out, int curr_step, int[][] array) {
        int result = 0;
        if (array[col][row] == num_out) {
            result = num_out;
        } else {
            array[col][row] = ++curr_step;
            result = curr_step;
        }
        return result;
    }
    // Печать массива
    public static void PrintField(int[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.printf("%3d ",field[j][i]);
            }
            System.out.print('\n');
        }
    }
    // Получение кратчайшего пути
    public static String GetWay(int[][] array, int finish_col, int finish_row) {
        boolean is_no_way = false;
        String way = "";
        Deque<Coord> way_deque = new ArrayDeque<Coord>(50);
        Coord cur_way = null;
        way_deque.addFirst(new Coord(finish_col, finish_row));
        while((array[finish_col][finish_row] != 1)){
            if ((finish_col - 1 >= 0) && (array[finish_col - 1][finish_row] == array[finish_col][finish_row] - 1)){
                finish_col--;
            } else if (((finish_row + 1 < array[finish_col].length)) && (array[finish_col][finish_row + 1] == array[finish_col][finish_row] - 1)) {
                finish_row++;
            } else if ((finish_col + 1 < array.length) && (array[finish_col + 1][finish_row] == array[finish_col][finish_row] - 1)) {
                finish_col++;
            } else if ((finish_row + 1 >= 0) && (array[finish_col][finish_row - 1] == array[finish_col][finish_row] - 1)) {
                finish_row--;
            } else {
                is_no_way = true;
            }
            if (!is_no_way){
                way_deque.addFirst(new Coord(finish_col, finish_row));
            }
        }
        System.out.print("\n");
        // Собираем строку пути из очереди
        if (!is_no_way) {
            while((cur_way = way_deque.pollFirst()) != null) {
                way += String.format("%d(%d, %d) ", array[cur_way.getCol()][cur_way.getRow()], cur_way.getCol(), cur_way.getRow());
            }
        } else {
            way = "Нет пути";
        }
        
        return way;
    }
}

class Coord{
    private int col;
    private int row;

    public Coord(int col, int row) {
        super();
        this.col = col;
        this.row = row;
    }
    public int getCol(){
        return col;
    }
    public int getRow(){
        return row;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public void setRow(int row) {
        this.row = row;
    }
}