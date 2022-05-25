package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;

public class MainSceneController implements Initializable {	// 컨트롤러의 동작들을 수행하는 Initializable 인터페이스 구현
	@FXML
	private TableView<ModelTable> eEmp;	// TableView(테이블의 틀)에 ModelTable 클래스를 매개해줍니다 
	@FXML
	private TableColumn<ModelTable, Integer> eEmpno; // TableColumn(테이블의 열)에 ModelTable클래스와 데이터베이스 열타입에 맞는 래퍼(wrapper)클래스를 매개해줍니다.
	@FXML
	private TableColumn<ModelTable, String> eEname;
	@FXML
	private TableColumn<ModelTable, String> eJob;
	@FXML
	private TableColumn<ModelTable, Integer> eMgr;
	@FXML
	private TableColumn<ModelTable, Date> eHiredate;
	@FXML
	private TableColumn<ModelTable, Integer> eSal;
	@FXML
	private TableColumn<ModelTable, Integer> eComm;
	@FXML
	private TableColumn<ModelTable, Integer> eDeptno;
	
	@FXML
	private TableView<ModelTable2> dDept;
	
	@FXML
	private TableColumn<ModelTable2, Integer> dDeptno;
	@FXML
	private TableColumn<ModelTable2, String> dDname;
	@FXML
	private TableColumn<ModelTable2, String> dLoc;
	
	@FXML
	private TableView<ModelTable3> sSalgrade;
	@FXML
	private TableColumn<ModelTable3, Integer> sGrade;
	@FXML
	private TableColumn<ModelTable3, Integer> sLosal;
	@FXML
	private TableColumn<ModelTable3, Integer> sHisal;
	
	@FXML
	private TableView<ModelTable4> bBONUS;

	@FXML
	private TableColumn<ModelTable4, Integer> bComm;

	@FXML
	private TableColumn<ModelTable4, String> bEname;

	@FXML
	private TableColumn<ModelTable4, String> bJob;

	@FXML
	private TableColumn<ModelTable4, Integer> bSal;
	
    @FXML
    private TableView<ModelTable5> dtDept;

    @FXML
    private TableColumn<ModelTable5, String> dtDeptno;

    @FXML
    private TableColumn<ModelTable5, String> dtDname;

    @FXML
    private TableColumn<ModelTable5, String> dtLoc;

	@FXML
	private TextField Title;
	
	// ModelTable의 값(데이터)이 변경될때마다 추적해서 담아주는 컬렉션 배열 observableArrayList oblist 생성
	ObservableList<ModelTable> oblist = FXCollections.observableArrayList();	
	ObservableList<ModelTable2> oblist2 = FXCollections.observableArrayList();
	ObservableList<ModelTable3> oblist3 = FXCollections.observableArrayList();
	ObservableList<ModelTable4> oblist4 = FXCollections.observableArrayList();
	ObservableList<ModelTable5> oblist5 = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Connection conn = DBConnection.getConnection();	// 만들어둔 DBconnection 클래스에서 데이터베이스 연결을 불러옵니다.
		try {
			ResultSet rs = conn.createStatement().executeQuery("select * from emp"); // 쿼리문을 작성하는 곳입니다.
			ResultSet rs2 = conn.createStatement().executeQuery("select * from dept");
			ResultSet rs3 = conn.createStatement().executeQuery("select * from salgrade");
			ResultSet rs4 = conn.createStatement().executeQuery("select * from bonus1");
			ResultSet rs5 = conn.createStatement().executeQuery("select * from dept_temp");
			// ModelTable 클래스안의 emp테이블 데이터들을 oblist에 담아줍니다
			while(rs.next()) {	
				oblist.add(new ModelTable(rs.getInt("empno"),rs.getString("ename"),
						rs.getString("job"), rs.getInt("mgr"),rs.getDate("hiredate"),
						rs.getInt("sal"), rs.getInt("comm"), rs.getInt("deptno")));
			}
			while(rs2.next()) {	
				oblist2.add(new ModelTable2(rs2.getInt("deptno"), rs2.getString("dname"), rs2.getString("loc")));}
			while(rs3.next()) {	
				oblist3.add(new ModelTable3(rs3.getInt("grade"), rs3.getInt("losal"), rs3.getInt("hisal")));}
			while(rs4.next()) {	
				oblist4.add(new ModelTable4(rs4.getString("ename"), rs4.getString("job"), rs4.getInt("sal"), rs4.getInt("comm")));
			}
			while(rs5.next()) {
				oblist5.add(new ModelTable5(rs5.getInt("deptno"), rs5.getString("dname"), rs5.getString("loc")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// javafx로 만들어두었던 열들 하나하나에 setCellValueFactory 메소드로 들어갈 데이터베이스 형식을 짝지어줍니다 

		eEmpno.setCellValueFactory(new PropertyValueFactory<>("empno"));
		eEname.setCellValueFactory(new PropertyValueFactory<>("ename"));
		eJob.setCellValueFactory(new PropertyValueFactory<>("job"));
		eMgr.setCellValueFactory(new PropertyValueFactory<>("mgr"));
		eHiredate.setCellValueFactory(new PropertyValueFactory<>("hiredate"));
		eSal.setCellValueFactory(new PropertyValueFactory<>("sal"));
		eComm.setCellValueFactory(new PropertyValueFactory<>("comm"));
		eDeptno.setCellValueFactory(new PropertyValueFactory<>("deptno"));
		
	
		eEmp.setItems(oblist); 	//마지막으로 setItems 메소드를 통해 위에서 생성한 리스트를 javafx 테이블뷰안에 집어넣어줍니다 
		
		dDeptno.setCellValueFactory(new PropertyValueFactory<>("deptno"));
		dDname.setCellValueFactory(new PropertyValueFactory<>("dname"));
		dLoc.setCellValueFactory(new PropertyValueFactory<>("loc"));
		
		dDept.setItems(oblist2);
		
		sGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
		sLosal.setCellValueFactory(new PropertyValueFactory<>("losal"));
		sHisal.setCellValueFactory(new PropertyValueFactory<>("hisal"));
		
		sSalgrade.setItems(oblist3);
		
		bEname.setCellValueFactory(new PropertyValueFactory<>("ename"));
		bJob.setCellValueFactory(new PropertyValueFactory<>("job"));
		bSal.setCellValueFactory(new PropertyValueFactory<>("sal"));
		bComm.setCellValueFactory(new PropertyValueFactory<>("comm"));
		
		bBONUS.setItems(oblist4);
		
		dtDeptno.setCellValueFactory(new PropertyValueFactory<>("deptno"));
		dtDname.setCellValueFactory(new PropertyValueFactory<>("dname"));
		dtLoc.setCellValueFactory(new PropertyValueFactory<>("loc"));
		
		dtDept.setItems(oblist5);

	}
	@FXML
	public void OKBTN(ActionEvent event) {
		Stage mainWindow = (Stage) Title.getScene().getWindow();
		String title = Title.getText();
		mainWindow.setTitle(title);
		
	}

}