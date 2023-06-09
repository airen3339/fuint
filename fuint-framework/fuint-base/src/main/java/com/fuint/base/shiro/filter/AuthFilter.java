package com.fuint.base.shiro.filter;

import com.google.code.kaptcha.Constants;
import com.fuint.base.shiro.CaptchaUsernamePasswordToken;
import com.fuint.base.shiro.exception.IncorrectCaptchaException;
import com.fuint.util.RSAKeys;
import com.fuint.util.RSAUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 身份认证过滤器
 *
 * Created by FSQ
 * Contact wx fsq_better
 */
public class AuthFilter extends FormAuthenticationFilter {

    private String captchaParam = DEFAULT_CAPTCHA_PARAM;

    private static final Logger logger = LoggerFactory.getLogger(FormAuthenticationFilter.class);

    public static final String DEFAULT_CAPTCHA_PARAM = "captcha";

    public String getCaptchaParam() {
        return this.captchaParam;
    }

    protected String getCaptcha(ServletRequest request) {
        return WebUtils.getCleanParam(request, this.getCaptchaParam());
    }

    // 创建Token
    @Override
    protected CaptchaUsernamePasswordToken createToken(ServletRequest request, ServletResponse response) {
        String username = getUsername(request);
        String password = getPassword(request);
        //RSA密码解密
        password = RSAUtil.decryptByPrivateKey(password, RSAKeys.PRIVATE_KEY);
        String captcha = getCaptcha(request);
        boolean rememberMe = isRememberMe(request);
        return new CaptchaUsernamePasswordToken(username, password, rememberMe, captcha);
    }

    // 认证
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        CaptchaUsernamePasswordToken token = createToken(request, response);

        try {
            doCaptchaValidate((HttpServletRequest) request, token);
            Subject subject = getSubject(request, response);
            subject.login(token);
            return onLoginSuccess(token, subject, request, response);
        } catch (AuthenticationException e) {
            return onLoginFailure(token, e, request, response);
        }
    }

    // 验证码校验
    protected void doCaptchaValidate(HttpServletRequest request, CaptchaUsernamePasswordToken token) {
        String captcha = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (captcha != null && !captcha.equalsIgnoreCase(token.getCaptcha())) {
            throw new IncorrectCaptchaException("验证码错误！");
        }
    }
}
