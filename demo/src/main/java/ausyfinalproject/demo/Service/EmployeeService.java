package ausyfinalproject.demo.Service;

import ausyfinalproject.demo.Error.DepartmentNotFoundException;
import ausyfinalproject.demo.Error.EmployeeNotFoundException;
import ausyfinalproject.demo.Error.JobCategoryNotFoundException;
import ausyfinalproject.demo.Model.DAO.Department;
import ausyfinalproject.demo.Model.DAO.Employee;
import ausyfinalproject.demo.Model.DAO.JobCategory;
import ausyfinalproject.demo.Repository.DepartmentRepository;
import ausyfinalproject.demo.Repository.EmployeeRepository;
import ausyfinalproject.demo.Repository.JobCategoriesRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JobCategoriesRepository jobCategoriesRepository;

    public Department saveDepartment( Department department)
    {
        return this.departmentRepository.save(department);
    }

    public Employee saveEmployee( Employee employee)
    {
        return this.employeeRepository.save(employee);
    }

    public JobCategory saveJobCategory(JobCategory jobCategory)
    {
        return this.jobCategoriesRepository.save(jobCategory);
    }

    public Employee getEmployeeById(Integer id)
    {
        if( this.employeeRepository.findById(id) == null )
        {
            throw new EmployeeNotFoundException(id);
        }
        return this.employeeRepository.findById(id).get();
    }

    public Department findDepartmentById(Integer id)
    {
        if (this.departmentRepository.findById(id) == null)
        {
            throw new DepartmentNotFoundException(id);
        }
        return this.departmentRepository.findById(id).get();
    }

    public JobCategory findJobCategoryById (Integer id)
    {
        if(this.jobCategoriesRepository.findById(id) == null)
        {
            throw new JobCategoryNotFoundException(id);
        }
        return this.jobCategoriesRepository.findById(id).get();
    }

    public List<Department> findAllDepartments()
    {
        return departmentRepository.findAll();
    }

    public Department deleteDepartment(Integer id)
    {
        Department d= departmentRepository.findById(id).get();
        departmentRepository.deleteById(id);
        return d;
    }

    public List<JobCategory> findAllJobCategories()
    {
        return jobCategoriesRepository.findAll();
    }

    public JobCategory deleteJobCategory(Integer id)
    {
        JobCategory j = jobCategoriesRepository.findById(id).get();
        jobCategoriesRepository.deleteById(id);
        return j;
    }

    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    public Department getDepartmentById(Integer id)
    {
        return  departmentRepository.findById(id).get();
    }

    public JobCategory getJobCateboryById(Integer id)
    {
        return jobCategoriesRepository.findById(id).get();
    }
    public Employee deleteEmployee (Integer id)
    {
        Employee e = employeeRepository.findById(id).get();
        employeeRepository.deleteById(id);
        return e;
    }

    public Boolean existsDepartment (int id )
    {
        return this.departmentRepository.existsById(id);
    }

    public Boolean existsJobCategory (int id)
    {
        return this.jobCategoriesRepository.existsById(id);
    }

    public Boolean existsEmployee (int id)
    {
        return this.employeeRepository.existsById(id);
    }

    public List<Employee> getAllEmployeesWithIdDepartment (int id)
    {
        Department d= departmentRepository.findById(id).get();
        return this.employeeRepository.findAllByDepartment(d);
    }

    public List<Employee> getAllEmployeesWithIdJob (int id)
    {
        JobCategory j = jobCategoriesRepository.findById(id).get();
        return this.employeeRepository.findAllByJobCategory(j);
    }

    public Employee updateEmployee(  Employee newEmployee)
    {
        return this.employeeRepository.save(newEmployee);
    }

    public List<Employee> getAllEmployeesSortedByName(int order)
    {
      if(order==1)  return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
      else return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "firstName"));
    }

    public List<Employee> getAllEmployeesSortedBySalary(int order)
    {
        if(order==1)  return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "salary"));
        else return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "salary"));
    }



}
