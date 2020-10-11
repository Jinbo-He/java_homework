/*
3?????洢int??????????????????List?????
??1??????????????????0??????????巨???β????????
??3?????void merge(L)?????????????????????????
??4??????????????????????????в??????x??????????????????
??5??????????????????????
*/
import java.util.Scanner;
class List{
     int data;
     List next;
     List(int x){ data = x; }
     void append1(){
     	  List head, q; 
     	  head = this;
          System.out.print("please input somedata\n");
          Scanner sc = new Scanner(System.in);
          int x = sc.nextInt();
          while(x != 0){
              q = new List(x);
              q.next = head.next;
              head.next = q;
              x = sc.nextInt();
          }
     }
     //β?巨
      void append2(){
     	  List tail, q; 
     	  tail = this;
          System.out.print("please input somedata\n");
          Scanner sc = new Scanner(System.in);
          int x = sc.nextInt();
          while(x != 0){
              q = new List(x);
              tail.next = q;
              tail = q;
              x = sc.nextInt();
          }
     }
     //?????????
     void merge(List L){
     	  List newL = new List(0);
          List h1, h2 ;
          h1 = this.next;
          h2 = L.next;
         List temp;
          while(h1!=null && h2!=null){
               if(h1.data < h2.data) {
                   temp = h1;
                   h1 = h1.next;
               }
               else {
                   temp= h2;
                   h2 = h2.next;
               }
               temp.next = newL.next;
               newL.next = temp;
          }
          while(h1!=null){
              temp = h1 ;
              temp.next = newL.next;
              newL.next = temp;
              h1 = h1.next;
          }
          while(h2!=null){
              temp = h2 ;
              temp.next = newL.next;
              newL.next = temp;
              h2 = h1.next;
          }
          this.next = newL.next;

/*          int [] a = new int [50];
          int i=0;
          List h1, h2;
          h1 = this.next; h2 = L.next;
          while(h1!=null || h2!=null){
               if(h1.data < h2.data) { a[i] = h1.data; h1 = h1.next; i++;}
               else { a[i] = h2.data; h2 = h2.next; i++; }
          }
          while(h1!=null) { a[i] = h1.data; h1 = h1.next; i++;}
          while(h2!=null) { a[i] = h2.data; h2 = h2.next; i++;}
          h1 = this.next;
          for(int j = i; j>=0; j--){ h1.data = a[j]; h1 = h1.next; }
          */
     }
     void insert(){
           System.out.print("????????????????");
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            List pre, f, q;
            q = new List(x);
            pre = this; f = this.next;
            while(x > f.data && f!=null) { pre = pre.next; f = f.next; }
            q.next = pre.next;
            pre.next = q;
     }
     void print(){
          for(List q = this.next; q!=null; q = q.next)
          	  System.out.print(q.data+" ");
          System.out.print("\n");
     }
}
class App111{
     public static void main(String [] x){
           List h = new List(0);          
  //      h.append1();
           h.append2();
           h.print();
           List k = new List(0);
           k.append2();
           k.print();
           System.out.print("????????\n");
           h.merge(k);
           h.print();
//              h.insert();
//              h.print();
     }
}