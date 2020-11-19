//package Re正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
1、假设给定输入：1.2+3.4*（5.6-7.8/（9.0-10））。请借助正则表达式实现：
（1）提取出所有的操作数，并输出；（2）提取出所有的运算符（注意左右括号也视为运算符）；
2、给定字符串" 192.168.9.1  sadsd 123.456.89.9 cxv000.000.111.000"，请识别出其中的ip地址。
 */

class RegexMatches {
    public static void main(String args[]) {
        String str = "192.168.9.1 sadsd 123.456.89.9 cxv000.000.111.000 255.255.255.255";
        String pattern = "(\\d){0,3}(\\.\\d+){0,3}";
        //emmm真实的ip地址应该比我写的麻烦很多  这里简化处理了
//        String str = "1.2+3.4*（5.6-7.8/（9.0-10））";
//        String pattern = "\\d+(\\.\\d)*";
//        String pattern1 = "(\\+|\\*|/|（|）|-)";
//       老师原来的字符串似乎是中文符的（）
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        while (m.find()){
            System.out.print(m.group()+"\t");
        }

//        String[] str2 = r.split(str);
//        for(String item:str2){
//            System.out.print(item+" ");
//        }
    }
}