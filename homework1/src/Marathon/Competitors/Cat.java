package Marathon.Competitors;

import Marathon.Competitors.Animal;

public class Cat extends Animal {

    public Cat(String name) {
        super("Кот", name, 200, 20, 0);
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот " + this.name + " не умеет плавать!!!");
    }
}
