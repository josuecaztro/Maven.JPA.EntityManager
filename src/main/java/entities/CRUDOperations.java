package entities;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CRUDOperations {

    public void insertEntity (CD aCD){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(aCD);
        em.getTransaction().commit();
        em.close();
        System.out.println("Entity added!");
    }

    public CD findById(int id){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        CD aCd = em.find(CD.class, id);
        System.out.println("===== ENTITY FOUND! =====");
        System.out.println("Title: " + aCd.getTitle());
        System.out.println("Description: " + aCd.getDescription());
        System.out.println("Year: " + aCd.getYear());
        System.out.println("Artist: " + aCd.getArtist());
        System.out.println("Price: " + aCd.getPrice());
        em.getTransaction().commit();
        em.close();
        return aCd;
    }

    public void findAll(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        TypedQuery<CD> query = em.createQuery("SELECT c FROM CD c", CD.class);
        List<CD> cds = query.getResultList();
        for (CD x : cds){
            System.out.println("===== ID #: " + x.getId() + " =====");
            System.out.println("Title: " + x.getTitle());
            System.out.println("Description: " + x.getDescription());
            System.out.println("Year: " + x.getYear());
            System.out.println("Artist: " + x.getArtist());
            System.out.println("Price: " + x.getPrice());
            System.out.println();
        }
        em.getTransaction().commit();
        em.close();
    }

    public void removeEntity(int id){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        CD aCd = em.find(CD.class, id);
        em.remove(aCd);
        System.out.println("===== " + aCd.getTitle() + " has been removed. =====" );
        em.getTransaction().commit();
        em.close();
    }

    public void updateEntity(int id, String newTitle){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        CD acd = em.find(CD.class, id);
        acd.setTitle(newTitle);
        em.flush();
        System.out.println("=====  #" + id + " has been updated. =====");

        em.getTransaction().commit();
        em.close();
    }
}
