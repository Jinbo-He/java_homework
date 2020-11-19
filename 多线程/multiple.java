import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
    * 2、线程类T定义方式为：class T implements Runnable{ int data; ...}
    * 线程体实现依次输出data的1~10倍数据。
    * 在main中，构造和启动线程的方式形如： T t=new T(2);  t.start();
    * 构造data分别为2、3、5的线程，线程名分别为t2、t3、t5，要求：t2、t3、t5分3行输出，且输出结果不得交叉。
     */
class multiple implements Runnable {
        private static Set h = new TreeSet();
        private int x ;
        multiple(int x ){
            this.x=x;
        }
        @Override
        public  void run() {
            synchronized (multiple.class ){
                for (int i = 1; i <= 10; i++) {
                    System.out.print(x * i + "\t");
                }
                System.out.println();
            }
        }
        void start(){
            new Thread(this).start();
        }
}


class multiple2 implements Runnable {
    public static Set h = new HashSet();
    private int x ;
    multiple2(int x ){
        this.x=x;
    }
    @Override
    public void run() {
        synchronized (h){
            for (int i = 1;i<=10;i++) {
                if (multiple2.h.contains(x * i )) {
                    continue;
                }
                else {
                    multiple2.h.add(x * i );
                    System.out.print(x * i + "\t");
                }
            }
            System.out.println();
        }
    }

    void start(){
        new Thread(this).start();
    }
}

class mmm{
    public static void main(String[] args) {
//        multiple2 t=new multiple2(2);
//        t.start();
//
//        multiple2 t1=new multiple2(3);
//        t1.start();
//
//        multiple2 t2=new multiple2(5);
//        t2.start();


        multiple t=new multiple(2);
        t.start();

        multiple t1=new multiple(3);
        t1.start();

        multiple t2=new multiple(5);
        t2.start();
    }

}