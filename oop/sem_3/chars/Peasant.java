import java.util.List;

public class Peasant extends BaseDamager {

    public Peasant(String name, List<BaseHero> team) {
        super(1, 1, 0, new int[]{1,1}, 1, 3, name,"Peasant", team);
    }
    public Peasant(List<BaseHero> team, int x, int y) {
        this("",team);
        super.position = new Vector2(x, y);
    }
}