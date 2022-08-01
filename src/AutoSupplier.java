public class AutoSupplier implements Runnable {
    private AutoShop autoShop;


    public AutoSupplier ( AutoShop autoShop ) {
        this.autoShop = autoShop;

    }

    @Override
    public void run () {
        String name = Thread.currentThread().getName();
        System.out.println( "Provider " + name + " started to work!" );
        try {
            for (int i = 0; i < AutoShop.BUYER; i++) {
                Thread.sleep( 2000 );
                autoShop.putCar( new Auto() );
                System.out.println( "Provider " + name + " did the job and brought the car." );
            }
        } catch (InterruptedException e) {
        }
        System.out.println( "Provider " + name + " task completed!!" );
    }

}
