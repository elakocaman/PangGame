package project;
//PangMenuBar.java
import javax.swing.*;

public class PangMenuBar extends JMenuBar {
 public PangMenuBar(GamePanel gamePanel) {
     JMenu gameMenu = new JMenu("Game");
     JMenuItem register = new JMenuItem("Register");
     JMenuItem login = new JMenuItem("Login");
     JMenuItem newGame = new JMenuItem("New");
     JMenuItem quit = new JMenuItem("Quit");

     gameMenu.add(register);
     gameMenu.add(login);
     gameMenu.add(newGame);
     gameMenu.add(quit);
     add(gameMenu);

     JMenu optionsMenu = new JMenu("Options");
     JMenuItem history = new JMenuItem("History");
     JMenuItem highScore = new JMenuItem("High Score");
     JMenu difficultyMenu = new JMenu("Difficulty");
     ButtonGroup group = new ButtonGroup();
     JRadioButtonMenuItem novice = new JRadioButtonMenuItem("Novice");
     JRadioButtonMenuItem intermediate = new JRadioButtonMenuItem("Intermediate");
     JRadioButtonMenuItem advanced = new JRadioButtonMenuItem("Advanced");

     group.add(novice);
     group.add(intermediate);
     group.add(advanced);
     difficultyMenu.add(novice);
     difficultyMenu.add(intermediate);
     difficultyMenu.add(advanced);

     optionsMenu.add(history);
     optionsMenu.add(highScore);
     optionsMenu.add(difficultyMenu);
     add(optionsMenu);

     JMenu helpMenu = new JMenu("Help");
     JMenuItem about = new JMenuItem("About");
     helpMenu.add(about);
     add(helpMenu);
     
  // Menü çubuğu içinde, butonları tanımladıktan sonra şu kodları ekle:

     register.addActionListener(e -> {
         new RegisterWindow(); // sadece pencere açılır
     });

     login.addActionListener(e -> {
         new LoginWindow(username -> {
             JOptionPane.showMessageDialog(null, "Welcome, " + username + "!");
             gamePanel.setCurrentUser(username); // gamePanel'a gönder
         });
     });

     newGame.addActionListener(e -> {
         if (gamePanel.getCurrentUser() == null) {
             JOptionPane.showMessageDialog(null, "Please log in before starting a game.");
             new LoginWindow(username -> {
                 gamePanel.setCurrentUser(username);
                 // burada oyun başlatılır
                 JOptionPane.showMessageDialog(null, "Game starting!");
                 // gamePanel.startGame(); // ileride burası aktif edilecek
             });
         } else {
             // kullanıcı zaten giriş yapmış
             JOptionPane.showMessageDialog(null, "Game starting!");
             // gamePanel.startGame(); // ileride
         }
     });

     quit.addActionListener(e -> System.exit(0));

     

     // Event Handlers (ileride eklenecek)
 }
}
