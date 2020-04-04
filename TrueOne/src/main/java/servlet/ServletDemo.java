package servlet;

import dto.Student;
import service.StudentServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class ServletDemo extends HttpServlet {

    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = (String) request.getParameter("user");
        String passWord = (String) request.getParameter("pswd");
        if (Objects.isNull(userName)){
            request.setAttribute("message", "用户名或者密码错误，请重新输入！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        Student student = new StudentServiceImp().query(userName);
        if (Objects.nonNull(student) && Objects.equals(passWord,student.getPassWord())){
            response.sendRedirect("/main.jsp");
        }else {
            request.setAttribute("message", "用户名或者密码错误，请重新输入！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    /**
     * 0
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the POST method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

}