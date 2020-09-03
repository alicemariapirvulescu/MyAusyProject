package ausyfinalproject.demo.Repository;

import ausyfinalproject.demo.Model.DAO.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobCategoriesRepository extends JpaRepository<JobCategory, Integer> {

    List<JobCategory> findAll();

//    <JobCategory> findById(Integer id);
//
//    JobCategory findByName (String name);

}
