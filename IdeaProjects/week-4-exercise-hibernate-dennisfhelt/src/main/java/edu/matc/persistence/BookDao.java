package edu.matc.persistence;

import edu.matc.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * TODO At minimum create methods to create, read, update, and delete Books.
 * TODO a logger is used here, be sure to set up a log4j2.properties file
 */
public class BookDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<Book> getAllBooks() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        List<Book> books = session.createQuery(query).getResultList();

        logger.debug("The list of books " + books);
        session.close();
        return books;
    }


        /**
         * Get book by id
         */
        public Book getById ( int id){

            Session session = sessionFactory.openSession();
            Book books = session.get( Book.class, id );
            session.close();
            return books;
        }

        /**
         * update book
         * @param books  Book to be inserted or updated
         */
        public void saveOrUpdate (Book books) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(books);
            transaction.commit();
            session.close();

        }

        /**
         * update Book
         * @param books  Book to be inserted or updated
         */
        public int insert (Book books){

            int id = 0;
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            id = (int)session.save(books);
            transaction.commit();
            session.close();
            return id;

        }

        /**
         * Delete a book
         * @param books Book to be deleted
         */
        public void delete (Book books){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(books);
            transaction.commit();
            session.close();
        }
}
