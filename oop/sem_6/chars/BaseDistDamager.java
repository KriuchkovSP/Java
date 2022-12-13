import java.util.List;

public abstract class BaseDistDamager extends BaseDamager {
    protected int shoot;
    public BaseDistDamager(int attack, int defence, int[] damage, int maxHP, int speed, 
        String name, String classHero, List<BaseHero> team) {
        super(attack, defence, damage, maxHP, speed, name, classHero, team);
    }
    @Override
    public void Step(List<BaseHero> list_enemy, int idHero, boolean right) {
        for (BaseHero h: this.team){
            if (h.getClassHero().equals("Peasant") && h.status.equals("stand")){
                this.shoot++;
                h.status = "used";
                break;
            }
        }
        double min_dist = 1000;
        if (this.shoot > 0) {
            this.shoot--;
            idHero = 0;
            for (int i = 0; i < list_enemy.size(); i++) {
                if(!list_enemy.get(i).status.equals("dead")) {
                    if(this.getPosition().getDistance(list_enemy.get(i).getPosition()) < min_dist) {
                        idHero = i;
                        min_dist = this.getPosition().getDistance(list_enemy.get(i).getPosition());
                    }
                }
            }
        } else {
            min_dist = 1000;
        }
        this.attackHero(list_enemy.get(idHero), min_dist, right);
    }
    @Override
    public void Step(List<BaseHero> list_enemy, boolean right) {
        Step(list_enemy, right);
    }
    @Override
    public String toString() {
        return super.toString() + String.format(", shoot: %d", shoot);
    }
    @Override
    public String getInfo() {
        return super.getInfo() + String.format(", shoot: %d", shoot);
    }
}
