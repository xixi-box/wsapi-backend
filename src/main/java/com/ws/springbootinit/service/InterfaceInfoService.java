package com.ws.springbootinit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wsapi.common.model.entity.InterfaceInfo;


/**
* @author 26062
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-11-10 16:37:55
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    /**
     * 校验
     *
     * @param interfaceInfo
     * @param add
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

    /**
     * 获取查询条件
     *
     * @param postQueryRequest
     * @return
     */
}
