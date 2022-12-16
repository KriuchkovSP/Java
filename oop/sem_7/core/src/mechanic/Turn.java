package mechanic;
import java.util.List;

import mechanic.chars.BaseHero;

public class Turn {
    public static int[] right_team;
    public static int[] left_team;
    public static void initStep(List<BaseHero> team_left, List<BaseHero> team_right) {
        left_team = sortTeamStep(team_left);
        right_team = sortTeamStep(team_right);
    }
    public static void order() {
        if (ConsoleView.step > 0) {
            if (ConsoleView.step % 2 == 0) {
                teamStep(Mechanic.lightside, Mechanic.darkside, left_team, false);
                teamStep(Mechanic.darkside, Mechanic.lightside, right_team, true);
            } else {
                teamStep(Mechanic.darkside, Mechanic.lightside, right_team, true);
                teamStep(Mechanic.lightside, Mechanic.darkside, left_team, false);
            }
        }
    }
    /**
     * @param team
     * @param to_attack_team
     * @param array - Массив индексов, определяющих порядок хода
     * @param right - boolean, true - the right side is attacking
     */
    static void teamStep(List<BaseHero> team, List<BaseHero> to_attack_team, int[] array, boolean right) {
        for (int i = 0; i < array.length; i++) {
            team.get(array[i]).Step(to_attack_team, array[i], right);
        }
    }

    static int[] sortTeamStep(List<BaseHero> team) {
        // 1. Бойцы
        // 2. Маги
        // 3. Лучники
        // 4. Крестьяне
        int[] index = new int[Mechanic.NUMHEROTOCREATE];
        int j = 0;
        j = getIndex(index, j, "Lancer", "Robber", team);
        j = getIndex(index, j, "Сrossbowman", "Sniper", team);
        j = getIndex(index, j, "Monk", "Wizard", team);
        j = getIndex(index, j, "Peasant", "Peasant", team);
        return index;
    }

    static int getIndex(int[] index, int j, String class_hero_1, String class_hero_2, List<BaseHero> team) {
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i).classHero.equals(class_hero_1) || team.get(i).classHero.equals(class_hero_2)) {
                index[j] = i;
                j++;
            }
        }
        return j;
    }
}
    