package servlet;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MyDiary extends HttpServlet {

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
     final static Gson gson = new Gson();
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            /*list集合中存放的是好多student对象*/
            ArrayList<Diary> diaries = new ArrayList<>();
            Diary diary = new Diary();
            diary.setTitle("title");
            diary.setContext("context");
            diary.setDate("date");
            diaries.add(diary);
            //接下来发送数据
            /*设置编码，防止出现乱码问题*/
            response.setCharacterEncoding("utf-8");
            /*得到输出流*/
            PrintWriter respWritter = response.getWriter();
            /*将JSON格式的对象toString()后发送*/
            respWritter.append(gson.toJson(diaries));
        } catch (Exception e) {
            e.printStackTrace();
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
        doPost(request, response);
    }


    static class Diary {

        String context;
        String date;
        String title;

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

}