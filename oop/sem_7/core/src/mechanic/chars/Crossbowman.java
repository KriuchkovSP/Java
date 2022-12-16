package mechanic.chars;
import java.util.List;

public class Crossbowman extends BaseDistDamager {
    public Crossbowman(String name, List<BaseHero> team) {
        super(6, 3, new int[]{2,3}, 10, 4, name, "Сrossbowman", team);
        this.shoot = 16;
    }
    public Crossbowman(List<BaseHero> team, int x, int y) {
        this("",team);
        super.position = new Vector2(x, y);
    }
}