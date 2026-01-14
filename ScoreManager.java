package project;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ScoreManager {
    private static final String SCORE_FILE = "scores.csv";

    public static void saveScore(String username, int score) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SCORE_FILE, true))) {
            String timestamp = new Date().toString();
            writer.write(username + "," + score + "," + timestamp);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getUserHistory(String username) {
        List<String> history = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(SCORE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(username + ",")) {
                    history.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return history;
    }

    public static List<String> getTop10Scores() {
        List<String> allScores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(SCORE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                allScores.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allScores.stream()
                .sorted((a, b) -> {
                    int scoreA = Integer.parseInt(a.split(",")[1]);
                    int scoreB = Integer.parseInt(b.split(",")[1]);
                    return Integer.compare(scoreB, scoreA);
                })
                .limit(10)
                .collect(Collectors.toList());
    }
}
