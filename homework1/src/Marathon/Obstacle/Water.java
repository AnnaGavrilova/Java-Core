package Marathon.Obstacle;

import Marathon.Competitors.Competitor;

public class Water extends Obstacle{
    int distance;

    public Water(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(distance);
    }
}
