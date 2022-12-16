package mechanic;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import mechanic.chars.*;
// import mechanic.chars.Peasant;
// import mechanic.chars.TextLogger;


public class Mechanic {
    public static final int NUMHEROTOCREATE = 10;
    public static List<BaseHero> darkside;
    public static List<BaseHero> lightside;
    public static void mechanic(String[] args) {
        init();
        TextLogger.firstLog(Mechanic.lightside, Mechanic.darkside);
        Turn.initStep(lightside, darkside);
        Scanner scanner = new Scanner(System.in);
        while (true){
            if (ConsoleView.step > 0) {TextLogger.clearLog();}
            Turn.order();
            ConsoleView.view();
            if (GameOver(darkside) || GameOver(lightside)) {
                scanner.close();
                break;
            } else {
                scanner.nextLine();
            }
        }
    }
        
    private static void init() {
        darkside = new ArrayList<>();
        lightside = new ArrayList<>();
        
        int x=1;
        int y=10;
        for (int i = 0; i < NUMHEROTOCREATE; i++) {
            switch (new Random().nextInt(4)){
                case 0: darkside.add(new Peasant(darkside, x++, y)); break;
                case 1: darkside.add(new Lancer(darkside, x++, y)); break;
                case 2: darkside.add(new Crossbowman(darkside, x++, y)); break;
                default: darkside.add(new Wizard(darkside, x++, y));
            }
        }

        x=1;
        y=1;
        for (int i = 0; i < NUMHEROTOCREATE; i++) {
            switch (new Random().nextInt(4)){
                case 0: lightside.add(new Peasant(lightside, x++, y)); break;
                case 1: lightside.add(new Robber(lightside, x++, y)); break;
                case 2: lightside.add(new Sniper(lightside, x++, y)); break;
                default: lightside.add(new Monk(lightside, x++, y));
            }
        }
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
