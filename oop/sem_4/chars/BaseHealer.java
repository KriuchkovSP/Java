
import java.util.List;

public abstract class BaseHealer extends BaseHero{

    public BaseHealer(int attack, int defence, int[] damage, int maxHP, int speed,
            String name, String classHero, List<BaseHero> team) {
        super(attack, defence, damage, maxHP, speed, name, classHero, team);
        
    }
    
    public void Heal(boolean right){
        int heroInd = 0;
        if (getHP() > 0) {
            int minPercentHP = 100;
            for (int i = 0; i < team.size(); i++) {
                if (!team.get(i).status.equals("dead")) {
                    int currentPerHP = team.get(i).getHP() * 100 / team.get(i).getMaxHP();
                    if (currentPerHP <= minPercentHP) {
                        minPercentHP = currentPerHP;
                        heroInd = i;
                    }
                }
            }
        }
        int resHeal = team.get(heroInd).setHP(this.damage[0]);
        TextLogger.logAdd(right, this.getPosition().x - 1, this.team, team.indexOf(this), this.team, heroInd, -resHeal);
    }

    @Override
    public void Step(List<BaseHero> list_enemy, int idHero, boolean right) {
        this.Heal(right);
    }
    public void Step(List<BaseHero> list_enemy, boolean right) {
        Step(list_enemy, 0, right);
    }
}