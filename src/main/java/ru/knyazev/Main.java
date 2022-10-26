package ru.knyazev;

import org.hibernate.cfg.Configuration;
import ru.knyazev.entity.Consumer;
import ru.knyazev.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = emFactory.createEntityManager();

        //INSERT
        em.getTransaction().begin();

        Consumer elena = new Consumer("Elena");
        Consumer olga = new Consumer("Olga");
        Consumer victoria = new Consumer("Victoria");
        Consumer marina = new Consumer("Marina");
        Consumer angela = new Consumer("Angela");

        em.persist(elena);
        em.persist(olga);
        em.persist(victoria);
        em.persist(marina);
        em.persist(angela);

        Product tomato = new Product("Tomato", 10);
        Product carrot = new Product("Carrot", 20);
        Product cucumber = new Product("Cucumber", 30);
        Product milk = new Product("Milk", 40);
        Product butter = new Product("Butter", 50);
        em.persist(tomato);
        em.persist(carrot);
        em.persist(cucumber);
        em.persist(milk);
        em.persist(butter);

        em.getTransaction().commit();
        em.close();

        //SELECT
//        //find by ID
//        System.out.println("Product with id=1");
//        Product product = em.find(Product.class, 1L);
//        System.out.println(product);
//        System.out.println("*********");
//        System.out.println();
//
//        //find by query (HQL, JPQL)
//        System.out.println("All products");
//        List<Product> productList = em.createQuery("from Product", Product.class)
//                .getResultList();
//        System.out.println(productList);
//        System.out.println("*********");
//        System.out.println();
//
//        System.out.println("Product with title=Tomato");
//        Object tomato = em.createQuery("from Product p where p.title = :title")
//                .setParameter("title", "Carrot")
//                .getSingleResult();
//        System.out.println(tomato);
//        System.out.println("*********");
//        System.out.println();
//
//        //SQL
//        System.out.println("All products by SQL");
//        List resultList = em.createNativeQuery("select * from products", Product.class)
//                .getResultList();
//        System.out.println(resultList);
//
//        //By named query
//        em.createNamedQuery("productByTitle")
//                .setParameter("title", "Carrot")
//                .getSingleResult();
//
//        em.close();

        //UPDATE
//        Product product = em.find(Product.class, 1L);
//        em.getTransaction().begin();
//        product.setCost(123);
//
//        em.getTransaction().commit();
//        em.close();

        //DELETE
//        em.getTransaction().begin();
//        Product product = em.find(Product.class, 2L);
//        if (product != null){
//            em.remove(product);
//        }
//        em.createQuery("delete from Product where title=:title")
//                .setParameter("title", "Milk")
//                .executeUpdate();
//
//        em.getTransaction().commit();
//        em.close();
    }
}