package com.kk.bs.service.master;

import com.kk.bs.comm.vo.search.BaseFilter;
import com.kk.bs.entity.master.BnUser;

import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * service层
 * @author allahbin
 * @since 2019-10-14
 */
@DS("master")
public interface BnUserService extends IService<BnUser>{

    /**
     * 说明：按照条件进行查询，如果带页码就进行分页查询
     * @author allahbin
     * @date ${datetime}
     */
    List<Map<String,Object>> selectByParams(BaseFilter baseFilter);

    /**
     * 说明：按照条件进行分页查询
     * @author allahbin
     * @date ${datetime}
     */
    Page selectPageByParams(BaseFilter baseFilter);

    /**
    * 查询操作
    * @author allahbin
    **/
    List<BnUser> query(BnUser bnUser);

    /**
    * 查询条数
    */
    Long queryTotal();

    /**
    * 删除
    * @param primaryKey 主键
    */
    boolean deleteBnUser(String primaryKey);

    /**
     * 新增操作
     * @param bnUser 新增的实体类
     */
    boolean insertBnUser(BnUser bnUser);

    /**
     * 更新操作
     * @param bnUser 更新的实体类
     */
    boolean updateBnUser(BnUser bnUser);

}
