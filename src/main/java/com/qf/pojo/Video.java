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


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("video")
public class Video implements Serializable {
    @TableId(type = IdType.AUTO)
   // @TableField("id")
    private Integer id;
   // @TableField("title")
    private String title;
   // @TableField("detail")
    private String detail;
   // @TableField("time")
    private Integer time;
   // @TableField("speaker_id")
    private Integer speakerId;
    //@TableField("course_id")
    private Integer courseId;
    //@TableField("video_url")
    private String videoUrl;
   // @TableField("image_url")
    private String imageUrl;
    //@TableField("play_num")
    private Integer playNum;


    private Speaker speaker;


}
