/*
0、微信程序中可以插装青桔等小程序。某公司编写了一款名为“菜场”的软件，
1、计划支持插装小程序，插装标准为MarketApplet，符合该标准的小程序都可插装到菜场中。
2、该标准内有start()、run()、stop()三项功能。
3、main中演示了插装“白菜”、“萝卜”等小程序，以及插装后的运行结果。
4、要求，菜场中至多能插装10个小程序。
5、为简化处理，添加小程序时，可不考虑小程序插满的情形。
6、请完成CaiChangApplet标准的设计，以及菜场（CaiChang）、白菜（BaiCai）、萝卜（LuoBo）等类的设计。
 */


//接口是行为的标准，这三项功能都是行为，所以用接口。
interface MarketApplet{
    void start();
    void run();
    void stop();
}

/*
* 抽象类
* 高度聚合软件的标准
* 拥有Name属性以及getname方法
* 满足MarketApplet标准
 */
abstract class VegetablesSoftwate implements MarketApplet{
    private String name ;
    VegetablesSoftwate(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}

/*
* 白菜类
* 没啥好说的。。。。实现了标准接口
 */
class CabbageSoftware extends VegetablesSoftwate{
    public CabbageSoftware(String name) {
        super(name);
    }

    @Override
    public void start() {
        System.out.println("CabbageSoftware start");
    }

    @Override
    public void run() {
        System.out.println("CabbageSoftware on the run");
    }

    @Override
    public void stop() {
        System.out.println("CabbageSoftware stop");
    }
}

/*
 * 萝卜类
 * 没啥好说的。。。。实现了标准接口
 */
class CarrotSoftware extends VegetablesSoftwate{
    public CarrotSoftware(String name) {
        super(name);
    }

    @Override
    public void start() {
        System.out.println("CarrotSoftware start");
    }

    @Override
    public void run() {
        System.out.println("CarrotSoftware on the run");
    }

    @Override
    public void stop() {
        System.out.println("Carrot_Software stop");
    }

}

/*
 * 操作类
 * 实现了标准接口（我个人认为不实现标准接口也行,因为软件类标准和操作软件类标准似乎不一样 *这里似乎是一样的）
 * add() 有限定：Data[item] == null && count<10 && x instanceof MarketApplet
 */
class OperateSoftware implements MarketApplet{
    private static int count = 0;
    private static VegetablesSoftwate[] Data = new VegetablesSoftwate[10];
    public void add(VegetablesSoftwate x){
        for(int item=0;item<Data.length;item++) {
            if (Data[item] == null && count<10 && x instanceof MarketApplet) {
                Data[item] = x;
                count++;
                System.out.println(x.getName()+"\tSuccess");
                return;
            }
        }
        System.out.println("Full or don't meet the standards!");
    }

    @Override
    public void start() {
/*
* 不能这样使用，会出现空指针引用
* for (VegetablesSoftwate item :Data)
            item.start();
*/
        for (int item=0;item<count;item++)
            Data[item].start();
    }

    @Override
    public void run() {
        for (int item=0;item<count;item++)
            Data[item].run();
    }

    @Override
    public void stop() {
        for (int item=0;item<count;item++)
            Data[item].stop();

    }
}

class App{
    public static void main (String[] args) {
        OperateSoftware c=new OperateSoftware();
        CabbageSoftware bc=new CabbageSoftware("Cabbage");
        CarrotSoftware lb=new CarrotSoftware("Carrot");
        c.add(bc);
        c.add(lb);
        c.run();
        c.start();
        c.stop();
    }
}