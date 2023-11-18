package com.ws.springbootinit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wsapi.common.model.entity.UserInterfaceInfo;


/**
* @author 26062
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2023-11-15 14:07:46
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {


    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean b);
    boolean invokeCount(long interfaceInfoId,long userId);
}
