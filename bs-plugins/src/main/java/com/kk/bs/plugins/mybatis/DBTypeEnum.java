package com.kk.bs.plugins.mybatis;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author allahbin
 * @create 2019/8/2
 * @since 1.0.0
 */
public enum DBTypeEnum {
    db1("master"), db2("minor");
    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
