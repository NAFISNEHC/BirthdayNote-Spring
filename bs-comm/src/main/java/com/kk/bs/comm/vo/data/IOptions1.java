/**
 * Copyright (C), 2015-2019, 知融科技服务有限公司
 * FileName: IOptions1
 * Author:   56969
 * Date:     2019/10/12 15:02
 * Description: 由id，text，num组成的
 */
package com.kk.bs.comm.vo.data;

import lombok.Data;

/**
 * 〈一句话功能简述〉<br> 
 * 〈由id，text，count组成的〉
 *
 * @author 56969
 * @create 2019/10/12
 * @since 1.0.0
 */
@Data
public class IOptions1 {
    private String id;
    private String text;
    private int count;

    public IOptions1(String id, String text, int count){
        this.id = id;
        this.text = text;
        this.count = count;
    }
}
