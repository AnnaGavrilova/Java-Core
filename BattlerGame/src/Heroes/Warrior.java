package Heroes;

import java.sql.SQLOutput;

public class Warrior extends Hero {

    public Warrior(int health, String name, int damage, int cure) {
        super(health, name, damage, cure);
    }

    @Override
    public void hit(Hero hero) {
        if (hero != this) {
            hero.causeDamage(damage);
            System.out.println(this.name + " наносит урон " + hero.getName());
        }
    }

    @Override
    public void healing(Hero hero) {
        System.out.println("Войны не умеют лечить!");
    }
}
