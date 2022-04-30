package com.LearnersAcademy;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

/**
 * Servlet implementation class AssignTeacher
 */
@WebServlet("/assignTeacher")
public class AssignTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Step 1: Get details , user has entered
		String name = request.getParameter("name");
		String[] nameArray = name.split(" ");
		//System.out.println("NameList: " + nameList);
		String subject = request.getParameter("subject");
				
		// Step2: Create session
		SessionFactory sf  = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		
		// Step 3: Begin Transaction
		Transaction tx = session.beginTransaction();
		
		String hql_teacher= "from Teachers where name='" + nameArray[0] + "'" + " and lname='" + nameArray[1] + "'";
		List<Teachers> teachers = session.createQuery(hql_teacher).list();
		
		String hql_subject = "update Subjects s set s.teacher=:n where s.name=:sn";
		
		Query<Subjects> query = session.createQuery(hql_subject);
		query.setParameter("n", teachers.get(0));
		query.setParameter("sn", subject);
				
		query.executeUpdate();

		
		// STep5: Commit transaction and close sessoin
		tx.commit();
		session.close();
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewTeachers.jsp");
        dispatcher.forward(request, response); 
	}

}
