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

public class MainSceneController implements Initializable {	// ��Ʈ�ѷ��� ���۵��� �����ϴ� Initializable �������̽� ����
	@FXML
	private TableView<ModelTable> eEmp;	// TableView(���̺��� Ʋ)�� ModelTable Ŭ������ �Ű����ݴϴ� 
	@FXML
	private TableColumn<ModelTable, Integer> eEmpno; // TableColumn(���̺��� ��)�� ModelTableŬ������ �����ͺ��̽� ��Ÿ�Կ� �´� ����(wrapper)Ŭ������ �Ű����ݴϴ�.
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
	
	// ModelTable�� ��(������)�� ����ɶ����� �����ؼ� ����ִ� �÷��� �迭 observableArrayList oblist ����
	ObservableList<ModelTable> oblist = FXCollections.observableArrayList();	
	ObservableList<ModelTable2> oblist2 = FXCollections.observableArrayList();
	ObservableList<ModelTable3> oblist3 = FXCollections.observableArrayList();
	ObservableList<ModelTable4> oblist4 = FXCollections.observableArrayList();
	ObservableList<ModelTable5> oblist5 = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Connection conn = DBConnection.getConnection();	// ������ DBconnection Ŭ�������� �����ͺ��̽� ������ �ҷ��ɴϴ�.
		try {
			ResultSet rs = conn.createStatement().executeQuery("select * from emp"); // �������� �ۼ��ϴ� ���Դϴ�.
			ResultSet rs2 = conn.createStatement().executeQuery("select * from dept");
			ResultSet rs3 = conn.createStatement().executeQuery("select * from salgrade");
			ResultSet rs4 = conn.createStatement().executeQuery("select * from bonus1");
			ResultSet rs5 = conn.createStatement().executeQuery("select * from dept_temp");
			// ModelTable Ŭ�������� emp���̺� �����͵��� oblist�� ����ݴϴ�
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
		
		// javafx�� �����ξ��� ���� �ϳ��ϳ��� setCellValueFactory �޼ҵ�� �� �����ͺ��̽� ������ ¦�����ݴϴ� 

		eEmpno.setCellValueFactory(new PropertyValueFactory<>("empno"));
		eEname.setCellValueFactory(new PropertyValueFactory<>("ename"));
		eJob.setCellValueFactory(new PropertyValueFactory<>("job"));
		eMgr.setCellValueFactory(new PropertyValueFactory<>("mgr"));
		eHiredate.setCellValueFactory(new PropertyValueFactory<>("hiredate"));
		eSal.setCellValueFactory(new PropertyValueFactory<>("sal"));
		eComm.setCellValueFactory(new PropertyValueFactory<>("comm"));
		eDeptno.setCellValueFactory(new PropertyValueFactory<>("deptno"));
		
	
		eEmp.setItems(oblist); 	//���������� setItems �޼ҵ带 ���� ������ ������ ����Ʈ�� javafx ���̺��ȿ� ����־��ݴϴ� 
		
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