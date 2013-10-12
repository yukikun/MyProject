package todo.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import todo.dao.TodoDao;
import todo.entity.TodoValueObject;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/todo/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userid = request.getRemoteUser();
		request.setAttribute("LoginUserId", userid);

		boolean isAdmin = request.isUserInRole("admin");
		request.setAttribute("isAdmin", isAdmin);

		TodoDao dao = new TodoDao();

		try{
			List<TodoValueObject> list = dao.todoList();
			request.setAttribute("todoList", list);
		}catch(Exception e){
			throw new ServletException(e);
		}finally{
			dao.closeConnection();

		}

		// 一覧表示
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/search.jsp");
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
