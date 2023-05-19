package com.z.platform.service;


import java.util.List;

import com.z.platform.dto.UserDto;
import com.z.platform.model.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
