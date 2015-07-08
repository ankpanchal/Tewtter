package test;

import static org.junit.Assert.*;

//import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;

import model.Tewtterrrr;

import org.junit.Test;

import customTools.DBUtil;

public class GetNameTestFail {
	
	
	//This Should Fail
	@Test
	public void testGetAllTewts() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		Tewtterrrr t = new Tewtterrrr();
		try
		{
			t = (Tewtterrrr)  em.createQuery("SELECT T FROM Tewtterrrr T WHERE T.name = :actorname")
					.setParameter("actorname", null)
					.getSingleResult();
		}catch (Exception e){
			System.out.println(e.getMessage());
		}finally{
			t.setName("Bob");
			assertNull(t.getName());
			em.close();
		}
	
	}

}
