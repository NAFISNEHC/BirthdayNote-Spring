package com.kk.bs.service.master;

import com.kk.bs.entity.master.BnUser;
import com.kk.bs.entity.master.SendLog;

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
public interface SendLogService extends IService<SendLog>{

    /**
     * 说明：按照条件进行查询，如果带页码就进行分页查询
     * @author allahbin
     * @date ${datetime}
     */
    List<Map<String,Object>> selectByParams(JSONObject jsonObject);

    /**
     * 说明：按照条件进行分页查询
     * @author allahbin
     * @date ${datetime}
     */
    Page selectPageByParams(JSONObject jsonObject);

    /**
    * 查询操作
    * @author allahbin
    **/
    List<SendLog> query(SendLog sendLog);

    /**
    * 查询条数
    */
    Long queryTotal();

    /**
    * 删除
    * @param primaryKey 主键
    */
    boolean deleteSendLog(String primaryKey);

    /**
     * 新增操作
     * @param sendLog 新增的实体类
     */
    boolean insertSendLog(SendLog sendLog);

    /**
     * 更新操作
     * @param sendLog 更新的实体类
     */
    boolean updateSendLog(SendLog sendLog);

}
