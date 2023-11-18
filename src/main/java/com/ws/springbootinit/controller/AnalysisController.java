package com.ws.springbootinit.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ws.springbootinit.annotation.AuthCheck;
import com.ws.springbootinit.common.BaseResponse;
import com.ws.springbootinit.common.ErrorCode;
import com.ws.springbootinit.common.ResultUtils;
import com.ws.springbootinit.exception.BusinessException;
import com.ws.springbootinit.mapper.UserInterfaceInfoMapper;
import com.ws.springbootinit.model.vo.InterfaceInfoVO;
import com.ws.springbootinit.service.InterfaceInfoService;
import com.wsapi.common.model.entity.InterfaceInfo;
import com.wsapi.common.model.entity.UserInterfaceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xixibox
 * @version 1.0
 * @date 2023/11/18 16:07
 */

@Slf4j
@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Resource
    private InterfaceInfoService interfaceInfoService;

        /**
     * 获取调用次数最多的接口信息
     * @return 接口信息列表
     */
    @GetMapping("/top/interface/invoke")
    @AuthCheck(mustRole = "admin")
    public BaseResponse<List<InterfaceInfoVO>> listTopInvokeInterfaceInfo() {
        // 获取调用次数最多的3个接口的用户接口信息列表
        List<UserInterfaceInfo> userInterfaceInfoList = userInterfaceInfoMapper.listTopInvokeInterfaceInfo(3);

        // 根据接口信息ID分组，得到接口信息ID和用户接口信息对象的关系映射
        Map<Long, List<UserInterfaceInfo>> interfaceInfoIdObjMap = userInterfaceInfoList.stream()
                .collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));

        // 构建查询条件，查询ID在接口信息ID集合中的接口信息
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", interfaceInfoIdObjMap.keySet());

        // 获取接口信息列表
        List<InterfaceInfo> list = interfaceInfoService.list(queryWrapper);

        // 如果接口信息列表为空，则抛出业务异常
        if (CollectionUtils.isEmpty(list)) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }

        // 遍历接口信息列表，创建并返回接口信息视图对象列表
        List<InterfaceInfoVO> interfaceInfoVOList = list.stream().map(interfaceInfo -> {
            InterfaceInfoVO interfaceInfoVO = new InterfaceInfoVO();
            BeanUtils.copyProperties(interfaceInfo, interfaceInfoVO);

            // 获取对应接口信息ID的用户接口信息对象集合并取第一个对象的总调用次数，赋值给总调用次数字段
            int totalNum = interfaceInfoIdObjMap.get(interfaceInfo.getId()).get(0).getTotalNum();
            interfaceInfoVO.setTotalNum(totalNum);

            return interfaceInfoVO;
        }).collect(Collectors.toList());

        // 返回成功，并携带接口信息视图对象列表
        return ResultUtils.success(interfaceInfoVOList);
    }

}
