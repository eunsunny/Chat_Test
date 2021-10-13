import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(7776); // ������ ��Ʈ�� ������̶� ��ȣ�ٲ㼭 ������
			System.out.println(getTime() + " ������ �غ�Ǿ����ϴ�.");
			
			Socket socket = serverSocket.accept();
			// ���� ��û�� Ŭ���̾�Ʈ�� IP�ּ� Ȯ��
			System.out.println(getTime() + " " + socket.getInetAddress() + "�� ���� �����û�� ���Խ��ϴ�.");
			
			// �����͸� �۽�(input�� ����, �۽��� output)�ϱ� ���� ��½�Ʈ���� ���´�.
			OutputStream out = socket.getOutputStream();  // (�ƿ�ǲ��)����Ʈ����� ��� ��Ʈ��(���ڱ���� ��Ʈ���� Writer �����
			// ����Ʈ����̱� ������ ������Ʈ��(DataOutputStream)�� ����� �ؼ� ���
			DataOutputStream dos = new DataOutputStream(out);
			
			dos.writeUTF("[�˸�] �������� ����޽����� ���۵Ǿ����ϴ�.");  // Ŭ���̾�Ʈ�� ���۵Ǵ� �޽���
			System.out.println(getTime() + " �����͸� �����Ͽ����ϴ�.");
			
			dos.close();   // ��½�Ʈ�� close
			socket.close();  // ��ſ�������
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/* 
	 * ����ð��� ����ϴ� �޼ҵ�
	 */
	static String getTime() {
		
		// ����� �ð� ���� ����
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss] ");
		
		return sdf.format(new Date());
	}
}