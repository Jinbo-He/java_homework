package 类的继承_Static等操作;
//        构造超级英雄类SuperHero，该类有String型常量属性name，其值固定为“谭雅”、“伊万”。要求：
//        a. 在程序运行期间，至多只能造出一个对象，要么是谭雅，要么是伊万。
//        b. 如何实现：在程序运行期间，至多只能造出两个对象，其中一个是谭雅，另一个是伊万。
class Create_Hero {
    final private String name;
    static private int count = 0 ;
    static String twoname = "谭雅伊万";
    private Create_Hero(String name){
        this.name = name;
    }
    //最多造一个的英雄
    static boolean limit(String name){
        if (twoname.contains(name) && count<=0){
            count++;
            return true;
        }
        return false;
    }
    static Create_Hero create(String name){
        if (limit(name))
            return new Create_Hero(name);
        else
            return null;
    }
    //最多造俩
    static boolean limit1(String name){
        if (twoname.contains(name) && count<=1){
            count++;
            twoname = twoname.replace(name,"");
            return true;
        }
        else
            return false;
    }
    static Create_Hero create1(String name){
       if(limit1(name))
            return new Create_Hero(name);
        else
            return null;
    }
    public String toString(){
        return this.name;
    }
}

class hero{
    public static void main(String[] args) {
//        Create_Hero hero1 =Create_Hero.create1("谭雅");
//        Create_Hero hero2 =Create_Hero.create1("伊万");
//        Create_Hero hero3 =Create_Hero.create1("伊万");
//        Create_Hero hero34 =Create_Hero.create1("伊万");
//        System.out.println(hero1);
//        System.out.println(hero2);
//        System.out.println(hero3);
//        System.out.println(hero34);
//        //以上是测试create1
        //以下测试create2
        Create_Hero hero1 =Create_Hero.create1("伊万");
        System.out.println(hero1);
        Create_Hero hero2 =Create_Hero.create1("伊万");
        System.out.println(hero2);
        Create_Hero hero3 =Create_Hero.create1("谭雅");
        System.out.println(hero3);
    }
}