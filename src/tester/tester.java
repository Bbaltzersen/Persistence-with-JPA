/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bbalt
 */
public class tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persistence.generateSchema("Persistence_with_JPAPU", null);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence_with_JPAPU");
        EntityManager em = emf.createEntityManager();
        facade f = new facade();
        f.createUser("Bert", "Haha@Yahoo.dk");
        try {
        System.out.println(f.getUser("Bert").toString());
        }
        catch (Exception ex) {
            System.out.println("not found");
        }
    }

}
