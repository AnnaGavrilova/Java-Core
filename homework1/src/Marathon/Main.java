package Marathon;


import Marathon.Obstacle.*;

public class Main {
    public static void main(String[] args) {

        Course course = new Course(); //полоса препятствий

        Team team = new Team("Победители"); // команда

        course.doIt(team); // команда проходит полосу препятствий

        team.showRezults(); //показываем результаты

    }
}
