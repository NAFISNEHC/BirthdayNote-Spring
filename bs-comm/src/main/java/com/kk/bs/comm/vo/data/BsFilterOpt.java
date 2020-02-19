/**
 * Copyright (C), 2015-2019, 知融科技服务有限公司
 * FileName: BsFilterOpt
 * Author:   56969
 * Date:     2019/10/12 15:01
 * Description: 经营范围条目的筛选项
 */
package com.kk.bs.comm.vo.data;

import lombok.Data;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈筛选项〉
 *
 * @author 56969
 * @create 2019/10/12
 * @since 1.0.0
 */
@Data
public class BsFilterOpt {
    private String name;
    private String type;
    private List<IOptions1> opts;

    public BsFilterOpt(String name, String type, List<IOptions1> opts){
        this.name = name;
        this.type = type;
        this.opts = opts;
    }
}
