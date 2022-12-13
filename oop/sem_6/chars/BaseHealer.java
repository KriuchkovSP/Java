
import java.util.List;

public abstract class BaseHealer extends BaseHero{

    public BaseHealer(int attack, int defence, int[] damage, int maxHP, int speed,
            String name, String classHero, List<BaseHero> team) {
        super(attack, defence, damage, maxHP, speed, name, classHero, team);
        
    }
    
    private void heal(int heroInd, boolean right){
        int resHeal = team.get(heroInd).setHP(this.damage[0]);
        TextLogger.logAdd(right, this.team, team.indexOf(this), this.team, heroInd, -resHeal);
    }

    private void ressurection(int heroDeadInd, boolean right) {
        this.team.get(heroDeadInd).status = "stand";
        this.team.get(heroDeadInd).setHP(-1);
        TextLogger.logAdd(right, this.team, team.indexOf(this), heroDeadInd);
    }
    
    private void attackHero(BaseHero unit, double min_dist, boolean right) {
        if (getHP() > 0) {
            unit.setHP(this.attack);
            die(unit);
        }
        TextLogger.logAdd(right, this.team, team.indexOf(this), unit.team, unit.team.indexOf(unit), this.attack);
    }
    @Override
    public void Step(List<BaseHero> list_enemy, int idHero, boolean right) {
        int heroInd = 0;
        int heroDeadInd = 99;
        int minPercentHP = 100;
        boolean is_dead = false;
        if (getHP() > 0) {
            for (int i = 0; i < team.size(); i++) {
                if (!team.get(i).status.equals("dead")) {
                    int currentPerHP = team.get(i).getHP() * 100 / team.get(i).getMaxHP();
                    if (currentPerHP <= minPercentHP) {
                        minPercentHP = currentPerHP;
                        heroInd = i;
                    }
                } else {
                    is_dead = true;
                    heroDeadInd = i;
                }
            }
            if (minPercentHP > 75 && !is_dead) {
                double min_dist = 1000;
                idHero = 0;
                for (int i = 0; i < list_enemy.size(); i++) {
                    if(!list_enemy.get(i).status.equals("dead")) {
                        if(this.getPosition().getDistance(list_enemy.get(i).getPosition()) < min_dist) {
                            idHero = i;
                            min_dist = this.getPosition().getDistance(list_enemy.get(i).getPosition());
                        }
                    }
                }
                this.attackHero(list_enemy.get(idHero), min_dist, right);
            } else if (is_dead) {
                this.ressurection(heroDeadInd, right);
            } else {
                this.heal(heroInd, right);
            }
        }
    }

    @Override
    public void Step(List<BaseHero> list_enemy, boolean right) {
        Step(list_enemy, 0, right);
    }
}