import java.util.List;

public class Robber extends BaseDamager {

    public Robber(String name, List<BaseHero> team) {
        super(8, 3, new int[]{2,4}, 10, 6, name, "Robber", team);
    }
    public Robber(List<BaseHero> team, int x, int y) {
        this("",team);
        super.position = new Vector2(x, y);
    }
}