package clock;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class DigitalClock extends JFrame implements Runnable {
    private Calendar c;
    private Font f;
    private int h, m, s;
    private Thread t;

    public DigitalClock() {
        setTitle("Digital Clock");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f = new Font("Helvetica", Font.BOLD, 50);
        t = new Thread(this);
        t.start();
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(f);
        g.setColor(Color.black);
        g.drawString(String.format("%02d", h), 50, 100);
        g.drawString(String.format("%02d", m), 150, 100);
        g.drawString(String.format("%02d", s), 250, 100);
    }

    public void run() {
        while (true) {
            c = Calendar.getInstance();
            h = c.get(Calendar.HOUR_OF_DAY);
            m = c.get(Calendar.MINUTE);
            s = c.get(Calendar.SECOND);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    public static void main(String[] args) {
        new DigitalClock();
    }
}
