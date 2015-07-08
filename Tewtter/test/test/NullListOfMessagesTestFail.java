package test;

import static org.junit.Assert.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Tewtterrrr;
import org.junit.Test;
import customTools.DBUtil;
public class NullListOfMessagesTestFail {
	
    
	//This Should Fail
	@Test
	public void testInsertTewt() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT T FROM Tewtterrrr T";
		
		TypedQuery<Tewtterrrr> q = em.createQuery(qString, Tewtterrrr.class);
		
		List<Tewtterrrr> tewts;
		try
		{
			tewts = q.getResultList();
			if (tewts == null || tewts.isEmpty())
				tewts = null;	
		} finally{
			assertNull(q.getResultList().size());
			em.close();
			
		}
        		
	}
}
