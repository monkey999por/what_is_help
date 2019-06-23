package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.control.LoginLogic;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

//		リクエストパラメータ取得
		String name=(String) request.getParameter("name");
		String pass=(String) request.getParameter("pass");


//		ユーザ名、パスワードを持ったUserインスタンスの生成
		User user=new User(name, pass);


//		ログイン処理(パスワードの一致)
		LoginLogic loginLogic=new LoginLogic();
		boolean isLogin= loginLogic.excute();
		System.out.println("パスワードの一致: "+isLogin);

/*		セッションスコープにインスタンスを保存
		ログイン処理の結果でフォワード先を変更
*/

		if (isLogin) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("loginUser", user);
//			フォワードする
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
			requestDispatcher.forward(request, response);
		}else {
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(request, response);
		}


	}

}
