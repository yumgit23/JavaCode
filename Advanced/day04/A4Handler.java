import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A4Handler implements ActionListener {
	A4 a4;
	A4Handler(A4 a4){
		this.a4 = a4;
	}
	public void actionPerformed(ActionEvent e){
		a4.b.setText("��ư Ŭ����!!( by ��3Ŭ���� )");
	}
}
