package fr.formation.inti.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer empId;	
	private String firstName;	
	private String lastName;	
	private String title;
	private Employee manager;	
	private Date endDate;	
	private Date startDate;
	private Department department;
	private Branch branch;
	private Set<Employee> employees = new HashSet<Employee>(0);

	public Employee() {
	}
	
	public Employee(String firstName, String lastName, Date startDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDate = startDate;
	}

	public Employee(String firstName, String lastName, String title, Employee manager, Date endDate, Date startDate,
			Department department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.manager = manager;
		this.endDate = endDate;
		this.startDate = startDate;
		this.department = department;
	}
	
	public Employee(String firstName, String lastName, String title, Employee manager, Date endDate, Date startDate,
			Department department, Branch branch) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.manager = manager;
		this.endDate = endDate;
		this.startDate = startDate;
		this.department = department;
		this.branch = branch;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID")
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPERIOR_EMP_ID")
	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPT_ID", nullable = true,
			foreignKey = @ForeignKey(name="EMPLOYEE_DEPARTMENT_FK"),referencedColumnName = "DEPT_ID")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "manager")
	public Set<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	@Column(name = "FIRST_NAME", length = 20, nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name = "LAST_NAME", length = 20, nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE", nullable = false)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRANCH_ID", nullable = true,
			foreignKey = @ForeignKey(name="ASSIGNED_BRANCH_ID_FK"),referencedColumnName = "BRANCH_ID")
	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title
				+ ", manager=" + manager + ", endDate=" + endDate + ", startDate=" + startDate + ", department="
				+ department + ", branch=" + branch + "]";
	}
	
	
	
}