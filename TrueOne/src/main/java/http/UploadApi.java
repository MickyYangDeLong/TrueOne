package http;


@Controller
@RequestMapping(value = "/api")
public class UploadApi {
    //postman 测试上传下载
    private Logger logger = LoggerFactory.getLogger(UploadApi.class);

    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    @ResponseBody
    public String beginUpload(){
       logger.info("start upload");
       logger.info("uploading.......");
       logger.info("end upload");
       return "Test upload";
    }
}
