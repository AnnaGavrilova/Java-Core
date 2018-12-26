package Marathon;

import Marathon.Competitors.Cat;
import Marathon.Competitors.Competitor;
import Marathon.Competitors.Dog;
import Marathon.Competitors.Human;
import Marathon.Obstacle.*;

public class Main {
    public static void main(String[] args) {

        Course course = new Course(); //полоса препятствий

        Team team = new Team("Победители"); // команда

        course.doIt(team); // команда проходит полосу препятствий

        team.showRezults(); //показываем результаты

    }
}
