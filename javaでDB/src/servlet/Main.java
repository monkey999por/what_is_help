package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.User;
import model.control.GetMutterLogic;
import model.control.PostMutterLogic;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		つぶやきリストを取得してrecestスコープに保存
		GetMutterLogic getMutterLogic=new GetMutterLogic();
		List<Mutter> mutterList=getMutterLogic.excute();
		request.setAttribute("mutterList", mutterList);

//		ログイン確認(セッションスコープからユーザ情報を取得)
		HttpSession httpSession=request.getSession();
		User loginUser=(User) httpSession.getAttribute("loginUser");
		System.out.println("セッションからユーザ情報: "+loginUser);


//		未ログインならTOP画面にリダイレクト
//		ログイン済みならフォワード
		if (loginUser==null) {
			response.sendRedirect("http://localhost:8080/docoTsubu/index.jsp");
		}else  {
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		リクエストパラメータの取得
		String text=request.getParameter("text");
//		String filePath = request.getParameter("filePath");
		String errormsg=new String("つぶやきが空だよ！");
//		if (text instanceof String) {
//			try {
//				Voice.saisei(filePath);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//
//			}
//		}

//		入力チェック
		if (text!=null&&text.length()!=0) {


//			セッションスコープからユーザ情報を取得
			HttpSession httpSession=request.getSession();
			User user=(User) httpSession.getAttribute("loginUser");


//			つぶやきをテーブルに追加
			Mutter mutter=new Mutter(user.getName(), text);
			PostMutterLogic logic=new PostMutterLogic();
			logic.excute(mutter);

		}else  {
			request.setAttribute("error", errormsg);
		}
//	  	つぶやきリストを取得してリクエストスコープに保存
		GetMutterLogic getMutterLogic=new GetMutterLogic();
		List<Mutter> mutterList=getMutterLogic.excute();
		request.setAttribute("mutterList", mutterList);


//		メイン画面にフォワード
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		requestDispatcher.forward(request, response);

	}

}
