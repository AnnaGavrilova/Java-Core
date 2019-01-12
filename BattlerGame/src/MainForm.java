import Exceptions.TeamException;
import Heroes.Assassin;
import Heroes.Doctor;
import Heroes.Hero;
import Heroes.Warrior;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class MainForm extends JFrame {

    public String[] elements = new String[]{"Warrior", "Assassin", "Doctor"};
    public String hero = "";
    public String hero2 = "";
    public ArrayList<Hero> team1 = new ArrayList<>();
    public ArrayList<Hero> team2 = new ArrayList<>();
    public Random random = new Random();
    String name = "";
    public String[] names = {"Джон", "Елизабет", "Рейнхарт", "Мойра", "Люсия",
            "Роджер", "Лукас", "Айра", "Томас", "Фьорд", "Иван", "Петр", "Сергей", "Иннокентий" +
            "Геракл", "Ольга", "Лара", "Никита", "Георгий", "Аксиний"};
    public JTextArea fieldText = new JTextArea(6, 21);

    public MainForm() {

        super("Simple battler game");
        setBounds(650, 350, 370, 380);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        getContentPane().add(panel);

        JPanel panelNorth = new JPanel(new FlowLayout());
        panel.add(panelNorth, BorderLayout.NORTH);
        JComboBox comboBox1 = new JComboBox(elements);
        panelNorth.add(comboBox1);
        JButton add1 = new JButton("ADD");
        panelNorth.add(add1);
        JComboBox comboBox2 = new JComboBox(elements);
        panelNorth.add(comboBox2);
        JButton add2 = new JButton("ADD");
        panelNorth.add(add2);

        JPanel panelCenter = new JPanel(new FlowLayout());
        panel.add(panelCenter, BorderLayout.CENTER);
        JTextArea fieldTeam1 = new JTextArea(10, 11);
        fieldTeam1.setForeground(Color.BLUE);
        JTextArea fieldTeam2 = new JTextArea(10, 11);
        fieldTeam2.setForeground(Color.RED);
        panelCenter.add(fieldTeam1);
        panelCenter.add(fieldTeam2);

        JPanel panelSouth = new JPanel(new FlowLayout());
        panel.add(panelSouth, BorderLayout.SOUTH);
        JButton start = new JButton("START");
        JTextArea fieldText = new JTextArea(6, 21);
        JScrollPane info = new JScrollPane(fieldText);
        info.setViewportView(fieldText);
        panelSouth.add(start);
        panelSouth.add(info);

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hero = (String) comboBox1.getSelectedItem();
                team1.add(createTeam(hero));
            }
        });

        add1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldTeam1.append(hero + "\n");
            }
        });

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hero2 = (String) comboBox2.getSelectedItem();
                team2.add(createTeam(hero2));
            }
        });

        add2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldTeam2.append(hero2 + "\n");
            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Battle.battle(team1, team2);
                } catch (TeamException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public Hero createTeam(String hero) {

        name = names[random.nextInt(19)];
        Hero mainHero = null;
        switch (hero) {
            case "Warrior":
                mainHero = new Warrior(250, name, 60, 0);
                break;
            case "Assassin":
                mainHero = new Assassin(150, name, 90, 0);
                break;
            case "Doctor":
                mainHero = new Doctor(120, name, 0, 80);
                break;
        }
        return mainHero;
    }

    public void setFieldText(Hero hero1, Hero hero2) {

        if (hero1 instanceof Doctor) {
            fieldText.append(hero1.getName() + " лечит " + hero2.getName() + ". Здоровья стало " + hero2.getHealth());
        } else {
            fieldText.append(hero1.getName() + " наносит удар " + hero2.getName() + ". Осталось " + hero2.getHealth() + " здоровья.");
        }

    }
}
