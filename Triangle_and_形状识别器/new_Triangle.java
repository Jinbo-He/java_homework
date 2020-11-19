package Triangle_and_形状识别器;
//        1、创建一个三角形类，包含属性：private int a,b,c;分别代表三角形的三条边。设计是需要满足如下需求：
//        a. 在创建对象输入三条边，三边取值必须合法（三边均为正值，且任意两边之和大于第三边），否则将无法创建对象；
//        b.为使类更易于维护，必须单独设计一个boolean limit(…)函数，实现对三条边的限制检查，符合创建条件则返回真，否则返回假。
//        c.该类有一个public boolean setEdges(int x, int y, int z)方法（注：此方法为非静态方法），将a/b/c的值替换成x/y/z，返回true。但当x,y,z的值不满足三角形限制条件时，将不予替换，并返回false;
//        d. 三角形至多能创建3个。
//        设计该三角形类，并验证上述需求。
class new_Triangle {
    private int a,b,c;
    static int count = 0;
    new_Triangle(int x,int y ,int z){
        a=x;
        b=y;
        c=z;
    }
    static boolean limit(int x,int y ,int z){
        return (x>0 && y>0 && z>0 && x+y>z && x+z>y && y+z>x );
    }

    static new_Triangle create(int x, int y , int z){
        if (limit(x, y, z) && count < 3 ){
            count++;
            return new new_Triangle(x,y,z);
        }
        else return null;
    }

    public boolean setEdges(int x, int y , int z){

        if (new_Triangle.limit(x,y,z)){
            this.a = x;
            this.b = y;
            this.c = z;
            return true;
        }
        else return false;
    }
    public String toString(){
        return ("x："+ a +"\ty: "+b+"\tz: "+c);
    }
}
class op1{
    public static void main(String[] args) {
        new_Triangle a1 = new_Triangle.create(7,7,7);
        new_Triangle a2 = new_Triangle.create(1,3,7);
        new_Triangle a3 = new_Triangle.create(6,7,5);
        new_Triangle a4 = new_Triangle.create(9,7,4);
        new_Triangle a5 = new_Triangle.create(4,3,5);
        //如上应该有2个创建失败（数值不对+超过个数） 分别是a2 a5
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);

        a4.setEdges(7,7,7);
        System.out.println(a4);


    }
}