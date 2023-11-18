package com.ws.springbootinit.model.dto.interfaceInfo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 编辑请求
 *
 * @author <a href="https://github.com/xixi-box">西西盒子</a>
 * @from 
 */
@Data
public class InterfaceInfoEditRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;
    /**
     * 请求参数
     */
    private String requestParams;
    /**
     * 标签列表
     */
    private List<String> tags;

    private static final long serialVersionUID = 1L;
}