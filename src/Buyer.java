public class Buyer implements Runnable {
    private AutoShop autoShop;

    public Buyer ( AutoShop autoShop ) {
        this.autoShop = autoShop;
    }

    @Override
    public void run () {
        String name = Thread.currentThread().getName();
        try {
            System.out.println( "Client -" + name + " came to the dealership!" );
            Thread.sleep( 3000 );
            System.out.println( "Client -" + name + " chooses a car !" );
        } catch (InterruptedException e) {
        }
        autoShop.buyCar();
    }
}
