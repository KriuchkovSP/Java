import java.util.ArrayList;
import java.util.List;

public abstract class BaseHero {
    protected int attack;
    protected int defence;
    protected int dist_damage;
    protected int[] damage;
    protected int  hp;
    protected int speed;
    protected boolean delivery;
    protected boolean magic;
    protected String name;
    private int playerID;
    protected String classHero;

    public BaseHero(int attack, int defence, int dist_damage, int[] damage, int hp, int speed, boolean delivery,
            boolean magic, String name, String classHero) {
        this.attack = attack;
        this.defence = defence;
        this.dist_damage = dist_damage;
        this.damage = damage;
        this.hp = hp;
        this.speed = speed;
        this.delivery = delivery;
        this.magic = magic;
        this.name = name;
        heroes.add(this);
        this.playerID = heroes.size() - 1;
        if (name.equals("")) {
            this.name = String.format("default_name_%d", this.playerID);
        }
        this.classHero = classHero;
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
        return String.format("ID: %d, Name: %s, class: %s, attack: %d, defence: %d, dist_damage: %d, damage: %d-%d, HP: %d, speed: %d, delivery: %b, magic: %b", playerID, name, classHero, attack, defence, dist_damage, damage[0],damage[1], hp, speed, delivery, magic);
    }
    
}
