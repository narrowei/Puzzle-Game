package Demo2;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Demo3.Demo3;
import Demo6.Demo6;

public class Demo2 extends MouseAdapter implements ActionListener,MouseListener{
	public JFrame frame=new JFrame("Demo 2");
	public void midShow(JFrame frame){
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 550;
		int height = 360;
		frame.setBounds((d.width - width) / 2, (d.height - height) / 2, width, height);
	}
	public void setMouse(){
		Toolkit kit = Toolkit.getDefaultToolkit();
        Image image=kit.getImage("mouse.png");
        Cursor cursor=kit.createCustomCursor(image, new Point(10,10), "mouse");
        frame.setCursor(cursor);
	}
	public Demo2(){
		
		frame.setBackground(Color.BLACK);
		JPanel panel=new JPanel();
		frame.setLayout(new BorderLayout());
	    Icon main=new ImageIcon("main/main.jpg");
	    frame.add(BorderLayout.CENTER,new JLabel(main));
	    frame.add(BorderLayout.SOUTH,panel);
	    panel.setLayout(new GridLayout(1,3));
	    panel.setBackground(Color.BLACK);
	    String[] icon={"main/btnSortNormal.png","main/btnStartNormal.png","main/btnExitNormal.png"};
	    for(int i=0;i<icon.length;i++){
	    	Icon img=new ImageIcon(icon[i]);
	    	JButton button=new JButton(img);
	    	button.setName(String.valueOf(i));
	    	button.addMouseListener(this);
	    	button.setContentAreaFilled(false);
	    	button.setBorderPainted(false);
	    	button.addActionListener(this);
	    	panel.add(button);
	    }
	    
	    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(550, 360);
	    midShow(frame);
	    setMouse();
		frame.setVisible(true);
		frame.setResizable(false);
		
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {

		super.mouseClicked(e);
	}


	@Override
	public void mousePressed(MouseEvent e) {

		super.mousePressed(e);
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseReleased(e);
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn=(JButton)e.getSource();
		String name=btn.getName();
		int i=Integer.parseInt(name);
		switch (i) {
		case 0:
			btn.setIcon(new ImageIcon("main/btnSortPress.png"));
			break;
		case 1:
			btn.setIcon(new ImageIcon("main/btnStartPress.png"));
			break;
		case 2:
			btn.setIcon(new ImageIcon("main/btnExitPress.png"));
			break;

		default:
			break;
		}
		
		super.mouseEntered(e);
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn=(JButton)e.getSource();
		String name=btn.getName();
		int i=Integer.parseInt(name);
		switch (i) {
		case 0:
			btn.setIcon(new ImageIcon("main/btnSortNormal.png"));
			break;
		case 1:
			btn.setIcon(new ImageIcon("main/btnStartNormal.png"));
			break;
		case 2:
			btn.setIcon(new ImageIcon("main/btnExitNormal.png"));
			break;

		default:
			break;
		}
		super.mouseExited(e);
	}


	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		super.mouseWheelMoved(e);
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseDragged(e);
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseMoved(e);
	}


	public static void main(String[] args) {
		
		new Demo2();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn=(JButton)e.getSource();
		String name=btn.getName();
		int i=Integer.parseInt(name);
		switch (i) {
		case 0:
			try {
				new Demo6();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 1:
			frame.dispose();
			new Demo3();
			break;
		case 2:
			
			if((JOptionPane.showConfirmDialog(null, "exit?"))==0){
				System.exit(0);
			}		
			break;

		default:
			break;
		}
	}

}
