/*功能：旨在展现Random产生随机数序列可以再现。
 *因此，本质上属于伪随机数
 **/
import java.util.Random;
public class isRandom{
	public static void main (String[] args) {
		int i;
		System.out.print("第1组int：");
		Random a=new Random(100);
		for(i=0; i<5; i++)System.out.print (a.nextInt ()+"  ");
		System.out.print("\n");
		System.out.print("第2组int：");
		Random b=new Random(100);
		for(i=0; i<5; i++)System.out.print (b.nextInt ()+"  ");
		System.out.print("\n");
		System.out.print("第1组double：");
		Random c=new Random(100);
		for(i=0; i<5;i++)System.out.print (c.nextDouble()+"  ");
		System.out.print("\n");
		System.out.print("第2组double：");
		Random d=new Random(100);
		for(i=0; i<5;i++)System.out.print (d.nextDouble()+"  ");
		System.out.print("\n");
	}
}