import java.io.*;
import java.net.*;

class Client extends Thread {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Socket s;
	InputStream is;
	OutputStream os;
	DataInputStream dis;
	DataOutputStream dos;
	String chatId;

	Client(){
		connect();
	}
	void connect(){ //������ ����
		try{
			p("����IP(�⺻:127.0.0.1): ");
			String ip = br.readLine();
			if(ip != null) ip = ip.trim();
			if(ip.length() == 0) ip = "127.0.0.1";
			
			p("PORT(�⺻:3000): ");
			String portStr = br.readLine();
			if(portStr != null) portStr = portStr.trim();
			if(portStr.length() == 0) portStr = "3000";
			int port = Integer.parseInt(portStr);
			if(port<0 || port>65535){
				pln("������ ��ȿ���� ���� ��Ʈ��");
				connect();
				return;
			}

			s = new Socket(ip, port);
			pln("������ ���� ����");
			is = s.getInputStream();
			os = s.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
			start();
             
            inputChatId();
		}catch(IOException ie){}
	}
	public void run(){ //listen ( socket -> monitor )
		try{
			while(true){
				String msg = dis.readUTF();
				pln(msg);
			}
		}catch(IOException ie){
			pln("������ �ٿ��.. 2�� �Ŀ� ����˴ϴ�.");
			try{
				Thread.sleep(2000);
				System.exit(0);
			}catch(InterruptedException iee){}
		}finally{
			closeAll();
		}
	}
    void inputChatId(){ //ä��ID�� �Է�
		p("ä��ID(�⺻:GUEST): ");
		try{
			chatId = br.readLine();
			if(chatId  != null) chatId = chatId.trim();
			if(chatId.length() == 0) chatId = "GUEST";
			dos.writeUTF(chatId);
			dos.flush();

			inputMsg();
		}catch(IOException ie){
		}
	}
    void inputMsg(){ //speak ( key -> socket )
		String msg = "";
		try{
			while(true){
				msg = br.readLine();
				dos.writeUTF(chatId + ">> " + msg);
				dos.flush();
			}
		}catch(IOException ie){
		}finally{
			closeAll();
		}
	}
	void closeAll(){ //���ᰴü�� �ݱ�
		try{
			if(dis != null) dis.close();
			if(dos != null) dos.close();
			if(is != null) is.close();
			if(os != null) os.close();
			if(s != null) s.close();
		}catch(IOException ie){
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) {
		new Client();
	}
}
