package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tewtterrrr;
import modelcontroller.TewtterDB;

/**
 * SERVLET implementation class tewtterr
 */
@WebServlet("/TewtterrServlet")
public class TewtterrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TewtterrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tewtterrrr tewttermessage = new Tewtterrrr();
		
		
		try{
			String name = request.getParameter("name");
			String mes = request.getParameter("mes"); 
			
			if(!name.equals(null) && !mes.equals(null))
			{
				tewttermessage.setName(name);
				tewttermessage.setMessage(mes);
				TewtterDB.insertTewt(tewttermessage);
			}
		}catch(Exception e){}
		List<Tewtterrrr>  messageList = TewtterDB.getAllTewtsYtO();
		
		request.setAttribute("flag", true);
		request.setAttribute("messageList", messageList);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
