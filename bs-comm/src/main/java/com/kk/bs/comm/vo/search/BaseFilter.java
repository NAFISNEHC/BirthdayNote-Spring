/**
 * Copyright (C), 2015-2019, 知融科技服务有限公司
 * FileName: BaseFilter
 * Author:   56969
 * Date:     2019/10/11 15:44
 * Description: 基础的筛选数据
 */
package com.kk.bs.comm.vo.search;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 〈一句话功能简述〉<br> 
 * 〈基础的筛选数据 〉
 *
 * @author 56969
 * @create 2019/10/11
 * @since 1.0.0
 */
@Data
public class BaseFilter {
    /**
     * 开始时间
     */
    private LocalDateTime startDay;

    /**
     * 结束时间
     */
    private LocalDateTime endDay;

    /**
     * 页码
     */
    private int pageNum;

    /**
     * 关键词
     */
    private String keyword;
}
