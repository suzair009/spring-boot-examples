package com.session.tutorials_dto.Service;

import com.session.tutorials_dto.dto.Userdto;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface UserService {
    Userdto createUsers(Userdto userdto);

    Userdto getUserById(Long userId);

    Userdto updateUserById(Userdto userdto);

    List<Userdto> showAllUsers();

    List<Map<String,Object>> getDataByEmail(String emailId);


}
