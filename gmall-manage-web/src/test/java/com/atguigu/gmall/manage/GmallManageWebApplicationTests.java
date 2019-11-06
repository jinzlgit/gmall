package com.atguigu.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
class GmallManageWebApplicationTests {

    @Test
    public void contextLoads() throws IOException, MyException {
        // 配置fdfs的全局连接地址
        String tracker = GmallManageWebApplicationTests.class.getResource("tracker.conf").getPath();// 获得配置文件的路径
        ClientGlobal.init(tracker);
        TrackerClient client = new TrackerClient();
        // 获得一个tracker Server的实例
        TrackerServer trackerServer = client.getConnection();

    }

}
