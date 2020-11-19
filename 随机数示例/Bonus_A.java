import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.math.BigDecimal;
import javax.swing.border.TitledBorder;
class Bonus_A extends JFrame implements ActionListener{

	private JButton bt_start;//发红包
	private JTextField totalMoney,bonusCount,minBonus;  //产生的随机数
	JTextArea jt_result;

	Bonus_A(){
		setSize(800,400);
		setTitle("模拟发红包");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel p1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		add(p1, BorderLayout.NORTH);

		p1.add( new JLabel("总金额")) ;
		totalMoney=new JTextField("1000",8); 			p1.add(totalMoney);
		p1.add( new JLabel("元   发红包数量")) ;
		bonusCount=new JTextField("10",3); 			p1.add(bonusCount);
		p1.add( new JLabel("个  最小红包金额")) ;
		minBonus=new JTextField("1",4);
		p1.add(minBonus); p1.add( new JLabel("分 ")) ;

		bt_start=new JButton("发红包");  p1.add(bt_start);
		bt_start.addActionListener(this);

		jt_result=new JTextArea();
		jt_result.setLineWrap(true);//自动换行
		Font f1=new Font("微软雅黑",Font.BOLD,24);
		jt_result.setFont(f1);
		jt_result.setForeground(Color.blue);

		JScrollPane p2=new JScrollPane(jt_result);
		p2.setBorder(new TitledBorder("  产生的红包  "));
		add(p2,BorderLayout.CENTER);


		setVisible(true);
	}
    private void execute(int max, int min, int count){
    	int i,j;
    	int mm=max;//暂时保存总金额
    	int[]d=new int[count];

    	for(i=0; i<count; i++)  d[i]=min;//先支付每人的最低金额
    	max=max-min*count;
    	Random r=new Random();
    	//* 策略1：会导致两极分化
    	for(i=0; i<count-1; i++){
    		j=r.nextInt(max);
    		d[i]=d[i]+j;
    		max=max-j;
    	}
    	/* 策略2：可避免红包两极分化
    	int dAverage;
    	for(i=0; i<count-1; i++){
    		dAverage=2*max/(count-i); //count-i为待产生的红包数量
    		j=r.nextInt(dAverage);
    		d[i]=d[i]+j;
    		max=max-j;
    	}
    	 */
    	d[count-1]=d[count-1]+max; //将余额放入最后一个红包
    	double[]ddd=new double[count];
    	for(i=0; i<count; i++)ddd[i]=d[i]/100.0;
    	String s="";
    	String t="";
    	jt_result.append("\n");
    	//double[] dd=new double[count];
    	for(i=0;i<count; i++){
    		s=s+String.format("%6.2f",ddd[i])+"元、"; //保留2位小数
    		t=t+ddd[i]+"+";//产生运算式
    	}
    	jt_result.append(s+"\n");
    	jt_result.append(t+"\n");
    }
    public void actionPerformed(ActionEvent e){
		if(e.getSource()==bt_start) {
			int max,min,count;
			max=Integer.valueOf(totalMoney.getText().trim());
				max=max*100; //将元转换成分
			min=Integer.valueOf(minBonus.getText().trim());
			count=Integer.valueOf(bonusCount.getText().trim());

			execute(max,min,count);
			setVisible(true);
			return;
		}
	}

	public static void main (String[] args) {
		SetDefaultFont.setAll(new Font("微软雅黑", Font.BOLD,16));
		new Bonus_A();
	}
}
