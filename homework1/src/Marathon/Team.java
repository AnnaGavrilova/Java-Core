package Marathon;

import Marathon.Competitors.Competitor;

public class Team {

    private String nameTeam;
    public Competitor[] competitors;

    public Team(String name, Competitor...competitors) {
        this.nameTeam = name;
        this.competitors = competitors;
    }

    public void showRezults() {
        for (Competitor c : competitors) {
            c.info();
        }
    }

    public Competitor[] getCompetitors(){
        return competitors;
    }
}
