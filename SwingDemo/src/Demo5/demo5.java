package Demo5;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Demo2.Demo2;

public class demo5 extends JFrame {

	Timer timer;
	JProgressBar jpbFileLoading;
	public void bar(){
		 jpbFileLoading = new JProgressBar(JProgressBar.HORIZONTAL); 
	        jpbFileLoading.setStringPainted(true);  //设置进度条呈现进度字符串,默认为false  
	        jpbFileLoading.setBorderPainted(true); //不绘制边框,默认为true  
	        jpbFileLoading.setPreferredSize(new Dimension(100, 40)); //设置首选大小  
	        timer = new Timer(500, new ActionListener(){ 
	            public void actionPerformed(ActionEvent e) { 
	                int loadingValue = jpbFileLoading.getValue(); 
	               
	                if (loadingValue<100){ 
	                	
	                	
	                    jpbFileLoading.setValue(++loadingValue); 
	                    
	                    
	                }else { 
	                    timer.stop(); 
	                } 
	            } 
	        }); 
	        timer.start(); 
		
	}
	
	public demo5(){
		   super("进度条测试"); 
	   
		    bar();
	        this.add(jpbFileLoading, BorderLayout.NORTH); 
	       
	        this.setSize(300, 150); 
	        this.setLocationRelativeTo(null); //居中显示 
	        this.enableEvents(AWTEvent.WINDOW_EVENT_MASK);
	        this.setVisible(true); 
	        Toolkit kit = Toolkit.getDefaultToolkit();
	        Image image=kit.getImage("mouse.png");
	        Cursor cursor=kit.createCustomCursor(image, new Point(10,10), "mouse");
	        setCursor(cursor);
	        
	}
	
	@Override
	protected void processWindowEvent(WindowEvent e) {
		if(e.getID()==WindowEvent.WINDOW_CLOSING){
			
			if((JOptionPane.showConfirmDialog(null, "exit?"))==0){
//				this.dispose();
//				new Demo2();
				this.setDefaultCloseOperation(EXIT_ON_CLOSE);
				}
			else
				return;
			
		}
			
		
		super.processWindowEvent(e);
	}
	

	public static void main(String[] args) {
		new demo5();

	}

}
