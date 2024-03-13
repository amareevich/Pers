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

    public Person (String name, int age, int power, int health, int armor, int endurance, String weapon, int gold) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.health = health;
        this.armor = armor;
        this.endurance = endurance;
        this.weapon = weapon;
        this.gold= gold;
    }

}
