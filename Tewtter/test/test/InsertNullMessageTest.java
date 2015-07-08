package test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Tewtterrrr;

import org.junit.Test;

import customTools.DBUtil;

public class InsertNullMessageTest {
	
    
	
	@Test
	public void testInsertTewt() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		java.util.Date date= new java.util.Date();
		Timestamp t = new Timestamp(date.getTime());
		
		
		Tewtterrrr message = new Tewtterrrr();
		message.setName("Test");
		message.setMessage("");
		message.setMdate(t);
		
		
		try
        {
			trans.begin();
			em.persist(message);
		  	trans.commit();  	
        }catch (Exception e){
        	System.out.println(e);
        	trans.rollback();
        }finally{
        	String queryString = ("SELECT DISTINCT T FROM Tewtterrrr T WHERE T.message = :mess");
    		TypedQuery<Tewtterrrr> q = em.createQuery(queryString, Tewtterrrr.class);
    		q.setParameter("mess", "");
        	List<Tewtterrrr> testMessage = q.getResultList();
        	
        	assertEquals(testMessage.get(0).getMessage(), "");
        	em.close();
        }		
	}
}
