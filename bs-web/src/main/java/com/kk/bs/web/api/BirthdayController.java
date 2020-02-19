package com.kk.bs.web.master;

import com.kk.bs.comm.vo.search.BaseFilter;
import com.kk.bs.entity.master.SendLog;
import com.kk.bs.service.master.BnUserService;
import com.kk.bs.entity.master.BnUser;
import com.kk.bs.service.master.SendLogService;
import com.kk.common.utils.HttpRequest;
import com.kk.common.utils.Result;

import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;

import javax.annotation.Resource;


/**
 *  前端控制器
 *
 * @author allahbin
 * @since 2019-10-14
 */
@RestController
@RequestMapping("/api/user")
public class BirthdayController {

    @Resource
    private BnUserService bnUserService;

    @Resource
    private SendLogService sendLogService;

    @PostMapping(value = "list")
    public Result list(@RequestBody BaseFilter baseFilter){
        return Result.ok(bnUserService.selectPageByParams(baseFilter));
    }

    @PostMapping(value = "info")
    public Result info(String policyId){
        return Result.ok(bnUserService.getById(policyId));
    }

    /**
     * 删除
     * @params primaryKey 主键
     */
    @PostMapping(value = "delete")
    public Result delete(String primaryKey){
        if(bnUserService.deleteBnUser(primaryKey)){
            return Result.ok();
        }else{
            return Result.error("删除失败");
        }
    }

    @PostMapping(value = "update")
    public Result delete(@RequestBody BnUser bnUser){
        if(bnUserService.updateBnUser(bnUser)){
            return Result.ok();
        }else{
            return Result.error("更新失败");
        }
    }

    @PostMapping(value = "install")
    public Result install(@RequestBody BnUser bnUser){
        if(bnUserService.save(bnUser)){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

//    @PostMapping(value = "insert")
//    public Result insert(@RequestBody SendLog sendLog){
//        if(sendLogService.save(sendLog)){
//            return Result.ok();
//        }else {
//            return Result.error();
//        }
//    }
}
