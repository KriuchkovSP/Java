package mechanic.chars;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import mechanic.Coord;
import mechanic.Wave;

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
    public void attackHero(BaseHero unit, double distance, boolean right) {
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
        TextLogger.logAdd(right, this.team, team.indexOf(this), unit.team, unit.team.indexOf(unit), doneDamage);
    }

    @Override
    public void Step(List<BaseHero> list_enemy, int idHero, boolean right) {
        double min_dist = 1000;
        for (int i = 0; i < list_enemy.size(); i++) {
            if(!list_enemy.get(i).status.equals("dead")) {
                if(this.getPosition().getDistance(list_enemy.get(i).getPosition()) < min_dist) {
                    idHero = i;
                    min_dist = this.getPosition().getDistance(list_enemy.get(i).getPosition());
                }
            }
        }
        if (min_dist < 1.5 && !this.status.equals("dead")) {
            this.attackHero(list_enemy.get(idHero), 1, right);
            this.move = false;
            this.dead = false;
            this.stand = false;
            this.fire = true;
            this.time = 0;
        } else {
            //Генерируем боевое поле с текущей ситуацией
            int[][] battle_field = BattleField.getField();
            //Волновой алгоритм
            Coord next_step = Wave.wave(battle_field, right, this.getPosition(), list_enemy.get(idHero).getPosition());
            Vector2 nxt_stp = new Vector2(next_step.getCol() + 1, next_step.getRow() + 1);
            if (!nxt_stp.equals(new Vector2(-1, -1))) {
                this.move = true;
                this.dead = false;
                this.stand = false;
                this.fire = false;
				this.time = 0;
                // System.out.printf("Curr pos x: %d y: %d\n\r", this.position.y, this.position.x);
                // System.out.printf("Next stp x: %d y: %d\n\r", nxt_stp.y, nxt_stp.x);
                this.position = nxt_stp;
                TextLogger.logAdd(right, this.team, team.indexOf(this), list_enemy, idHero, 0);
            }
        }
    }
    public void Step(List<BaseHero> list_enemy, boolean right) {
        int rndInd = ThreadLocalRandom.current().nextInt(0, list_enemy.size());
        Step(list_enemy, rndInd, right);
    }
}
