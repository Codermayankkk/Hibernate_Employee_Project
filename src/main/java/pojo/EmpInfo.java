package pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class EmpInfo 
{
	@Id
	private String empid;
	
	private String emp_name;
	private String emp_mailid;
	private String emp_contact;
	  
	public String getEmpid() 
	{
		return empid;
	}
	public void setEmpid(String empid) 
	{
		this.empid = empid;
	}
	public String getEmp_name() 
	{
		return emp_name;
	}
	public void setEmp_name(String emp_name) 
	{
		this.emp_name = emp_name;
	}
	public String getEmp_mailid() 
	{
		return emp_mailid;
	}
	public void setEmp_mailid(String emp_mailid) 
	{
		this.emp_mailid = emp_mailid;
	}
	public String getEmp_contact() 
	{
		return emp_contact;
	}
	public void setEmp_contact(String emp_contact) 
	{
		this.emp_contact = emp_contact;
	}
	public EmpInfo(String empid, String emp_name, String emp_mailid, String emp_contact) 
	{
		this.empid = empid;
		this.emp_name = emp_name;
		this.emp_mailid = emp_mailid;
		this.emp_contact = emp_contact;
	}
	public EmpInfo() 
	{
		
	}
	
	
	  
}
