package com.lushu.checksystem;


import com.lushu.checksystem.constant.DatabaseConstant;
import com.lushu.checksystem.constant.OtherConstant;
import com.lushu.checksystem.pojo.Inform;
import com.lushu.checksystem.service.InformService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author lushu
 * @date 19-11-11 下午10:07
 **/
class InformTest extends ChecksystemApplicationTests{

    @Autowired
    private InformService informService;
    @Value("${checksystem.root}")
    private String root;

    @Test
    void addInformTest(){
        List<Inform> informs = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++){
            Inform inform = new Inform();
            String tmpUsername = String.valueOf(random.nextInt(13)+1001);
            inform.setSendId(tmpUsername);
            inform.setContent("这是第"+(i+1)+"通知内容");
            inform.setDate(OtherConstant.DATE_FORMAT.format(new Date()));
            inform.setType(DatabaseConstant.Inform.COMPULSORY.getType());
            inform.setPath(root+"1001_测试教师"+"\\"+"实验一");
            informs.add(inform);
        }
        for (int i = 0; i < 20; i++){
            Inform inform = new Inform();
            String tmpUsername = String.valueOf(random.nextInt(13)+1001);
            inform.setSendId(tmpUsername);
            inform.setContent("这是第"+(i+1)+"通知内容");
            inform.setDate(OtherConstant.DATE_FORMAT.format(new Date()));
            inform.setType(DatabaseConstant.Inform.ELECTIVE.getType());
            inform.setPath(root+"1001_测试教师"+"\\"+"实验一");
            informs.add(inform);
        }
        informService.addInforms(informs);
    }

}
