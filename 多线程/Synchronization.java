import java.io.BufferedReader;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.stream.IntStream;

/**
     * 缓存区BufferArea
     */

class BufferArea {
    private int data;
    private boolean isEmpty=true;
//    BufferArea(int data,boolean flag){
//        this.data=data;
//        this.isEmpty=flag;
//    }
    public void put(int x){
        while(!isEmpty){
            try{
                wait();
            }
            catch (Exception e){
                ;
            }
        }
        data=x;
        isEmpty=false;
        notify();
    }
    public int get(){
        while(isEmpty){
            try{
                wait();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        isEmpty=true;
        notify();
        return data;
    }

}

class Producer implements Runnable{
    Thread th = new Thread(this);
    BufferArea ba;
    public Producer(BufferArea x){
        ba=x;
    }

    @Override
    public void run() {
        synchronized (ba) {
            for (int i = 1; i <= 5; i++) {
                try {
                    th.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ba.put(i);
                try {
                    th.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Producer :" + i);
            }
        }
    }

    public void start(){
        th.start();
    }
}

class Consumer implements Runnable{
    Thread th = new Thread(this);
    BufferArea ba;
    public Consumer(BufferArea x){
        ba=x;
    }

    @Override
    public void run() {
        synchronized (ba) {
            for (int i = 1; i <= 5; i++) {
                try {
                    th.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Consumer :" + ba.get());
            }
        }
    }
    public void start(){
       th.start();
    }
}


class A1{
    public static void main(String[] args) {
        BufferArea ba = new BufferArea();
        Consumer a1 = new Consumer(ba);
        Producer a2 = new Producer(ba);
        a1.start();
        a2.start();
    }
}