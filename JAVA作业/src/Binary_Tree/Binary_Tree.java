import java.util.Scanner;

class Read_String{
    int pos;
    String data;
    Read_String(String x ) {
        data = x ;
    }
    char read(){
        char temp = data.charAt(pos++);
        return temp;
    }
}

class Binary_Tree {
    Binary_Tree Right,Left;
    char data ;
    Binary_Tree(char c){
        data=c;
    }//牛逼之处在于 他可以自己选择是否初始化或者赋值！
    Binary_Tree(){}
    //确定root  if 节点为# return null  else 给左右节点赋值
    Binary_Tree create(Read_String r){
        char x = r.read();
        if (x == '#')
            return null;
        Binary_Tree root = new Binary_Tree(x);
        root.Left=create(r);
        root.Right=create(r);
        return root;
    }


    void pre(){
        Binary_Tree t = this;
        System.out.print(t.data);
        if (t.Left != null)
            t.Left.pre();
        if (t.Right != null)
            t.Right.pre();
    }

    void in(){
        Binary_Tree t = this;
        if (t.Left != null)
            t.Left.in();
        System.out.print(t.data);
        if (t.Right != null)
            t.Right.in();
    }

    void after(){
        Binary_Tree t = this;
        if (t.Left != null)
            t.Left.after();
        if (t.Right != null)
            t.Right.after();
        System.out.print(t.data);
    }
    class Stack{
        Binary_Tree[] x;
        int top;
        Stack(int maxsize){
            x = new Binary_Tree[maxsize];
            top=0;
        }
        Boolean isEmpty(){
            return top==0;
        }
        void push(Binary_Tree root){
            x[top++]=root;
        }

        Binary_Tree pop(){
            top--;
            return x[top];
        }
    }

    void preN(){
        Stack x = new Stack(20);
        Binary_Tree temp = this;
        while(temp!=null || !x.isEmpty()){
            if(temp!=null){
                System.out.print(temp.data);
                x.push(temp);
                temp = temp.Left;
            }
            else{
                temp = x.pop();
                temp =temp.Right;
            }

        }
    }

    void inN(){
        Stack x = new Stack(20);
        Binary_Tree temp = this;
        while(temp!=null || !x.isEmpty()){
            if(temp!=null){
                x.push(temp);
                temp = temp.Left;
            }
            else{
                temp = x.pop();
                System.out.print(temp.data);
                temp =temp.Right;
            }

        }
    }
}

class operate{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Read_String getchar = new Read_String(sc.nextLine());
        Binary_Tree root = new Binary_Tree();
        root = root.create(getchar);

        System.out.println("前序如上:");
        root.pre();


        System.out.println("中序如上:");
        root.in();

        System.out.println("后序如上:");
        root.after();

        System.out.println("非递归前序:");
        root.preN();

        System.out.println("非递归中序:");
        root.inN();



    }
}