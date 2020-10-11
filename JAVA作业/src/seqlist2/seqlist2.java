package seqlist2;

import java.io.SequenceInputStream;
import java.util.Scanner;

class seqlist2 {
    int[]  array;
    int maxsize;
    int len;
    seqlist2(int maxsize){
        this.maxsize = maxsize;
        array = new int[maxsize];
    }

    void append(){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        while(x != -1){
            array[len++]=x;
            x = sc.nextInt();
        }
    }

    void add(int x ){
        for (int i = len-1 ; i>=0 ;i--){
            if (array[i]>x)
                array[i+1] = array[i];
            else {
                array[i + 1] = x;
                break;
            }
        }
        len = len +1 ;
    }

    void merge(seqlist2 L){
        int len_L1 = 0, len_L2 = 0,i = 0;
        int[] new_array = new int[len+L.len];
        while (len_L1 <len && len_L2 < L.len){
            if (array[len_L1]>L.array[len_L2])
                new_array[i++] = L.array[len_L2++];
            else
                new_array[i++] = array[len_L1++];
        }
        while(len_L1 < len)
            new_array[i++] = array[len_L1++];
        while(len_L2 < L.len)
            new_array[i++] = L.array[len_L2++];
        array = new_array;
        len = len+L.len;
    }

    void show(){
        for (int i=0;i<len;i++)
            System.out.print(array[i]+"\t");
    }

}

class Main_op{
    public static void main(String[] args) {
        seqlist2 L1 = new seqlist2(10);
        seqlist2 L2 = new seqlist2(10);
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