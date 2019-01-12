package Heroes;

public abstract class Hero {

    protected int health;
    protected String name;
    protected int damage;
    protected int cure;

    public Hero(int health, String name, int damage, int cure) {
        this.health = health;
        this.name = name;
        this.damage = damage;
        this.cure = cure;
    }

    // метод нанесения удара
    public abstract void hit(Hero hero);

    // метод лечения
    public abstract void healing(Hero hero);

    // метод получения удара
    public void causeDamage(int damage) {
        health -= damage;
    }

    public int getHealth() {
        return health;
    }

    // метод для добавления здоровья
    public void addHealth(int health) {
        this.health += health;
    }

    public void info() {
        System.out.println(name + " " + (health < 0 ? "Герой мертвый" : health) + " " + damage);
    }

    public String getName() {
        return this.name;
    }
}
