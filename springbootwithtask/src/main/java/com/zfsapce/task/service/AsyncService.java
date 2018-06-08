package com.zfsapce.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author ZF
 * @description
 * @date 2018-06-08 10:52
 */
@Service
public class AsyncService {

    /**
     * 异步任务
     */
    @Async
    public void hello() {
        try {
            Thread.sleep(300);
            System.out.println("数据处理中....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
