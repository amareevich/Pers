package perkpackege;
//разбойник
public class Outlaw extends Person{
    public Outlaw (String name, int age, int x, int y) {
        super(name, age, 20, 100, 50, 20, "knife", 20, 1, x, y);
    }

    public void attack (Person person) {
        person.health -= this.power;
    }

    public void theft (Person person, int val) {
        person.gold -= val;
    }

    @Override
    public String toString() {
        return String.format("[Разбойник] %s", super.name + " " + position.toString());
    }
}
