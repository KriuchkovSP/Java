import java.util.List;

public class Peasant extends BaseHero {

    public Peasant(String name, List<BaseHero> team) {
        super(1, 1, 0, new int[]{1,1}, 1, 3, name,"Peasant", team);
    }
    public Peasant(List<BaseHero> team) {
        this("",team);
    }
}