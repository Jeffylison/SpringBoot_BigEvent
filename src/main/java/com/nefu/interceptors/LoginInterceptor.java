package com.nefu.interceptors;

import com.nefu.pojo.Result;
import com.nefu.utils.JwtUtil;
import com.nefu.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    private final StringRedisTemplate stringRedisTemplate;

    public LoginInterceptor(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //令牌验证
        String token = request.getHeader("Authorization");

//        System.out.println("JwtUtil.verifyToken:" + JwtUtil.verifyToken(token));
        System.out.println("JwtUtil");

        //验证token
        try {
            //从redis获取token
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            String redisToken = operations.get(token);
            if((redisToken == null) || (redisToken.length() == 0)){
                //token失效
                throw new RuntimeException();
            }

            Map<String ,Object> claims = JwtUtil.verifyToken(token);
//            System.out.println("claims:" + claims);
            //业务数据存储到线程池中
            ThreadLocalUtil.set(claims);

            //放行
            return true;
        } catch (Exception e) {
            System.out.println("this is jwt401");
            //http响应码401
            response.setStatus(401);
            //不放行
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清空线程数据
        ThreadLocalUtil.remove();
    }
}
