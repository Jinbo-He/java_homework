import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import java.util.Random;
class PKPanel extends JPanel{//贴扑克牌的面板
	Image img;
	PKPanel(Image im){      img=im;    }
    public void setImg(Image ig){img=ig;     	repaint();    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }
}
class PokeA extends JFrame implements ActionListener{
	PKPanel[] pk=new PKPanel[54];
	Image[] img=new Image[54];
	int[] pos=new int[54];
	JButton bt_xiPai,bt_init;//洗牌
	//JTextField jt_result;  //产生的随机数
	JTextArea jt_result;  //产生的随机数
	PokeA(){
		setSize(1200,360);
		setTitle("抽取洗牌方式");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//洗牌按钮和产生的随机数
		JPanel p1=new JPanel(new BorderLayout(5,10));
		p1.setBorder(new TitledBorder("洗牌产生的随机数"));  	add(p1,BorderLayout.SOUTH);
		//jt_result=new JTextField();
		jt_result=new JTextArea();
		jt_result.setLineWrap(true);//自动换行
		jt_result.setWrapStyleWord(true);  // 激活断行不断字功能

		p1.add(jt_result,BorderLayout.CENTER);

		JPanel p3=new JPanel(new GridLayout(2,1,2,2));//2行1列
		p1.add(p3,BorderLayout.EAST);
		bt_init=new JButton("初始"); p3.add(bt_init);
		bt_xiPai=new JButton("洗牌"); p3.add(bt_xiPai,BorderLayout.EAST);


		JPanel p2=new JPanel(new GridLayout(1,54,1,10));//1行54列
		p2.setBorder(new TitledBorder(" 洗牌结果"));
		add(p2,BorderLayout.CENTER);

		bt_xiPai.addActionListener(this);
		bt_init.addActionListener(this);
		//jt_result.addActionListener(this);

		generatePoke(); //生成扑克
		//原始牌面面板
		for(int i=0; i<54; i++)p2.add(pk[i]); //载入原始牌面
		//洗牌后牌面的显示面板
    	setVisible(true);
	}
	private void generatePoke(){//构造扑克牌
		Image im;
		initPos();
    	for(int i=0; i<54;i++){
	        try {    im = ImageIO.read(new File("poke.img/"+i+".png"));
	            img[i]=im.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
	        } catch (IOException ex) {  ex.printStackTrace();  }
    		pk[i]=new PKPanel(img[i]);
    	}
	}
    private void initPos(){//pos[i]原本存储的是下标为i的牌
    	for(int i=0; i<54; i++)	pos[i]=i;
    }
    private void del(int i, int len){//当前有len个元素。从pos中删除pos[i]
    	for(int j=i+1; j<len; j++)pos[j-1]=pos[j];
    }
    private void cqxp_pos(){//抽取方式洗牌54次===========
    	int i,a,b,t;
    	String s="";
    	int[] p=new int[54];
    	Random r=new Random();
    	for(i=0; i<54; i++){
      		a=r.nextInt(54);
    		p[i]=a;
    		s=s+a+"-";
    	}
    	for(i=0; i<54; i++)pos[i]=p[i];
    	jt_result.setText(s);
    }
    private void associatePos_Img(){
    	for(int i=0; i<54; i++)
    		pk[i].setImg(img[pos[i]]);
    }
    public void actionPerformed(ActionEvent e){
		if(e.getSource()==bt_init){//初始化
			initPos();
			jt_result.setText(null);
			associatePos_Img();
		}
		if(e.getSource()==bt_xiPai) { //抽取洗牌
			initPos(); //洗牌前先初始化
			cqxp_pos();
			associatePos_Img();//关联到牌面图片
			return;
		}
	}

	public static void main (String[] args) {
		SetDefaultFont.setAll(new Font("微软雅黑", Font.BOLD,16));
		new PokeA();
	}
}