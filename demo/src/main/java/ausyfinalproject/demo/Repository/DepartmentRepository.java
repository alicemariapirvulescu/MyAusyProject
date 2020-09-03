package ausyfinalproject.demo.Repository;

import ausyfinalproject.demo.Model.DAO.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer>
{

    List<Department> findAll();

//    @Override
//    Department findById (Integer id);
//
//    Department findByName(String name);

}
