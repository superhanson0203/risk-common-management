package com.shuai.dao.impl;

import com.shuai.dao.SensitiveWordDAO;
import com.shuai.dao.entity.SensitiveWord;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class SensitiveWordDAOImpl implements SensitiveWordDAO {

    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;


    public int deleteByPrimaryKey(Integer id) {
        SensitiveWord _key = new SensitiveWord();
        _key.setId(id);
        int rows = sqlSessionTemplate.delete("sensitive_word.deleteByPrimaryKey", _key);
        return rows;
    }

    public Integer insert(SensitiveWord record) {
        Object newKey = sqlSessionTemplate.insert("sensitive_word.insert", record);
        return (Integer) newKey;
    }

    public Integer insertSelective(SensitiveWord record) {
        Object newKey = sqlSessionTemplate.insert("sensitive_word.insertSelective", record);
        return (Integer) newKey;
    }

    public SensitiveWord selectByPrimaryKey(Integer id) {
        SensitiveWord _key = new SensitiveWord();
        _key.setId(id);
        SensitiveWord record = (SensitiveWord) sqlSessionTemplate.selectOne("sensitive_word.selectByPrimaryKey", _key);
        return record;
    }

    public SensitiveWord selectByGroupPrimaryKey(Integer id) {
        SensitiveWord _key = new SensitiveWord();
        _key.setId(id);
        SensitiveWord record = (SensitiveWord) sqlSessionTemplate.selectOne("sensitive_word.selectByGroupPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(SensitiveWord record) {
        int rows = sqlSessionTemplate.update("sensitive_word.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(SensitiveWord record) {
        int rows = sqlSessionTemplate.update("sensitive_word.updateByPrimaryKey", record);
        return rows;
    }

    @Override
    public List<SensitiveWord> selectByRecord(SensitiveWord record) {
        return sqlSessionTemplate.selectList("sensitive_word.selectByRecord", record);
    }


    @Override
    public List<SensitiveWord> selectSensitiveWordGroupByRecord(SensitiveWord record) {
        return sqlSessionTemplate.selectList("sensitive_word.selectSensitiveWordGroupByRecord", record);
    }

    @Override
    public List<SensitiveWord> selectSensitiveWordsByWords(Set<String> sensitiveWords) {
        List<String> list = new ArrayList<>();
        list.addAll(sensitiveWords);
        return sqlSessionTemplate.selectList("sensitive_word.selectSensitiveWordsByWords", list);
    }

    public Integer insertSelectiveGroup(SensitiveWord record) {
        Object newKey = sqlSessionTemplate.insert("sensitive_word.insertSelectiveGroup", record);
        return (Integer) newKey;
    }

    @Override
    public Integer updateSelectiveGroupByPrimaryKey(SensitiveWord record) {
        int rows = sqlSessionTemplate.update("sensitive_word.updateByPrimaryKeySelectiveGroup", record);
        return rows;
    }

    @Override
    public List<SensitiveWord> selectSensitiveWordGroupByRecordPage(SensitiveWord record,Date updateTimeBegin,Date updateTimeEnd,Integer pageIndex, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        setSensitiveMap(map,record,updateTimeBegin,updateTimeEnd);
        //大于0为分页查询，为0则为查询全部
        if (pageIndex != null && pageIndex > 0) {
            map.put("beginCount", (pageIndex - 1) * pageSize);
        }
        map.put("pageSize", pageSize);

        return sqlSessionTemplate.selectList("sensitive_word.selectSensitiveWordGroupByRecordPage", map);
    }

    @Override
    public Long getSensitiveWordGroupByRecordGroupPageCount(SensitiveWord record,Date updateTimeBegin,Date updateTimeEnd) {
        Map<String, Object> map = new HashMap<>();
        setSensitiveMap(map,record,updateTimeBegin,updateTimeEnd);
        return (Long) sqlSessionTemplate.selectOne("sensitive_word.selectSensitiveWordGroupByRecordPageCount", map);
    }

    public List<SensitiveWord> selectSensitiveWordByRecordPage(SensitiveWord record, Date updateTimeBegin,Date updateTimeEnd, Integer pageIndex, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        setSensitiveMap(map,record,updateTimeBegin,updateTimeEnd);
        //大于0为分页查询，为0则为查询全部
        if (pageIndex != null && pageIndex > 0) {
            map.put("beginCount", (pageIndex - 1) * pageSize);
        }
        map.put("pageSize", pageSize);
        return sqlSessionTemplate.selectList("sensitive_word.selectSensitiveWordByRecordPage", map);
    }

    @Override
    public Long getSensitiveWordGroupByRecordPageCount(SensitiveWord record,Date updateTimeBegin,Date updateTimeEnd) {
        Map<String, Object> map = new HashMap<>();
        setSensitiveMap(map,record,updateTimeBegin,updateTimeEnd);
        return (Long) sqlSessionTemplate.selectOne("sensitive_word.selectSensitiveWordByRecordPageCount", map);
    }

    @Override
    public void batchInsertSelectiveGroup(List<SensitiveWord> recordList) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", recordList);
        sqlSessionTemplate.insert("sensitive_word.batchInsertSelectiveGroup",map);
    }

    @Override
    public void batchInsertSelective(List<SensitiveWord> recordList) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", recordList);
        sqlSessionTemplate.insert("sensitive_word.batchInsertSelective",map);
    }

    @Override
    public List<SensitiveWord> selectSensitiveWordGroupByWord(SensitiveWord record) {
        return sqlSessionTemplate.selectList("sensitive_word.selectSensitiveWordGroupByWord", record);
    }

    @Override
    public List<SensitiveWord> selectSensitiveWordByWord(SensitiveWord record) {
        return sqlSessionTemplate.selectList("sensitive_word.selectSensitiveWordByWord", record);
    }

    @Override
    public List<SensitiveWord> batchSelectSensitiveWordGroupByWord(List<SensitiveWord> records) {
        Map<String,List<SensitiveWord>> queryMaps = new HashMap<>();
        queryMaps.put("list",records);
        return sqlSessionTemplate.selectList("sensitive_word.batchSelectSensitiveGroupWordByWord", queryMaps);
    }

    @Override
    public List<SensitiveWord> batchSelectSensitiveWordByWord(List<SensitiveWord> records) {
        Map<String,List<SensitiveWord>> queryMaps = new HashMap<>();
        queryMaps.put("list",records);
        return sqlSessionTemplate.selectList("sensitive_word.batchSelectSensitiveWordByWord", queryMaps);
    }

    private void setSensitiveMap(Map<String, Object> map,SensitiveWord record,Date updateTimeBegin,Date updateTimeEnd){
        if (StringUtils.isNotBlank(record.getWord())) {
            map.put("word", record.getWord());
        }
        if (record.getEnable() != null) {
            map.put("enable", record.getEnable());
        }

        if (null != record.getLable()&&record.getLable()>0) {
            map.put("lable", record.getLable());
        }

        if (updateTimeBegin != null) {
            map.put("updateTimeBegin", updateTimeBegin);
        }

        if (updateTimeEnd != null) {
            map.put("updateTimeEnd", updateTimeEnd);
        }
    }


}