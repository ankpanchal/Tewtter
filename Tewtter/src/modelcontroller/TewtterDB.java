package modelcontroller;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Tewtterrrr;
import customTools.DBUtil;

public class TewtterDB {
	
	static public void insertTewt(Tewtterrrr message){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		java.util.Date date= new java.util.Date();
		Timestamp t = new Timestamp(date.getTime());
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
        	em.close();
        }
	}//END insert
	
	static public List<Tewtterrrr> getAllTewtsYtO(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT T FROM Tewtterrrr T ORDER BY T.mdate DESC";
		
		TypedQuery<Tewtterrrr> q = em.createQuery(qString, Tewtterrrr.class);
		
		List<Tewtterrrr> tewts;
		try
		{
			tewts = q.getResultList();
			if (tewts == null || tewts.isEmpty())
				tewts = null;	
			return tewts;
		} finally{
			em.close();
		}
	}
	
	static public List<Tewtterrrr> getAllTewtsOtY(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT T FROM Tewtterrrr T ORDER BY T.mdate";
		
		TypedQuery<Tewtterrrr> q = em.createQuery(qString, Tewtterrrr.class);
		
		List<Tewtterrrr> tewts;
		try
		{
			tewts = q.getResultList();
			if (tewts == null || tewts.isEmpty())
				tewts = null;	
			return tewts;
		} finally{
			em.close();
		}
	}
	
	
}//END class TewtterDB
