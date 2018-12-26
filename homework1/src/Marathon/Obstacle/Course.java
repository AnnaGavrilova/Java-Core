package Marathon.Obstacle;

import Marathon.Competitors.Competitor;
import Marathon.Team;

public class Course {

    public Obstacle[] courses;

    public Course(){
        Cross cross = new Cross(80);
        Wall wall = new Wall(5);
        Water water = new Water(100);

        courses = new Obstacle[]{cross, wall, water};
    }

    public void doIt(Team team){
        for (int i = 0; i < team.competitors.length; i++) {
            for (Obstacle o : courses) {
                o.doIt(team.competitors[i]);
                if (!team.competitors[i].isOnDistance()) break;
            }
        }
    }
}
