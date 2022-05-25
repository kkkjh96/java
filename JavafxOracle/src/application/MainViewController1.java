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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MainViewController1 implements Initializable {
	@FXML
	private TableView <ModelTable2> eEmp;
	@FXML
	private TableColumn <ModelTable2, Integer> eEmpno;
	@FXML
	private TableColumn <ModelTable2, String> eEname;
	@FXML
	private TableColumn <ModelTable2, String> eJob;
	@FXML
	private TableColumn <ModelTable2, Integer> eMgr;
	@FXML
	private TableColumn <ModelTable2, Date> eHiredate;
	@FXML
	private TableColumn <ModelTable2, Integer> eSal;
	@FXML
	private TableColumn <ModelTable2, Integer> eComm;
	@FXML
	private TableColumn <ModelTable2, Integer> eDeptno;
	@FXML
	private TextField tfTitle;
	@FXML
	private TableView <ModelTable> EMP;
	@FXML
	private TableColumn <ModelTable, Integer> EMPNO;
	@FXML
	private TableColumn <ModelTable, String> ENAME;
	@FXML
	private TableColumn <ModelTable, String> JOB;
	@FXML
	private TableColumn <ModelTable, Integer> MGR;
	@FXML
	private TableColumn <ModelTable, Date> HIREDATE;
	@FXML
	private TableColumn <ModelTable, Integer> SAL;
	@FXML
	private TableColumn <ModelTable, Integer> COMM;
	@FXML
	private TableColumn <ModelTable, Integer> DEPTNO;
	
	
	ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
	ObservableList<ModelTable2> oblist2 = FXCollections.observableArrayList();
	
	public void initialize(URL location, ResourceBundle resource) {
		
		Connection conn = DBConnection.getConnection();
		try {
			ResultSet rs = conn.createStatement().executeQuery("select * from emp");
			ResultSet rs2 = conn.createStatement().executeQuery("select * from emp_temp");
			
			while(rs.next()) {
				oblist.add(new ModelTable(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("mgr"),
							rs.getDate("hiredate"), rs.getInt("sal"), rs.getInt("comm"), rs.getInt("deptno")));
				}
			while(rs2.next()) {
				oblist2.add(new ModelTable2(rs2.getInt("empno"), rs2.getString("ename"), rs2.getString("job"), rs2.getInt("mgr"),
							rs2.getDate("hiredate"), rs2.getInt("sal"), rs2.getInt("comm"),rs2.getInt("deptno")));
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			EMPNO.setCellValueFactory(new PropertyValueFactory<>("empno"));
			ENAME.setCellValueFactory(new PropertyValueFactory<>("ename"));
			JOB.setCellValueFactory(new PropertyValueFactory<>("job"));
			MGR.setCellValueFactory(new PropertyValueFactory<>("mgr"));
			HIREDATE.setCellValueFactory(new PropertyValueFactory<>("hiredate"));
			SAL.setCellValueFactory(new PropertyValueFactory<>("sal"));
			COMM.setCellValueFactory(new PropertyValueFactory<>("comm"));
			DEPTNO.setCellValueFactory(new PropertyValueFactory<>("deptno"));
			
			EMP.setItems(oblist);
			
			eEmpno.setCellValueFactory(new PropertyValueFactory<>("empno"));
			eEname.setCellValueFactory(new PropertyValueFactory<>("ename"));
			eJob.setCellValueFactory(new PropertyValueFactory<>("job"));
			eMgr.setCellValueFactory(new PropertyValueFactory<>("mgr"));
			eHiredate.setCellValueFactory(new PropertyValueFactory<>("hiredate"));
			eSal.setCellValueFactory(new PropertyValueFactory<>("sal"));
			eComm.setCellValueFactory(new PropertyValueFactory<>("comm"));
			eDeptno.setCellValueFactory(new PropertyValueFactory<>("deptno"));
			
			eEmp.setItems(oblist2);
			
		} 
	// Event Listener on Button.onAction
	@FXML
	public void btnOKClicked(ActionEvent event) {
		Stage MainWindow = (Stage)tfTitle.getScene().getWindow();
		String title = tfTitle.getText();
		MainWindow.setTitle(title);

	}
}
