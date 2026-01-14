package project;

import javax.swing.*;

public class AboutWindow extends JFrame {
    public AboutWindow() {
        setTitle("About");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText(
        	    "Developer: Zimpabwe Filleri\n" +
        	    "School Number: 1234567\n" +
        	    "Email: zimpabwe@itu.edu.tr\n" +
        	    "CSE212 - Spring 2025\n" +
        	    "Pang Arcade Game Project"
        	);


        add(textArea);
        setVisible(true);
    }
}
