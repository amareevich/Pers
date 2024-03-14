package perkpackege;
//копейщик
public class Spearman extends Person{
    int arrow;
    public Spearman (String name, int age, int x, int y) {
        super(name, age, 20, 100, 50, 20, "arrow", 20, 1,  x, y);
        this.arrow = 40;
    }

    public void attack (Person person) {
        person.health -= this.power;
    }

    @Override
    public String toString() {
        return String.format("[Копейщик] %s", super.name + " " + position.toString());
    }
}
