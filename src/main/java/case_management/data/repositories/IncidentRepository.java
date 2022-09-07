package case_management.data.repositories;

import case_management.data.entities.IncidentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IncidentRepository extends JpaRepository<IncidentsEntity,Integer> {

    IncidentsEntity findById(int id);
    List<IncidentsEntity> findAll();

//    @Query(value = "select * from inc_db.incidents where (:id=0 or id = :id) and (:date is not null and date(rec_time)= :date)", nativeQuery = true)

    @Query(value = "select * from inc_db.incidents where (:id is null or id = :id) and (:date is null or date(rec_time)= :date)", nativeQuery = true)
        // and - if no parameter then no data. with and no data at all, maybe do different queries for all combinations??? too many
//@Query(value = "select * from inc_db.incidents where id = :id and date(rec_time)= :date", nativeQuery = true)
List<IncidentsEntity> filterIncidents(@Param("id") Optional<Integer> id, @Param("date") Optional<Date> date);

}
