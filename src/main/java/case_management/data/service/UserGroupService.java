package case_management.data.service;

import case_management.data.entities.UserGroupsEntity;
import case_management.data.repositories.UserGroupsEntityRepository;
import case_management.data.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGroupService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserGroupsEntityRepository userGroupsEntityRepository;

    private UserGroupsEntity userGroups;

//    public String FindGroupOfUser(DAOUser userDao) {
//
//        Integer group = userDao.getGroupId();
//        String title = String.valueOf(userGroupsEntityRepository.getTitle(group));
//        return title;
//
//    }

}



