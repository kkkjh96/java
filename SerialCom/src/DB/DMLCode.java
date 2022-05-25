package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

public class DMLCode {	
	/**
	 * @param tbName
	 * @param TEMPERATURE
	 * @param HEARTRATE
	 */
	public void insert(String ARDUINO_TPHR, String TEMPERATURE, String HEARTRATE) {
		Connection conn = null; // DB����� ����(����)�� ���� ��ü
        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
        
        try {
            // SQL ������ ����� ���� ������ ���Ǿ�(SELECT��)���
            // �� ����� ���� ResulSet ��ü�� �غ��� �� �����Ų��.
        	
    		String tableName = ARDUINO_TPHR;
    		String msg = "INSERT INTO "+ tableName +" VALUES (''{0}'',''{1}'',{2})";

    		Object[][] arguments = {
    			{TEMPERATURE, HEARTRATE, "SYSDATE"},
    		};
    		
    		for(int i=0; i < arguments.length;i++) {
    			String result = MessageFormat.format(msg, arguments[i]);
    			System.out.println(result);
    			
                conn = DBConnection.getConnection();
                pstm = conn.prepareStatement(result);
                rs = pstm.executeQuery();
    		}
    		
        } catch (SQLException sqle) {
            System.out.println("SELECT������ ���� �߻�");
            sqle.printStackTrace();
            
        }finally{
            // DB ������ �����Ѵ�.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            System.out.println("����Ϸ�");
        }
	}
	

}

