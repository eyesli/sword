package com.lideng.sword.admin.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lideng.sword.admin.model.entity.AccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.lideng.sword.admin.model.entity.SysUser;
import com.lideng.sword.admin.security.JwtAuthenticatioToken;
import com.lideng.sword.admin.service.SysUserService;
import com.lideng.sword.common.utils.PasswordUtils;
import com.lideng.sword.admin.util.SecurityUtils;
import com.lideng.sword.admin.vo.LoginBean;
import com.lideng.sword.common.utils.IOUtils;
import com.lideng.sword.core.http.HttpResult;

/**
 * 登录控制器
 * @author lideng
 * @date July 30, 2019
 */
@RestController
@RequestMapping("user")
public class SysLoginController {

	@Autowired
	private Producer producer;

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("captcha.jpg")
	public void captcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		// 生成文字验证码
		String text = producer.createText();
		// 生成图片验证码
		BufferedImage image = producer.createImage(text);
		// 保存到验证码到 session
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);	
		IOUtils.closeQuietly(out);
	}

	/**
	 * 登录接口
	 */
	@PostMapping(value = "/login")
	public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request)   {
		String username = loginBean.getUsername();
		String password = loginBean.getPassword();
		//String captcha = loginBean.getCaptcha();
		//这就是传说中的建造者模式？？？
		//LoginBean bean =LoginBean.builder().account("name").captcha("123").password("123").build();
		//System.out.println("qwer"+bean.toString());

		//request.getSession().setAttribute(USERNAME.getValue(), username);
		// 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
//		Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
//		if(kaptcha == null){
//			return HttpResult.error("验证码已失效");
//		}
//		if(!captcha.equals(kaptcha)){
//			return HttpResult.error("验证码不正确");
//		}
		// 用户信息
		SysUser user = sysUserService.findByName(username);
		// 账号不存在、密码错误
		if (user == null) {
			return HttpResult.error("账号不存在");
		}
		if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
			return HttpResult.error("密码不正确");
		}
		// 账号锁定
		if (AccountStatus.DISABLE.equals(user.getStatus())) {
			return HttpResult.error("账号已被锁定,请联系管理员");
		}
		// 系统登录认证
		JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
		token.setSysUser(user);
		return HttpResult.ok(token);
	}

}
