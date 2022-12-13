import java.util.List;

public class Sniper extends BaseDistDamager {
    public Sniper(String name, List<BaseHero> team) {
        super(12, 10, new int[]{8,10}, 15, 9, name, "Sniper", team);
        this.shoot = 16;
    }
    public Sniper(List<BaseHero> team, int x, int y) {
        this("",team);
        super.position = new Vector2(x, y);
    }
}