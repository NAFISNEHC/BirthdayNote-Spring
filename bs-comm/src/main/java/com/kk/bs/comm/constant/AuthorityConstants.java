/**
 * Copyright (C), 2015-2019, 知融科技服务有限公司
 * FileName: AuthorityConstants
 * Author:   Zeling
 * Date:     2019/1/29 16:58
 * Description: 权限的常亮
 */
package com.kk.bs.comm.constant;

/**
 * 〈一句话功能简述〉<br> 
 * 〈权限的常亮〉
 *
 * @author Zeling
 * @date 2019/1/29
 * @since 1.0.0
 */
public class AuthorityConstants {

    /**
     * 管理员权限
     */
    public static final String ADMIN_PRODUCT = "system.user";

    /**
     * 普通用户权限
     */
    public static final String COMMON_PRODUCT = "common.user";

    /**
     * 游客权限
     */
    public static final String ZGBM_PRODUCT = "visitor.user";

    /**
     * 全部权限
     */
    public static final String[] ALL_PRODUCT_LIST = {ADMIN_PRODUCT};

    /**
     * Redis中保存的token
     */
    public static final String TOKEN_STR = "TheLing-Token";

    /**
     * jwt生成的token
     */
    public static final String JWT_TOKEN_STR = "";
}
