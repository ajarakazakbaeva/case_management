package case_management.data.dao;

import case_management.data.entities.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserDao extends JpaRepository<DAOUser, Integer> {
    DAOUser findByUsername(String username);
    Optional<DAOUser> findById(long id);
}