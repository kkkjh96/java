package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
    public static Connection dbConn;
    
        public static Connection getConnection()
        {
        	//데이터베이스 연결을 위한 메서드입니다, url부분의 환경설정이 맞는지 주의해주세요, 사용전 해당 프로젝트에 jdbc 라이브러리 적용 해주세요
            Connection conn = null;
            try {
                String user = "scott"; 
                String pw = "tiger";
                String url = "jdbc:oracle:thin:@192.168.0.44:1521:xe";
                
                Class.forName("oracle.jdbc.driver.OracleDriver");        
                conn = DriverManager.getConnection(url, user, pw);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return conn;
        }
}