package org.sample.dao;

import java.util.List;

public interface UserDao {

    User findByName( String name );

    List<User> findAll();

}
