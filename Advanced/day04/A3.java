import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A3 extends JFrame implements ActionListener { //Container 
	JButton b; //UI Component
	void init(){
		b = new JButton("�ڹ��� ��ư");
		add(b);
        b.addActionListener(this);

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
	public void actionPerformed(ActionEvent e){
		b.setText("��ư Ŭ����!!( by �ڽ��� Ŭ���� )");
	}
	public static void main(String args[]){
		A3 a3 = new A3();
		a3.init();
	}
}