package com.arulstudies.hibernate.operations.aliens;

import com.arulstudies.hibernate.operations.employees.Employee;
import com.arulstudies.hibernate.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class AlienRepository {

    private static AlienRepository repository = new AlienRepository();
    public static AlienRepository getInstance() {
        if(repository != null) return repository;

        return new AlienRepository();
    }

    public String createAlien(Alien alien) {

        Session session = Util.getInstance().getSession(Alien.class);
        Transaction transaction = session.beginTransaction();

        try {
            session.save(alien);
            transaction.commit();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            return "";
        } finally {
            Util.getInstance().terminateSession(session);
        }

        return String.valueOf(alien.getId());
    }

    public boolean deleteAlien(Alien alien) {
        Session session = Util.getInstance().getSession(Alien.class);
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(alien);
            transaction.commit();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            Util.getInstance().terminateSession(session);
        }
        return true;
    }

    public Alien getAlien(int id) {
        Session session = Util.getInstance().getSession(Alien.class);
        Transaction transaction = session.beginTransaction();
        Alien alien = null;

        try {
            alien = (Alien) session.get(Alien.class, id);
            transaction.commit();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            Util.getInstance().terminateSession(session);
        }
        return alien;
    }

    public List<Alien> getAliens(Restrictions restrictions, int limit, int offset) {
        Session session = Util.getInstance().getSession(Alien.class);
        Transaction transaction = session.beginTransaction();

        try {

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            Util.getInstance().terminateSession(session);
        }

        return null;
    }
}
