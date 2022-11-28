import java.util.List;

public class Lancer extends BaseDamager {

    public Lancer(String name, List<BaseHero> team) {
        super(4, 5, 0, new int[]{1,3}, 10, 4, name, "Lancer", team);
    }
    public Lancer(List<BaseHero> team, int x, int y) {
        this("",team);
        super.position = new Vector2(x, y);
    }
}