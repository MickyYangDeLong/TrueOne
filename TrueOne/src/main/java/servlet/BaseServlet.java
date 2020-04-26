package servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
public class BaseServlet extends HttpServlet {
    private static final long serialVersionUID = 797979797999080L;
    public BaseServlet(){
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response){
        String methodName = request.getParameter("methodName");
        if (!StringUtils.isEmpty(methodName)){
            try {
                Method method = this.getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
                method.setAccessible(true);
                method.invoke(this,request,response);
            }catch (Exception e){
                log.error("exception happened",e,e.getMessage());
            }
        }else{
          log.info(" it is has no method name!");
        }
    }
}
