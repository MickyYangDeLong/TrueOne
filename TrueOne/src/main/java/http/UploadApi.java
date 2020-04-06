package http;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api")
public class UploadApi {
/*    //postman 测试上传下载
    private Logger logger = LoggerFactory.getLogger(UploadApi.class);

    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    @ResponseBody
    public String beginUpload(){
       logger.info("start upload");
       logger.info("uploading.......");
       logger.info("end upload");
       return "Test upload";
    }*/
}
