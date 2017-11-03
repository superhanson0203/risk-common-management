package com.shuai.dao.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description Created by min on 2017/10/24.
 */
@Data
public class SensitiveWord {
    private Integer id;

    private String word;

    private Integer lable;

    private Byte enable;

    private Byte level;

    private Date createTime;

    private Date updateTime;
}
