import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A2 extends JFrame { //Container 
	JButton b; //UI Component
	void init(){
		b = new JButton("�ڹ��� ��ư");
		add(b);
        /*ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				b.setText("��ư Ŭ����!!( by ��(��)����Ŭ���� )");
			}
		};
        b.addActionListener(listener);
		*/
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				b.setText("��ư Ŭ����!!( by ��(��)����Ŭ���� )");
			}
		});

		setUI();
	}
	void setUI(){
		setTitle("GUI Test Ver 1.0");
		setSize(300, 200);
		setVisible(true);
		setLocation(200, 100);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[]){
		A2 a2 = new A2();
		a2.init();
	}
}