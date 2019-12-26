/*
 * This file was automatically generated by EvoSuite
 * Thu Dec 26 02:55:29 GMT 2019
 */

package org.sse.userservice.service;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.javaee.injection.Injector;
import org.junit.runner.RunWith;
import org.sse.userservice.mapper.UserMapper;
import org.sse.userservice.model.Result;
import org.sse.userservice.model.User;
import org.sse.userservice.service.UserService;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class UserService_ESTest extends UserService_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      UserService userService0 = new UserService();
      User user0 = mock(User.class, new ViolatedAssumptionAnswer());
      doReturn("$2a").when(user0).getPassword();
      doReturn((String) null).when(user0).getPhone();
      doReturn((String) null).when(user0).toString();
      User user1 = mock(User.class, new ViolatedAssumptionAnswer());
      UserMapper userMapper0 = mock(UserMapper.class, new ViolatedAssumptionAnswer());
      doReturn(user0, user1).when(userMapper0).getUserByEmail(anyString());
      Injector.inject(userService0, (Class<?>) UserService.class, "userMapper", (Object) userMapper0);
      Injector.validateBean(userService0, (Class<?>) UserService.class);
      User user2 = userService0.getUserInfoWithoutPassword("$uie74,S%`");
      // Undeclared exception!
      userService0.register(user2);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      UserService userService0 = new UserService();
      User user0 = mock(User.class, new ViolatedAssumptionAnswer());
      doReturn((String) null).when(user0).getPassword();
      doReturn("Register fail").when(user0).getPhone();
      doReturn("Register fail").when(user0).toString();
      User user1 = mock(User.class, new ViolatedAssumptionAnswer());
      doReturn((String) null).when(user1).getPassword();
      UserMapper userMapper0 = mock(UserMapper.class, new ViolatedAssumptionAnswer());
      doReturn(user0, user1).when(userMapper0).getUserByEmail(anyString());
      Injector.inject(userService0, (Class<?>) UserService.class, "userMapper", (Object) userMapper0);
      Injector.validateBean(userService0, (Class<?>) UserService.class);
      User user2 = userService0.getUserInfoWithoutPassword("(4XDF>Dfue-{N8ovLG");
      // Undeclared exception!
      try { 
        userService0.login(user2);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder", e);
      }
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      UserService userService0 = new UserService();
      UserMapper userMapper0 = mock(UserMapper.class, new ViolatedAssumptionAnswer());
      doReturn((User) null).when(userMapper0).getUserByEmail(anyString());
      Injector.inject(userService0, (Class<?>) UserService.class, "userMapper", (Object) userMapper0);
      Injector.validateBean(userService0, (Class<?>) UserService.class);
      // Undeclared exception!
      try { 
        userService0.getUserInfoWithoutPassword("kopO");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.sse.userservice.service.UserService", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      UserService userService0 = new UserService();
      User user0 = mock(User.class, new ViolatedAssumptionAnswer());
      doReturn("").when(user0).getPhone();
      doReturn("").when(user0).toString();
      User user1 = mock(User.class, new ViolatedAssumptionAnswer());
      UserMapper userMapper0 = mock(UserMapper.class, new ViolatedAssumptionAnswer());
      doReturn(user0, user1).when(userMapper0).getUserByEmail(anyString());
      Injector.inject(userService0, (Class<?>) UserService.class, "userMapper", (Object) userMapper0);
      Injector.validateBean(userService0, (Class<?>) UserService.class);
      User user2 = userService0.getUserInfoWithoutPassword("");
      Result result0 = userService0.register(user2);
      assertEquals("Phone registered", result0.getMsg());
      assertEquals(0, result0.getCode());
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      UserService userService0 = new UserService();
      User user0 = mock(User.class, new ViolatedAssumptionAnswer());
      doReturn("").when(user0).toString();
      User user1 = mock(User.class, new ViolatedAssumptionAnswer());
      doReturn((String) null).when(user1).getPassword();
      doReturn((String) null).when(user1).getPhone();
      doReturn((String) null).when(user1).toString();
      User user2 = mock(User.class, new ViolatedAssumptionAnswer());
      UserMapper userMapper0 = mock(UserMapper.class, new ViolatedAssumptionAnswer());
      doReturn(user0, user1, user2).when(userMapper0).getUserByEmail(anyString());
      Injector.inject(userService0, (Class<?>) UserService.class, "userMapper", (Object) userMapper0);
      Injector.validateBean(userService0, (Class<?>) UserService.class);
      userService0.getUserInfoWithoutPassword("");
      User user3 = userService0.getUserInfoWithoutPassword("");
      // Undeclared exception!
      try { 
        userService0.register(user3);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder", e);
      }
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      UserService userService0 = new UserService();
      User user0 = mock(User.class, new ViolatedAssumptionAnswer());
      doReturn("").when(user0).toString();
      User user1 = mock(User.class, new ViolatedAssumptionAnswer());
      doReturn((String) null).when(user1).getPhone();
      doReturn((String) null).when(user1).toString();
      User user2 = mock(User.class, new ViolatedAssumptionAnswer());
      UserMapper userMapper0 = mock(UserMapper.class, new ViolatedAssumptionAnswer());
      doReturn(user0, user1, user2).when(userMapper0).getUserByEmail(anyString());
      Injector.inject(userService0, (Class<?>) UserService.class, "userMapper", (Object) userMapper0);
      Injector.validateBean(userService0, (Class<?>) UserService.class);
      userService0.getUserInfoWithoutPassword("");
      User user3 = userService0.getUserInfoWithoutPassword("");
      Result result0 = userService0.login(user3);
      assertEquals(0, result0.getCode());
      assertEquals("No such user", result0.getMsg());
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      UserService userService0 = new UserService();
      User user0 = mock(User.class, new ViolatedAssumptionAnswer());
      doReturn("9g)?8BK6D`").when(user0).getPassword();
      doReturn("9g)?8BK6D`").when(user0).getPhone();
      doReturn("9g)?8BK6D`").when(user0).toString();
      User user1 = mock(User.class, new ViolatedAssumptionAnswer());
      doReturn((String) null).when(user1).getPassword();
      UserMapper userMapper0 = mock(UserMapper.class, new ViolatedAssumptionAnswer());
      doReturn(user0, user1).when(userMapper0).getUserByEmail(anyString());
      Injector.inject(userService0, (Class<?>) UserService.class, "userMapper", (Object) userMapper0);
      Injector.validateBean(userService0, (Class<?>) UserService.class);
      User user2 = userService0.getUserInfoWithoutPassword("9g)?8BK6D`");
      // Undeclared exception!
      userService0.login(user2);
  }
}