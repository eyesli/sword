package com.lideng.sword.admin.model.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 *
 * @author lideng
 * @date 2019/10/09
 */
@Data
public class SysUserUpdateDTO {

    private String id;

    private String name;

    private String nickName;

    private String avatar;

    private String password;

    private String email;

    private String mobile;

    private Boolean status;

    @NotEmpty(message = "部门名称不能为空")
    private String deptId;

    @NotEmpty(message = "角色名称不能为空")
    private String roleId;

}