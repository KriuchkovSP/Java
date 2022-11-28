import java.util.List;

public class Monk extends BaseHealer {

    public Monk(String name, List<BaseHero> team) {
        super(12, 7, 0, new int[]{-4,-4}, 30, 5, name, "Monk", team);
    }
    public Monk(List<BaseHero> team, int x, int y) {
        this("",team);
        super.position = new Vector2(x, y);
    }

}