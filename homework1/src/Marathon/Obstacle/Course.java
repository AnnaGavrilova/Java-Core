package Marathon.Obstacle;

import Marathon.Competitors.Competitor;
import Marathon.Team;

public class Course {

    public Obstacle[] courses;

    public Course(Obstacle...courses) {
        this.courses = courses;
    }

    public void doIt(Team team) {
        for (Competitor c : team.getCompetitors()) {
            for (Obstacle o : courses) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }
}
