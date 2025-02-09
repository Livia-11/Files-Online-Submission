package com.submission.mis.filesonlinesubmission.dao;

import com.submission.mis.filesonlinesubmission.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserDao {
    public User authenticate(String email, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery(
                    "FROM User WHERE email = :email AND password = :password", User.class
            );
            query.setParameter("email", email);
            query.setParameter("password", password);

            return query.uniqueResult(); // Returns null if no match found
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


