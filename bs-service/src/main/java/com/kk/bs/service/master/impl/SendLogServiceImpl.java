package com.kk.bs.service.master.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.kk.bs.entity.master.SendLog;
import com.kk.bs.mapper.master.SendLogMapper;
import com.kk.bs.service.master.SendLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.alibaba.fastjson.JSONObject;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author allahbin
 * @since 2019-10-14
 */
@Service
@DS("master")
public class SendLogServiceImpl extends ServiceImpl<SendLogMapper, SendLog> implements SendLogService {

    @Resource
    public SendLogMapper sendLogMapper;


    /**
     * 说明：按照条件进行查询，如果带页码就进行分页查询
     * @author allahbin
     * @date ${datetime}
     */
    @Override
    public List<Map<String, Object>>selectByParams(JSONObject jsonObject){
        // 判断是否分页
        if(jsonObject.get("pagenum")!=null){
            // 获取页码
            int pageNum=jsonObject.getInteger("pagenum");
            // 分页对象
            Page<Map<String, Object>> page=new Page<>(pageNum,10);
            // 分页查询
            return sendLogMapper.selectByParams(page,jsonObject);
        }else{
            // 不进行分页
            return sendLogMapper.selectByParams(jsonObject);
        }
    }

    /**
     * 说明：按照条件进行分页查询
     * @author allahbin
     * @date ${datetime}
     */
    @Override
    public Page selectPageByParams(JSONObject jsonObject){
        // 获取页码
        int pageNum=jsonObject.getInteger("pagenum");
        // 分页对象
        Page page=new Page(pageNum,10);
        // 分页查询
        return page.setRecords(sendLogMapper.selectByParams(page,jsonObject));
    }

    /**
    * 查询操作
    **/
    @Override
    public List<SendLog> query(SendLog sendLog){
        return sendLogMapper.query(sendLog);
    }

    @Override
    public Long queryTotal(){
        return sendLogMapper.queryTotal();
    }

    /**
    * 插入操作
    **/
    @Override
    public boolean insertSendLog(SendLog sendLog){
        // TODO 这里要补全前端没有传递的信息
        return this.save(sendLog);
    }

    /**
    * 更新操作
    **/
    @Override
    public boolean updateSendLog(SendLog sendLog){
        // TODO 这里要补全前端没有传递的信息
        return this.updateById(sendLog);
    }
    /**
    * 根据主键进行删除
    **/
    @Override
    public boolean deleteSendLog(String primaryKey){
        // TODO 这里要补全前端没有传递的信息
        return this.removeById(primaryKey);
    }
}
