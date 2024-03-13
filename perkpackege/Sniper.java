package perkpackege;
//снайпер
public class Sniper extends Person{
    int arrow;
    public Sniper (String name, int age) {
        super(name, age, 20, 100, 50, 20, "arrow", 20);
        this.arrow = 20;
    }

    public void attack (Person person) {
        person.health -= this.power;
    }

    public void headshot (Person person) {
        person.armor -= person.armor;
    }

    @Override
    public String toString() {
        return super.name;
    }
}
