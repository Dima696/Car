public class Main {

    public static void main ( String[] args ) throws InterruptedException {
        AutoShop showroom = new AutoShop();

        Thread provider = new Thread( new AutoSupplier( showroom ) );
        provider.start();
        Thread.sleep( 2000 );
        for (int i = 0; i < AutoShop.AUTO; i++) {
            Thread buyer = new Thread( new Buyer( showroom ) );
            buyer.setDaemon( true );
            buyer.start();
            Thread.sleep( 2000 );
        }
        provider.join();
        Thread.sleep( 2000 );
        System.out.println( "Bye Bye:)" );
    }

}

