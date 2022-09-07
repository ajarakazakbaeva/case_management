package case_management.controllers;

import case_management.commons.RestResponse;
import case_management.data.dao.UserDao;
import case_management.data.entities.DAOUser;
import case_management.data.repositories.UserGroupsEntityRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
@Tag(name = "User service", description = "Работа с аккаунтами клиентов и содержимым онных")
public class UsersController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserGroupsEntityRepository userGroupsEntityRepository;

    public UsersController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/{id}")
    public RestResponse getUser(@PathVariable int id) {
        try {
            var user = userDao.findById(id);
            System.out.println("FOUND" + user);
            return new RestResponse(HttpStatus.OK, user, "");
        } catch (Exception e) {
            return RestResponse.error("Пользователь не найден");
        }
    }

    @GetMapping()
    public RestResponse getUsers(@RequestParam(defaultValue = "") String username) {
        try {
            if (username.length() > 0) {
                return RestResponse.success(userDao.findByUsername(username));
            }

            return RestResponse.success(userDao.findAll());
        } catch (Exception e) {
            return RestResponse.error("Произошла ошибка");
        }
    }

    @PutMapping()
    public RestResponse saveUser(@RequestBody DAOUser userDAO) {
        try {
            userDao.save(userDAO);
            return RestResponse.success(userDAO.getId());
        } catch (Exception e) {
            return RestResponse.error("Произошла ошибка");
        }
    }

}
