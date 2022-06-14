import javax.swing.*;
import java.awt.*;

public class UserInput {
    private int x = 200, y1 = 150, y2 = 250, width = 200, height = 50;

    public UserInput() {
        // font setting
        Font myFont = new Font("Arial", Font.BOLD, 22);

        // button setting
        Button sendButton = new Button("sign in");
        sendButton.setFont(myFont);
        sendButton.setBackground(new Color(0, 209, 142));
        sendButton.setBounds(90, 400, 300, 70);
        MainWindow.window.add(sendButton);

        // number textField
        JTextField phoneNumber = new JTextField("0502592666");
        phoneNumber.setBounds(this.x, this.y1, this.width, this.height);
        phoneNumber.setBackground(new Color(0, 209, 142));
        phoneNumber.setFont(myFont);
        System.out.println(noNumber(phoneNumber));
        System.out.println(checkNumber(phoneNumber));


        // massage textField
        JTextField textMessage = new JTextField();
        textMessage.setBounds(this.x, this.y2, this.width, this.height);
        textMessage.setBackground(new Color(0, 209, 142));
        textMessage.setFont(myFont);
        MainWindow.window.add(textMessage);
        MainWindow.window.add(phoneNumber);
        MainWindow.window.setVisible(true);

        // number label
        JLabel numberLabel = new JLabel("Enter number");
        numberLabel.setBounds(50, this.y1, 170, this.height);
        numberLabel.setBackground(new Color(0, 209, 142));
        numberLabel.setOpaque(true);
        numberLabel.setFont(myFont);
        MainWindow.window.add(numberLabel);


        // text label
        JLabel textLabel = new JLabel("Enter text");
        textLabel.setBounds(50, this.y2, 170, this.height);
        textLabel.setBackground(new Color(0, 209, 142));
        textLabel.setOpaque(true);
        textLabel.setFont(myFont);
        MainWindow.window.add(textLabel);

        // error label setting
        Font erorFont = new Font("Arial", Font.BOLD, 17);
        JLabel errorLabel = new JLabel();
        errorLabel.setBounds(90, 350, 300, 50);
        errorLabel.setForeground(Color.RED);
        errorLabel.setBackground(new Color(0, 209, 142));
        errorLabel.setOpaque(true);
        errorLabel.setFont(erorFont);
        errorLabel.setVisible(false);
        MainWindow.window.add(errorLabel);

        // button affect -->
        sendButton.addActionListener((e -> {
            try {
                if (!noMessage(textMessage) || noNumber(phoneNumber) || checkNumber(phoneNumber)) {
                    errorLabel.setVisible(true);
                    if (!noMessage(textMessage) && checkNumber(phoneNumber) && noNumber(phoneNumber)) {
                        errorLabel.setText("ENTER MESSAGE");
                    }
                    if (!checkNumber(phoneNumber) || !noNumber(phoneNumber)) {
                        errorLabel.setText("YOU MUST ENTER NUMBER(10 digits)");
                    }
                }
            }catch (Exception ex ){
                errorLabel.setVisible(true);
                    errorLabel.setText("bla");
                System.err.println("!!!");
            }

        }));


    }


    //  checkNumber  method
    public boolean checkNumber(JTextField t) {
        String str = "";
        int numOfCars = t.getText().length();
        for (int i = 0; i < 3; i++) {
            str += t.getText().charAt(i);
        }
        System.out.println(str);

        if (numOfCars != 10)
            return false;
        if (str.equals("050") || str.equals("051") || str.equals("052") || str.equals("053") || str.equals("054") || str.equals("055") || str.equals("058")) {
            return true;
        }
        return false;
    }

    // noNumber method
    public boolean noNumber(JTextField t) {
        if (t.getText().equals(""))
            return false;
        return true;
    }

    // check message method
    public boolean noMessage(JTextField t) {
        if (t.getText().equals(""))
            return false;
        return true;
    }

}




