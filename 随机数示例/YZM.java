/**本例生成8位验证码
*    Random类将根据候选字符集的大小随机产生该集合的下标
*/
import java.util.Random;

public class YZM{
	public static void main (String[] args) {
		int len=5;                        //假定产生8位验证码
		char[] yzmCh=new char[len]; 
		String s="589abcdfgiTjklW4Vmno1pq0rtu6vwxyhzAB章CeD王EFG李UHI3赵7JKsLM2NOPQRSXYZ@#$%&()!+-";
		char[] charSet=s.toCharArray();
			
		int pos;
		Random r=new Random(System.currentTimeMillis());
		for(int i=0; i<len; i++){
			pos=r.nextInt(charSet.length); 
			yzmCh[i]=charSet[ pos ];
		}
		System.out.print("产生的验证码为："); 
			for(char c: yzmCh)
				System.out.print(" "+c);
	}
}