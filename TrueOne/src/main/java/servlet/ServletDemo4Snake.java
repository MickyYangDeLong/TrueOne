package servlet;

import o.two.Yard;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class ServletDemo4Snake extends HttpServlet {

    /**
     * The doGet method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = (String) request.getParameter("user");
        String passWord = (String) request.getParameter("pswd");
        if (Objects.equals(userName, "micky") && Objects.equals(passWord, "123456")) {
            response.sendRedirect("/main.jsp");
        } else {
            request.setAttribute("message", "用户名或者密码错误，请重新输入！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    /**
     * 0
     * The doPost method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException      if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CompletableFuture.runAsync(() -> Yard.main(new String[]{}));
        response.sendRedirect("/main.jsp");
    }

}