import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpServer2 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(7776);
			System.out.println(getTime() + " 서버가 준비되었습니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				serverSocket = new ServerSocket(7776); // 웹소켓 포트가 사용중이라 번호바꿔서 실행함
				System.out.println(getTime() + " 연결 요청을 기다립니다.");
				
				Socket socket = serverSocket.accept();
				// 연결 요청한 클라이언트의 IP주소 확인
				System.out.println(getTime() + " " + socket.getInetAddress() + "로 부터 연결요청이 들어왔습니다.");
				System.out.println("통신포트: " + socket.getPort());
				
				// 데이터를 송신(input이 수신, 송신은 output)하기 위한 출력스트림을 얻어온다.
				OutputStream out = socket.getOutputStream();  // (아웃풋은)바이트기반의 출력 스트림(문자기반의 스트림은 Writer 등등임
				// 바이트기반이기 때문에 보조스트림(DataOutputStream)을 사용을 해서 사용
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF("[알림] 서버에서 응답메시지가 전송되었습니다.");  // 클라이언트로 전송되는 메시지
				System.out.println(getTime() + " 데이터를 전송하였습니다.");
				
				dos.close();   // 출력스트림 close
				socket.close();  // 통신연결해지
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	/* 
	 * 현재시각을 출력하는 메소드
	 */
	static String getTime() {
		
		// 출력할 시간 포맷 생성
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss] ");
		
		return sdf.format(new Date());
	}
}