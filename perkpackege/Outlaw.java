package perkpackege;
//разбойник
public class Outlaw extends Person{
    public Outlaw (String name, int age) {
        super(name, age, 20, 100, 50, 20, "knife", 20);
    }

    public void attack (Person person) {
        person.health -= this.power;
    }

    public void theft (Person person, int val) {
        person.gold -= val;
    }

    @Override
    public String toString() {
        return super.name;
    }
}
