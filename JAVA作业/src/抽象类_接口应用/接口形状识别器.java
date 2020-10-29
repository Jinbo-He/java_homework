package 抽象类_接口应用;

interface Shape{
/*  1.private static final 变量
    2.public abstract 方法
    3.需要一个shape的name----但是不能搞 因为 1、没有构造函数 2、初始不能赋值
    但是 接口类可以直接返回值
    4.只有一个GetArea 还是abstract类型 無方法体
*/
    String Get_Type();
    float GetArea();
}

class Triangle implements Shape {
    final private int x,y;
    String name = "三角形";
    Triangle(int x,int y ) {
        this.x=x;
        this.y=y;
    }

    @Override
    public String Get_Type() {
        return name;
    }
    @Override
    public float GetArea() {
        return (float) (0.5*x*y);
    }
    public String toString (){
        return "底:"+(float)x+" 高"+(float)y;
    }
}

class circle implements Shape {
    final private int r;
    String name ="圆";
    circle(int r ) {
        this.r=r;
    }
    @Override
    public float GetArea() {
        return (float) (Math.PI*Math.pow(r,2));
    }
    @Override
    public String Get_Type(){
        return name;
    }
    public String toString (){
        return "半径:"+(float)(r);
    }
}

class rectangle implements Shape {
    final private int x,y;
    String name = "矩形";
    rectangle(int x,int y  ) {
        this.x=x;
        this.y=y;
    }

    @Override
    public String Get_Type() {
        return name;
    }

    @Override
    public float GetArea() {
        return (float) (x*y);
    }

    public String toString (){
        return "长:"+(float)(x)+" 宽"+(float)(y);
    }
}



class IDfy {
    public static void recognize(Shape s) {//框架程序，基于超类Shape来编程
        //此处书写识别器识别的结果
        System.out.println("类型："+s.Get_Type()+" "+s+" 面积："+s.GetArea());
    }
}

class 接口形状识别器{
    public static void main(String[] args) {
        Shape a = new circle(10);
        Shape a2 = new rectangle(6,6);
        Shape a3 = new Triangle(6,6);
        IDfy.recognize(a);
        IDfy.recognize(a2);
        IDfy.recognize(a3);

    }
}