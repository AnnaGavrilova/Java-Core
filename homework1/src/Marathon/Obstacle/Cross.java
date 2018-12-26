package Marathon.Obstacle;

import Marathon.Competitors.Competitor;

public class Cross extends Obstacle {
    int distance;

    public Cross(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(distance);
    }
}
