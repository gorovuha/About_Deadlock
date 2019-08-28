public class Main {

    public static void main(String[] args) throws InterruptedException {

        Cat cat = new Cat();
        Dog dog = new Dog();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1 started...");
                synchronized (cat){
                    for (int i = 0; i < 10000; i++) {
                        cat.age++;
                    }


                    synchronized (dog){
                        dog.age++;
                    }
                }
                System.out.println("Thread1 finished!");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread2 started...");
                synchronized (dog){
                    for (int i = 0; i < 10000; i++) {
                        dog.weight++;
                    }

                    synchronized (cat){
                        cat.weight++;
                    }
                }
                System.out.println("Thread2 finished!");
            }
        });
        System.out.println("Start");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("End");
    }

}
