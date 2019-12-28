/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Thu Dec 26 02:55:29 GMT 2019
 */

package org.sse.userservice.service;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

import static org.evosuite.shaded.org.mockito.Mockito.*;
@EvoSuiteClassExclude
public class UserService_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "org.sse.userservice.service.UserService"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    try { initMocksToAvoidTimeoutsInTheTests(); } catch(ClassNotFoundException e) {} 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("file.encoding", "UTF-8"); 
    java.lang.System.setProperty("java.awt.headless", "true"); 
    java.lang.System.setProperty("java.io.tmpdir", "/var/folders/d3/k2gc1l3d2v56t6f1l9xsh6jm0000gn/T/"); 
    java.lang.System.setProperty("user.country", "CN"); 
    java.lang.System.setProperty("user.dir", "/Users/cbc/Project/Java/ChiSha/user-service"); 
    java.lang.System.setProperty("user.home", "/Users/cbc"); 
    java.lang.System.setProperty("user.language", "zh"); 
    java.lang.System.setProperty("user.name", "cbc"); 
    java.lang.System.setProperty("user.timezone", "Asia/Shanghai"); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(UserService_ESTest_scaffolding.class.getClassLoader() ,
      "org.sse.userservice.service.UserService",
      "org.sse.userservice.model.Result",
      "org.apache.ibatis.annotations.Select",
      "org.apache.ibatis.annotations.Param",
      "org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder",
      "org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder$BCryptVersion",
      "org.springframework.beans.factory.annotation.Autowired",
      "org.springframework.stereotype.Component",
      "org.springframework.security.crypto.password.PasswordEncoder",
      "org.sse.userservice.model.User",
      "org.springframework.transaction.annotation.Propagation",
      "org.springframework.stereotype.Service",
      "org.sse.userservice.mapper.UserMapper",
      "org.apache.ibatis.annotations.Mapper",
      "org.springframework.security.crypto.bcrypt.BCrypt",
      "org.springframework.stereotype.Indexed",
      "org.springframework.transaction.annotation.Isolation",
      "org.springframework.transaction.annotation.Transactional",
      "org.apache.ibatis.annotations.Insert"
    );
  } 
  private static void initMocksToAvoidTimeoutsInTheTests() throws ClassNotFoundException { 
    mock(Class.forName("org.sse.userservice.mapper.UserMapper", false, UserService_ESTest_scaffolding.class.getClassLoader()));
    mock(Class.forName("org.sse.userservice.model.User", false, UserService_ESTest_scaffolding.class.getClassLoader()));
  }

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(UserService_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "org.sse.userservice.service.UserService",
      "org.springframework.transaction.annotation.Propagation",
      "org.springframework.transaction.annotation.Isolation",
      "org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder",
      "org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder$BCryptVersion",
      "org.sse.userservice.model.User",
      "org.springframework.security.crypto.bcrypt.BCrypt",
      "org.sse.userservice.model.Result"
    );
  }
}
