public class NewThread extends Thread{
    @Override
    public void run(){
        System.out.println("Hello from "+this.getName());
    }
}
