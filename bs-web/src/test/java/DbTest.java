/**
 * Copyright (C), 2015-2019, 知融科技服务有限公司
 * FileName: DbTest
 * Author:   56969
 * Date:     2019/10/9 15:09
 * Description: 数据库切换测试
 */

import com.kk.bs.entity.master.BnUser;
import com.kk.bs.service.master.BnUserService;
import com.kk.bs.web.AppApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static junit.framework.TestCase.assertNotNull;

/**
 * 〈一句话功能简述〉<br> 
 * 〈数据库切换测试〉
 *
 * @author 56969
 * @create 2019/10/9
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppApplication.class)
public class DbTest {

    @Resource
    BnUserService bnUserService;

    @Test
    public void getById(){
        BnUser bnUser = bnUserService.getById("013fe2b5093d4407b8545ce73ee09476");
        assertNotNull(bnUser);
    }
}
