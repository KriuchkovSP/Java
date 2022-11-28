import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class BaseDamager extends BaseHero{

    public BaseDamager(int attack, int defence, int dist_damage, int[] damage, int maxHP, int speed, 
            String name, String classHero, List<BaseHero> team) {
        super(attack, defence, dist_damage, damage, maxHP, speed, name, classHero, team);

    }
    @Override
    public String Step(List<BaseHero> list_enemy, int idHero) {
        int i = 0;
        while (list_enemy.get(idHero).getHP() == 0) {
            idHero = i++;
            if (i == list_enemy.size()) {break;}
        }
        String resAttack = this.Attack(list_enemy.get(idHero));
        return resAttack;
    }
    public String Step(List<BaseHero> list_enemy) {
        int rndInd = ThreadLocalRandom.current().nextInt(0, list_enemy.size());
        return Step(list_enemy, rndInd);
    }
}
