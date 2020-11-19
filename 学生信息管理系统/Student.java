import java.util.Scanner;

class Student{
    String name,num; boolean sex;int age;double score;
    Student( String name,int age,boolean sex,String num,double score ){
        this.age=age;this.name=name;this.sex =sex;this.num=num;this.score=score;
    }
    public String toString(){
        String x ;
        if(sex == true) x = "MaLe";
        else if (sex == false) x = "Female";
        else x = "Unknow";
        return "Num:"+num+"\tname:"+ name +"\tage:"+age + "\tsex:"+x+"\tscore:"+score;
    }

    void show_information(){
        System.out.println(this);
    }
}

class Class_mine{
    int maxsize;
    int current_len;
    String name,num; boolean sex;int age;double score;
    Student[] Ss_group;
    Class_mine(int maxsize){
        this.maxsize=maxsize;
        Ss_group = new Student[maxsize];
    }
    void add(){
        Scanner sc = new Scanner(System.in);
        System.out.println("输入格式如下:姓名\t 性别(true男/false女)\t 学号\t 年龄\t 分数");
        System.out.println("输入时请用回车间隔,#为停止输入符哦");

        while(sc.hasNext("#") != true){
            name = sc.next();   // why 0?
            sex = sc.nextBoolean();
            num = sc.next();
            age = sc.nextInt();
            score = sc.nextDouble();
            Ss_group[current_len++] = new Student(name,age,sex,num,score);
        }
    }

    void show_all_information(){
        System.out.println("Student's information listed as following:" );
        for (int i=0;i<current_len;i++){
            Ss_group[i].show_information();
        }
    }
}

class App11{
    public static void main(String[] args) {
        Class_mine banji = new Class_mine(100);
        banji.add();
        banji.show_all_information();
        }

}
