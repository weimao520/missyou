package com.lin.missyou.repository;

import com.lin.missyou.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author WeiMao
 * @create 2020-12-06 18:19
 */
public interface UserRepository  extends JpaRepository<User,Long> {

    User findByEmail(String email);
    Optional<User> findByOpenid(String openid);
    User findFirstById(Long id);
    User findByUnifyUid(Long uuid);

}
