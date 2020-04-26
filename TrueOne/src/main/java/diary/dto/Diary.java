package diary.dto;

import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("Diary")
public class Diary {
    //id
    private int id;
    //diary_text
    private String content;//日记内容
    //topic
    private String topic;//日记主题
    //create_time
    private Timestamp createTime;
    //update_time
    private Timestamp updateTime;
    //author
    private String authorName;//作者名字
    //authorid
    private String authorId;//作者id
}
