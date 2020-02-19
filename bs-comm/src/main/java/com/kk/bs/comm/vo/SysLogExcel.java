/**
 * Copyright (C), 2015-2019, 知融科技服务有限公司
 * FileName: sysLogExcel
 * Author:   allahbin
 * Date:     2019/4/24 17:28
 * Description: 日志的excel导出对象
 */
package com.kk.bs.comm.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈日志的excel导出对象〉
 *
 * @author allahbin
 * @create 2019/4/24
 * @since 1.0.0
 */
@Data
public class SysLogExcel implements Serializable {

    @Excel(name = "日志的id", width = 50)
    private String logid;
    @Excel(name = "创建人id", width = 50)
    private String creuserid;
    @Excel(name = "创建人名称", width = 50)
    private String creusername;
    @Excel(name = "创建时间", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd", width = 20)
    private Date cretime;
    @Excel(name = "访问者id", width = 50)
    private String ip;
    @Excel(name = "访问的方式", width = 50)
    private String type;
    @Excel(name = "请求的地址", width = 50)
    private String url;
    @Excel(name = "备注", width = 50)
    private String remark;
    @Excel(name = "用户操作系统", width = 50)
    private String os;
    @Excel(name = "浏览器", width = 50)
    private String browser;
    /**
     * 传递的参数
     */
    @Excel(name = "传递的参数", width = 50)
    private String params;
    /**
     * 类方法
     */
    @Excel(name = "传递的参数", width = 50)
    private String classmethod;
}
