package sample.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.dao.TodoDao;
import todo.entity.TodoValueObject;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/todo/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TodoDao dao = new TodoDao();

		String paramId = request.getParameter("id");

		TodoValueObject vo;

		try{
			int id = Integer.parseInt(paramId);

			vo = dao.detail(id);
		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			dao.closeConnection();
		}

		request.setAttribute("vo", vo);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/detail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
