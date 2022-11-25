import java.util.List;

public class Robber extends BaseHero {

    public Robber(String name, List<BaseHero> team) {
        super(8, 3, 0, new int[]{2,4}, 10, 6, name, "Robber", team);
    }
    public Robber(List<BaseHero> team) {
        this("",team);
    }
}