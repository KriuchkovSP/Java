import java.util.List;

public class Peasant extends BaseDamager {

    public Peasant(String name, List<BaseHero> team) {
        super(1, 1, new int[]{1,1}, 1, 3, name,"Peasant", team);
    }
    public Peasant(List<BaseHero> team, int x, int y) {
        this("",team);
        super.position = new Vector2(x, y);
    }
    @Override
    public void Step(List<BaseHero> list_enemy, int i, boolean right) {
        if (this.status.equals("used")) {
            this.status = "stand";
            TextLogger.logAddPeasant(right, getPosition().x - 1, this.team, team.indexOf(this));
        } else {
            super.Step(list_enemy, i, right);
        }
    }

}