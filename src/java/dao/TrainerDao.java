/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Trainer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author me
 */
public class TrainerDao {
    
    public List<Trainer> getTrainersJPA() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TrainersJPAPU");
        EntityManager em = emf.createEntityManager();
        List<Trainer> trainers=null;
        Query q;
        q=em.createQuery("SELECT c.name,c.surname, c.subject FROM trainers c");
        em.getTransaction().begin();
        try {
            trainers= q.getResultList();
            em.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return trainers;
    }
    
    public Trainer getTrainerById(long id){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TrainersJPAPU");
        EntityManager em = emf.createEntityManager();
        Trainer tr =em.find(entities.Trainer.class, id);
        return tr;
    }
    
    public boolean insertTrainerJPA(Trainer t) {
        boolean completed = false;
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TrainersJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(t);
            em.getTransaction().commit();
            completed = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return completed;
    }
    
    public boolean updateTrainerJPA(long id,Trainer tr) {
        boolean completed = false;
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TrainersJPAPU");
        EntityManager em = emf.createEntityManager();
        Trainer s =em.find(entities.Trainer.class, id);
            s.setName(tr.getName());
            s.setSurname(tr.getSurname());
            s.setSubject(tr.getSubject());
            em.getTransaction().begin();
        try {
            em.persist(s);
            em.getTransaction().commit();
            completed = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return completed;
    }
    
    public boolean deleteTrainerJPA(long id) {
        boolean completed = false;
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("TrainersJPAPU");
        EntityManager em = emf.createEntityManager();
        Trainer t =em.find(entities.Trainer.class, id);
        em.getTransaction().begin();
        try {
            em.remove(t);
            em.getTransaction().commit();
            completed = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return completed;
    }
}
