package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterWindow extends JFrame {
    public RegisterWindow() {
        setTitle("Register");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        JLabel lblUser = new JLabel("Username:");
        JTextField txtUser = new JTextField();
        JLabel lblPass = new JLabel("Password:");
        JPasswordField txtPass = new JPasswordField();
        JButton btnRegister = new JButton("Register");

        add(lblUser);
        add(txtUser);
        add(lblPass);
        add(txtPass);
        add(new JLabel()); // boşluk
        add(btnRegister);

        btnRegister.addActionListener(e -> {
            String user = txtUser.getText();
            String pass = new String(txtPass.getPassword());

            if (UserManager.registerUser(user, pass)) {
                JOptionPane.showMessageDialog(this, "User registered successfully!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Username already exists!");
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
