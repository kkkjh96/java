package application;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection 
{
    public static Connection dbConn;
    
        public static Connection getConnection()
        {
        	//�����ͺ��̽� ������ ���� �޼����Դϴ�, url�κ��� ȯ�漳���� �´��� �������ּ���, ����� �ش� ������Ʈ�� jdbc ���̺귯�� ���� ���ּ���
            Connection conn = null;
            try {
            	
                String user = "scott"; 
                String pw = "tiger";
                String url = "jdbc:oracle:thin:@localhost:1521:xe";
                conn = DriverManager.getConnection(url, user, pw);
                Class.forName("oracle.jdbc.driver.OracleDriver");        
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return conn;
        }
		
}