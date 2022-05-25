
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import DB.DMLCode;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class Serial {
	public Serial() {
		super();
	}

	void connect(String portName) throws Exception {
		CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
		if (portIdentifier.isCurrentlyOwned()) {
			System.out.println("Error: Port is currently in use");
		} else {
			// 클래스 이름을 식별자로 사용하여 포트 오픈
			CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);

			if (commPort instanceof SerialPort) {
				// 포트 설정(통신속도 설정. 기본 9600으로 사용)
				SerialPort serialPort = (SerialPort) commPort;
				serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
						SerialPort.PARITY_NONE);

				// Input,OutputStream 버퍼 생성 후 오픈
				InputStream in = serialPort.getInputStream();
				OutputStream out = serialPort.getOutputStream();

				// 읽기, 쓰기 쓰레드 작동
				(new Thread(new SerialReader(in))).start();
				(new Thread(new SerialWriter(out))).start();

			} else {
				System.out.println("Error: Only serial ports are handled by this example.");
			}
		}
	}

	/** */
	// 데이터 수신
//	public static class SerialReader implements Runnable {
//		InputStream in;
//
//		public SerialReader(InputStream in) {
//			this.in = in;
//		}
//
//		public void run() {
//			byte[] buffer = new byte[1024];
//			int len = -1;
//			try {
//				while ((len = this.in.read(buffer)) > -1) {
//					System.out.printf(new String(buffer, 0, len));
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	public static class SerialReader implements Runnable
	{
		InputStream in;
		public SerialReader(InputStream in)
		{
			this.in = in;
		}
		public void run()
		{
			byte[] buffer = new byte[1024];
			int len = -1;
			String tphr = "";
			DMLCode db = new DMLCode();
			try
			{
				while ((len = this.in.read(buffer)) > -1)
				{
					// 아두이노에서 받은 문자열 저장
					tphr = new String(buffer, 0, len).replaceAll("(\\r\\n|\\r|\\n|\\n\\r)", "");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// 문자열 NULL체크
					if (!tphr.isEmpty() && !tphr.equals("") && tphr.length() >= 7) {
						System.out.println(tphr);
						// 인설트문 실행
						db.insert("arduino_tphr", tphr.substring(0, 4), tphr.substring(4, 7));
					}
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	/** */
	// 데이터 송신
	public static class SerialWriter implements Runnable {
		OutputStream out;

		public SerialWriter(OutputStream out) {
			this.out = out;
		}

		public void run() {
			try {
				int c = 0;
				while ((c = System.in.read()) > -1) {
					this.out.write(c);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		try {
			(new Serial()).connect("COM3"); // 입력한 포트로 연결
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}