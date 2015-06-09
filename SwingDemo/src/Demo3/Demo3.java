package Demo3;

import java.awt.AWTEvent;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Demo2.Demo2;
import Demo4.Demo4;

public class Demo3 extends JFrame implements ActionListener{
	public void midShow(JFrame frame){
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 375;
		int height = 275;
		frame.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);
	}
	public void setMouse(){
		Toolkit kit = Toolkit.getDefaultToolkit();
        Image image=kit.getImage("mouse.png");
        Cursor cursor=kit.createCustomCursor(image, new Point(10,10), "mouse");
        this.setCursor(cursor);
	}
	public Demo3(){
		super("Demo3");
		JPanel panel=new JPanel();
		this.add(panel);
		panel.setLayout(new GridLayout(2,2));
		String[] pic={"gate1/open1.png","map/close2.png","map/close3.png","map/close4.png"};
		for(int i=0;i<pic.length;i++){
			Icon img=new ImageIcon(pic[i]);
	    	JButton button=new JButton(img);
	    	button.setName(String.valueOf(i));
	    	button.setContentAreaFilled(false);
	    	button.setBorderPainted(false);
	    	button.addActionListener(this);
	    	panel.add(button);
		}
		  this.enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		  setMouse();
		  this.setSize(375, 275);
		  midShow(this);
		  this.setResizable(false);
	      this.setVisible(true);
		
	}

	@Override
	protected void processWindowEvent(WindowEvent e) {
		if(e.getID()==WindowEvent.WINDOW_CLOSING){
				this.dispose();
				new Demo2();
		}
		
		super.processWindowEvent(e);
	}
	public static void main(String[] args) {
		
		new Demo3();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn=(JButton)e.getSource();
		int id=Integer.parseInt(btn.getName());
		if(id==0){
			this.dispose();
			new Demo4();
			
		}
		
		
		
	}

}
