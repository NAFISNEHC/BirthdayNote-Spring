package com.kk.bs.comm.vo.search;
import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2019-08-22 20:19:5
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class NlpItems {
    private String formal;
    private List<String> loc_details;
    private String item;
    private String pos;
    private String ne;
    private List<String> basic_words;
    private int byte_length;
    private int byte_offset;
    private String uri;
}