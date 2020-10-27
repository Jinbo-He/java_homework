package 类的继承_Static等操作;
//        a. 假设“三角形”类派生出子类“等腰三角形”，等腰三角形派生出子类“等边三角形”；
//        b. 三角形类有属性三条边，并在构造函数中为三边赋初值；
//        c. 等腰三角形中无新增属性，提供2个参数的构造函数，在构造函数中为三边赋初值；
//        d. 等边三角形中无新增属性，提供1个参数的构造函数，在构造函数中为三边赋初值。
//        e. 在main中创建普通三角、等腰三角、等边三角各1个，并输出三角形的信息。
class sanjiaoxing {
    private int a,b,c;
    private static int count,total = 3;
    private sanjiaoxing(int x,int y ,int z){
        a=x;
        b=y;
        c=z;
        count++;
    }
    static boolean isTriangle(int x,int y ,int z){
        return (x>0 && y>0 && z>0 && x+y>z && x+z>y && y+z>x && count<total );
    }

    public static sanjiaoxing create(int x,int y ,int z){
        if (isTriangle( x, y , z))
            return new sanjiaoxing(x,y,z);
        else
            return null;
    }
    public String toString(){
        return a+","+b+","+c;
    }
}

class op{
    public static void main(String[] args) {
        sanjiaoxing a1 = sanjiaoxing.create(2,3,4);
        sanjiaoxing a2 = sanjiaoxing.create(1,3,4);
        sanjiaoxing a3 = sanjiaoxing.create(5,3,4);
        sanjiaoxing a4 = sanjiaoxing.create(4,3,4);
        sanjiaoxing a5 = sanjiaoxing.create(4,3,4);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);

    }
}