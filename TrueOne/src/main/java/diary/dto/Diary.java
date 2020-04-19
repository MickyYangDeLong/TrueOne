package diary.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Diary {
    private int id;
    private String content;//日记内容
    private Timestamp createTime;
    private Timestamp updateTime;
    private String authorName;//作者名字
    private String authorId;//作者id
}
