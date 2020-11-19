
import java.util.Scanner;

class Linklist {
    int data ;
    Linklist next;

    void append(){
        Linklist t,p;
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        t = this;
        while(x != -1){
            p = new Linklist();
            p.data = x;
            t.next = p;
            t = p;
            x = sc.nextInt();
        }
    }

    void add(int x){
        Linklist head = this.next;
        Linklist temp = new Linklist();
        Linklist pre ;
        temp.data = x;
        pre = this;
        while(head!=null && x>head.data){
            pre = head;
            head = head.next;
        }
        temp.next=pre.next;
        pre.next=temp;
    }

    void show(){
        Linklist t=this.next ;
        while (t!= null) {
            System.out.print(t.data+"\t");
            t = t.next;
        }
        System.out.println();
    }

    void merger(Linklist L){
        Linklist L1 =this.next;
        Linklist L2 =L.next;
        Linklist new_head = new Linklist();
        Linklist temp ;
        while (L1!=null && L2!=null){
            if(L1.data>L2.data){
                temp=L2;
                L2 = L2.next;
            }
            else {
                temp = L1;
                L1 = L1.next;
            }
            temp.next=new_head.next;
            new_head.next=temp;
        }
        while (L1!=null){
            temp = L1;
            L1=L1.next;
            temp.next=new_head.next;
            new_head.next=temp;
        }
        while (L2!=null){
            temp = L2;
            L2=L2.next;
            temp.next=new_head.next;
            new_head.next=temp;
        }
        this.next = new_head.next;
    }
}

class op{
    public static void main(String[] args) {
        Linklist head = new Linklist();
        head.append();
        head.add(4);
        head.show();
        Linklist head2 = new Linklist();
        head2.append();
        head2.show();
        head.merger(head2);
        head.show();
    }
}