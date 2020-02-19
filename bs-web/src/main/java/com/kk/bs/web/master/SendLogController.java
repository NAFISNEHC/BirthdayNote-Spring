package com.kk.bs.web.master;

import com.kk.bs.service.master.SendLogService;
import com.kk.bs.entity.master.SendLog;
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
@RequestMapping("/sys/sendLog")
public class SendLogController {

    @Resource
    private SendLogService sendLogService;

    @PostMapping(value = "list")
    public Result list(@RequestBody JSONObject jsonObject){
        return Result.ok(sendLogService.selectPageByParams(jsonObject));
    }

    @PostMapping(value = "info")
    public Result info(String policyId){
        return Result.ok(sendLogService.getById(policyId));
    }

    /**
    * 删除
    * @params primaryKey 主键
    */
    @PostMapping(value = "delete")
    public Result delete(String primaryKey){
        if(sendLogService.deleteSendLog(primaryKey)){
            return Result.ok();
        }else{
            return Result.error("删除失败");
        }
    }

    @PostMapping(value = "update")
    public Result delete(@RequestBody SendLog sendLog){
        if(sendLogService.updateSendLog(sendLog)){
            return Result.ok();
        }else{
            return Result.error("更新失败");
        }
    }

    @PostMapping(value = "install")
    public Result install(@RequestBody SendLog sendLog){
        if(sendLogService.save(sendLog)){
            return Result.ok();
        }else {
            return Result.error();
        }
    }
}
