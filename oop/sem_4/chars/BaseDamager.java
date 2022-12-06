import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class BaseDamager extends BaseHero{

    public BaseDamager(int attack, int defence, int[] damage, int maxHP, int speed, 
            String name, String classHero, List<BaseHero> team) {
        super(attack, defence, damage, maxHP, speed, name, classHero, team);

    }
/*
 * если == 0 то среднее повреждение
 * если < 0 максимальное
 * если > 0 то минимальное
 * если расстояние больше скорости то ещё и пополам делим 
 */
    public void Attack(BaseHero unit, double distance, boolean right) {
        int doneDamage = 0;
        if (getHP() > 0) {
            if (this.attack > unit.defence) {
                doneDamage = this.damage[1];
            } else if (this.attack == unit.defence) {
                doneDamage = this.damage[0] + (this.damage[1] - this.damage[0]) / 2;
            } else {
                doneDamage = this.damage[0];
            }
            if ((distance > (double)speed) && distance != 1000) {doneDamage /= 2;}
            if (distance > 0 && distance != 1000) {
                unit.setHP(doneDamage);
            } else {
                doneDamage = 0;
            }
            die(unit);
        }
        TextLogger.logAdd(right, this.getPosition().x - 1, this.team, team.indexOf(this), unit.team, unit.team.indexOf(unit), doneDamage);
    }

    @Override
    public void Step(List<BaseHero> list_enemy, int idHero, boolean right) {
        int i = 0;
        
        while (list_enemy.get(idHero).getHP() == 0) {
            idHero = i++;
            if (i == list_enemy.size()) {break;}
        }
        this.Attack(list_enemy.get(idHero), 1, right);
    }
    public void Step(List<BaseHero> list_enemy, boolean right) {
        int rndInd = ThreadLocalRandom.current().nextInt(0, list_enemy.size());
        Step(list_enemy, rndInd, right);
    }
}
