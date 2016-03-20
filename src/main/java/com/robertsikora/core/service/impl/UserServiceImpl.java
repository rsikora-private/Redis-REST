package com.robertsikora.core.service.impl;

import com.robertsikora.core.service.api.UserService;
import com.robertsikora.core.service.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by robertsikora on 18.03.2016.
 */

@Service(value = "userService")
public class UserServiceImpl extends CommonServiceImpl<User> implements UserService {


}
