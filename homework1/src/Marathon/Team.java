package Marathon;

import Marathon.Competitors.Cat;
import Marathon.Competitors.Competitor;
import Marathon.Competitors.Dog;
import Marathon.Competitors.Human;

public class Team {

    String nameTeam;
    public Competitor[] competitors;

    public Team(String name){
        this.nameTeam = name;
        Human human1 = new Human ("Боб", 5000, 30, 200);
        Human human2 = new Human("Джо", 2000, 30, 200);
        Cat cat = new Cat("Барсик");
        Dog dog = new Dog("Бобик");
        competitors = new Competitor[]{human1, human2, cat, dog};
    }

    public void showRezults(){
        for (Competitor c : competitors) {
            c.info();
        }
    }
}
