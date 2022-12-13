public class BattleField {
    public static int[][] getField() {
        int[][] battle_field = new int[10][10];
        for (int i = 0; i < battle_field.length; i++) {
            for (int j = 0; j < battle_field[i].length; j++) {
                battle_field[i][j] = ConsoleView.checkHero(new Vector2(i + 1, j + 1));
            }
        }
        return battle_field;
    }
}
