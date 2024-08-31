package org.lyflexi.proxy;


import org.junit.Test;
import org.lyflexi.proxy.dynamic_proxy_manual_file.mapper.UserMapper;
import org.lyflexi.proxy.dynamic_proxy_manual_file.proxy.ProxyFactory;

public class DynamicProxyManualFileTest {

    @Test
    public void proxyTest() throws Exception {
        UserMapper userMapper = ProxyFactory.newInstance(UserMapper.class);
        userMapper.getUserById(12);
    }
}
