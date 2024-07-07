package appletTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppletTest extends JFrame implements ActionListener, Runnable {
    private JButton bt1, bt2;
    private boolean one, two;
    private Thread t;

    public AppletTest() {
        setTitle("Applet Test");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel p1 = new JPanel();
        JLabel lb = new JLabel();
        Canvas canvas = new Canvas();

        bt1 = new JButton("Oval");
        bt2 = new JButton("Rectangle");

        p1.add(bt1);
        p1.add(lb);
        p1.add(bt2);

        p1.setBounds(100, 300, 200, 50);
        add(p1);
        add(canvas);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        t = new Thread(this);
        t.start();
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));

        if (one && !two) {
            g.fillOval((int) (Math.random() * 290), (int) (Math.random() * 300), 50, 50);
        } else if (two && !one) {
            g.fillRect((int) (Math.random() * 290), (int) (Math.random() * 300), 50, 50);
        }
    }

    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == bt1) {
            one = true;
            two = false;
        } else if (ev.getSource() == bt2) {
            one = false;
            two = true;
        }
        repaint();
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    public static void main(String[] args) {
        new AppletTest();
    }
}
