package perkpackege;

public abstract class Person {
    protected String name;
    protected int age;
    protected int power;
    protected int health;
    protected int armor;
    protected int endurance;
    protected String weapon;
    protected int gold;
    protected Point position;
    protected int distance;

    public Person (String name, int age, int power, int health, int armor, int endurance, String weapon, int gold, int distance, int x, int y) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.health = health;
        this.armor = armor;
        this.endurance = endurance;
        this.weapon = weapon;
        this.gold= gold;
        this.distance = distance;
        position = new Point(x,y);
    }

    public void setPosititon (int x, int y) {
        position.setX(x);
        position.setY(y);
    }

    public double distanceTo(Person target) {
        double x = position.getX() - target.position.getX();
        double y = position.getY() - target.position.getY();
        return Math.sqrt(x * x + y * y);
    }

}
