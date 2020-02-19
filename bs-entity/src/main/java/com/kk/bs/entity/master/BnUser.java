package com.kk.bs.entity.master;


import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.time.LocalDate;

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
@TableName("bn_user")
public class BnUser extends Model<BnUser> implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 用户id
     */
    @TableId(value = "U_ID", type = IdType.UUID)
    @Excel(name = "用户id", width = 50)
    private String uId;

    /**
     * 用户名称
     */
    @TableField("USER_NAME")
    @Excel(name = "用户名称", width = 50)
    private String userName;

    /**
     * 性别
     */
    @TableField("SEX")
    @Excel(name = "性别", width = 50)
    private Boolean sex;

    /**
     * 电话
     */
    @TableField("PHONE")
    @Excel(name = "电话", width = 50)
    private String phone;

    @TableField("BIRTHDAY")
    @Excel(name = "生日", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd", width = 20)
    private LocalDate BIRTHDAY;

    @Override
    protected Serializable pkVal() {
        return this.uId;
    }

}
