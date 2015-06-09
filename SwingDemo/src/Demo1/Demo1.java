package Demo1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.concurrent.TimeUnit;

import javax.naming.TimeLimitExceededException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Demo2.Demo2;

import com.sun.awt.AWTUtilities;

public class Demo1 extends JFrame {
	public void midShow(JFrame frame){
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 500;
		int height = 500;
		frame.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);
	}
	public Demo1() throws InterruptedException{
		super("hello swing");
		JPanel panel=new JPanel();
		this.setLayout(new BorderLayout());
		
		this.setUndecorated(true);
		AWTUtilities.setWindowOpaque(this, false);
		
		JLabel lable=new JLabel();
		this.add(BorderLayout.CENTER,lable);
		panel.setLayout(new GridLayout(2,2));
		
		midShow(this);
		 //this.setLocationRelativeTo(null);
		this.setSize(415, 400);
		this.setVisible(true); 
		
		for(int i=1;i<8;i++){
	    TimeUnit.SECONDS.sleep(1);
	    Icon icon=new ImageIcon("logo/"+String.valueOf(i)+".png");
	    lable.setIcon(icon);
	    }
		this.dispose();
		new Demo2();
}
public static void main(String args[]) throws InterruptedException{
	
	Demo1 demo1 = new Demo1();
	
	
	
  }
}
