package 抽象类_接口应用;

/*  2、功能：设计一组类和接口，满足如下要求：（编译成功即可）
    a.游戏模拟：兵种包括轰炸机、直升机、重型坦克、轻型坦克、音波坦克、步兵、飞行兵
    b.轰炸机、直升机、飞行兵属于空军；步兵、轻型坦克、重型坦克属于陆军，音波坦克属于水陆两栖；
    （提示：设计时，音波坦克内有标记inWater，在构造时填入，若为true，则表示目前音波坦克在水中，否则就是在陆地上）
    c.轻型坦克、步兵只能攻击陆军，音波坦克只能攻击空军，轰炸机可攻击陆军、海军；重型坦克可攻击陆军、空军，直升机、飞行兵可攻击海军、陆军、空军；
    并验证设计效果。（即向兵种变量填入海/陆/空军兵种，检测a.attack(b)的输出）
*/

interface AttackAir{
    default void attack(AirArms x){ System.out.println("Beat the AirArms firecely!!!!");}
//    void attack();
/*
  * why default ?
  * 在接口中定义非抽象方法
  * why need no abstract method？
  * 似乎不需要去重写了  因为攻击这里已经定死了 不需要再去重新写
 */
}

interface AttackLand{
    default void attack(LandArms x){ System.out.println("Beat the LandArms firecely!!!!");}
    /*
     * why default ?
     * 在接口中定义非抽象方法
     * why need abstract method？
     * 似乎不需要去重写了  因为攻击这里已经定死了 不需要再去重新写
     */
}

interface AttackNavy{
    default void attack(NavyArms x){ System.out.println("Beat the Navy firecely!!!!");}
    /*
     * why default ?
     * 在接口中定义非抽象方法
     * why need abstract method？
     * 似乎不需要去重写了  因为攻击这里已经定死了 不需要再去重新写
     */
}

interface AllAttack extends AttackAir,AttackLand,AttackNavy{
    ;
//  为啥为空呢？因为已经继承了对地对空 已经有这两项属性了
}

interface LandArms{;}
//空的方法体，只作标签用
interface AirArms{;}
//空的方法体，只作标签用
interface NavyArms{;}
//空的方法体，只作标签用

abstract class Arms{
    /*
        几点需求：1、兵种名字 2、兵种攻击(抽象类) 3、兵种攻击对象
    */
    private String name ;
    public Arms(String name){
        this.name = name;
    }
    public String GetType(){
        return name;
    }
    public abstract void Attack(Arms x);
//  why abstract method? Need to be overrided
//  Different Arms -> different way to attack
    public String AttackInfo(Arms x ){
        String type ="",TypeofX="" ;
        if(this instanceof NavyArms ) {
            type = "NavyArms";
        }
        if(this instanceof AirArms) {
            type = "AirArms";
        }
        if(this instanceof LandArms) {
            type = "LandArms";
        }
        if(x instanceof NavyArms ) {
            TypeofX = "NavyArms";
        }
        if(x instanceof AirArms) {
            TypeofX = "AirArms";
        }
        if(x instanceof LandArms) {
            TypeofX = "LandArms";
        }
//      目前还没想到啥好办法缩减if switch不给力呀
//        switch (){
//            case (this instanceof AirArms ):type = "AirArms";
//        }
        return (this.name+"("+type+")"+"\tmeet\t"+x.name+"("+TypeofX+")"+"\t");
    }
}

//why abstract Aircraft ------->(extends Arms) abstract or override (no need to override
abstract class Aircraft extends Arms implements AirArms {
    public Aircraft(String name) {
        super(name);
    }
}
//飞行器就是空军 实现接口AirArms
abstract class Tank extends Arms implements LandArms{
    public Tank(String name) {
        super(name);
    }
}
//Tank就是陆军 实现接口LandArms
abstract class Solider extends Arms {
    public Solider(String name) {
        super(name);
    }
}
//Solider可以是空军也可以是陆军，所以只extends Arms 但不实现接口


class Helicopter extends Aircraft implements AllAttack{
    public Helicopter() {
        super("Helicopter");
    }
    @Override
    public void Attack(Arms x) {
        System.out.print(AttackInfo(x));
        if (x instanceof LandArms) {
            attack((LandArms)x);
            return;
        }
        if (x instanceof AirArms) {
            attack((AirArms)x);
            return;
        }
        if (x instanceof NavyArms) {
            attack((NavyArms)x);
            return;
        }
        System.out.println("Unable to attack !!!!!");
    }
}
//直升机

class Boomer extends Aircraft implements AttackLand,AttackNavy {
    public Boomer() {
        super("AirBoomer");
    }

    @Override
    public void Attack(Arms x) {
        System.out.print(AttackInfo(x));
        if (x instanceof LandArms) {
            attack((LandArms) x);
            return;
        }
        if (x instanceof NavyArms) {
            attack((NavyArms) x);
            return;
        }
        System.out.println("Unable to attack !!!!!");
    }
}
//轰炸机

//LandSolider 需要实现 AttackLand和LandArms 因为Solider这一兵种未实现陆空分类
class LandSolider extends Solider implements AttackLand,LandArms{
    public LandSolider() {
        super("LandSolider");
    }
    @Override
    public void Attack(Arms x) {
        System.out.print(AttackInfo(x));
        if (x instanceof LandArms) {
            attack((LandArms)x);
            return;
        }
        System.out.println("Unable to attack !!!!!");
    }
}
//步兵

//AirSolider 需要实现 AllAttackk和AirArms 因为Solider这一兵种未实现陆空分类
class AirSolider extends Solider implements AllAttack,AirArms{
    public AirSolider() {
        super("AirSolider");
    }
    @Override
    public void Attack(Arms x) {
        System.out.print(AttackInfo(x));
        if (x instanceof LandArms) {
            attack((LandArms)x);
            return;
        }
        if (x instanceof AirArms) {
            attack((AirArms)x);
            return;
        }
        if (x instanceof NavyArms) {
            attack((NavyArms)x);
            return;
        }
        System.out.println("Unable to attack !!!!!");
    }
}
//空降兵

class HeavyTank extends Tank implements AttackLand,AttackAir{
    public HeavyTank() {
        super("HeavyTank");
    }
    @Override
    public void Attack(Arms x) {
        System.out.print(AttackInfo(x));
        if (x instanceof LandArms) {
            attack((LandArms)x);
            return;
        }
        if (x instanceof AirArms) {
            attack((AirArms)x);
            return;
        }
        System.out.println("Unable to attack !!!!!");
    }
}
//重型坦克

class LightTank extends Tank implements AttackLand{
    public LightTank() {
        super("LightTank");
    }
    @Override
    public void Attack(Arms x) {
        System.out.print(AttackInfo(x));
        if (x instanceof LandArms) {
            attack((LandArms)x);
            return;
        }
//        if (x instanceof AirArms) {
//            attack((AirArms)x);
//            报错：无 AirArms类型为参数的attackS
//            return;
//        }
        System.out.println("Unable to attack !!!!!");
    }
}
//轻型坦克

class SoundWaveTank extends Tank implements NavyArms,AttackAir{
    private Boolean Inwater;
    public SoundWaveTank(Boolean Status) {
        super("SoundWave");
        this.Inwater=Status;
    }
    public Boolean GetStatus(){
        return Inwater;
    }
    public void Attack(Arms x) {
        System.out.print(AttackInfo(x));
        if (x instanceof AirArms) {
            attack((AirArms)x);
            return;
        }
        System.out.println("Unable to attack !!!!!");
    }
}
//音波坦克

class military {
    public static void main(String[] args) {
        Arms[] a = {new LandSolider(),new Boomer(),
                    new Helicopter(),new HeavyTank(),
                    new SoundWaveTank(true),new SoundWaveTank(false),
                    new HeavyTank(),new AirSolider(),
                    new LightTank(),new LightTank()};
        for (int i =0 ;i<a.length- 1;i++){
            a[i+1].Attack(a[i]);
            a[i].Attack(a[i+1]);
        }
//        a[1].Attack(a[0]);
    }
}