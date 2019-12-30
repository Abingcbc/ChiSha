/*
 * This file was automatically generated by EvoSuite
 * Thu Dec 26 02:54:19 GMT 2019
 */

package org.sse.userservice.model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import org.sse.userservice.model.Result;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Result_ESTest extends Result_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Result result0 = new Result(0, "org.sse.userservice.model.Result");
      Result result1 = new Result(1709, "org.sse.userservice.model.Result");
      boolean boolean0 = result0.equals(result1);
      assertEquals(1709, result1.getCode());
      assertFalse(result1.equals((Object)result0));
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Result result0 = new Result((-806), "");
      result0.setMsg("hl!@VW]1+y");
      result0.getMsg();
      assertEquals((-806), result0.getCode());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Result result0 = new Result((-1423), "");
      result0.getMsg();
      assertEquals((-1423), result0.getCode());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Result result0 = new Result(0, "org.sse.userservice.model.Result");
      int int0 = result0.getCode();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Result result0 = new Result((-2248), "^LFW4aQ%I,XSWc|YN");
      result0.setCode(1);
      int int0 = result0.getCode();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Result result0 = new Result((-2297), "");
      result0.canEqual(result0);
      assertEquals((-2297), result0.getCode());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Result result0 = new Result((-866), (String) null);
      result0.getMsg();
      assertEquals((-866), result0.getCode());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Result result0 = new Result((-2248), "^LFW4aQ%I,XSWc|YN");
      int int0 = result0.getCode();
      assertEquals((-2248), int0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Result result0 = new Result((-2849), "org.sse.userservice.model.Result");
      Result result1 = new Result((-2849), "org.sse.userservice.model.Result");
      boolean boolean0 = result0.equals(result1);
      assertTrue(boolean0);
      assertEquals((-2849), result1.getCode());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Result result0 = new Result(0, "Uf");
      result0.setMsg((String) null);
      Result result1 = new Result(0, "Uf");
      boolean boolean0 = result0.equals(result1);
      assertEquals(0, result1.getCode());
      assertFalse(result1.equals((Object)result0));
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Result result0 = new Result(3, "Gf3'By%bwaA>XwwX");
      boolean boolean0 = result0.equals("Gf3'By%bwaA>XwwX");
      assertFalse(boolean0);
      assertEquals(3, result0.getCode());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Result result0 = new Result((-2248), "^LFW4aQ%I,XSWc|YN");
      boolean boolean0 = result0.equals(result0);
      assertTrue(boolean0);
      assertEquals((-2248), result0.getCode());
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Result result0 = new Result(3, "Gf3'By%bwaA>XwwX");
      Result result1 = new Result(3, "Result(code=3, msg=Gf3'By%bwaA>XwwX)");
      boolean boolean0 = result0.equals(result1);
      assertFalse(boolean0);
      assertEquals(3, result1.getCode());
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Result result0 = new Result(3, "Gf3'By%bwaA>XwwX");
      result0.hashCode();
      assertEquals(3, result0.getCode());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Result result0 = new Result((-2248), "^LFW4aQ%I,XSWc|YN");
      result0.setCode(1);
      result0.setMsg((String) null);
      Result result1 = new Result(1, (String) null);
      boolean boolean0 = result0.equals(result1);
      assertEquals(1, result0.getCode());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Result result0 = new Result((-2248), "^LFW4aQ%I,XSWc|YN");
      result0.canEqual("^LFW4aQ%I,XSWc|YN");
      assertEquals((-2248), result0.getCode());
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Result result0 = new Result((-2248), "^LFW4aQ%I,XSWc|YN");
      result0.setMsg((String) null);
      result0.hashCode();
      assertEquals((-2248), result0.getCode());
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Result result0 = new Result((-2248), "^LFW4aQ%I,XSWc|YN");
      String string0 = result0.toString();
      assertEquals("Result(code=-2248, msg=^LFW4aQ%I,XSWc|YN)", string0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Result result0 = new Result((-1423), "");
      Result result1 = new Result((-1423), "");
      result0.setCode((-168));
      boolean boolean0 = result0.equals(result1);
      assertEquals((-168), result0.getCode());
      assertFalse(boolean0);
  }
}
