import java.awt.Toolkit;
import java.awt.Dimension;
  
public class �ػ� {
	public static void main(String[] agrs){
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println("�ػ� : " + res.width + " x " + res.height);  
	}
}