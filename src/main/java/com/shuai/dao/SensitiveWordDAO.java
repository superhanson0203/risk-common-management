package com.shuai.dao;

import com.shuai.dao.entity.SensitiveWord;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface SensitiveWordDAO {
    int deleteByPrimaryKey(Integer id);

    Integer insert(SensitiveWord record);

    Integer insertSelective(SensitiveWord record);

    SensitiveWord selectByPrimaryKey(Integer id);

    SensitiveWord selectByGroupPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SensitiveWord record);

    int updateByPrimaryKey(SensitiveWord record);

    List<SensitiveWord> selectByRecord(SensitiveWord record);

    List<SensitiveWord> selectSensitiveWordGroupByRecord(SensitiveWord record);

    List<SensitiveWord> selectSensitiveWordsByWords(Set<String> sensitiveWords);

    Integer insertSelectiveGroup(SensitiveWord record);

    Integer updateSelectiveGroupByPrimaryKey(SensitiveWord record);

    List<SensitiveWord> selectSensitiveWordGroupByRecordPage(SensitiveWord record, Date updateTimeBegin, Date updateTimeEnd, Integer pageIndex, Integer pageSize);

    Long getSensitiveWordGroupByRecordGroupPageCount(SensitiveWord record, Date updateTimeBegin, Date updateTimeEnd);

    List<SensitiveWord> selectSensitiveWordByRecordPage(SensitiveWord record, Date updateTimeBegin, Date updateTimeEnd, Integer pageIndex, Integer pageSize);

    Long getSensitiveWordGroupByRecordPageCount(SensitiveWord record, Date updateTimeBegin, Date updateTimeEnd);

    void  batchInsertSelectiveGroup(List<SensitiveWord> recordList);

    void  batchInsertSelective(List<SensitiveWord> recordList);

    List<SensitiveWord> selectSensitiveWordGroupByWord(SensitiveWord record);

    List<SensitiveWord> selectSensitiveWordByWord(SensitiveWord record);

    List<SensitiveWord> batchSelectSensitiveWordGroupByWord(List<SensitiveWord> records);

    List<SensitiveWord> batchSelectSensitiveWordByWord(List<SensitiveWord> records);

}