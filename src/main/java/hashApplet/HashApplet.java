package hashApplet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

class HTApplet {
    private Hashtable<String, String> ht;

    HTApplet() {
        ht = new Hashtable<>();
        String[] userName = {"Lee", "Kim", "Jang"};
        String[] passWord = {"1234", "4567", "9801"};
        for (int i = 0; i < userName.length; i++) {
            ht.put(userName[i], passWord[i]);
        }
    }

    boolean findID(String name) {
        return ht.containsKey(name);
    }

    boolean findPW(String name, String pwName) {
        String value1 = ht.get(name);
        return value1 != null && value1.equals(pwName);
    }
}

public class HashApplet extends JFrame implements ActionListener {
    private JTextField t1, t2, t3;

    public HashApplet() {
        setTitle("Hash Applet");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel l1 = new JLabel("ID");
        JLabel l2 = new JLabel("PW");
        t1 = new JTextField(10);
        t2 = new JPasswordField(10);
        t3 = new JTextField(" ", 20);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(t3);

        t1.addActionListener(this);
        t2.addActionListener(this);
        t3.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        HTApplet hta = new HTApplet();
        boolean id, pw;

        try {
            String name = t1.getText();
            id = hta.findID(name);
            String pwName = t2.getText();
            pw = hta.findPW(name, pwName);

            if (id && e.getSource() != t2) {
                t3.setText("ID exists, PW required");
            } else if (id) {
                if (pw) {
                    t3.setText("Login successful");
                } else {
                    t3.setText("Incorrect PW");
                }
            } else {
                t3.setText("ID does not exist");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new HashApplet();
    }
}
