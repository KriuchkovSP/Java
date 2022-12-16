package mechanic.chars;
import java.util.List;

public class Wizard extends BaseHealer {

    public Wizard(String name, List<BaseHero> team) {
        super(17, 12, new int[]{-5,-5}, 30, 9, name, "Wizard", team);
    }
    public Wizard(List<BaseHero> team, int x, int y) {
        this("",team);
        super.position = new Vector2(x, y);
    }

}