import java.util.List;

public class Crossbowman extends BaseHero {

    public Crossbowman(String name, List<BaseHero> team) {
        super(6, 3, 16, new int[]{2,3}, 10, 4, name, "Сrossbowman", team);

    }
    public Crossbowman(List<BaseHero> team) {
        this("",team);
    }
}