package 随机数;
import java.util.*;

/*
1、模拟洗牌：一副扑克，将洗牌结果用字符表示。
洗牌前，结果为：红桃A  红桃2  红桃3  红桃4 。。。
洗牌后，结果为：方片J  梅花5  梅花10 。。。
【拓展】：两副扑克，按花色排序
策略1：可以给每种花色一个基数，如黑红梅方，分别给予100、200、300、400，小王500、大王600，对数值：3~10、J/Q/K/A/2对应：1-13，两者相加为牌面值，之后统一排序；
策略2：先设定5个数组，分别表示红黑梅方和王，之后将所得牌放入五个数组，最后对各数组进行排序
 */

class CardWasher {
    private Map dict_ = new TreeMap();
    CardWasher(){
       for (int i =3;i<=15;i++){
           String temp = i +"";
           switch (i){
               case 11:temp="j";break;
               case 12:temp="Q";break;
               case 13:temp="K";break;
               case 14:temp="A";break;
               case 15:temp="2";break;
           }
           dict_.put(100+i,"黑桃"+temp);
           dict_.put(200+i,"红心"+temp);
           dict_.put(300+i,"梅花"+temp);
           dict_.put(400+i,"方块"+temp);
       }
       dict_.put(500,"小王");
       dict_.put(600,"大王");
   }
    void Washer(){
        Random hs = new Random();
        Random num = new Random();
        Set key = dict_.keySet();
        for (Object item :key){
            System.out.println(item+"\t"+dict_.get(item));
        }
        Set sort = new TreeSet();
        while (true){
            int num1 =(num.nextInt(13)+3);
            int hs1 = (hs.nextInt(4)+1)*100;
            int hs2 = (hs.nextInt(2)+5)*100;
            sort.add(hs2);
            sort.add(num1+hs1);
            if (sort.size()==54)
                break;
        }
        System.out.println("洗牌完成");
        for (Object item :sort){
            System.out.println(item+"\t"+dict_.get(item));
        }
   }
}

class app{
    public static void main(String[] args) {
        CardWasher g = new CardWasher();
        g.Washer();
    }
}