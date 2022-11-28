import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static final int NUMHEROTOCREATE = 10;
    public static List<BaseHero> darkside;
    public static List<BaseHero> lightside;
    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        String[] lightside_text;
        String[] darkside_text;
        while (true){
            if (ConsoleView.step > 0) {
                if (ConsoleView.step % 2 == 0) {
                    lightside_text = teamStep(lightside, darkside);
                    darkside_text = teamStep(darkside, lightside);
                } else {
                    darkside_text = teamStep(darkside, lightside);
                    lightside_text = teamStep(lightside, darkside);
                }
            } else {
                lightside_text = new String[NUMHEROTOCREATE];
                darkside_text = new String[NUMHEROTOCREATE];
                for (int i = 0; i < NUMHEROTOCREATE; i++) {
                    lightside_text[i] = lightside.get(i).getInfo();
                    darkside_text[i] = darkside.get(i).getInfo();
                }
            }
            
            int max_lenght = 0;
            for (int i = 0; i < NUMHEROTOCREATE; i++) {
                if (max_lenght < lightside_text[i].length()) {
                    max_lenght = lightside_text[i].length();
                }
            }
            String temp = "";
            if (GameOver(darkside)) {
                temp = AnsiColors.ANSI_GREEN+"Темная сторона пала :("+AnsiColors.ANSI_RESET;
            } else if (GameOver(lightside)){
                temp = AnsiColors.ANSI_BLUE+"Светлая сторона пала, тьма воссторжестовала!"+AnsiColors.ANSI_RESET;
            }
            ConsoleView.view(darkside_text, lightside_text, max_lenght);

            if (GameOver(darkside) || GameOver(lightside)) {
                System.out.println(temp);
                break;
            } else {
                System.out.println("Press ENTER");
                scanner.nextLine();
            }
        }
    }
        
    private static void init() {
        darkside = new ArrayList<>();
        lightside = new ArrayList<>();
        
        int x=1;
        int y=1;
        for (int i = 0; i < NUMHEROTOCREATE; i++) {
            switch (new Random().nextInt(4)){
                case 0: darkside.add(new Peasant(darkside, x++, y)); break;
                case 1: darkside.add(new Lancer(darkside, x++, y)); break;
                case 2: darkside.add(new Crossbowman(darkside, x++, y)); break;
                default: darkside.add(new Wizard(darkside, x++, y));
            }
        }

        x=1;
        y=10;
        for (int i = 0; i < NUMHEROTOCREATE; i++) {
            switch (new Random().nextInt(4)){
                case 0: lightside.add(new Peasant(lightside, x++, y)); break;
                case 1: lightside.add(new Robber(lightside, x++, y)); break;
                case 2: lightside.add(new Sniper(lightside, x++, y)); break;
                default: lightside.add(new Monk(lightside, x++, y));
            }
        }
    }

    static String[] teamStep(List<BaseHero> team, List<BaseHero> to_attack_team) {
        String[] result;
        result = new String[team.size()];
        for (int i = 0; i < team.size(); i++) {
            result[i] = team.get(i).Step(to_attack_team, i);
        }
        return result;
    }

    static boolean GameOver(List<BaseHero> team){
        boolean result = true;
        for (int i = 0; i < team.size(); i++) {
            if (!team.get(i).status.equals("dead")){
                result = false;
            }
        }
        return result;
    }

    static String PrintHero(List<BaseHero> list, String classHero) {
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).classHero.equals(classHero)) {
                result += list.get(i) + "\n\r";
            } else if (classHero.equals("all")){
                result += list.get(i) + "\n\r";
            }
        }
        return result;
    }
}
