package LoginSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField  userIdField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIdLabel = new JLabel("UserID:");
    JLabel userPassLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();

    HashMap<String, String> hashMap = new HashMap<>();

    LoginPage(HashMap<String,String > hashMapOriginal) {
        hashMap = hashMapOriginal;

        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(userPasswordField);
        frame.add(userIdField);
        frame.add(messageLabel);
        frame.add(userIdLabel);
        frame.add(userPassLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

        userIdLabel.setBounds(50, 100 ,75, 25);
        userPassLabel.setBounds(50, 150 ,75, 25);

        messageLabel.setBounds(125, 250 ,250 ,35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIdField.setBounds(125, 100 , 200, 25);
        userPasswordField.setBounds(125, 150 , 200, 25);

        loginButton.setBounds(125, 200 , 100 ,25);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);

        resetButton.setBounds(225, 200 , 100 ,25);
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton){
            userIdField.setText("");
            userPasswordField.setText("");
            //
        }
        if (e.getSource() == loginButton){
            String userID = userIdField.getText();
            String userPass = String.valueOf(userPasswordField.getPassword());

            if (hashMap.containsKey(userID)){
                if (hashMap.get(userID).equals(userPass)) {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage();
                }
                else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong password");
                }
            }
            else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("username not found");
            }
        }
    }
}
