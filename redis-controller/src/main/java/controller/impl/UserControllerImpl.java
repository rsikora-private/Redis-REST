package controller.impl;

import model.User;
import controller.UserController;
import dto.PostDto;
import dto.UserDto;

/**
 * Created by robertsikora on 24.03.2016.
 */
class UserControllerImpl extends BasicControllerImpl<User, UserDto> implements UserController {

    @Override
    public long addPost(final long userId, final PostDto post) {
        final User user = commonService.findById(userId);

        return 0;
    }
}
