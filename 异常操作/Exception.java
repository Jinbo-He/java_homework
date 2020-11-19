
//异常的作业（某年的考题16分）
//        假设有一个动物类Animal的定义如下：
/**
        当实例化Animal时，如果年龄age<0，将抛出一个AgeException异常。
        试创建这个异常类，并改写以上的Animal类的构造函数，使它抛出一个AgeException的异常，另外编写代码从键盘输入数据，创建两个实例对象，验证此异常。例如，程序运行显示如下：
        My name is Tom,my age is 2
        Jerry is younger than zero.
        【答题要点】
        1、类Animal的构造函数需要 a.throws AgeException; b. 需要加入语句 if(age <0) throw new AgeException(...) else {...}
        2、构造AgeException类 ：a. 该类需要继承Exception; b. 由于输出结果中包含姓名，因此AgeException类中需要有姓名，即在AgeException类的构造函数中添加姓名，为有针对性的输出错误信息，可以在AgeException类中添加一个方法，如void showMessage(){.输出错误信息..}
        3、构造验证示例： a. 需要用try子句监控Animal对象的创建，用catch子句捕获AgeException异常。根据输出结果，应当是
        try{ Animal a,b; a=new Animal(Tom,2); a. introduce(); b=new Animal(Jerry,-1); b. introduce();} catch(AgeException e){ e.showMessage();}

 */




class AgeException extends Exception{
    Animal X;
    public AgeException(String a){
        super("Age: "+a+" Error" );
//        X=a;
    }
}
/**
*  Exception有很多种构造函数
* 其中这种super(String s)的会将一个字符串送到Exception.getMessage()中
* 其中Exception又是Throwable的子类 Throwable又实现了Serializable接口(序列化的技术
* 源代码如下:
    *
    public Exception(String message) {
        super(message);
    }
    *
    public Throwable(String message) {
        fillInStackTrace();
        detailMessage = message;
    }
    * 其中提到了一个StackTrace的东西 用到了锁机制
    *
    其中的Throwable有一个函数getMessage就可以返回对应的String串
    public String getMessage() {
        return detailMessage;
    }
    *
*
 */
class NameException extends Exception{
    Animal X;
//  这里属于重构构造函数（因为Exception根本没有参数为Animal类的构造函数）
    public NameException(Animal a){
        X=a;
    }
    public void showMessage(){
        System.out.println("Name Error");
    }
}

class Animal{
    public String name;
    public int age;
    public Animal(String name,int age) throws AgeException,NameException {
        if (name == "null"){
            throw new NameException(this);
        }
        this.name=name;
        if (age<0) {
            throw new AgeException((String.valueOf(age)));
        }
        this.age=age;
    }
    public void introduce(){
        System.out.println("My name is "+name+",my age is "+age);
    }
    public void sleep(){
        System.out.println(name+" is sleeping now!");
    }
}

class m{
    public static void main(String[] args) {
        try{
            Animal a,b,c;
            a=new Animal("Tom",2);
            a. introduce();
            b=new Animal("Jerry",-1);
            b. introduce();
            c=new Animal("null",-1);
            c. introduce();
        }

/**        catch (AgeException | NameException e) {
          由于Age 或者 Name 不全有showMessage()所以报错
            e.showMessage();
            System.out.println(e.getMessage());
        }
        一次性catch多个异常中 这两个异常必须是同级关系，不能是父子类关系

 */

//      在写异常处理的时候，一定要把异常范围小的放在前面，范围大的放在后面，另外抛出的声明必须要catch
        catch (NameException e) {
            e.showMessage();
        }
        catch (AgeException e) {
            System.out.println(e.getMessage());
        }

//        catch (AgeException | NameException e) {
////            由于Age 或者 Name 不全有showMessage()所以报错
////            e.showMessage();
//            System.out.println(e.getMessage());
//        }
        finally {
            System.out.println("We are done.");
        }
    }
}