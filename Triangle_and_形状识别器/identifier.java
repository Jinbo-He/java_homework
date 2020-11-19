package Triangle_and_形状识别器;
//        2、实现智能识别器，可针对圆形、矩形、三角形、梯形不同形状，提供如下服务：
//        a. 识别形状的面积；
//        b. 输出形状属性信息：类型和各种参数，如：梯形，上底：20，下底：30，高：10）--- 考虑toString()
class shape {
    //一个形状应该有什么呢？  名字+面积
    final private String type;
    shape(String name){
        type=name;
    }
    float getArea(){
        return 0;
    }

}

class Triangle extends shape {
    final private int x,y;
    Triangle(int x,int y ) {
        super("三角形");
        this.x=x;
        this.y=y;
    }

    float getArea() {
        return (float) (0.5*x*y);
    }
    public String toString (){
        return "Type:三角形 "+"底:"+(float)x+" 高"+(float)y;
    }
}

class circle extends shape {
    final private int r;
    circle(int r ) {
        super("圆");
        this.r=r;
    }

    float getArea() {
        return (float) (Math.PI*Math.pow(r,2));
    }
    public String toString (){
        return "Type:圆 "+"半径:"+(float)(r);
    }
}

class rectangle extends shape {
    final private int x,y;
    rectangle(int x,int y  ) {
        super("矩形");
        this.x=x;
        this.y=y;
    }

    float getArea() {
        return (float) (x*y);
    }
    public String toString (){
        return "Type:矩形 "+"长:"+(float)(x)+" 宽"+(float)(y);
    }
}

class trapezoid extends shape {
    final private int x,y,h;
    trapezoid(int x,int y,int h) {
        super("梯形");
        this.x=x;
        this.y=y;
        this.h=h;
    }

    float getArea() {
        return (float) (x+y)*h/2;
    }
    void test(){
        System.out.print(66);
    }
    public String toString (){
        return "Type:梯形 "+"底:"+(float)x+" "+(float)y +" 高:"+(float)h;
    }
}

class Identifier{
    static void Identifier(shape S){
        System.out.println(S+" 面积"+S.getArea());
    }
}
class a1gaoshan{
    public static void main(String[] args) {
//      因为子类中有一个隐藏的引用super会指向父类实例,所以在实例化子类之前会先实例化一个父类
//      也就是说会先执行父类的构造函数.所以子类可以调用父类的方法.
        System.out.println();
        shape a = new circle(10);
        shape a1 = new trapezoid(6,6,6);
        shape a2 = new rectangle(6,6);
        shape a3 = new Triangle(6,6);
//      a1属于shape类 shape类无.test()方法 不满足has-a关系 所以无法调用
//      a1.test();
        trapezoid a5 = new trapezoid(111,111,111);
        Identifier.Identifier(a);
        Identifier.Identifier(a1);
        Identifier.Identifier(a2);
        Identifier.Identifier(a3);
        Identifier.Identifier(a5);
        a5.test();
    }
}