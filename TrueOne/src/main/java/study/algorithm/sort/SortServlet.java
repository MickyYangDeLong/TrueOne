package study.algorithm.sort;

import com.google.gson.Gson;
import diary.dao.DiaryMapper;
import diary.dto.Diary;
import diary.service.DiaryServiceImp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/SortServlet.do")
public class SortServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(SortServlet.class);
    static Gson gson = new Gson();

    // 处理 GET 方法请求的方法
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // 设置响应内容类型
        DiaryServiceImp diaryServiceImp = new DiaryServiceImp();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String type = request.getParameter("type");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            this.add(request, response, diaryServiceImp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Diary> diaryList = new ArrayList<>();
        Diary diary = new Diary();
        diary.setAuthorId("222");
        diary.setTopic("sf");
        diary.setAuthorName("sfsfs");
        diary.setContent("sdfsf");
        diaryList.add(diary);
        response.getWriter().append(gson.toJson(diaryList));
        if (type != null && "add".equals(type)) {
            try {
                this.add(request, response, diaryServiceImp);
            } catch (Exception e) {
                logger.error("exception happened when add", e, e.getMessage());
            }
        }

        if (type != null && "query".equals(type)) {
            try {
                this.query(request, response, diaryServiceImp);
            } catch (Exception e) {
                logger.error("exception happened when query", e, e.getMessage());
            }
        }
        if (type != null && "update".equals(type)) {
            try {
                this.update(request, response, diaryServiceImp);
            } catch (Exception e) {
                logger.error("exception happened when update", e, e.getMessage());
            }
        }
        if (type != null && "delete".equals(type)) {
            try {
                this.delete(request, response, diaryServiceImp);
            } catch (Exception e) {
                logger.error("exception happened when delete", e, e.getMessage());
            }
        }
    }
    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @SuppressWarnings("unused")
    public void add(HttpServletRequest request, HttpServletResponse response, DiaryServiceImp service)
            throws Exception {
        Reader reader = Resources.getResourceAsReader("configuration.xml");
        SqlSessionFactoryBuilder ssfBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = ssfBuilder.build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DiaryMapper adminDao = sqlSession.getMapper(DiaryMapper.class);
     /*   Diary admin = new Diary();
        Timestamp now = new Timestamp(new Date().getTime());
        admin.setAuthorId("gaojs");
        admin.setAuthorName("123");
        admin.setContent("1sdfsf23");
        admin.setTopic("diary111");
        admin.setUpdateTime(now);
        admin.setCreateTime(now);
        Integer aRet = adminDao.addDiary(admin);*/
        /*System.out.println("addAdmin:" + gson.toJson(admin));*/
        List<Diary> found = adminDao.listDiary();
        System.out.println("findAdmin:" + gson.toJson(found));
     /*   found.setPassword("1234");
        boolean uRet = adminDao.updateAdmin(found);
        System.out.println("updateAdmin, uRet:" + uRet);
        Admin found2 = adminDao.findAdmin(admin.getId());
        System.out.println("findAdmin:" + found2);
        int count = adminDao.countAdmin();
        System.out.println("countAdmin, count:" + count);
        List<Admin> list = adminDao.listAdmin();
        System.out.println("listAdmin, list:" + list);
        boolean dRet = adminDao.deleteAdmin(admin.getId());
        System.out.println("deleteAdmin:" + dRet);*/
        sqlSession.commit();
        sqlSession.close();
    }

    // 根据id删除
    public void delete(HttpServletRequest request, HttpServletResponse response, DiaryServiceImp service)
            throws Exception {

    }

    // 修改
    public void update(HttpServletRequest request, HttpServletResponse response, DiaryServiceImp service)
            throws Exception {

    }

    // 查询
    public void query(HttpServletRequest request, HttpServletResponse response, DiaryServiceImp service)
            throws Exception {

    }

}
