package pojo;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="emplogin")
public class Emp 
{
  @Id
  private String empid;
  private String emp_password;

public String getEmpid() 
{
	return empid;
}

public void setEmpid(String empid) 
{
	this.empid = empid;
}

public String getEmp_password() 
{
	return emp_password;
}

public void setEmp_password(String emp_password) 
{
	this.emp_password = emp_password;
}
  
}
