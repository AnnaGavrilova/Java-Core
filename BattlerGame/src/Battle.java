import Dialoges.Win;
import Exceptions.TeamException;
import Heroes.Doctor;
import Heroes.Hero;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Battle {

    public static void battle(ArrayList<Hero> team1, ArrayList<Hero> team2) throws TeamException {

        if ((team1.size() != team2.size()) || (team1.size() == 0) || (team2.size() == 0)) {
            throw new TeamException("Количество участников в командах должно быть равным!" +
                    "\n" + "Количество участников должно быть больше 0!");
        }

        for (int i = 0; i < team1.size(); i++) {
            System.out.println(team1.get(i).getName());
            System.out.println(team2.get(i).getName());
        }

        do {
            moveTeam(team1, team2);
            moveTeam(team2, team1);
        } while (team1.size() != 0 && team2.size() != 0);

        if (team1.size() == 0) {
            Win.winBox("Победила команда 2!", "ИГРА ОКОНЧЕНА!");
        } else {
            Win.winBox("Победила команда 1!", "ИГРА ОКОНЧЕНА!");

        }
    }

    public static void moveTeam(ArrayList<Hero> team1, ArrayList<Hero> team2) {
        Random random = new Random();

        for (int i = 0; i < team1.size(); i++) {
            if (team1.get(i) instanceof Doctor) {
                int indexh = random.nextInt(team1.size());
                team1.get(i).healing(team1.get(indexh));
                gameForm.setFieldText(team1.get(i), team1.get(indexh)); // нужен доступ к элементу на форме JTextArea
            } else {
                if (team2.size() == 0) break;
                int index = random.nextInt(team2.size());
                team1.get(i).hit(team2.get(index));
                gameForm.setFieldText(team1.get(i), team2.get(index)); // нужен доступ к элементу на форме JTextArea
                if (team2.get(index).getHealth() <= 0) {
                    team2.remove(index);
                }
            }
        }
    }
}
