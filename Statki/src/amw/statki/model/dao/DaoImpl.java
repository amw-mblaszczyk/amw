package amw.statki.model.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public abstract class DaoImpl<K, E> implements Dao<K, E> {
	protected Class<E> entityClass;
	 
	@PersistenceContext
	protected EntityManager entityManager;
	
	private static SessionFactory sessionFactory = null;
 
	public DaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
	}
 
	public void persist(E entity) { entityManager.persist(entity); }
 
	public void remove(E entity) { entityManager.remove(entity); }
 
	public E findById(K id) { return entityManager.find(entityClass, id); }

	public List<E> findAll() {	
		return entityManager.createQuery("from " + entityClass.getName()).getResultList();
	}
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
        sessionFactory = meta.getSessionFactoryBuilder().build();  
		}
    
    return sessionFactory;
	}
	
	public Session createSession() {
		return getSessionFactory().openSession();
	}
	
}
