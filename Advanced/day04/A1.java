import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A1 extends JFrame { //Container 
	class A1Handler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			//System.out.println("�̺�Ʈ ����");
			b.setText("��ư Ŭ����!!( by ������Ŭ����1 )");

			//JButton bb = (JButton)e.getSource();
			//bb.setText("��ư Ŭ����!!( by ������Ŭ����2 )");
		}
	}

	JButton b; //UI Component
	void init(){
		b = new JButton("�ڹ��� ��ư");
		add(b);
        ActionListener listener = new A1Handler();
        b.addActionListener(listener);

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
		A1 a1 = new A1();
		a1.init();
	}
}