package repo;

import model.User;

/**
 * Created by robertsikora on 25.03.2016.
 */
public interface UserRepo extends RedisRepo<User, Long> {
}
