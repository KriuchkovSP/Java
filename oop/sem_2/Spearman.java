import java.util.List;

public class Spearman extends BaseHero {

    public Spearman(String name, List<BaseHero> team) {
        super(4, 5, 0, new int[]{1,3}, 10, 4, name, "Spearman", team);
    }
    public Spearman(List<BaseHero> team) {
        this("",team);
    }
}