package 随笔;
public class pow {
    long po1w(long x , int n){
        if (n==0)
            return 1 ;
        if (n==1)
            return x;
        if (n%2 ==  0)
            return po1w(x*x,n/2);
        else
            return po1w(x*x,n/2)*x;
    }
    public static void main(String[] args) {
        long x = 2;
        pow bbb = new pow();
        System.out.println(bbb.po1w(2,31));
    }
}
