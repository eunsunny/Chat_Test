import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;

public class TcpClient {

	public static void main(String[] args) {
		String serverIp = "127.0.0.1";  // localhost Ip주소
		System.out.println("서버에 연결 중입니다. 서버IP: " + serverIp);
		
		try {
			Socket socket = new Socket(serverIp, 7776);  // 웹소켓 포트가 사용중이라 번호바꿔서 실행함
			
			// 데이터를 전송할 입력스트림을 얻는다.
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			// 서버에서 받은 메세지 수신
			System.out.println("서버에서 받은 메시지 : " + dis.readUTF());
			System.out.println("연결을 종료합니다.");
			
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