package com.zfsapce.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author ZF
 * @description
 * @date 2018-06-08 11:41
 */
@Service
public class ScheduledService {

    /**
     * second 秒、minute 分、hour 时、day of month 日、month 月、day of week 周几
     */
    @Scheduled(cron = "0 * * * * MON-SAT")
    public void hello() {
        System.out.println("hello ...");
    }
}
