import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;

public class TcpClient {

	public static void main(String[] args) {
		String serverIp = "127.0.0.1";  // localhost Ip�ּ�
		System.out.println("������ ���� ���Դϴ�. ����IP: " + serverIp);
		
		try {
			Socket socket = new Socket(serverIp, 7776);  // ������ ��Ʈ�� ������̶� ��ȣ�ٲ㼭 ������
			
			// �����͸� ������ �Է½�Ʈ���� ��´�.
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			// �������� ���� �޼��� ����
			System.out.println("�������� ���� �޽��� : " + dis.readUTF());
			System.out.println("������ �����մϴ�.");
			
			dis.close();
			socket.close();
		
		} catch (ConnectException ce) {
			ce.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}