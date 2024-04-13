public class MyExample {
    public static void main(String[] args) {
        Correr correr=new Correr();
        correr.start();
        System.out.println("Executed Thread");

        System.out.println("**********************************");

        Yoga yoga=new Yoga();
        yoga.ejecutar();

        Thread thread=new Thread(yoga);
        thread.start();
    }
}
