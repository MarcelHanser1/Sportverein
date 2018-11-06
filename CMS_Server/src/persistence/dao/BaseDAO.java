package persistence.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;


public class BaseDAO<T, PK extends Serializable> {

	protected SessionFactory _sessionFactory = HibernateUtil.getSessionFactory();
	private Class<T> _type;
	
	public BaseDAO(Class<T> type) {
		_type = type;
	}
	
	public List<T> getAll(){
		Session session = _sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<T> query = criteriaBuilder.createQuery(_type);
		query.from(_type);

		List<T> result = session.createQuery(query).getResultList();
		tx.commit();
		session.close();
		return result;
	}

	public void insert(T t) {
		Session session = _sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(t);
		tx.commit();
		session.close();
	}

    public void update(T t) {
        Session session = _sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(t);
        tx.commit();
        session.close();
    }

    public void saveOrUpdate(T t) {
		Session session = _sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(t);
		tx.commit();
		session.close();
	}

	public void delete(T t) {
		Session session = _sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
//		session.merge(t);
		session.delete(t);
		tx.commit();
		session.close();
	}


	public T getEagerRolesForPersonByKey(PK key) {
		Session session = _sessionFactory.openSession();
		session.enableFetchProfile("eagerRoles");
		Transaction tx = session.beginTransaction();
		T t = session.get(_type, key);
		tx.commit();
		session.disableFetchProfile("eagerRoles");
		session.close();
		return t;
	}

	public T getEagerTeamsForCompetitionByKey(PK key) {
		Session session = _sessionFactory.openSession();
		session.enableFetchProfile("eagerTeams");
		Transaction tx = session.beginTransaction();
		T t = session.get(_type, key);
		tx.commit();
		session.disableFetchProfile("eagerTeams");
		session.close();
		return t;
	}




}
