import Dialoges.Info;

import javax.swing.*;

public class MainClass {

    public static void main(String[] args) {

        JFrame gameForm = new MainForm();
        gameForm.setVisible(true);

        Info.infoBox("Выберите из списков участников двух команд!" + "\n" +
                "В командах должно быть равное количество игроков. " + "\n" +
                "Нажмите на START, чтобы начать битву.", "ПРАВИЛА ИГРЫ");


    }
}
