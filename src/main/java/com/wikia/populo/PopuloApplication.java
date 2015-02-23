package com.wikia.populo;

import com.wikia.populo.jdbi.UserDAO;
import com.wikia.populo.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.jdbi.*;
import org.skife.jdbi.v2.DBI;

public class PopuloApplication extends Application<PopuloConfiguration> {
    public static void main(String[] args) throws Exception {
        new PopuloApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<PopuloConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(PopuloConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
        final UserDAO userDAO = jdbi.onDemand(UserDAO.class);
        environment.jersey().register(new UserResource(userDAO));
    }
}
