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

public class MainViewController implements Initializable {
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
	@FXML
	private TextField tfTitle;
	
	
	ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
	
public void initialize(URL location, ResourceBundle resource) {
		
		Connection conn = DBConnection.getConnection();
		try {
			ResultSet rs = conn.createStatement().executeQuery("select * from emp");
			
			while(rs.next()) 
				oblist.add(new ModelTable(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getInt("mgr"),
							rs.getDate("hiredate"), rs.getInt("sal"), rs.getInt("comm"), rs.getInt("deptno")));
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

			}
		public void btnOKClicked(ActionEvent event) {
			Stage MainWindow = (Stage)tfTitle.getScene().getWindow();
			String title = tfTitle.getText();
			MainWindow.setTitle(title);

		}
	
}

