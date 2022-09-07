package case_management.data.repositories;

import case_management.data.entities.UserGroupsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupsEntityRepository extends JpaRepository<UserGroupsEntity, Integer> {
//    @Modifying
    @Query(value = "select title from inc_db.user_groups where id = ?1", nativeQuery = true)
    String findTitleById(int id);

}