//package com.gpdi.config.shiro;
//import com.gpdi.common.respone.OAuth2Token;
//import com.gpdi.entity.system.SysUser;
//import com.gpdi.entity.system.SysUserToken;
//import com.gpdi.service.system.SysUserService;
//import com.gpdi.service.system.SysUserTokenService;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import java.util.Set;
//@Component
//public class OAuth2Realm extends AuthorizingRealm {
//
//    @Autowired
//    private SysUserService sysUserService;
//    @Autowired
//    private SysUserTokenService sysUserTokenService;
//
//    @Override
//    public boolean supports(AuthenticationToken token) {
//        return token instanceof OAuth2Token;
//    }
//
//    /**
//     * 授权(验证权限时调用)
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
//        Integer userId = sysUser.getId();
//        //用户权限列表
//        Set<String> permsSet = sysUserService.queryUserPerms(userId);
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.setStringPermissions(permsSet);
//        return info;
//    }
//
//    /**
//     * 认证(登录时调用)
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        String accessToken = (String) token.getPrincipal();
//        //根据accessToken，查询用户信息
//        SysUserToken tokenEntity = sysUserTokenService.queryByToken(accessToken);
//        //token失效
//        if (tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()) {
//            throw new IncorrectCredentialsException("token失效，请重新登录");
//        }
//        //查询用户信息
//        SysUser sysUser = sysUserService.getById(tokenEntity.getUserId());
//        return new SimpleAuthenticationInfo(sysUser, accessToken, getName());
//    }
//}
