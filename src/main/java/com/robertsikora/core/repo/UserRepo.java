package com.robertsikora.core.repo;

import com.robertsikora.core.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by robertsikora on 21.03.2016.
 */

@Repository
public class UserRepo extends RedisRepo<User, Long> {


}
