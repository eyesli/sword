package com.lideng.sword.admin.model.request;

import lombok.Data;

import java.util.List;

/**
 * @author lideng
 * @date 2019/10/08
 */
@Data
public class SysDeptCreateDTO   {

    private String name;

    private String parentId;

    private Integer orderNum;

}