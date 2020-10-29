package 抽象类_接口应用;
/*展示接口实现“功能扩展”
 *【需求】主板预留PCI插槽。不可能知道该插槽将插装什么硬件。
 *主板做的事情只能是：加电、启动、run、停止。
 *主板类预留5个PCI插槽，如何实现？
 *分别为：NetCard  SoundCard DisplayCard
 */

interface PCI{
    void start();
    void run();
    void stop();
}

class SoundCard implements PCI{
    public void start(){System.out.println("SoundCard initiate");}
    public void run(){System.out.println("SoundCard run");}
    public void stop(){System.out.println("SoundCard stop");}
}

class DisplayCard implements PCI{
    public void start(){System.out.println("DisplayCard initiate");}
    public void run(){System.out.println("DisplayCard run");}
    public void stop(){System.out.println("DisplayCard stop");}
}

class NetCard implements PCI{
    public void start(){System.out.println("NetCard initiate");}
    public void run(){System.out.println("NetCard run");}
    public void stop(){System.out.println("NetCard stop");}
}

class Mainboard{
    PCI[] a = new PCI[5];
    //主板的五个插槽
    public void add(PCI x){
        for (int i = 0 ;i<a.length;i++)
            if (a[i]==null) {
                a[i] = x;
                return;
            }
        System.out.println("Already Full");
    }
    public void start() {//模拟主板加电运行
        System.out.println("主板加电运行");
        for(int i=0; i<a.length; i++)
            if(a[i]!=null) {
                a[i].start();
                a[i].run();
            }

    }
    public void stop() {//模拟主板关机前的停止
        System.out.println("主板关机前停止");
        for(int i=0; i<a.length; i++)
            if(a[i]!=null)
                a[i].stop();

    }
}


class Computer{
    Mainboard Main_Board=new Mainboard();
//  new 一块主板上来
    public Computer(PCI[] pci) {
//      通过PCI[]数组传入插入卡的类型
        for(int i=0; i<pci.length; i++)
            Main_Board.add(pci[i]);
//          依次将PCI板卡插入主板
    }
    public void start() { Main_Board.start(); }
//  主板启动
    public void stop() { Main_Board.stop(); }
//  主板关闭
}

class A1gaoshan{
    public static void main(String[] args) {
        PCI[] a1 = {new NetCard(),new SoundCard(),new DisplayCard(),new DisplayCard(),new NetCard()};
        Computer pc = new Computer(a1);
        pc.start();
        pc.stop();
    }
}