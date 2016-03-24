package com.robertsikora.rest.api;

import com.robertsikora.rest.dto.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by robertsikora on 18.03.2016.
 */

@RequestMapping("/users")
public interface UserEndpoint {

    @RequestMapping(method = RequestMethod.POST)
    long create(UserDto dto);

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    UserDto findById(Long id);

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    void delete(Long id);
}
