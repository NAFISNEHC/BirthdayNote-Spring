package com.kk.bs.comm.vo.search;
/**
 * Copyright 2019 bejson.com
 */
import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2019-08-22 20:19:5
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class NlpRootBean {
    private long log_id;
    private String text;
    private List<NlpItems> items;
}