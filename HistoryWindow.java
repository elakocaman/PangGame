package project;
import javax.swing.*;
import java.util.List;

public class HistoryWindow extends JFrame {
    public HistoryWindow(String username) {
        setTitle("Score History");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        List<String> history = ScoreManager.getUserHistory(username);
        JTextArea area = new JTextArea();
        area.setEditable(false);

        for (String line : history) {
            area.append(line + "\n");
        }

        JScrollPane scroll = new JScrollPane(area);
        add(scroll);

        setVisible(true);
    }
}
