package sumth;

class Sumth extends Thread {
    private int from, to, sum;

    Sumth(int from, int to) {
        this.from = from;
        this.to = to;
    }

    synchronized int getSum() {
        return sum;
    }

    synchronized void add() {
        System.out.print(from + " to " + to + ": ");
        for (int i = from; i <= to; i++) {
            sum += i;
        }
    }

    public void run() {
        add();
        System.out.println(getSum());
    }
}

public class Sumth1 {
    public static void main(String[] args) {
        Sumth st1 = new Sumth(1, 50);
        Sumth st2 = new Sumth(51, 100);
        st1.start();
        st2.start();
    }
}
