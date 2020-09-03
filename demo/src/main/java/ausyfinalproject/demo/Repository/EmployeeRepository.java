package ausyfinalproject.demo.Repository;

import ausyfinalproject.demo.Model.DAO.Department;
import ausyfinalproject.demo.Model.DAO.Employee;
import ausyfinalproject.demo.Model.DAO.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee findById (int id);

    List<Employee> findAllByDepartment(Department d);

    List<Employee> findAllByJobCategory(JobCategory j);

    Employee findByFirstName(String firstName);

    Employee findByLastName(String lastName);


}