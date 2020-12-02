import java.io.*;
import java.net.*;

//�ϳ��� Ŭ���̾�Ʈ�� ���(Ư��Ŭ���� �� ������Ŭ�鿡�� �ѷ���)�ϴ� ���� ��� Ŭ����
class OneClientModul extends Thread 
{
	Server server;
	Socket s;
	InputStream is;
	OutputStream os;
	DataInputStream dis;
	DataOutputStream dos;
	String chatId = "GUEST";

	OneClientModul(Server server){
		this.server = server;
		this.s = server.s;
		try{
			is = s.getInputStream();
			os = s.getOutputStream();
			dis= new DataInputStream(is);
			dos = new DataOutputStream(os);
		}catch(IOException ie){}
	}
	public void run(){ // listen -> broadcasting 
		listen();
	}
	void listen(){
		String msg = "";
		try{
			chatId = dis.readUTF();
			String inMsg = chatId +"�� ����!! (���ο�:" + server.v.size()+"��)";
			broadcast(inMsg);
			server.pln(inMsg);
			while(true){
				msg = dis.readUTF();
				broadcast(msg);
				server.pln(msg);
			}
		}catch(IOException ie){
			server.v.remove(this);
			String outMsg = chatId+"�� ����!!(���ο�:" + server.v.size()+"��)";
			broadcast(outMsg);
			server.pln(outMsg);
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
	void broadcast(String msg){
		try{
			for(OneClientModul ocm: server.v){
				ocm.dos.writeUTF(msg);
				ocm.dos.flush();
			}
		}catch(IOException ie){}
	}
}
