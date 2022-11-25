import java.util.List;

public class Sniper extends BaseHero {

    public Sniper(String name, List<BaseHero> team) {
        super(12, 10, 32, new int[]{8,10}, 15, 9, name, "Sniper", team);
    }
    public Sniper(List<BaseHero> team) {
        this("",team);
    }
}