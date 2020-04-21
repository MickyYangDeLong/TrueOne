package diary.dao;

import diary.dto.Diary;

import java.util.List;

public interface DiaryMapper {
    public Integer addDiary(Diary user);

    public boolean updateDiary(Diary user);

    public boolean deleteDiary(Integer Id);

    public Diary findDiary(Integer Id);

    public int countDiary();

    public List<Diary> listDiary();

}
