package com.ws.springbootinit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsapi.common.model.entity.UserInterfaceInfo;

import java.util.List;


/**
* @author 26062
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
* @createDate 2023-11-15 14:07:46
* @Entity generator.domain.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int i);

}




