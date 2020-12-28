package com.qf.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("user")
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String email;
    @TableField("phoneNum")
    private String phoneNum;
    private String password;
    private String code;
    @TableField("nickName")
    private String nickName;
    private String sex;
    private String birthday;
    private String address;
    @TableField("imgUrl")
    private String imgUrl;
    @TableField("createTime")
    private Date createTime;
}
