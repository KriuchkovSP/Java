import java.util.List;

public class Сrossbowman extends BaseHero {

    public Сrossbowman(String name, List<BaseHero> team) {
        super(6, 3, 16, new int[]{2,3}, 10, 4, name, "Сrossbowman", team);

    }
    public Сrossbowman(List<BaseHero> team) {
        this("",team);
    }
}