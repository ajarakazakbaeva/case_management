package case_management.data.dao;

import case_management.data.entities.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentDao extends JpaRepository<DAOUser, Integer> {

}
