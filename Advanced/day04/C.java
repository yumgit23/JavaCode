import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//GridLayout
class C extends JFrame {
	JButton b1, b2, b3, b4;
	Container cp;
	void init(){
		b1 = new JButton("��ư1");
		b2 = new JButton("��ư2");
		b3 = new JButton("��ư3");
		b4 = new JButton("��ư4");
		CHandler h = new CHandler(this);
		b1.addActionListener(h);
		b2.addActionListener(h);
		b3.addActionListener(h);
		b4.addActionListener(h);

		setLayout(new GridLayout(2, 3));
		cp = getContentPane();
		cp.add(b1);cp.add(b2);cp.add(b3);cp.add(b4);
		cp.add(new JButton("��ư5"));
		cp.add(new JButton("��ư6"));

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
		C c = new C();
		c.init();
	}
}
class CHandler implements ActionListener 
{
	C c;
	CHandler(C c){
		this.c = c;
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		JButton b = (JButton)obj;
		if(obj == c.b1){
			c.b1.setText("Ŭ��1");
		}else if(obj == c.b2){
			c.b2.setText("Ŭ��2");
		}else if(obj == c.b3){
			c.b3.setText("Ŭ��3");
		}else{ 
			c.b4.setText("Ŭ��4");
		}

		System.out.println(b.getLabel());
	}
}
