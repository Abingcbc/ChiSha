/*
 * This file was automatically generated by EvoSuite
 * Thu Dec 26 02:57:07 GMT 2019
 */

package org.sse.userservice.controller;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.javaee.injection.Injector;
import org.junit.runner.RunWith;
import org.sse.userservice.controller.UserController;
import org.sse.userservice.model.Result;
import org.sse.userservice.model.User;
import org.sse.userservice.service.UserService;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class UserController_ESTest extends UserController_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      UserController userController0 = new UserController();
      UserService userService0 = mock(UserService.class, new ViolatedAssumptionAnswer());
      doReturn((User) null).when(userService0).getUserInfoWithoutPassword(anyString());
      Injector.inject(userController0, (Class<?>) UserController.class, "userService", (Object) userService0);
      Injector.validateBean(userController0, (Class<?>) UserController.class);
      User user0 = userController0.getUserInfoWithoutPassword("<8@bM=J 2/FNp7 3");
      assertNull(user0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      UserController userController0 = new UserController();
      UserService userService0 = mock(UserService.class, new ViolatedAssumptionAnswer());
      doReturn((Result) null).when(userService0).register(any(org.sse.userservice.model.User.class));
      Injector.inject(userController0, (Class<?>) UserController.class, "userService", (Object) userService0);
      Injector.validateBean(userController0, (Class<?>) UserController.class);
      Result result0 = userController0.createNewUser((User) null);
      assertNull(result0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      UserController userController0 = new UserController();
      UserService userService0 = mock(UserService.class, new ViolatedAssumptionAnswer());
      doReturn((Result) null).when(userService0).login(any(org.sse.userservice.model.User.class));
      Injector.inject(userController0, (Class<?>) UserController.class, "userService", (Object) userService0);
      Injector.validateBean(userController0, (Class<?>) UserController.class);
      Result result0 = userController0.login((User) null);
      assertNull(result0);
  }
}