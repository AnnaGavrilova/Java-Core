package Heroes;

import java.util.Random;

public class Assassin extends Hero {

    private int criticalHit;
    private Random random = new Random();

    public Assassin(int heal, String name, int damage, int cure) {
        super(heal, name, damage, cure);
        this.criticalHit = random.nextInt(20);
    }

    @Override
    public void hit(Hero hero) {
        if (hero != this) {
            hero.causeDamage(damage + criticalHit);
            System.out.println(this.name + " наносит урон " + hero.getName());
        }
    }

    @Override
    public void healing(Hero hero) {
        System.out.println("Убийцы не умеют лечить!");
    }
}
