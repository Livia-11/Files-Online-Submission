package com.submission.mis.filesonlinesubmission.dao;

import org.hibernate.Session;
import org.hibernate.sql.ast.tree.update.Assignment;

public class AssignmentDao {
    public void saveAssignment(Assignment assignment) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(assignment);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
