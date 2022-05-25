package application;

import java.sql.Date;

public class ModelTable {
	// 데이터베이스의 테이블데이터들을 서술한 ModelTable 클래스입니다.
	int empno;
    String ename; 
    String job; 
    int mgr; 
    Date hiredate; 
    int sal; 
    int comm;
    int deptno; 
    
    
    public ModelTable (int empno, String ename, String job, int mgr,
    	Date hiredate, int sal, int comm, int deptno) {
    	this.empno = empno;
    	this.ename = ename;
    	this.job = job;
    	this.mgr = mgr;
    	this.hiredate = hiredate;
    	this.sal = sal;
    	this.comm = comm;
    	this.deptno = deptno;
    }
    // 여기서부터는 위의 ModelTable 생성자를 만든후 마우스우클릭 Source -> Generate Getters and Setters 해주시면 알아서 getter, setter 생성해줍니다.

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
}
