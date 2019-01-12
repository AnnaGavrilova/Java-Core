package Heroes;

public class Doctor extends Hero {
    public Doctor(int heal, String name, int damage, int cure) {
        super(heal, name, damage, cure);
    }

    @Override
    public void hit(Hero hero) {
        System.out.println("Доктор не может бить!");
    }

    @Override
    public void healing(Hero hero) {
        int check = cure + hero.getHealth();
        if (check < hero.getHealth()) {
            hero.addHealth(cure);
            System.out.println(this.name + " лечит " + hero.getName());
        }
    }
}
