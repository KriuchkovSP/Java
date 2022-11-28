import java.util.List;

public class Sniper extends BaseDamager {

    public Sniper(String name, List<BaseHero> team) {
        super(12, 10, 32, new int[]{8,10}, 15, 9, name, "Sniper", team);
    }
    public Sniper(List<BaseHero> team, int x, int y) {
        this("",team);
        super.position = new Vector2(x, y);
    }
}