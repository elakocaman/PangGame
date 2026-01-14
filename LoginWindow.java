package project;

import java.awt.*;

import javax.swing.*;

public class LoginWindow extends JFrame {
    public interface LoginCallback {
        void onLoginSuccess(String username);
    }

    public LoginWindow(LoginCallback callback) {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        JLabel lblUser = new JLabel("Username:");
        JTextField txtUser = new JTextField();
        JLabel lblPass = new JLabel("Password:");
        JPasswordField txtPass = new JPasswordField();
        JButton btnLogin = new JButton("Login");

        add(lblUser);
        add(txtUser);
        add(lblPass);
        add(txtPass);
        add(new JLabel());
        add(btnLogin);

        btnLogin.addActionListener(e -> {
            String user = txtUser.getText();
            String pass = new String(txtPass.getPassword());

            if (UserManager.validateLogin(user, pass)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                callback.onLoginSuccess(user);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password!");
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
