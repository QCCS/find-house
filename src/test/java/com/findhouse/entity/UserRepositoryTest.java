package com.findhouse.entity;

import com.findhouse.ApplicationTests;
import com.findhouse.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

//  findOne(…) -> findById(…).get()
//  save(Iterable) -> saveAll(Iterable).get()
//  findAll(Iterable<ID>) -> findAllById(…).get()
//  delete(ID) -> deleteById(ID).get()
//  delete(Iterable<T>) -> deleteAll(Iterable<T>).get()
//  exists() -> existsById(…).get()
public class UserRepositoryTest extends ApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne() {
        //这种测试是直接使用的mysql数据库，注意测试最好配置为h2内存数据库
        User user = userRepository.findById(1L).get();
        Assert.assertEquals("json", user.getName());
    }
}
