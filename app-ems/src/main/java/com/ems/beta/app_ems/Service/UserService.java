package com.ems.beta.app_ems.Service;

import com.ems.beta.app_ems.Entity.Employee;
import com.ems.beta.app_ems.Entity.User;

import java.util.List;

public interface UserService {

    User createBulkUser(User users);

    User getByUserId(Long userid);

    User getDataByEmployeeId(Long Id,User user);


}
