package com.birdben.log.service;

import com.birdben.log.annotation.Log;
import com.birdben.log.annotation.LogParam;
import com.birdben.log.bean.UserInfo;
import com.birdben.log.handler.UserServiceLogHandler;
import com.birdben.log.springaop.LogAopWithPointcut;
import org.springframework.stereotype.Service;

/**
 * @author birdben
 * @version V1.0
 * @name UserServiceImpl
 * @description 用户业务实现类
 * @github https://github.com/birdben
 * @date 16/7/23 下午3:19
 */
@Service
public class UserServiceImpl implements IUserService {

    /******************************************************** 测试正常情况开始 **********************************************************/
    @Log(message = "UserServiceImpl自己当做LogHandler来处理多参数", method = "handlerUserServiceLogInThisClassWithMultipleParam")
    public void saveHandlerLogInThisClassWithMultipleParam(@LogParam("user") UserInfo user) {
        System.out.println("UserServiceImpl自己当做LogHandler来处理多参数 name:" + user.getName());
        System.out.println("UserServiceImpl自己当做LogHandler来处理多参数 age:" + user.getAge());
        System.out.println("UserServiceImpl自己当做LogHandler来处理多参数 job:" + user.getJob());
        System.out.println("UserServiceImpl自己当做LogHandler来处理多参数 website:" + user.getWebsite());
    }

    @Log(message = "UserServiceImpl自己当做LogHandler来处理Map参数", method = "handlerUserServiceLogInThisClassWithMapParam")
    public void saveHandlerLogInThisClassWithMapParam(@LogParam("user") UserInfo user) {
        System.out.println("UserServiceImpl自己当做LogHandler来处理Map参数 name:" + user.getName());
        System.out.println("UserServiceImpl自己当做LogHandler来处理Map参数 age:" + user.getAge());
        System.out.println("UserServiceImpl自己当做LogHandler来处理Map参数 job:" + user.getJob());
        System.out.println("UserServiceImpl自己当做LogHandler来处理Map参数 website:" + user.getWebsite());
    }

    @Log(message = "使用UserServiceLogHandler当做LogHandler来处理多参数", handler = UserServiceLogHandler.class, method = "handlerUserServiceLogWithMultipleParam")
    public void saveHandlerLogWithMultipleParam(@LogParam("user") UserInfo user) {
        System.out.println("使用UserServiceLogHandler当做LogHandler来处理多参数 name:" + user.getName());
        System.out.println("使用UserServiceLogHandler当做LogHandler来处理多参数 age:" + user.getAge());
        System.out.println("使用UserServiceLogHandler当做LogHandler来处理多参数 job:" + user.getJob());
        System.out.println("使用UserServiceLogHandler当做LogHandler来处理多参数 website:" + user.getWebsite());
    }

    @Log(message = "使用UserServiceLogHandler当做LogHandler来处理Map参数", handler = UserServiceLogHandler.class, method = "handlerUserServiceLogWithMapParam")
    public void saveHandlerLogWithMapParam(@LogParam("user") UserInfo user) {
        System.out.println("使用UserServiceLogHandler当做LogHandler来处理Map参数 name:" + user.getName());
        System.out.println("使用UserServiceLogHandler当做LogHandler来处理Map参数 age:" + user.getAge());
        System.out.println("使用UserServiceLogHandler当做LogHandler来处理Map参数 job:" + user.getJob());
        System.out.println("使用UserServiceLogHandler当做LogHandler来处理Map参数 website:" + user.getWebsite());
    }
    /******************************************************** 测试正常情况结束 **********************************************************/

    /******************************************************** 测试异常情况开始 **********************************************************/
    @Log(message = "LogHandler没有找到同名的方法", method = "handlerUserServiceLogInThisClassMethodNotFound")
    public void saveHandlerLogInThisClassMethodNotFound(@LogParam("user") UserInfo user) {
        System.out.println("LogHandler没有找到同名的方法 name:" + user.getName());
        System.out.println("LogHandler没有找到同名的方法 age:" + user.getAge());
        System.out.println("LogHandler没有找到同名的方法 job:" + user.getJob());
        System.out.println("LogHandler没有找到同名的方法 website:" + user.getWebsite());
    }

    @Log(message = "LogHandler找到同名的方法,但是方法参数不匹配", method = "handlerUserServiceLogInThisClassMethodParamNotMatch")
    public void saveHandlerLogInThisClassMethodParamNotMatch(@LogParam("user") UserInfo user) {
        System.out.println("LogHandler找到同名的方法,但是方法参数不匹配 name:" + user.getName());
        System.out.println("LogHandler找到同名的方法,但是方法参数不匹配 age:" + user.getAge());
        System.out.println("LogHandler找到同名的方法,但是方法参数不匹配 job:" + user.getJob());
        System.out.println("LogHandler找到同名的方法,但是方法参数不匹配 website:" + user.getWebsite());
    }
    /******************************************************** 测试异常情况结束 **********************************************************/

    /******************************************************** UserServiceImpl自己当成LogHandler的处理方法开始 **********************************************************/
    public void handlerUserServiceLogInThisClassWithMultipleParam(UserInfo user) {
        System.out.println("========================handlerUserServiceLogInThisClassWithMultipleParam用户自定义格式开始============================");
        System.out.println("name:" + user.getName());
        System.out.println("age:" + user.getAge());
        System.out.println("job:" + user.getJob());
        System.out.println("website:" + user.getWebsite());
        System.out.println("========================handlerUserServiceLogInThisClassWithMultipleParam用户自定义格式结束============================");
    }

    public void handlerUserServiceLogInThisClassWithMapParam(Object parameterObject) {
        System.out.println("========================handlerUserServiceLogInThisClassWithMapParam用户自定义格式开始============================");
        Class<?> parameterType = parameterObject == null ? Object.class : parameterObject.getClass();
        if (parameterType == LogAopWithPointcut.ParamMap.class) {
            LogAopWithPointcut.ParamMap paramMap = (LogAopWithPointcut.ParamMap) parameterObject;
            UserInfo user = (UserInfo) paramMap.get("user");

            System.out.println("name:" + user.getName());
            System.out.println("age:" + user.getAge());
            System.out.println("job:" + user.getJob());
            System.out.println("website:" + user.getWebsite());
        }
        System.out.println("========================handlerUserServiceLogInThisClassWithMapParam用户自定义格式结束============================");
    }

    public void handlerUserServiceLogInThisClassMethodParamNotMatch(String name) {
        System.out.println("========================handlerUserServiceLogInThisClassMethodParamNotMatch用户自定义格式开始============================");
        System.out.println("name:" + name);
        System.out.println("========================handlerUserServiceLogInThisClassMethodParamNotMatch用户自定义格式结束============================");
    }
    /******************************************************** UserServiceImpl自己当成LogHandler的处理方法结束 **********************************************************/

}