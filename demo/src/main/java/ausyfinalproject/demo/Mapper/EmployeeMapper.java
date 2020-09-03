package ausyfinalproject.demo.Mapper;

import ausyfinalproject.demo.Model.DAO.Employee;
import ausyfinalproject.demo.Model.DTO.EmployeeDto;
import ausyfinalproject.demo.Repository.DepartmentRepository;
import ausyfinalproject.demo.Repository.EmployeeRepository;
import ausyfinalproject.demo.Repository.JobCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeMapper {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private JobCategoriesRepository jobCategoriesRepository;

    public EmployeeDto convertToEmployeeDto(Employee employee)
    {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setJobCategoryId(employee.getJobCategory().getId());
        employeeDto.setDepartmentId(employee.getDepartment().getId());
        employeeDto.setManager(employee.getManager());
        employeeDto.setStartDate(employee.getStartDate());
        employeeDto.setEndDate(employee.getEndDate());
        employeeDto.setActive(employee.getActive());

        return employeeDto;
    }
}
