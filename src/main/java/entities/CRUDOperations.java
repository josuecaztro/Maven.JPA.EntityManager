package entities;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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

    public void findById(int id){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        CD aCd = em.find(CD.class, id);
        System.out.println("Title: " + aCd.getTitle());
        System.out.println("Description: " + aCd.getDescription());
        System.out.println("Year: " + aCd.getYear());
        System.out.println("Artist: " + aCd.getArtist());
        System.out.println("Price: " + aCd.getPrice());
        em.getTransaction().commit();
        em.close();
    }
}
