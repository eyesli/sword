package com.lideng.sword.admin.vo;

import lombok.Builder;
import lombok.Data;

/**
 * 登录接口封装对象
 * @author lideng
 * @date Oct 29, 2018
 */
@Builder
@Data

public class LoginBean {

	private String username;
	private String password;
	//private String captcha;
}
