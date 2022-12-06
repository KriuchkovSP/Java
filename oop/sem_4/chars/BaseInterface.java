import java.util.List;

public interface BaseInterface {
    String getInfo();
    void Step(List<BaseHero> list_enemy, int idHero, boolean right);
    void Step(List<BaseHero> list_enemy, boolean right);
}
