package com.kk.bs.service.master.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.kk.bs.comm.vo.search.BaseFilter;
import com.kk.bs.entity.master.BnUser;
import com.kk.bs.mapper.master.BnUserMapper;
import com.kk.bs.service.master.BnUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.alibaba.fastjson.JSONObject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
public class BnUserServiceImpl extends ServiceImpl<BnUserMapper, BnUser> implements BnUserService {

    @Resource
    public BnUserMapper bnUserMapper;


    /**
     * 说明：按照条件进行查询，如果带页码就进行分页查询
     * @author allahbin
     * @date ${datetime}
     */
    @Override
    public List<Map<String, Object>>selectByParams(BaseFilter baseFilter){
        // 判断是否分页
        if(baseFilter.getPageNum()!=0){
            // 获取页码
            int pageNum=baseFilter.getPageNum();
            // 分页对象
            Page<Map<String, Object>> page=new Page<>(pageNum,10);
            // 分页查询
            return bnUserMapper.selectByParams(page, baseFilter);
        }else{
            // 不进行分页
            return bnUserMapper.selectByParams(baseFilter);
        }
    }

    /**
     * 说明：按照条件进行分页查询
     * @author allahbin
     * @date ${datetime}
     */
    @Override
    public Page selectPageByParams(BaseFilter baseFilter){
        // 获取页码
        int pageNum=baseFilter.getPageNum();
        // 分页对象
        Page<Map<String, Object>> page=new Page<Map<String, Object>>(pageNum,10);
        // 分页查询
        List<Map<String, Object>> list = bnUserMapper.selectByParams(page,baseFilter);
        return page.setRecords(list);
    }

    /**
    * 查询操作
    **/
    @Override
    public List<BnUser> query(BnUser bnUser){
        return bnUserMapper.query(bnUser);
    }

    @Override
    public Long queryTotal(){
        return bnUserMapper.queryTotal();
    }

    /**
    * 插入操作
    **/
    @Override
    public boolean insertBnUser(BnUser bnUser){
        // TODO 这里要补全前端没有传递的信息
        return this.save(bnUser);
    }

    /**
    * 更新操作
    **/
    @Override
    public boolean updateBnUser(BnUser bnUser){
        // TODO 这里要补全前端没有传递的信息
        return this.updateById(bnUser);
    }
    /**
    * 根据主键进行删除
    **/
    @Override
    public boolean deleteBnUser(String primaryKey){
        // TODO 这里要补全前端没有传递的信息
        return this.removeById(primaryKey);
    }
}
