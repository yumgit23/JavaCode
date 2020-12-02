import java.io.*;
import java.net.*;

class FServer {
	String fname = "CHEEZE(ġ��) _ Love You(������)(bye).mp4";
	int port = 4000;
	ServerSocket ss;
	Socket s;
	InputStream is; //Node 
	BufferedInputStream bis; //Filter
	FileOutputStream fos; //Node 
	BufferedOutputStream bos; //Filter 
	
	FServer(){
		try{
			ss = new ServerSocket(port);
			pln("���� ������ "+port+"�� ��Ʈ���� �����..");
			s = ss.accept();

			is = s.getInputStream();
			bis = new BufferedInputStream(is, 4096);
			
			fos = new FileOutputStream(fname);
			bos = new BufferedOutputStream(fos, 4096);

			receive();
		}catch(IOException ie){
		}
	}
	void receive(){ //socket -> file 
		byte bs[] = new byte[1024];
		int i=0;
		long total = 0L;
		try{
			while((i=bis.read(bs)) != -1){
				bos.write(bs, 0, i);
				pln("�޴� ��..."+ ( total+=i ) + "bytes");
			}
			bos.flush();
			pln("����("+fname+": "+total+"bytes) �ޱ� �Ϸ�!!");
		}catch(IOException ie){
		}finally{
			closeAll();	
		}
	}
	void closeAll(){
		try{
			bis.close();
			bos.close();
			is.close();
			fos.close();
			s.close();
			ss.close();
		}catch(IOException ie){}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		new FServer();
	}
}
