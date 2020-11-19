import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.util.Random;
class PKPanel_B extends JPanel{
	Image img;
	PKPanel_B(Image im){      img=im;    }
    public void setImg(Image ig){img=ig;     	repaint();    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }
}
class PP extends JFrame implements ActionListener{
 	JButton bt_init=new JButton("初始化");
	JButton bt_xp=new JButton("洗牌");
	JTextField xp_count=new JTextField("0",5);
	Poke t;
	PP(Poke tt){
		super("扑克游戏控制台");
		t=tt;
		setLayout(new FlowLayout(FlowLayout.LEFT));
		Font f1=new Font("宋体",Font.BOLD,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(526,100);	setLocation(400,580);
     		JLabel la=new JLabel("洗牌次数："); la.setFont(f1);add(la);
     		xp_count.setFont(f1);  add(xp_count);
     		bt_init.setFont(f1);add(bt_init);bt_init.addActionListener(this);
     		bt_xp.setFont(f1);add(bt_xp);bt_xp.addActionListener(this);
			setVisible(true);
	}
    public void actionPerformed(ActionEvent e){
		if(e.getSource()==bt_xp) {
			int n=0;
			try{n=Integer.valueOf(xp_count.getText());
			}catch(Exception ex){ xp_count.setText("输入错误");	}
			if(n<0)  xp_count.setText("输入错误");
			else t.executeXP(n);
		}
		else if(e.getSource()==bt_init)	t.executeXP(0);
	}
}
class Poke extends JFrame{
	PKPanel_B[] pk=new PKPanel_B[54];
	Image[] img=new Image[54];
	int[] pos=new int[54];

   public Poke(){
    	super("扑克洗牌");	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	setSize(1200,700); setLayout(new GridLayout(5,13,5,5));
   		Image im;
    	initPos();
    	for(int i=0; i<54;i++){
	        try {    im = ImageIO.read(new File("poke.img/"+i+".png"));
	         img[i]=im.getScaledInstance(75, 100, Image.SCALE_SMOOTH);
	        } catch (IOException ex) {  ex.printStackTrace();  }
    		pk[i]=new PKPanel_B(img[i]);
    		add(pk[i]);
    	}
    	for(int i=54; i<65; i++)add(new JPanel());
    	setVisible(true);
    }
    private void initPos(){
    	for(int i=0; i<54; i++)	pos[i]=i;
    }
    private void xp_pos(int n){//洗牌n次
    	Random r=new Random();
    	int i,a,b,t;
    	for(i=0; i<n; i++){
      		a=r.nextInt(54); b=r.nextInt(54);
    		t=pos[a]; pos[a]=pos[b]; pos[b]=t;
    	}
    }
    private void associatePos_Img(){
    	for(int i=0; i<54; i++)
    		pk[i].setImg(img[pos[i]]);
    }
    public void executeXP(int n){//展现洗牌后的结果
    	if(n==0)  initPos();
    	else if(n>0)  xp_pos(n);
    	associatePos_Img();
    }

    public static void main (String[] args) {
    	Poke t=new Poke();
    	PP p=new PP(t);
    }
 }