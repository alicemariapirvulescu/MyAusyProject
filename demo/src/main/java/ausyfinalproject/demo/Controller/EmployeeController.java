package ausyfinalproject.demo.Controller;

import ausyfinalproject.demo.Mapper.EmployeeMapper;
import ausyfinalproject.demo.Model.DAO.Department;
import ausyfinalproject.demo.Model.DAO.Employee;
import ausyfinalproject.demo.Model.DAO.JobCategory;
import ausyfinalproject.demo.Model.DTO.EmployeeDto;
import ausyfinalproject.demo.Service.EmployeeService;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;

    //DEPARTMENTS starting here

    @PostMapping("/addDepartment")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department d) {

        if (d.getName().isEmpty()) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded", "noContent");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body(null);

        } else {
            Department department = this.employeeService.saveDepartment(d);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded", "addNewDepartment");
            return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(department);
        }
    }

    @GetMapping("/findAllDepartments")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> l = employeeService.findAllDepartments();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "got Department");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(l);

    }

    @DeleteMapping("/deleteDepartment/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Integer id) {
        if (!employeeService.existsDepartment(id)) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded", "Department not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(httpHeaders).body("Department with this id doesn't exist " + id.toString());
        }
        Department d = employeeService.deleteDepartment(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "Department deleted");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body("Department deleted " + d.toString());

    }

    //FINISHED WITH DEPARTMENTS

    //STARTING WITH JOB CATEGORIES
    @PostMapping("/addJobCategory")
    public ResponseEntity<JobCategory> saveJobCategory(@RequestBody JobCategory j) {
        if (j.getName().isEmpty()) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded", "noContent");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).headers(httpHeaders).body(j);

        } else {
            JobCategory jobCategory = this.employeeService.saveJobCategory(j);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded", "added Job Category");
            return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(jobCategory);
        }
    }

    @GetMapping("/getAllJobCategories")
    public ResponseEntity<List<JobCategory>> getAllJobCategories() {
        List<JobCategory> l = this.employeeService.findAllJobCategories();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "got all Job Categories");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(l);
    }

    @DeleteMapping("/deleteJobCategory/{id}")
    public ResponseEntity<String> deleteJobCategory(@PathVariable Integer id) {
        if (!this.employeeService.existsJobCategory(id)) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded", "Job Category not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(httpHeaders).body("Job category whith this id doesn't exist " + id);
        }
        JobCategory j = this.employeeService.deleteJobCategory(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "Job Category deleted");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(j.toString());
    }

    //DONE WITH JOB CATEGORY

    //STARTING WITH EMPLOYEE
    @PostMapping("/addEmployee")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee e) throws ParseException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "addNewEmployee");
        if (e.getBirthday() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body("Wrong birthday format. You should use next pattern: dd-MM-yyyy");
        }
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date starting_date = sdformat.parse("1900-01-01");
        Date current_date = new Date(System.currentTimeMillis());
        if (starting_date.compareTo(e.getBirthday()) > 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body("Birthday before 1900");
        }
        if (current_date.compareTo(e.getBirthday()) < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body("Birthday after current date");
        }
        Employee employee = this.employeeService.saveEmployee(e);
        return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(employee.toString());

    }

    @GetMapping("/findEmployeeById/{id}")
    public ResponseEntity<String> getEmployeeById(@PathVariable int id) {
        if (!this.employeeService.existsEmployee(id)) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded", "Employee not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(httpHeaders).body("Employee whith this id doesn't exist " + id);
        } else {
            Employee e = this.employeeService.getEmployeeById(id);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded", "gotEmployee");
            return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(e.toString());
        }
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> l = employeeService.getAllEmployees();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "got all Employees");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(l);
    }

    @PostMapping("/addEmployee/{id_dep}/{id_job}")
    public ResponseEntity<String> saveEmployee
            (@RequestBody Employee e, @PathVariable Integer id_dep, @PathVariable Integer id_job) throws ParseException {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "addNewEmployee");
        Boolean exists_department = this.employeeService.existsDepartment(id_dep);
        Boolean exists_jobCategory = this.employeeService.existsJobCategory(id_job);
        if (!(exists_department) || (!exists_jobCategory)) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body("id department or id job missing");

        }

        if (e.getBirthday() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body("Wrong birthday format. You should use next pattern: dd-MM-yyyy");
        }
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date starting_date = sdformat.parse("1900-01-01");
        Date current_date = new Date(System.currentTimeMillis());
        if (starting_date.compareTo(e.getBirthday()) > 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body("Birthday before 1900");
        }
        if (current_date.compareTo(e.getBirthday()) < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body("Birthday after current date");
        }

        Department department = this.employeeService.getDepartmentById(id_dep);
        List<Employee> department_employees = department.getEmployees();
        department_employees.add(e);
        department.setEmployees(department_employees);

        JobCategory jobCategory = this.employeeService.getJobCateboryById(id_job);
        List<Employee> job_employees = jobCategory.getEmployees();
        job_employees.add(e);
        jobCategory.setEmployees(job_employees);

        e.setDepartment(department);
        e.setJobCategory(jobCategory);

        Employee employee = this.employeeService.saveEmployee(e);
        return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(employee +
                "\n" + "With department " + e.getDepartment().toString() + "\nWith Job Category "
                + e.getJobCategory().toString());

    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        if (!this.employeeService.existsEmployee(id)) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded", "Employee not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(httpHeaders).body("Employee whith this id doesn't exist " + id);
        } else {
            Employee e = this.employeeService.deleteEmployee(id);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded", "Employee deleted");
            return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(e.toString());
        }
    }

    @GetMapping("/getEmployeeByDepartment/{id}")
    public ResponseEntity<String> getEmployeeByDepartment(@PathVariable Integer id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "Got Employee");
        if (!employeeService.existsDepartment(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body("department with this id doesn't exist " + id);
        }
        List<Employee> employees = this.employeeService.getAllEmployeesWithIdDepartment(id);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(employees.toString());
    }

    @GetMapping("/getEmployeeByJob/{id}")
    public ResponseEntity<String> getEmployeeByJob(@PathVariable Integer id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "Got Employee");
        if (!employeeService.existsJobCategory(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body("Job category with this id doesn't exist " + id);
        }
        List<Employee> employees = this.employeeService.getAllEmployeesWithIdJob(id);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(employees.toString());
    }

    @GetMapping("getEmployeeByDepAndJob/{id_dep}/{id_job}")
    public ResponseEntity<String> getEmployeeByDepAndJob(@PathVariable Integer id_dep, @PathVariable Integer id_job) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "addNewEmployee");
        Boolean exists_department = this.employeeService.existsDepartment(id_dep);
        Boolean exists_jobCategory = this.employeeService.existsJobCategory(id_job);
        if (!(exists_department) || (!exists_jobCategory)) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body("There are not employees with this id_Dep and id_Job");
        }
        List<Employee> initialEmployees = this.employeeService.getAllEmployeesWithIdDepartment(id_dep);
        List<Employee> finalEmployees = new ArrayList<>();
        for (Employee e : initialEmployees) {
            if (e.getJobCategory().getId() == id_job) {
                finalEmployees.add(e);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(finalEmployees.toString());
    }

    @PutMapping("/updateEmployee/{id}/{id_dep}/{id_job}")
    public ResponseEntity<String> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee,
                                                 @PathVariable Integer id_dep, @PathVariable Integer id_job) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Responded", "addNewEmployee");
        Boolean exists_department = employeeService.existsDepartment(id_dep);
        Boolean exists_jobCategory = employeeService.existsJobCategory(id_job);
        if (!(exists_department) || (!exists_jobCategory)) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body("id dep or id job cannot be found");
        }

        Boolean exists_employee = employeeService.existsEmployee(id);
        if(!exists_employee)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body("id employee cannot be found");
        }

        employee.setId(id);
        employee.setDepartment(employeeService.getDepartmentById(id_dep));
        employee.setJobCategory(employeeService.getJobCateboryById(id_job));
        employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body("employee updated: "+ employee.toString());
    }

    @GetMapping("/getEmployeeDtoById/{id}")
    public ResponseEntity<String> getEmployeeDtoById(@PathVariable int id) {
        if (!employeeService.existsEmployee(id)) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded", "Employee not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(httpHeaders).body("Employee whith this id doesn't exist " + id);
        } else {
            Employee employee = employeeService.getEmployeeById(id);
            EmployeeDto employeeDto = employeeMapper.convertToEmployeeDto(employee);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Responded", "got Dto Employee");
            return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(employeeDto.toString());
        }
    }

    @GetMapping("/getAllEmployeesDto")
    public List<EmployeeDto> getAllEmployeesDto()
    {
        List<Employee> employees = employeeService.getAllEmployees();
        List<EmployeeDto> employeeDtos = employees.stream().map(e->employeeMapper.convertToEmployeeDto(e)).collect(Collectors.toList());
        return employeeDtos;
    }

    @GetMapping("/getAllManagersDto")
    public List<EmployeeDto> getAllManagersDto()
    {
        List<Employee> employees = employeeService.getAllEmployees();
        List<EmployeeDto> employeeDtos = employees.stream().map(e->employeeMapper.convertToEmployeeDto(e)).collect(Collectors.toList());
        List<EmployeeDto> managersDto = employeeDtos.stream().filter(employee -> employee.isManager()).collect(Collectors.toList());
        return managersDto;
    }

    @GetMapping("/getAllActiveDto")
    public List<EmployeeDto> getAllActiveDto()
    {
        List<Employee> employees = employeeService.getAllEmployees();
        List<EmployeeDto> employeeDtos = employees.stream().map(e->employeeMapper.convertToEmployeeDto(e)).collect(Collectors.toList());
        List<EmployeeDto> activeDto= employeeDtos.stream().filter(employee -> employee.isActive()).collect(Collectors.toList());
        return activeDto;
    }

    @GetMapping("/getAllOrderByFirstName/asc")
    public List<Employee> getAllEmployeesByFirstNameAsc()
    {
        return employeeService.getAllEmployeesSortedByName(1);
    }

    @GetMapping("/getAllOrderByFirstName/desc")
    public List<Employee> getAllEmployeesByFirstNameDesc()
    {
        return employeeService.getAllEmployeesSortedByName(0);
    }

    @GetMapping("/getAllOrderBySalary/asc")
    public List<Employee> getAllEmployeesBySalaryAsc()
    {
        return employeeService.getAllEmployeesSortedBySalary(1);
    }

    @GetMapping("/getAllOrderBySalary/desc")
    public List<Employee> getAllEmployeesBySalaryDesc()
    {
        return employeeService.getAllEmployeesSortedBySalary(0);
    }

}
