/**
 * Copyright (C), 2015-2019, 知融科技服务有限公司
 * FileName: IOptions2
 * Author:   56969
 * Date:     2019/10/12 14:50
 * Description: 由id和text组成的选项
 */
package com.kk.bs.comm.vo.data;

import lombok.Data;

/**
 * 〈一句话功能简述〉<br> 
 * 〈由id和text组成的选项〉
 *
 * @author 56969
 * @create 2019/10/12
 * @since 1.0.0
 */
@Data
public class IOptions2 {
    private String text;
    private String id;

    public IOptions2(String id, String text){
        this.id = id;
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
