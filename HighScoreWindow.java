package project;

import javax.swing.*;
import java.util.List;

public class HighScoreWindow extends JFrame {
    public HighScoreWindow() {
        setTitle("Top 10 Scores");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        List<String> topScores = ScoreManager.getTop10Scores();
        JTextArea area = new JTextArea();
        area.setEditable(false);

        for (String line : topScores) {
            area.append(line + "\n");
        }

        JScrollPane scroll = new JScrollPane(area);
        add(scroll);

        setVisible(true);
    }
}
