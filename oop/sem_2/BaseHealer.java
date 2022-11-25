import java.util.List;

public class BaseHealer extends BaseHero{

    public BaseHealer(int attack, int defence, int dist_damage, int[] damage, int maxHP, int speed,
            String name, String classHero, List<BaseHero> team) {
        super(attack, defence, dist_damage, damage, maxHP, speed, name, classHero, team);
        
    }
    
    public String Heal(){
        int minPercentHP = 100;
        int heroInd = 0;
        for (int i = 0; i < team.size(); i++) {
            int currentPerHP = team.get(i).currentHP * 100 / team.get(i).maxHP;
            if (currentPerHP <= minPercentHP) {
                minPercentHP = currentPerHP;
                heroInd = i;
            }
        }
        String result = String.format("Минимальное HP у %s - %d. ", team.get(heroInd).name, minPercentHP);
        if (team.get(heroInd).currentHP - this.damage[0] <= team.get(heroInd).maxHP) {
            team.get(heroInd).currentHP -= this.damage[0];
            result += String.format("Герой был вылечен на %d HP.\n\r", -this.damage[0]);
        } else {
            result += String.format("Герой был вылечен на %d HP.\n\r", team.get(heroInd).maxHP - team.get(heroInd).currentHP);
            team.get(heroInd).currentHP = team.get(heroInd).maxHP;
        }
        result += team.get(heroInd).getInfo();
        return result;
    }

    @Override
    public String Step(List<BaseHero> list_enemy) {
        String resHeal = this.Heal();
        return resHeal;
    }
}
