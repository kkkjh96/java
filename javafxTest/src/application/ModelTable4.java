package application;

public class ModelTable4 {
		String ename;
		String job;
		int sal;
		int comm;
    
    public ModelTable4 (String ename, String job, int sal, int comm) {
        this.ename = ename;
        this.job = job;
        this.sal = sal;
        this.comm = comm;
        
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
}

