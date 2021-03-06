package com.wikia.populo.jdbi;

import com.wikia.populo.core.User;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements ResultSetMapper<User> {
    public User map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new User(r.getInt("user_id"), r.getString("user_name"), r.getString("user_email"));
    }
}
