package com.shh.entity;

import java.math.BigInteger;
import java.util.Date;
import lombok.Data;

/**
    * 会员表
    */
@Data
public class Member {
    private Integer memberId;

    /**
    * 用户名
    */
    private String username;

    /**
    * 密码
    */
    private String password;

    /**
    * 昵称
    */
    private String nickname;

    /**
    * 手机号码
    */
    private String phone;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 帐号启用状态:0->禁用；1->启用
    */
    private Integer status;

    /**
    * 注册时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 头像
    */
    private String icon;
}