import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Main {
    public static void main(String[] args) {
        List<BaseHero> team1 = new ArrayList<>();
        team1.add(new Peasant("Robert"));
        team1.add(new Monk("Alex"));
        team1.add(new Robber("Max"));
        team1.add(new Sniper("Alexandr"));
        team1.add(new Spearman("Den"));
        team1.add(new Wizard("Ruslan"));
        team1.add(new Сrossbowman("Danil"));
        
        PrintHero(team1, "all");

        int min = 0;
        int max = 6;

        List<BaseHero> team2 = new ArrayList<>();
        int numHeroToCreate = 50;
        for (int i = 0; i < numHeroToCreate; i++) {
            int rndInt = ThreadLocalRandom.current().nextInt(min, max + 1);
            switch (rndInt) {
                case 0:
                    team2.add(new Peasant());
                    break;
                case 1:
                    team2.add(new Monk());
                    break;
                case 2:
                    team2.add(new Robber());
                    break;
                case 3:
                    team2.add(new Sniper());
                    break;
                case 4:
                    team2.add(new Spearman());
                    break;
                case 5:
                    team2.add(new Wizard());
                    break;
                case 6:
                    team2.add(new Сrossbowman());
                    break;
                default:
                    break;
            }
        }
        System.out.println();
        // Вывод конкретного класса из созданного списка
        System.out.println(PrintHero(team2, "Wizard"));
        // Вывод конкретного класса из всех созданных экземпляров класса BaseHero
        System.out.print(BaseHero.ListHeroes("Robber"));
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
