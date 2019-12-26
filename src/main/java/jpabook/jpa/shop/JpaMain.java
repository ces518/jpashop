package jpabook.jpa.shop;

import com.sun.tools.corba.se.idl.constExpr.Or;
import jpabook.jpa.shop.domain.Book;
import jpabook.jpa.shop.domain.Order;
import jpabook.jpa.shop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: june
 * Date: 12/12/2019
 * Time: 10:29 오후
 **/
public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 주문을 할 경우
            Book book = new Book();
            book.setAuthor("박준영");
            book.setIsbn("ASDF");
            em.persist(book);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.clear();
        }
        emf.close();
    }
}
