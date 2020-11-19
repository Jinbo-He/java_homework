package Seqlist;
import java.util.Scanner;

class SeqList{
    int[] x;
    int maxsize;
    int len = 0;

    SeqList(int maxsize) {
        this.maxsize = maxsize;
        x = new int[maxsize];
    }

    void append() {
        Scanner sc = new Scanner(System.in);
        int new_data = sc.nextInt();
        while (new_data != 0) {
            x[len++] = new_data;
            new_data = sc.nextInt();
        }
    }

    void merge(SeqList L) {
        int i = 0, j = 0, k = 0;
        int[] array_new = new int[L.len + this.len];
        while (i < len && j < L.len)
            if (x[i] < L.x[j])
                array_new[k++] = x[i++];
            else
                array_new[k++] = L.x[j++];
        while (i < len)
            array_new[k++] = x[i++];
        while (j < L.len)
            array_new[k++] = L.x[j++];
        x = array_new;
        len = len + L.len;
    }

    void merge2(SeqList L) {
        int i = 0, j = 0, k = 0;
        int[] array_new = new int[L.len + this.len];
        while (i < len && j < L.len)
            if (x[i] < L.x[j])
                array_new[k++] = x[i++];
            else
                array_new[k++] = L.x[j++];
        while (i < len)
            array_new[k++] = x[i++];
        while (j < L.len)
            array_new[k++] = L.x[j++];
        x = array_new;
        len = len + L.len;
    }
    
    void add(int num ){
        for (int i = len-1  ;i>=0 ; i--){
            if (num<x[i])
                x[i+1] = x[i];
            else {
                x[i+1] = num;
                break;
            }
        }
        len  = len+1 ;
    }
    void  show(){
        for (int i = 0 ; i<len;i++)
            System.out.print(x[i]+"\t");
    }

}

class opopopop{
    public static void main(String[] args){
        SeqList L1 = new SeqList(10);
        SeqList L2 = new SeqList(10);
        //System.out.print(len+L2.len);
        L1.append();
        L2.append();
        L1.add(10);
        L1.show();
        L1.merge(L2);
        System.out.println();
        L1.show();
    }
}
