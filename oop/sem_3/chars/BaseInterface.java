import java.util.List;

public interface BaseInterface {
    String getInfo();
    String Step(List<BaseHero> list_enemy, int idHero);
    String Step(List<BaseHero> list_enemy);
}
