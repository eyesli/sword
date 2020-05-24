package com.lideng.sword.admin.model.request;

import lombok.Data;

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

    private String deptId;

    private String roleId;

}