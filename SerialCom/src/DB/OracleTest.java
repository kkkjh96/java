package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleTest {

	public static void main(String[] args) {
		 Connection conn = null; // DB����� ����(����)�� ���� ��ü
	        PreparedStatement pstm = null;  // SQL ���� ��Ÿ���� ��ü
	        ResultSet rs = null;  // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
	        
	        try {
	            // SQL ������ ����� ���� ������ ���Ǿ�(SELECT��)���
	            // �� ����� ���� ResulSet ��ü�� �غ��� �� �����Ų��.
	            String quary = "SELECT E.EMPNO, E.ENAME, E.SAL, S.GRADE \r\n"
	            		+ "	FROM EMP E, SALGRADE S \r\n"
	            		+ "WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL \r\n"
	            		+ "	AND SAL > (SELECT MAX(SAL) \r\n"
	            		+ "             FROM EMP \r\n"
	            		+ "            WHERE JOB  = 'SALESMAN') \r\n"
	            		+ "ORDER BY E.EMPNO";
	            
	            conn = DBConnection.getConnection();
	            pstm = conn.prepareStatement(quary);
	            rs = pstm.executeQuery();
	            
	            /*  EMP ���̺��� ������ Ÿ��
	             * 
	                EMPNO NOT NULL NUMBER(4) -- int
	                ENAME VARCHAR2(10) -- String
	                JOB VARCHAR2(9) -- String
	                MGR NUMBER(4) -- int
	                HIREDATE DATE -- Date
	                SAL NUMBER(7,2) -- float/double
	                COMM NUMBER(7,2) -- float/double
	                DEPTNO NUMBER(2) -- int
	            */
	            
	            System.out.println("EMPNO ENAME SAL GRADE");
	            System.out.println("=====================");
	            
	            while(rs.next()){
	                int empno = rs.getInt(1);
	                //int empno = rs.getInt("empno"); ���� ��� �÷� �̸��� ��� �ȴ�.
	                String ename = rs.getString(2);
	                int sal = rs.getInt(3);
	                int grade = rs.getInt(4);
	                
	                String result = empno+" "+ename+" "+sal+" "+grade;
	                System.out.println(result);
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
	        }
	}
}
