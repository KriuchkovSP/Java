import java.util.List;

public class BaseDamager extends BaseHero{

    public BaseDamager(int attack, int defence, int dist_damage, int[] damage, int maxHP, int speed, 
            String name, String classHero, List<BaseHero> team) {
        super(attack, defence, dist_damage, damage, maxHP, speed, name, classHero, team);

    }
    
}
