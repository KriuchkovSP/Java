

import java.util.ArrayList;
import java.util.List;

public abstract class BaseHero implements BaseInterface {
    protected int attack;
    protected int defence;
    protected int dist_damage;
    protected int[] damage;
    private int  maxHP;
    private int currentHP;
    protected int speed;
    protected String name;
    private int playerID;
    protected String classHero;
    protected List<BaseHero> team;
    protected Vector2 position;
    protected String status;

    public BaseHero(int attack, int defence, int dist_damage, int[] damage, int maxHP, int speed, 
            String name, String classHero, List<BaseHero> team) {
        this.attack = attack;
        this.defence = defence;
        this.dist_damage = dist_damage;
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
        this.status = "alive";
    }
    public int getMaxHP() {return maxHP;}
    public int getHP() {return currentHP;}
    public int setHP(int hp) {
        if (hp < 0) {hp = -hp;}
        if (currentHP + hp <= maxHP) {
            currentHP += hp;
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
    public String Attack(BaseHero unit) {
        String result = "";
        if (currentHP > 0) {
            int doneDamage = 0;
            if (this.attack > unit.defence) {
                doneDamage = this.damage[1];
            } else if (this.attack == unit.defence) {
                doneDamage = this.damage[0] + (this.damage[1] - this.damage[0]) / 2;
            } else {
                doneDamage = this.damage[0];
            }
            unit.currentHP -= doneDamage;
            result = getInfo();
            result += String.format(" Урон: %d %s", doneDamage, unit.name);
            Die(unit);
            //result += unit.getInfo();
        } else {
            result = "Герой убит";
        }

        return result;
    }
    public String Die(BaseHero unit) {
        if (unit.currentHP <= 0) {
            unit.currentHP = 0;
            unit.status = "dead";
            return String.format("%s был убит", unit.name);
        } else {return "";}
    }
    private static List<BaseHero> heroes = new ArrayList<>(); // Можно ли как то здесь переопределить печать...
    // чтобы вызов был что-то вроде heroes(или team1...team2 и т.д.).println("Wizard")...
    // так понимаю это надо как то расширять List...
    /**
     * 
     * @param classHero
     */
    public static String ListHeroes(String classHero) { // Почему компилятор потребовал static...
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

    // Не работает... надо разобраться
    // @Override
    // public static String ListHeroes() {
    //     ListHeroes("all");
    // }
    
    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, class: %s, attack: %d, defence: %d, dist_damage: %d, damage: %d-%d, MaxHP: %d, speed: %d", playerID, name, classHero, attack, defence, dist_damage, damage[0],damage[1], maxHP, speed);
    }
    
    @Override
    public String getInfo() {
        return String.format("Name: %s, class: %s, HP: %d/%d.", this.name, this.classHero, this.currentHP, this.maxHP);
    }

    
}
