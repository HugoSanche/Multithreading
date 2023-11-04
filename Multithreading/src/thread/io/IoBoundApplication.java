package thread.io;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IoBoundApplication {
    private static final int NUMBER_OF_TASKS=10_000;

    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        System.out.println("Press Enter to Start");
        s.nextLine();
        long start=System.currentTimeMillis();
        performTask();
        System.out.printf("Task took %dms to complete \n", System.currentTimeMillis()-start);
    }
    private static void performTask(){

        try(ExecutorService executorService= Executors.newFixedThreadPool(1000)){//ejecta 1000 thread a la vez
            for(int i=0; i<NUMBER_OF_TASKS; i++){
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        //for (int j=0; j<100; j++){
                            blockingIoOperation();
                      //  }

                    }
                });
            }
        }
    }

    // Simulate a long blocking IO
    private static void blockingIoOperation(){
        System.out.println("Executing a blocking task from thread: "+Thread.currentThread());
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
