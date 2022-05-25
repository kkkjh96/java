package application;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class MainViewController {
	
	private static Connection conn;
	private PreparedStatement pstmt;
	private ObservableList<Person> data;
	private CardAppDao cardDao;
	
	private int num;
	private boolean canSave = false;
	private boolean canEdit = false;
	
	public boolean isCanSave() {
		return canSave;
	}
	
	public void setCanSave(boolean canSave) {
		this.canSave = canSave;
	}
	
	public boolean isCanEdit() {
		return canEdit;
	}
	
	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}
	
    @FXML
    private TableView<?> addrTable;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtCom;
	@FXML
	private TextField txtAddr;
	@FXML
	private TextField txtPhone;
	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtBirthday;
	@FXML
	private TextField txtImg;
	@FXML
	private ImageView imgPhoto;
	@FXML
	private TableColumn colNo;
	@FXML
	private TableColumn colName;
	@FXML
	private TableColumn colCom;
	@FXML
	private TableColumn colAddr;
	@FXML
	private Button btnQuery;
	@FXML
	private Button btnIns;
	@FXML
	private Button btnModi;
	@FXML
	private Button btnDel;
	@FXML
	private TextField txtSearch;
	@FXML
	private Button btnsearch;
	
	@FXML
	private void initialize() {
		cardDao = new CardAppDao();
		showOverView();
		
		addrTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showPersonDetails((Person) newValue));
	}
	
	private void showOverView() {
		try {
			data = cardDao.getData;
			
			colNo.setCellValueFactory(new PropertyValueFactory<Person, String>("no"));
			colName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
			colCom.setCellValueFactory(new PropertyValueFactory<Person, String>("comm"));
			colAddr.setCellValueFactory(new PropertyValueFactory<Person, String>("addr"));
			
			addrTable.setItems(null);
			addrTable.setItems(data);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Data�� ���̺� ������ �� �����ϴ�.");
		}
	}
	
	private void showPersonDetails( Person person ) {
		 if (person != null) {
		 // ���̺� ���� Ŭ���Ǹ� person ��ü�� ������ ���޹޾� TextField�� ǥ��.
		 num = person.getNo();
		 txtName.setText(person.getName()); txtName.setEditable(false);
		 txtCom.setText(person.getCom()); txtCom.setEditable(false);
		 txtAddr.setText(person.getAddr()); txtAddr.setEditable(false);
		 txtEmail.setText(person.getEmail()); txtEmail.setEditable(false);
		 txtPhone.setText(person.getPhone()); txtPhone.setEditable(false);
		 txtBirthday.setText(person.getBirthday()); txtBirthday.setEditable(false); 
		 setCanSave(false); // ���� �Ұ��� ����
		 setCanEdit(false); // ���� �Ұ��� ����
		 }
		 else {
			 txtName.setText("");
			 txtCom.setText("");
			 txtAddr.setText("");
			 txtEmail.setText("");
			 txtPhone.setText("");
			 txtBirthday.setText("");
		 }
		 btnModi.setStyle("-fx-base: #abd5e8;"); //���� ��ư ���� ó�� ��
		 btnIns.setStyle("-fx-base: #abd5e8;"); //�߰� ��ư ���� ó�� ��
		 btnIns.setText("�߰�");
	}

	// Event Listener on Button[#btnQuery].onAction
	@FXML
	public void handleQuery(ActionEvent event) {
		showOverView();
	}
	// Event Listener on Button[#btnIns].onAction
	@FXML
	public void handleIns(ActionEvent event) {
		if(isCanSave() == false && txtName.getText().length() > 0) {
			showPersonDetails(null);
			txtName.setEditable(true); txtName.requestFocus();
			txtCom.setEditable(true);
			txtAddr.setEditable(true);
			txtEmail.setEditable(true);
			txtPhone.setEditable(true);
			txtBirthday.setEditable(true);
			
			setCanSave(true);
			btnIns.setStyle("-fx-base: #33ccff;");
			btnIns.setText("����");
			return;
		}
		if( confirm() == false) {
			return;
		}
		
		Person person = new Person();
		
		person.setName(txtName.getText());
		person.setCom(txtCom.getText());
		person.setAddr(txtAddr.getText());
		person.setPhone(txtPhone.getText());
		person.setEmail(txtEmail.getText());
		person.setBirthday(txtBirthday.getText());
		
		try {
			if(cardDao.insertPerson(person)) {
				setCanSave(false);
				showOverView();
				btnIns.setStyle("-fx-base: $abd5e8;");
				btnIns.setText("�߰�");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		private void alertAll(String msg) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("���ͳ�������Ű�");
			alert.setHeaderText("�˸�!!!");
			alert.setContentText(msg);
			alert.showAndWait();
		}
		private boolean confirm() {
			Alert alert = new Alert(AlertType.WARNING);
			if(txtName.getText().length() < 1) {
				alertAll("�̸��� �ʼ� �Է¶� �Դϴ�.");
				setCanSave(true);
				return false;
			}
			if(txtCom.getText().length() < 1) {
				alertAll("ȸ����� �Էµ����ʾҽ��ϴ�.");
				setCanSave(true);
				return false;
			}
			if(txtAddr.getText().length() < 1) {
				alertAll("�ּҰ� �Էµ����ʾҽ��ϴ�.");
				setCanSave(true);
				return false;
			}
			if(txtEmail.getText().length() < 1) {
				alertAll("���� �ּҰ� �Էµ����ʾҽ��ϴ�.");
				setCanSave(true);
				return false;
			}
			if(txtPhone.getText().length() < 1) {
				alertAll("��ȭ��ȣ�� �Էµ����ʾҽ��ϴ�.");
				setCanSave(true);
				return false;
			}
			if(txtBirthday.getText().length() < 1) {
				alertAll("��������� �Էµ����ɾҽ��ϴ�.");
				setCanSave(true);
				return false;
			}
			return true;
		
	}

	
		
	// Event Listener on Button[#btnModi].onAction
	@FXML
	public void handleEdit(ActionEvent event) {
		int selectedIndex = addrTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex < 0) {
			alertAll("���̺��� �����Ϸ��� ����� �������ּ���!");
			return;
		}
		if(isCanEdit() == false && txtName.isEditable() == false) {
			txtName.setEditable(true);txtName.requestFocus();
			txtCom.setEditable(true);
			txtAddr.setEditable(true);
			txtEmail.setEditable(true);
			txtPhone.setEditable(true);
			txtBirthday.setEditable(true);
			setCanEdit(true);
			btnModi.setStyle("-fx-base: #33ccff;");
			btnModi.setText("����");
			return;
		}
		if(confirm() == false) {
			return;
		}
		Person person = new Person();
		
		person.setNo(num);
		person.setName(txtName.getText());
	}
	// Event Listener on Button[#btnDel].onAction
	@FXML
	public void handleDel(ActionEvent event) {
		int selectedIndex = addrTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			
			try {
				cardDao.deleteData(num);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			addrTable.getItems().remove(selectedIndex);
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");
			
			alert.showAndWait();
		}
	}
	// Event Listener on Button[#btnsearch].onAction
	@FXML
	public void handleSearch(ActionEvent event) {
		// TODO Autogenerated
	}
}
