/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.ProjectUser;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author bbalt
 */
public class facade {
    public void createUser(String name, String email) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence_with_JPAPU");
        EntityManager em = emf.createEntityManager();
        int i = (int) (new Date().getTime()/1000);
        try {
             ProjectUser newUser = new ProjectUser(name, email, i);
             em.getTransaction().begin();
             em.persist(newUser);
             em.getTransaction().commit();
         }
         finally {
             em.close();
         }
    }
     public ProjectUser getUser(String user) {
        ProjectUser userFound = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence_with_JPAPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT p FROM ProjectUser p WHERE p.userName = :userName");
        q.setParameter("userName", user);
        List<ProjectUser> us = q.getResultList();
        userFound = us.get(0);
        return userFound;
    }
      
     public List<ProjectUser> getUsers() {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence_with_JPAPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT p FROM ProjectUser p");
        List<ProjectUser> us = q.getResultList();
        return us;
     }
}
