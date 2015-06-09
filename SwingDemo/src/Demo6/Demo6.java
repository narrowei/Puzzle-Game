package Demo6;

import java.awt.AWTEvent;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Demo4.Score;

public class Demo6 extends JFrame {
	public void setMouse(){
		Toolkit kit = Toolkit.getDefaultToolkit();
        Image image=kit.getImage("mouse.png");
        Cursor cursor=kit.createCustomCursor(image, new Point(10,10), "mouse");
        this.setCursor(cursor);
	}
	public Demo6() throws IOException{
		super("Demo6");
		Score score=new Score();
		this.setLayout(new GridLayout(5,2));
		int flag=0;
		int scorenumber=4;
		int picnumber=1;
		for(int i=0;i<10;i++){
			if(flag==0){
				JButton btn=new JButton(new ImageIcon("sort/"+picnumber+".png"));
				picnumber++;
				this.add(btn);
				flag=1;
			}
			else{
				JLabel lable=new JLabel(String.valueOf(score.getScore(scorenumber)));
				scorenumber--;
				this.add(lable);
				flag=0;
			}
		}
		
		this.setSize(200, 500);
		this.enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		this.setResizable(false);
		setMouse();
		this.setVisible(true);
	}

@Override
	protected void processWindowEvent(WindowEvent e) {
		// TODO Auto-generated method stub
	if(e.getID()==WindowEvent.WINDOW_CLOSING){
		this.dispose();}
		super.processWindowEvent(e);
	}

public static void main(String[] args) throws IOException {
	
		new Demo6();
	}
	

}
