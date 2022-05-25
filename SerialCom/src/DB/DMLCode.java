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
		Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
        
        try {
            // SQL 문장을 만들고 만약 문장이 질의어(SELECT문)라면
            // 그 결과를 담을 ResulSet 객체를 준비한 후 실행시킨다.
        	
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
            System.out.println("SELECT문에서 예외 발생");
            sqle.printStackTrace();
            
        }finally{
            // DB 연결을 종료한다.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            System.out.println("실행완료");
        }
	}
	

}

