import java.util.Scanner;


class Num2ASCII {
    private static int data;
    static void _Num2ASCII(){
        while (true){
            Scanner sc = new Scanner(System.in);
            data = sc.nextInt();
            if (data>=0 && data<=127){
                System.out.println((char)data);
                return;
            }
            else
                System.out.println("输入的数据有问题哦");
        }
    }

    public static void main(String[] args) {
        Num2ASCII._Num2ASCII();
    }
}
