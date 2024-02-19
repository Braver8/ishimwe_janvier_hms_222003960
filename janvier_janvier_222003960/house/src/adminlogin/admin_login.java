package adminlogin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import signupsetters.Signup;

public class admin_login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField emailTextField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    admin_login frame = new admin_login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public admin_login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 406, 329);
        setTitle("Admin Login"); 
        contentPane = new JPanel();
        contentPane.setBackground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        emailLabel.setBounds(86, 69, 46, 14);
        contentPane.add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setBackground(new Color(245, 245, 245));
        emailTextField.setBounds(86, 94, 214, 34);
        contentPane.add(emailTextField);
        emailTextField.setColumns(10);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        passwordLabel.setBounds(86, 135, 91, 14);
        contentPane.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBackground(new Color(245, 245, 245));
        passwordField.setBounds(86, 160, 214, 34);
        contentPane.add(passwordField);

        JButton loginButton = new JButton("LOGIN");
        loginButton.setBackground(new Color(25, 25, 112));
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = emailTextField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);
                
                // Simulating login process
                // Replace this with actual login logic
                if (isValidLogin(username, password)) {
                    // Login successful
                    JOptionPane.showMessageDialog(contentPane, "Login successful");
                    // Open menu window
                    SwingUtilities.invokeLater(() -> new Menu(username));
                } else {
                    // Login failed
                    JOptionPane.showMessageDialog(contentPane, "Invalid username or password");
                }
            }
        });
        loginButton.setBounds(88, 225, 212, 39);
        contentPane.add(loginButton);

        JButton forgotPasswordButton = new JButton("Forgot Password?");
        forgotPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic for handling forgot password
                // For demonstration purposes, just showing a message dialog
                JOptionPane.showMessageDialog(contentPane, "Please contact administrator for password reset.");
            }
        });
        forgotPasswordButton.setBounds(115, 275, 150, 30);
        contentPane.add(forgotPasswordButton);

        JButton createAccountButton = new JButton("Create New Account");
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open registration form
                Signup registrationForm = new Signup();
                registrationForm.setVisible(true);
                // Hide the current login frame
                setVisible(false);
            }
        });
        createAccountButton.setBounds(88, 320, 212, 39);
        contentPane.add(createAccountButton);
    }
    
    private boolean isValidLogin(String username, String password) {
        // Implement your actual login logic here
        // For example, you might check against a database of users
        return username.equals("admin") && password.equals("admin123");
    }
}
