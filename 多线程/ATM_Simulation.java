/**
* 1、模拟银行存取钱（注：自己设计、不要抄书）
* 假定张三的银行帐户中有余额1000元，对银行账户的处理需要经历三次函数调用：
* 显示余额、修改余额（存钱或取钱）、显示修改后的余额。
* 这三次调用的输出信息分别是：
  XX帐户余额为……元\n
  向……帐户存入（或者取出）……元\n
  XX帐户余额为……元\n
* 请构造3个线程来同时操纵上述帐户，并输出结果。如张三向其中存5000元，老婆取2000，儿子取4000
*/


class Account{
    final private String name;
    private int money;
    public Account(String name,int money){
        this.money=money;
        this.name=name;
    }
    public void ShowInformation(){
        System.out.println(this.name +"'s account: "+money);
    }
//    public void getout(int num){
//        money = money-num;
//    }
    public void get(int num){
        money = money+num;
    }
}

class operator extends Thread {

    final private Account op;
    final private int money;
    operator(Account x,int money) {
        op =  x;
        this.money=money;
    }

    @Override
    public void run(){
        synchronized (op){
            System.out.print("存款前:");
            op.ShowInformation();
            op.get(money);
            System.out.println("存取:"+money);
            System.out.print("存款后:");
            op.ShowInformation();
            System.out.println();
        }
    }
}

class operator1 implements Runnable {
    operator1(Account x,int money) {
        op =  x;
        this.money=money;
    }
    final private Account op;
    final private int money;

    @Override
    public void run(){
        synchronized (op){
            System.out.print("存款前:");
            op.ShowInformation();
            op.get(money);
            System.out.println("存取:"+money);
            System.out.print("存款后:");
            op.ShowInformation();
            System.out.println();

        }
    }
}



class vvv{
    public static void main(String[] args) {
        Account GoldOne = new Account("Lily0",10);
//        Thread L1 = new Thread(new operator1(GoldOne,10));
//        Thread L2 = new Thread(new operator1(GoldOne,-5));
//        Thread L3 = new Thread(new operator1(GoldOne,-3));
//        L1.start();
//        L2.start();
//        L3.start();

        operator z1 = new operator(GoldOne,10);
        operator z3 = new operator(GoldOne,-5);
        operator z2 = new operator(GoldOne,-9);
        z1.start();
        z2.start();
        z3.start();
    }
}