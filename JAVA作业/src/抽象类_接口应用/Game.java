package 抽象类_接口应用;

/*游戏模拟：兵种包括轰炸机、直升机、重型坦克、轻型坦克、步兵、飞行兵 -----基于class兵种
 * 轰炸机、直升机、飞行兵属于空军；其他属于陆军 -----基于类型接口
 * 轰炸机、轻型坦克、步兵只能攻击陆军；直升机、重型坦克、飞行兵可对空和对地 -----基于各种攻击的接口
 * 模拟：构造一组兵种（各方混在一起），模拟相互间攻击的可能
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

interface BothAttack extends AttackAir,AttackLand{;
//  为啥为空呢？因为已经继承了对地对空 已经有这两项属性了
}

interface LandArms{;}//空的方法体，只作标签用
interface AirArms{;}//空的方法体，只作标签用

abstract class Arms{
    /*
        几点需求：1、兵种名字 2、兵种攻击(抽象类) 3、兵种攻击对象
    */
    private String name ;
    public Arms(String name){
        this.name = name;
    }
    public abstract void Attack(Arms x);
//  why abstract method? Need to be overrided
//  Different Arms -> different way to attack
    public String AttackInfo(Arms x ){
        return (this.name+"\tmeet\t"+x.name+"\t");
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


class Helicopter extends Aircraft implements BothAttack{
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
        System.out.println("Unable to attack !!!!!");
    }
}

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

//AirSolider 需要实现 BothAttack和AirArms 因为Solider这一兵种未实现陆空分类
class AirSolider extends Solider implements BothAttack,AirArms{
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
        System.out.println("Unable to attack !!!!!");
    }
}

class HeavyTank extends Tank implements BothAttack{
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

class military {
    public static void main(String[] args) {
        Arms[] a = {new LandSolider(),new Helicopter(),
                    new Helicopter(),new HeavyTank(),
                    new HeavyTank(),new AirSolider(),
                    new LightTank(),new LightTank()};
        for (int i =0 ;i<a.length- 1;i++){
            a[i+1].Attack(a[i]);
            a[i].Attack(a[i+1]);
        }
//        a[1].Attack(a[0]);
    }
}