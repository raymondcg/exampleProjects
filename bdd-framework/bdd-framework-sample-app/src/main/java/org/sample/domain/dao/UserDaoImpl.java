package org.sample.domain.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.sample.domain.api.UserDao;
import org.sample.domain.model.User;

public class UserDaoImpl implements UserDao {

    private Set<User> users = new HashSet<>();

    @Override
    public Collection<User> findAll() {
        return this.users;
    }

    @Override
    public Boolean save( Collection<User> users ) {
        return this.users.addAll( users );
    }

    @Override
    public Boolean save( User user ) {
        return this.users.add( user );

    }

}
