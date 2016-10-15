package Factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by Aleksandr_Kolesov on 10/15/2016.
 */
public abstract class Sessions {
    private Session currentSession;
    private Transaction currentTransaction;
    private SessionFactory currentSessionFactory;

    public Session openCurrentSession() {
        currentSessionFactory = getSessionFactory();
        currentSession = currentSessionFactory.openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSessionFactory = getSessionFactory();
        currentSession = currentSessionFactory.openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
        currentSessionFactory.close();
    }

    public void closeCurrentSession() {
        currentSession.close();
        currentSessionFactory.close();
    }

    private SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

}
