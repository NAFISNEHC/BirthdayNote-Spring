package com.kk.bs.mapper.master;

import com.kk.bs.comm.vo.search.BaseFilter;
import com.kk.bs.entity.master.BnUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;


/**
 * 的Mapper层
 *
 * @author allahbin
 * @since 2019-10-14
 */
@Repository
@Mapper
@DS("master")
public interface BnUserMapper extends BaseMapper<BnUser>{

    /**
    * 查询 不分页
    **/
    List<Map<String,Object>> selectByParams(BaseFilter baseFilter);

    /**
    * 查询 分页
    **/
    List<Map<String,Object>> selectByParams(Page page, @Param("params") BaseFilter baseFilter);

    List<BnUser> query(BnUser bnUser);

    Long queryTotal();

}