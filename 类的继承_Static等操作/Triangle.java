package 类的继承_Static等操作;
//        a. 假设“三角形”类派生出子类“等腰三角形”，等腰三角形派生出子类“等边三角形”；
//        b. 三角形类有属性三条边，并在构造函数中为三边赋初值；
//        c. 等腰三角形中无新增属性，提供2个参数的构造函数，在构造函数中为三边赋初值；
//        d. 等边三角形中无新增属性，提供1个参数的构造函数，在构造函数中为三边赋初值。
//        e. 在main中创建普通三角、等腰三角、等边三角各1个，并输出三角形的信息。


//static方法可以被子类继承，但是无法被修改（無多态）
class Triangle {
    final private int x,y,z;
    Triangle(int x,int y ,int z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

    static boolean isTriangle1(int x,int y ,int z){
        return (x>0 && y>0 && z>0 && x+y>z && x+z>y && y+z>x );
    }
    static Triangle create(int x,int y ,int z){
        if (isTriangle1(x,y,z)==true){
            return new Triangle(x,y,z);
        }
        else return null;
    }
    public String toString(){
        return ("x："+ x +"\ty: "+y+"\tz: "+z);
    }
}

class isosceles_triangle extends Triangle{

    isosceles_triangle(int x, int y) {
        super(x, y, y);
    }

}

class equilateral_triangle extends Triangle {
    equilateral_triangle(int x) {
        super(x, x, x);
    }

    //测试Static的继承与重写
    static Triangle create(int x){
        System.out.println("55555");
        return null;
    }

}

class T_Triangle{
    public static void main(String[] args) {
        equilateral_triangle a1 = new equilateral_triangle(6);
        System.out.println(a1);
        isosceles_triangle a2 = new isosceles_triangle(6,7);
        System.out.println(a2);
        Triangle a3 = Triangle.create(7,6,5);
        System.out.println(a3);




        //static方法可以被子类继承，但是无法被修改（無多态）
        Triangle a4 = isosceles_triangle.create(11,7,7);
        System.out.println(a4);
        //可以看到这里的等腰三角形继承了static方法
        //但是接下来等边三角形修改了static 结果还是一样
        Triangle a5 = equilateral_triangle.create(11,7,7);
        System.out.println(a5);
    }
}