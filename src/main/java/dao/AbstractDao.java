package dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.oracle.wls.shaded.org.apache.bcel.generic.Type;

import JpaUntils.getConnection;

public class AbstractDao<T> {
	public static EntityManager entityManager = getConnection.getEntityManger() ;
			
	
	@Override
	protected void finalize() throws Throwable {
		entityManager.close();
		super.finalize();
	}
	public T findById(Class<T> clazz, Integer id){
		return entityManager.find(clazz, id); 
	}
	
	public List<T> findAll(Class<T> clazz, boolean existIsActive){
		String entityName =  clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("Select o FROM ").append(entityName).append(" o");
		if(existIsActive == true) {
			sql.append(" WHERE isActive = 1 ");
		}
		TypedQuery<T> query =  entityManager.createQuery(sql.toString(), clazz);
		return query.getResultList();
	}
	
	
	
	public List<T> findAll(Class<T> clazz, boolean existIsActive,int pageNumber, int pageSize){
		String entityName =  clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("Select o FROM ").append(entityName).append(" o");
		if(existIsActive == true) {
			sql.append(" WHERE o.isActive = 1 ");
		}
		TypedQuery<T> query =  entityManager.createQuery(sql.toString(), clazz);
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}
	
	public T findOne(Class<T> clazz, String sql, Object... params) {
		TypedQuery<T> query  = entityManager.createQuery(sql,clazz);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List<T> result =  query.getResultList();
		if(result.isEmpty()) {
			return null;
		}else {
			return result.get(0);
		}
		
	}
	
	public List<T> findMany(Class<T> clazz, String sql, Object... params){
		TypedQuery<T> query = entityManager.createQuery(sql,clazz);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);			
		}
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> findManyByNativeQuery(Class<T> clazz, String sql, Object... params) {
		Query query  = entityManager.createNativeQuery(sql,clazz);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return   query.getResultList();
	}
	
	public void Create(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			System.out.println("Create Success");
		} catch (Exception e){
			entityManager.getTransaction().rollback();
			System.out.println("Cannot Create");
		}
		
	}
	
	public void update(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			System.out.println("Create Success");
		} catch (Exception e){
			entityManager.getTransaction().rollback();
			System.out.println("Cannot update");
		}
	
	}
	
	
	public void delete(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			System.out.println("Create Success");
		} catch (Exception e){
			entityManager.getTransaction().rollback();
			System.out.println("Cannot delete");
		}
	}

}

