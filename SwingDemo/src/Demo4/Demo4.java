package Demo4;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import Demo2.Demo2;


public class Demo4 extends JFrame implements ActionListener{
	//int i；
	Score score=new Score();
	boolean flag=false;
	boolean complete=false;
	int result;
	static int finalresult=0;
	//ArrayList<Integer> resultList=new ArrayList<Integer>();
	int[] level1={4,3};
	int[] level2={4,4};
	int[] level3={4,5};
	int[] level4={5,5};
	int[][] level={level1,level2,level3,level4};
	static int whichlevel=1;
	int[] picNumber={12,16,20,25};
	String first;
	String second;
	
	JPanel panel=new JPanel();
	JPanel insidePanel=new JPanel(); 
	JButton button1=new JButton();
	JButton button2=new JButton();
	JProgressBar pb=new JProgressBar();
	Timer timer;
	ArrayList<String> list=new ArrayList<String>();
	public void midShow(JFrame frame){
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 960;
		int height = 360;
		frame.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);
	}
	public void setMouse(){
		Toolkit kit = Toolkit.getDefaultToolkit();
        Image image=kit.getImage("mouse.png");
        Cursor cursor=kit.createCustomCursor(image, new Point(10,10), "mouse");
        this.setCursor(cursor);
	}
	public int GameResult(){
		
		
		System.out.println("finalresult"+finalresult);
		return finalresult;
	}
	public void bar(){
		 pb = new JProgressBar(JProgressBar.HORIZONTAL); 
	        pb.setStringPainted(true);  //设置进度条呈现进度字符串,默认为false  
	        pb.setBorderPainted(false); //不绘制边框,默认为true  
	         
	        timer = new Timer(500, new ActionListener(){ 
	            public void actionPerformed(ActionEvent e) { 
	                int loadingValue = pb.getValue(); 
	               
	                if (loadingValue<100){ 
	                	
	                	
	                    pb.setValue(++loadingValue); 
	                    if(complete){
	                    	timer.stop();
	                    	result=100-loadingValue;
	                    	System.out.println("result="+result);
	                    	finalresult+=result;
	                    }
	                    
	                    
	                }else { 
	                    timer.stop();
	                    JOptionPane.showMessageDialog(null,"GameOver,you finalresult="+finalresult);
	                    try {
							score.addNewScore(finalresult);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	                    GameResult(); 
	                } 
	            } 
	        }); 
			timer.start(); 
	  }
	
	public static boolean isRight(ArrayList<String> list) {
		int count = 0;
		int size = list.size();
		for (int i = 0; i < list.size(); i++) {
			if (String.valueOf(i).equals(list.get(i))) {
				count++;
			}
			if (count == size)
				return true;
		}
		return false;
	}
	
	public int getListPosition(ArrayList<String> list,String name){
		int size=list.size();
		for(int i=0;i<size;i++){
			if(name.equals(list.get(i)))
				return i;}
		return 0;
	}
	

	public  void print(ArrayList<String> list,JPanel panel){
		for(String i:list){
			Icon icon=new ImageIcon("gate"+whichlevel+"/pic"+i+".png");
			JButton button=new JButton(icon);
			button.setName(String.valueOf(i));
			button.setContentAreaFilled(false);
	    	button.setBorderPainted(false);
	    	panel.add(button);
	    	button.addActionListener(this);
		}
	}
	public void insertList(ArrayList<String> list){
		for(int i=0;i<picNumber[(whichlevel-1)];i++){
			list.add(String.valueOf(i));
		}
		Collections.shuffle(list);
		for(String i:list){
			System.out.print(i+" ");
			
		}
	}

	public Demo4(){
		super("Demo4");
		insertList(list);
		//JFrame frame=new JFrame("Demo4");
		this.setLayout(new BorderLayout());
		insidePanel.setLayout(new GridLayout(1, 2));
		//JPanel panel=new JPanel();
		this.add(BorderLayout.CENTER,insidePanel);
		insidePanel.add(panel);
		print(list, panel);
		Icon pic=new ImageIcon("map/"+whichlevel+".png");
		JLabel lable=new JLabel(pic);
		insidePanel.add(lable);
		
		
		panel.setLayout(new GridLayout(level[(whichlevel-1)][0],level[(whichlevel-1)][1]));
		bar();
		this.add(BorderLayout.SOUTH,pb);
		
		 
	    
	
		this.enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(960, 360);
	    midShow(this);
	    setMouse();
	    this.setResizable(false);
	    this.setVisible(true);
	}
	@Override
	protected void processWindowEvent(WindowEvent e) {
if(e.getID()==WindowEvent.WINDOW_CLOSING){
			
			if((JOptionPane.showConfirmDialog(null, "exit?"))==0){
 				this.dispose();
		        new Demo2();
				
				}
			else
				return;
			
		}
		super.processWindowEvent(e);
	}
	public static void main(String[] args){
		new Demo4();
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(e.getActionCommand());
		//System.out.println(e.getSource().toString());
		if(flag==false){
			button1=(JButton)e.getSource();
			first=button1.getName();
			System.out.println();
			System.out.println(first);
			flag=true;
			}
		else{
			button2=(JButton)e.getSource();
			second=button2.getName();
			System.out.println(second);
			int firstPosition,secondPosition;
			secondPosition=getListPosition(list, second);
			firstPosition=getListPosition(list, first);
			list.set(secondPosition,first);
			list.set(firstPosition, second);
			for(String i:list){
				System.out.print(i+" ");
			}
			button1.setIcon(new ImageIcon("gate"+whichlevel+"/pic"+second+".png"));
			button1.setName(second);
			button2.setIcon(new ImageIcon("gate"+whichlevel+"/pic"+first+".png"));
			button2.setName(first);
		    if(isRight(list)){
		
		    	System.out.println("success");
		    	JOptionPane.showMessageDialog(null,"success");
		    	complete=true;
		    	whichlevel++;
		    	if(whichlevel!=5){
		    	this.dispose();
		    	new Demo4();}
		    	else{
		    		JOptionPane.showMessageDialog(null,"you have complete all level,you final result is"+finalresult);
		    		try {
						score.addNewScore(finalresult);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
		    }
			
			flag=false;
			
			
			}
		
		
	}
	

}
