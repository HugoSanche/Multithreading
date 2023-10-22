package thread.race.conditions;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter=new InventoryCounter();

        IncrementTread incrementTread=new IncrementTread(inventoryCounter);
        DecrementTread decrementTread=new DecrementTread(inventoryCounter);

        incrementTread.start();
        decrementTread.start();

        incrementTread.join();
        decrementTread.join();

        System.out.println("Total numbers of items "+inventoryCounter.getItems()+ " items");

    }
    public static class IncrementTread extends Thread{
        InventoryCounter inventoryCounter;

        public IncrementTread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }
        @Override
        public void run(){
            for (int i=0; i<1000; i++){
                inventoryCounter.increment();
            }
        }
    }
    public static class DecrementTread extends Thread{
        InventoryCounter inventoryCounter;

        public DecrementTread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }
        @Override
        public void run(){
            for (int i=0; i<1000; i++){
                inventoryCounter.decrement();
            }
        }
    }

    private static class InventoryCounter{
        private int items=0;

        public void increment(){
            items++;
        }
        public void decrement(){
            items--;
        }
        public int  getItems(){
            return items;
        }
    }
}
