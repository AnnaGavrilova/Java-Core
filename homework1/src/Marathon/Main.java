package Marathon;


import Marathon.Competitors.Cat;
import Marathon.Competitors.Dog;
import Marathon.Competitors.Human;
import Marathon.Obstacle.*;

public class Main {
    public static void main(String[] args) {

        Course course = new Course(new Cross(80), new Wall(5), new Water(100));

        Team team = new Team("Победители", new Human("Боб", 5000, 30, 200),
                new Human("Джо", 2000, 30, 200), new Cat("Барсик"), new Dog("Бобик"));

        course.doIt(team); // команда проходит полосу препятствий

        team.showRezults(); //показываем результаты

    }
}
