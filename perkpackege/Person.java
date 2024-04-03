package perkpackege;
import java.util.Random;

public abstract class Person implements interStep{
    protected String name;
    protected int power;
    protected double health;
    protected double maxHealth;
    protected double defence;
    protected int damage;
    protected int armor;
    protected Point position;
    protected int iniciative;
    protected String history;
    protected boolean ingame;

    Random rdn = new Random();

    public Person (String name, int power, double health, double defence, int armor, int x, int y, int iniciative, boolean ingame) {
        this.name = name;
        this.power = power;
        this.health = health;
        this.defence = defence;
        this.armor = armor;
        this.position = new Point(x,y);
        this.iniciative = iniciative;
        this.ingame = ingame;
        this.history = "";
    };

    public int getArmor () {
        return this.armor;
    };


    public void setArmor (int strela) {
        this.armor += strela;
    };

    public void setPosititon (double x, double y) {
        position.setX(x);
        position.setY(y);
    };

    public double distanceTo(Person target) {
        double x = position.getX() - target.position.getX();
        double y = position.getY() - target.position.getY();
        return Math.sqrt(x * x + y * y);
    };

    public int getDamage (int damage) {
        return damage;
    };

    public double[] getCoords () {
        return new double[] {position.getY(), position.getX()};
    };

    public double getHealth () {
        return health;
    };

    public void healed (double health) {
        this.health = Math.min(this.health + health, this.maxHealth);
    };

    public String getInfo (String log) {
        this.history += log;
        return this.history;
    }
}
