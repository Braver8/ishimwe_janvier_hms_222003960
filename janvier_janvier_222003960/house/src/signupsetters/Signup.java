package signupsetters;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import adminsetters.Admin;

public class Signup extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField fnametext;
    private JTextField lnametext;
    private JTextField idNumbertext;
    private JTextField phonetext;
    private JTextField martialStatustext;
    private JTextField dobtxt;
    private JTextField emailtext;
    private JPasswordField passwordtext;
    private JComboBox<String> gendertxt;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Signup frame = new Signup();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Signup() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SIGNUP FORM");
        setBounds(200, 100, 640, 450);
        contentPane = new JPanel();
        contentPane.setBackground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblfnmae = new JLabel("FIRST NAME :");
        lblfnmae.setBounds(10, 25, 77, 23);
        contentPane.add(lblfnmae);

        JLabel lbllname = new JLabel("LAST NAME :");
        lbllname.setBounds(10, 69, 77, 23);
        contentPane.add(lbllname);

        fnametext = new JTextField();
        fnametext.setBounds(97, 20, 180, 33);
        contentPane.add(fnametext);
        fnametext.setColumns(10);

        lnametext = new JTextField();
        lnametext.setBounds(97, 64, 180, 33);
        contentPane.add(lnametext);
        lnametext.setColumns(10);

        JLabel lblIdNumber = new JLabel("ID NUMBER :");
        lblIdNumber.setBounds(10, 119, 77, 23);
        contentPane.add(lblIdNumber);

        idNumbertext = new JTextField();
        idNumbertext.setBounds(97, 112, 180, 33);
        contentPane.add(idNumbertext);
        idNumbertext.setColumns(10);

        JLabel lblPhone = new JLabel("Phone :");
        lblPhone.setBounds(10, 170, 77, 23);
        contentPane.add(lblPhone);

        phonetext = new JTextField();
        phonetext.setBounds(97, 160, 180, 33);
        contentPane.add(phonetext);
        phonetext.setColumns(10);

        JLabel lblGender = new JLabel(" Gender :");
        lblGender.setBounds(10, 210, 77, 23);
        contentPane.add(lblGender);

        JLabel lblMartialStatus = new JLabel("Martial status :");
        lblMartialStatus.setBounds(348, 30, 77, 23);
        contentPane.add(lblMartialStatus);

        martialStatustext = new JTextField();
        martialStatustext.setBounds(425, 27, 180, 33);
        contentPane.add(martialStatustext);
        martialStatustext.setColumns(10);

        JLabel lblDateOfBirth = new JLabel("Date of Birth :");
        lblDateOfBirth.setBounds(348, 77, 77, 23);
        contentPane.add(lblDateOfBirth);

        dobtxt = new JTextField();
        dobtxt.setBounds(425, 73, 180, 33);
        contentPane.add(dobtxt);
        dobtxt.setColumns(10);

        JLabel lblEmail = new JLabel("Email :");
        lblEmail.setBounds(348, 124, 77, 23);
        contentPane.add(lblEmail);

        emailtext = new JTextField();
        emailtext.setBounds(425, 123, 180, 33);
        contentPane.add(emailtext);
        emailtext.setColumns(10);

        JLabel lblPhone_1_1 = new JLabel("Password :");
        lblPhone_1_1.setBounds(348, 183, 77, 23);
        contentPane.add(lblPhone_1_1);

        passwordtext = new JPasswordField();
        passwordtext.setBounds(425, 179, 182, 33);
        contentPane.add(passwordtext);

        JButton btnNewButton = new JButton("CANCEL");
        btnNewButton.setBounds(209, 285, 126, 33);
        contentPane.add(btnNewButton);

        JButton signUp = new JButton("SIGN UP");
        signUp.setBounds(380, 285, 132, 33);
        signUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    Admin ad = new Admin();
                    ad.setFname(fnametext.getText());
                    ad.setLname(lnametext.getText());
                    ad.setIdNumber(idNumbertext.getText());
                    ad.setPhone(phonetext.getText());
                    ad.setMartialStatus(martialStatustext.getText());
                    String selectedOption = gendertxt.getSelectedItem().toString();
                    ad.setGender(selectedOption);
                    ad.setDoB(dobtxt.getText());
                    ad.setEmail(emailtext.getText());
                    char[] passwordChars = passwordtext.getPassword();
                    String passwordString = new String(passwordChars);
                    ad.setPassword(passwordString);
                    if (ad.insertData()) {
                        JOptionPane.showMessageDialog(contentPane, "Registration successful!");
                        clearFields();
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Error occurred while registering. Please try again.");
                    }
                }
            }
        });
        contentPane.add(signUp);
        
        String[] gender = {"Male", "Female"};
        gendertxt = new JComboBox<>(gender);
        gendertxt.setBounds(97, 210, 180, 23);
        contentPane.add(gendertxt);
    }

    private boolean validateFields() {
        if (fnametext.getText().isEmpty() || lnametext.getText().isEmpty() || idNumbertext.getText().isEmpty()
                || phonetext.getText().isEmpty() || martialStatustext.getText().isEmpty() || dobtxt.getText().isEmpty()
                || emailtext.getText().isEmpty() || passwordtext.getPassword().length == 0) {
            JOptionPane.showMessageDialog(contentPane, "Please fill in all fields.");
            return false;
        }
        return true;
    }

    private void clearFields() {
        fnametext.setText("");
        lnametext.setText("");
        idNumbertext.setText("");
        phonetext.setText("");
        martialStatustext.setText("");
        dobtxt.setText("");
        emailtext.setText("");
        passwordtext.setText("");
    }
}
