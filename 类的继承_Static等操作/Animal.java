package 类的继承_Static等操作;

class Animal {
    Animal(){
        System.out.println("Animal");
    }
}
class dog extends Animal{
    int age;
    dog(int x ){
        age = x;
        System.out.println("dog " + age);
    }
    dog(){
        System.out.println("dog " + age);
    }
}

class tireddog extends dog{
    tireddog(int x) {
//        super(x);
        System.out.println("tireddog " + age);
    }
}

class operate{
    public static void main(String[] args) {
        new tireddog(5);
    }
}