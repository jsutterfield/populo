package com.wikia.populo.jdbi;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import com.wikia.populo.core.User;
import org.skife.jdbi.v2.sqlobject.Bind;

@RegisterMapper(UserMapper.class)
public interface UserDAO {
    @SqlQuery("select * from user where user_name = :name")
    User findByName(@Bind("name") String name);
}
