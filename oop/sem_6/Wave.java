import java.util.ArrayDeque;
import java.util.Deque;

// Волновой алгоритм

public class Wave {
    public static Coord wave(int[][] battle_field, boolean right, Vector2 my_position, Vector2 enemy_position) {
        int num_in = 1;
        int num_out = 999;
        int block_1 = 777;
        int block_2 = 666;
        battle_field[my_position.x - 1][my_position.y - 1] = num_in;

        battle_field[enemy_position.x - 1][enemy_position.y - 1] = num_out;
        // Распечатаем полученное поле
        // PrintField(battle_field);
        // System.out.println();
        /* Правила прохода и приоритет:
            1 - вверх;
            2 - диаг вверх вправо
            3 - вправо;
            4 - диаг вниз вправо
            5 - вниз;
            6 - диаг вниз влево
            7 - влево.
            8 - диаг вверх влево
        */
        int start_col = 0;
        int start_row = 0;
        boolean is_entry = false;
        Deque<Coord> deque = new ArrayDeque<Coord>(10);
        int i = 0, j = 0;
        while(!is_entry){
            if (battle_field[i][j] == num_in){
                start_col = i;
                start_row = j;
                is_entry = true;
            }
            if (j < battle_field[i].length - 1){
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
            min_steps = battle_field[col][row] + 1;

            // вверх
            if(CheckStep(col, row - 1, num_out, battle_field)) {
                result = StepCounter(col, row - 1, num_out, battle_field[col][row], battle_field);
                if(result != 0){
                    deque.addFirst(new Coord(col, row - 1));
                }
                if (result == num_out) {
                    is_exit = true;
                }
            }
            // диагональ вверх вправо
            if(CheckStep(col + 1, row - 1, num_out, battle_field)) {
                result = StepCounter(col + 1, row - 1, num_out, battle_field[col][row], battle_field);
                if(result != 0){
                    deque.addFirst(new Coord(col + 1, row - 1));
                }
                if (result == num_out) {
                    is_exit = true;
                }
            }
            // вправо
            if(CheckStep(col + 1, row, num_out, battle_field) && !is_exit) {
                result = StepCounter(col + 1, row, num_out, battle_field[col][row], battle_field);
                if(result != 0){
                    deque.addFirst(new Coord(col + 1, row));
                }
                if (result == num_out) {
                    is_exit = true;
                }
            }
             // диагональ вправо вниз
             if(CheckStep(col + 1, row + 1, num_out, battle_field) && !is_exit) {
                result = StepCounter(col + 1, row + 1, num_out, battle_field[col][row], battle_field);
                if(result != 0){
                    deque.addFirst(new Coord(col + 1, row + 1));
                }
                if (result == num_out) {
                    is_exit = true;
                }
            }
            // вниз
            if(CheckStep(col, row + 1, num_out, battle_field) && !is_exit) {
                result = StepCounter(col, row + 1, num_out, battle_field[col][row], battle_field);
                if(result != 0){
                    deque.addFirst(new Coord(col, row + 1));
                }
                if (result == num_out) {
                    is_exit = true;
                }
            }
            // диагональ вниз влево
            if(CheckStep(col - 1, row + 1, num_out, battle_field) && !is_exit) {
                result = StepCounter(col - 1, row + 1, num_out, battle_field[col][row], battle_field);
                if(result != 0){
                    deque.addFirst(new Coord(col - 1, row + 1));
                }
                if (result == num_out) {
                    is_exit = true;
                }
            }
            // влево
            if(CheckStep(col - 1, row, num_out, battle_field) && !is_exit) {
                result = StepCounter(col - 1, row, num_out, battle_field[col][row], battle_field);
                if(result != 0){
                    deque.addFirst(new Coord(col - 1, row));
                }
                if (result == num_out) {
                    is_exit = true;
                }
            }
            // диагональ влево вверх
            if(CheckStep(col - 1, row - 1, num_out, battle_field) && !is_exit) {
                result = StepCounter(col - 1, row - 1, num_out, battle_field[col][row], battle_field);
                if(result != 0){
                    deque.addFirst(new Coord(col - 1, row - 1));
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
            battle_field[finish_col][finish_row] = min_steps;
            // Распечатаем полученное поле
            // PrintField(battle_field);
            // System.out.println();
            return GetWay(battle_field, finish_col, finish_row);

        } else {
            return new Coord(-1, -1);
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
                System.out.printf("%3d ",field[i][j]);
            }
            System.out.print('\n');
        }
    }
    // Получение кратчайшего пути
    public static Coord GetWay(int[][] array, int finish_col, int finish_row) {
        boolean is_no_way = false;
        Deque<Coord> way_deque = new ArrayDeque<Coord>(50);
        way_deque.addFirst(new Coord(finish_col, finish_row));
        while((array[finish_col][finish_row] != 1)){
            if ((finish_col - 1 >= 0) && (finish_row - 1 >= 0) && (array[finish_col - 1][finish_row - 1] == array[finish_col][finish_row] - 1)) {
                finish_col--;
                finish_row--;
            } else if ((finish_col - 1 >= 0) && (array[finish_col - 1][finish_row] == array[finish_col][finish_row] - 1)){
                finish_col--;
            } else if ((finish_col - 1 >= 0) && (finish_row + 1 < array[finish_col].length) && (array[finish_col - 1][finish_row + 1] == array[finish_col][finish_row] - 1)) {
                finish_col--;
                finish_row++;
            } else if (((finish_row + 1 < array[finish_col].length)) && (array[finish_col][finish_row + 1] == array[finish_col][finish_row] - 1)) {
                finish_row++;
            } else if ((finish_row + 1 < array[finish_col].length) && (finish_col + 1 < array.length) && (array[finish_col + 1][finish_row + 1] == array[finish_col][finish_row] - 1)) {
                finish_col++;
                finish_row++;
            } else if ((finish_col + 1 < array.length) && (array[finish_col + 1][finish_row] == array[finish_col][finish_row] - 1)) {
                finish_col++;
            } else if ((finish_col + 1 < array.length) && (finish_row - 1 >= 0) && (array[finish_col + 1][finish_row - 1] == array[finish_col][finish_row] - 1)) {
                finish_col++;
                finish_row--;
            } else if ((finish_row - 1 >= 0) && (array[finish_col][finish_row - 1] == array[finish_col][finish_row] - 1)) {
                finish_row--;
            } else {
                is_no_way = true;
            }
            if (!is_no_way){
                way_deque.addFirst(new Coord(finish_col, finish_row));
            }
        }
        // Возвращаем следующий шаг
        if (!is_no_way) {
            way_deque.pollFirst(); // Текущая координата, выкидываем из очереди
            // Coord temp = way_deque.pollFirst();
            // System.out.println(temp.getRow() + " " + temp.getCol());
            return way_deque.pollFirst();
        } else {
            return new Coord(-1, -1);
        }
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