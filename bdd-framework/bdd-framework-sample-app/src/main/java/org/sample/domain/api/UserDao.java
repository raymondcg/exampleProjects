package org.sample.domain.api;

import java.util.Collection;

import org.sample.domain.model.User;

public interface UserDao {

    public Collection<User> findAll();

    public Boolean save( Collection<User> users );

    public Boolean save( User user );

}
