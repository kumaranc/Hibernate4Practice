package com.arulstudies.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Util {

    public static Util util = new Util();

    public static Util getInstance() {
        if(util != null) {
            return util;
        }
        return new Util();
    }

    public <O> Session getSession(Class<O> input) {

        Configuration configuration = new Configuration().configure().addAnnotatedClass(input);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();

        return session;
    }

    public void terminateSession(Session session) {
        session.close();
    }

    public String convertMapToString(Map<String, String> inputMap) {
        AtomicReference<String> output = new AtomicReference<>();
        inputMap.forEach((key, value) -> {
            if(output.get() != "") output.getAndSet(" and ");
            output.getAndSet(key +"="+value);
        });
        return output.get();
    }

    public static boolean isEmptyValue(String val) {
        return val == null || val == "";
    }
}
