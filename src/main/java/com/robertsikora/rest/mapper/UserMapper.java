package com.robertsikora.rest.mapper;

import com.robertsikora.core.service.model.User;
import com.robertsikora.rest.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

/**
 * Created by robertsikora on 18.03.2016.
 */

@Controller
public class UserMapper implements Mapper <User, UserDto> {

    public UserDto fromEntity(final User user){
        Assert.notNull(user);
        final UserDto userDTO = new UserDto();
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setfName(user.getfName());
        userDTO.setlName(user.getlName());
        return userDTO;
    }

    public User fromDTO(final UserDto userDTO){
        Assert.notNull(userDTO);
        final User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setfName(userDTO.getfName());
        user.setlName(userDTO.getlName());
        return user;
    }
}
