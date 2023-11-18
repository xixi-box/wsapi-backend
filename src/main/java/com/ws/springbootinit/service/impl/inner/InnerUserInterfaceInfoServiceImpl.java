package com.ws.springbootinit.service.impl.inner;

import com.ws.springbootinit.service.UserInterfaceInfoService;
import com.wsapi.common.service.InnerUserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author xixibox
 * @version 1.0
 * @date 2023/11/18 14:02
 */
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {
    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    /**
     * @param userId
     * @param interfaceInfoId
     * @return
     */
    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }
}
