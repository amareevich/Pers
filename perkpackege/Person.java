package perkpackege;
import java.util.Random;

public abstract class Person implements interStep{
    protected String name;
    protected int age;
    protected int power;
    protected int health;
    protected int armor;
    protected int endurance;
    protected String weapon;
    protected Point position;
    protected int distance;
    protected int damage;
    protected int agility;
    protected int defence;
    protected int iniciative;
    protected String history;
    protected int maxHealth;

    Random rdn = new Random();

    public Person (String name, int age, int power, int health, int armor, int endurance, String weapon, int gold, int distance, int x, int y, int iniciative) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.health = health;
        this.armor = armor;
        this.endurance = endurance;
        this.weapon = weapon;
        this.distance = distance;
        this.damage = 10;
        this.position = new Point(x,y);
        this.agility = 1;
        this.defence = 10;
        this.iniciative = iniciative;
        this.history = "";
    };

    public int getArmor () {
        return this.armor;
    };

    public void setArmor (int strela) {
        this.armor += strela;
    };

    public void setPosititon (int x, int y) {
        position.setX(x);
        position.setY(y);
    };

    public double distanceTo(Person target) {
        double x = position.getX() - target.position.getX();
        double y = position.getY() - target.position.getY();
        return Math.sqrt(x * x + y * y);
    };

    public int getDamage (int damage) {
        int d = this.health - damage;
        return d;
    };

    public int[] getCoords () {
        return new int [] {position.getY(), position.getX()};
    };

    public int getHealth () {
        return health;
    };

    public void healed (int health) {
        this.health = Math.min(this.health + health, this.maxHealth);
    };
}
