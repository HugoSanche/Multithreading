import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers= Arrays.asList(1000000L,3435L,3424L,4510L,583L,5581L);
        List<FactorialThread> threads=new ArrayList<>();

        for (int i=0; i<inputNumbers.size();i++){
            threads.add(new FactorialThread(inputNumbers.get(i)));
        }

        for(Thread thread: threads){
            thread.setDaemon(true);
            thread.start();
        }
        for (Thread thread:threads){
            thread.join(2000);
        }
        for (int i=0; i<inputNumbers.size(); i++){
            FactorialThread factorialThread=threads.get(i);
            if (factorialThread.isFinish){
                System.out.println("Factorial of "+ inputNumbers.get(i)+" is "+factorialThread.getResult());
            }
            else{
                System.out.println("The calculation for "+inputNumbers.get(i)+" is still in progress");
            }
        }
    }
    public static class FactorialThread extends Thread{
        private long inputNumber;
        private BigInteger result=BigInteger.ZERO;
        private boolean isFinish=false;
        public FactorialThread(long inputNumber){
            this.inputNumber=inputNumber;
        }
        @Override
        public void run(){
            this.result=factorial(inputNumber);
            this.isFinish=true;
        }
        public BigInteger factorial(long n){
            BigInteger tempResult=BigInteger.ONE;
            for(Long i=n; i>0; i--){
                tempResult=tempResult.multiply(new BigInteger(Long.toString(i)));
            }
            return tempResult;
        }
        public boolean isFinish(){
            return isFinish;
        }
        public BigInteger getResult(){
            return result;
        }
    }
}
