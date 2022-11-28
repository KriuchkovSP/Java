
import java.util.List;

public abstract class BaseHealer extends BaseHero{

    public BaseHealer(int attack, int defence, int dist_damage, int[] damage, int maxHP, int speed,
            String name, String classHero, List<BaseHero> team) {
        super(attack, defence, dist_damage, damage, maxHP, speed, name, classHero, team);
        
    }
    
    public String Heal(){
        String result = "";
        if (getHP() > 0) {
            int minPercentHP = 100;
            int heroInd = 0;
            for (int i = 0; i < team.size(); i++) {
                if (!team.get(i).status.equals("dead")) {
                    int currentPerHP = team.get(i).getHP() * 100 / team.get(i).getMaxHP();
                    if (currentPerHP <= minPercentHP) {
                        minPercentHP = currentPerHP;
                        heroInd = i;
                    }
                }
            }
            result = getInfo();
            // String result = String.format("Минимальное HP у %s - %d %%. ", team.get(heroInd).name, minPercentHP);
            int resHeal = team.get(heroInd).setHP(this.damage[0]);
            result += String.format(" %s + %d HP.", team.get(heroInd).name, resHeal);
            //result += team.get(heroInd).getInfo();
        } else {
            result = "Герой убит";
        }
        
        return result;
    }

    @Override
    public String Step(List<BaseHero> list_enemy, int idHero) {
        String resHeal = this.Heal();
        return resHeal;
    }
    public String Step(List<BaseHero> list_enemy) {
        return Step(list_enemy, 0);
    }
}