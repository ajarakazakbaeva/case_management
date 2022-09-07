package case_management.data.repositories;

import case_management.data.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
    @Modifying
    @Query(value = "select * from inc_db.category where lower(title) like lower(concat('%',:title,'%')) ", nativeQuery = true)
    List<CategoryEntity> findByTitle(@Param("title") String title);

    @Query(value = "select * from inc_db.category where lower(title) = lower(title)", nativeQuery = true)
    Optional<CategoryEntity> findOneByTitle(@Param("title") String title);

    CategoryEntity findById(int id);
}
