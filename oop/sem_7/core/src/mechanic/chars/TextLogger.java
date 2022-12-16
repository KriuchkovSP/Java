package mechanic.chars;
import java.util.List;

import mechanic.Mechanic;

public class TextLogger {
    private static String[] step_log = new String[Mechanic.NUMHEROTOCREATE * 2];
    public static void logAdd(boolean right, List<BaseHero> team, int idHero, List<BaseHero> list_enemy, int idHeroEnemy, int damage) {
        int temp = idHero;
        if (right) {temp += Mechanic.NUMHEROTOCREATE;}
        if (team.get(idHero).status.equals("dead")) {
            step_log[temp] = "Герой убит";
        } else if (damage == 0){
            step_log[temp] = String.format("%s.", team.get(idHero).getInfo());
        } else if (damage > 0){
            step_log[temp] = String.format("%s. %s получил урон %d.", team.get(idHero).getInfo(), list_enemy.get(idHeroEnemy).name, damage);
        } else {
            step_log[temp] = String.format("%s. %s был вылечен на %d.", team.get(idHero).getInfo(), list_enemy.get(idHeroEnemy).name, -damage);
        }
        if (list_enemy.get(idHeroEnemy).status.equals("dead")) {
            temp = idHeroEnemy;
            if (!right) {
                temp += Mechanic.NUMHEROTOCREATE;
            }
            if (step_log[temp] == "") {
                step_log[temp] = "Герой убит";
            }
            if (step_log[temp] != "" && !step_log[temp].equals("Герой убит")) {
                step_log[temp] += " Героя убили";
            }
        }
    }
    public static void logAdd(boolean right, List<BaseHero> team, int idHero, int idHeroRes) {
        int temp = idHero;
        if (right) {temp += Mechanic.NUMHEROTOCREATE;}
        if (team.get(idHero).status.equals("dead")) {
            step_log[temp] = "Герой убит";
        } else {
            step_log[temp] = String.format("%s. %s был воскрешен.", team.get(idHero).getInfo(), team.get(idHeroRes).name);
            temp = idHeroRes;
            if (right) {temp += Mechanic.NUMHEROTOCREATE;}
            step_log[temp] = "Герой воскрес";
        }
    }

    public static void logAddPeasant(boolean right, int num_row, List<BaseHero> team, int idHero) {
        int temp = num_row;
        if (right) temp += Mechanic.NUMHEROTOCREATE;
        step_log[temp] = team.get(idHero).getInfo() + ", used -> stand";
    }
    public static void clearLog() {
        for (int i = 0; i < step_log.length; i++) {
            step_log[i] = "";
        }
    }
    public static void firstLog(List<BaseHero> team_left, List<BaseHero> team_right) {
        for (int i = 0; i < Mechanic.NUMHEROTOCREATE; i++) {
            logAddfirst(false, team_left, i);
            logAddfirst(true, team_right, i);
        }
    }
    private static void logAddfirst(boolean right, List<BaseHero> team, int idHero) {
        int temp = idHero;
        if (right) {temp += Mechanic.NUMHEROTOCREATE;}
        step_log[temp] = String.format("%s", team.get(idHero).getInfo());
    }

    public static void logFormat() {
        int max_lenght = 0;
        int SHIFT = 8;
        for (int i = 0; i < Mechanic.NUMHEROTOCREATE; i++) {
            if (max_lenght < step_log[i].length()) {
                max_lenght = step_log[i].length();
            }
        }
        for (int i = 0; i < Mechanic.NUMHEROTOCREATE; i++) {
            while(step_log[i].length() < max_lenght + SHIFT) {
                step_log[i] += " ";
            }
        }
    }

    public static String[] logOut(int num_row) {
        return new String[] {step_log[num_row], step_log[num_row + Mechanic.NUMHEROTOCREATE]};
    }
}
