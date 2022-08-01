import java.util.Deque;
import java.util.LinkedList;

public class AutoShop {
    public static final int AUTO = 2;
    public static final int BUYER = 2;
    private final Deque<Auto> autos = new LinkedList<>();

    public synchronized void putCar ( Auto auto ) {
        autos.addLast( auto );
        notify();
    }

    public synchronized void buyCar () {
        String name = Thread.currentThread().getName();
        try {
            while (autos.isEmpty()) {
                System.out.println( "Client " + name + " is waiting." );
                wait();
            }
        } catch (InterruptedException ignored) {
        }
        Auto car = autos.pollLast();
        System.out.println( "Client " + name + " customer bought a car!!!!!!!!!! " );

    }
}