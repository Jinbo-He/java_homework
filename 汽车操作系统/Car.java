package 汽车操作系统;

import java.util.SplittableRandom;

class Car {
    String Owner,Brand,Color;
    Boolean Status ;
    //只要你写了构造函数 那么你所有的最初的变量都不会进行赋值（除了构造函数里写到过的）所以我在构造函数里写
    Car(String Owner,String Brand,String Color){
        this.Brand=Brand;
        this.Color=Color;
        this.Owner=Owner;
        this.Status=false;
    }
    void Start(){
        if (Status == true)
            System.out.println("Already started,you can't start again!!");
        else
            Status = true;
    }
    void Stop(){
        if(Status == true)
            System.out.println("Hasn't started!");
        else {
            Status = false;
            System.out.println("Car Stoped!");
        }

    }


    void move_forward(){
        if (Status == true)
            System.out.println("Car on the move_forward!!!!");
        else{
            System.out.println("Car hasn't Started yet!Please Start car firstly");
        }
    }

    void move_backward(){
        if (Status == true)
            System.out.println("Car on the move_backward!!!!");
        else{
            System.out.println("Car hasn't Started yet!Please Start car firstly");
        }
    }

    void move_left(){
        if (Status == true)
            System.out.println("Car on the move_left!!!!");
        else{
            System.out.println("Car hasn't Started yet!Please Start car firstly");
        }
    }

    void move_right(){
        if (Status == true)
            System.out.println("Car on the move_right!!!!");
        else{
            System.out.println("Car hasn't Started yet!Please Start car firstly");
        }
    }
    public String toString(){
        return "Onwer:"+Owner+" \tBrand:"+Brand+"\tColor:"+Color;
    }
}

class Operate{
    public static void main(String[] args) {
        Car mycar = new Car("何金波","Benz","Yellow");

        mycar.Start();
        System.out.println(mycar);
        mycar.Start();
        mycar.move_backward();
        mycar.move_forward();
        mycar.move_left();
        mycar.move_right();
    }
}