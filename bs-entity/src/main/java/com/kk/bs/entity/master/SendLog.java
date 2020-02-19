package com.kk.bs.entity.master;


import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author allahbin
 * @since 2019-10-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("send_log")
public class SendLog extends Model<SendLog> implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId("L_ID")
    @Excel(name = "主键", width = 50)
    private String lId;

    /**
     * 发送时间
     */
    @TableField("SEND_TIME")
    @Excel(name = "发送时间", width = 50)
    private LocalDateTime sendTime;

    /**
     * 发送的用户
     */
    @TableField("SEND_USER")
    @Excel(name = "发送的用户", width = 50)
    private String sendUser;

    /**
     * 用户的id
     */
    @TableField("SEND_USER_ID")
    @Excel(name = "用户的id", width = 50)
    private String sendUserId;


    @Override
    protected Serializable pkVal() {
        return this.lId;
    }

}
