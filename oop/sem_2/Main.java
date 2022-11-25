import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Main {
    public static void main(String[] args) {
        int numHeroToCreate = 10;
        List<BaseHero> darkside = new ArrayList<>();
        List<BaseHero> lightside = new ArrayList<>();
        GenTeam(darkside, numHeroToCreate, 4, 6, "Peasant", "Wizard");
        GenTeam(lightside, numHeroToCreate, 1, 3, "Peasant", "Monk");
        
        System.out.println(PrintHero(darkside, "all"));
        System.out.println();
        System.out.println(PrintHero(lightside, "all"));

        System.out.println("Атакует lightside");
        teamStep(lightside, darkside);
        System.out.println();
        System.out.println("Атакует darkside");
        teamStep(darkside, lightside);
        System.out.println();
        
    }

    static void teamStep(List<BaseHero> team, List<BaseHero> to_attack_team) {
        for (int i = 0; i < team.size(); i++) {
            String result = team.get(i).Step(to_attack_team);
            System.out.print(result);
        }
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
    // ToDO: Сделать на переменное количество аргументов...
    static void GenTeam(List<BaseHero> team, int numHeroToCreate, int minIdHero, int maxIdHero, String classInclude1, String classInclude2, String classInclude3) {
        int numIncludeHero = 0;
        int max = 6;
        if (minIdHero == -1) {minIdHero = 0;}
        if (maxIdHero == -1) {maxIdHero = max;}
        
        // Если будет какой то массив аргументов, то можно while... и соблюдем DRY
        if (!classInclude1.equals("")){
            ListAddHero(team, classInclude1);
            numIncludeHero++;
        }
        if (!classInclude2.equals("")){
            ListAddHero(team, classInclude2);
            numIncludeHero++;
        }
        if (!classInclude3.equals("")){
            ListAddHero(team, classInclude3);
            numIncludeHero++;
        }
        for (int i = 0; i < numHeroToCreate - numIncludeHero; i++) {
            int rndInd = 0;
            do {
                rndInd = ThreadLocalRandom.current().nextInt(0, max + 1);
            } while (!(rndInd == 0 || (rndInd >= minIdHero && rndInd <= maxIdHero)));
            switch (rndInd) {
                case 0:
                    team.add(new Peasant(team));
                    break;
                case 1:
                    team.add(new Monk(team));
                    break;
                case 2:
                    team.add(new Robber(team));
                    break;
                case 3:
                    team.add(new Sniper(team));
                    break;
                case 4:
                    team.add(new Spearman(team));
                    break;
                case 5:
                    team.add(new Wizard(team));
                    break;
                case 6:
                    team.add(new Crossbowman(team));
                    break;
                default:
                    break;
            }
        }
    }

    static void ListAddHero(List<BaseHero> list, String classInclude){
        switch (classInclude) {
            case "Peasant":
                list.add(new Peasant(list));
                break;
            case "Monk":
                list.add(new Monk(list));
                break;
            case "Robber":
                list.add(new Robber(list));
                break;
            case "Sniper":
                list.add(new Sniper(list));
                break;
            case "Spearman":
                list.add(new Spearman(list));
                break;
            case "Wizard":
                list.add(new Wizard(list));
                break;
            case "Сrossbowman":
                list.add(new Crossbowman(list));
                break;
            default:
                break;
        }
    }

    static void GenTeam(List<BaseHero> team, int numHeroToCreate, int minIdHero, int maxIdHero, String classInclude1, String classInclude2) {
        GenTeam(team, numHeroToCreate, minIdHero, maxIdHero, classInclude1, classInclude2, "");
    }

    static void GenTeam(List<BaseHero> team, int numHeroToCreate, int minIdHero, int maxIdHero, String classInclude1) {
        GenTeam(team, numHeroToCreate, minIdHero, maxIdHero, classInclude1, "");
    }
    static void GenTeam(List<BaseHero> team, int numHeroToCreate, int minIdHero, int maxIdHero) {
        GenTeam(team, numHeroToCreate, minIdHero, maxIdHero, "");
    }
    static void GenTeam(List<BaseHero> team, int numHeroToCreate, String classInclude1, String classInclude2, String classInclude3) {
        GenTeam(team, numHeroToCreate, -1, -1, classInclude1, classInclude2, classInclude3);
    }
    static void GenTeam(List<BaseHero> team, int numHeroToCreate, String classInclude1, String classInclude2) {
        GenTeam(team, numHeroToCreate, -1, -1, classInclude1, classInclude2, "");
    }
    static void GenTeam(List<BaseHero> team, int numHeroToCreate, String classInclude1) {
        GenTeam(team, numHeroToCreate, -1, -1, classInclude1, "");
    }
    static void GenTeam(List<BaseHero> team, int numHeroToCreate) {
        GenTeam(team, numHeroToCreate, -1, -1, "");
    }
}
