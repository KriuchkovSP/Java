package mechanic.chars;


import java.util.ArrayList;
import java.util.List;

public abstract class BaseHero implements BaseInterface {
    protected int attack;
    protected int defence;
    protected int[] damage;
    private int  maxHP;
    private int currentHP;
    protected int speed;
    protected String name;
    private int playerID;
    public String classHero;
    protected List<BaseHero> team;
    public Vector2 position;
    public String status;
    public boolean fire;
    public boolean move;
    public boolean stand;
    public boolean dead;
    public float time;

    public BaseHero(int attack, int defence, int[] damage, int maxHP, int speed, 
            String name, String classHero, List<BaseHero> team) {
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.speed = speed;
        this.name = name;
        heroes.add(this);
        this.playerID = heroes.size() - 1;
        if (name.equals("")) {
            this.name = String.format("default_name_%d", this.playerID);
        }
        this.classHero = classHero;
        this.team = team;
        this.status = "stand";
    }
    public int getMaxHP() {return maxHP;}
    public int getHP() {return currentHP;}
    public int setHP(int hp) {
        if (currentHP - hp <= maxHP) {
            currentHP -= hp;
            return hp;
        } else {
            int res = maxHP - currentHP;
            currentHP += res;
            return res;
        }
    }
    public Vector2 getPosition() {return position;}
    public String getName() {return name;}
    public String getClassHero() {return classHero;}
    
    public void die(BaseHero unit) {
        if (unit.currentHP <= 0) {
            unit.currentHP = 0;
            unit.status = "dead";
        }
    }
    private static List<BaseHero> heroes = new ArrayList<>();

    /**
     * 
     * @param classHero
     */
    public static String ListHeroes(String classHero) {
        String result = "";
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).classHero.equals(classHero)) {
                result += heroes.get(i) + "\n\r";
            } else if (classHero.equals("all")){
                result += heroes.get(i) + "\n\r";
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, class: %s, attack: %d, defence: %d, dist_damage: %d, damage: %d-%d, MaxHP: %d, speed: %d", playerID, name, classHero, attack, defence, damage[0],damage[1], maxHP, speed);
    }
    
    @Override
    public String getInfo() {
        return String.format("Name: %s, class: %s, HP: %d/%d", this.name, this.classHero, this.currentHP, this.maxHP);
    }

    
}
