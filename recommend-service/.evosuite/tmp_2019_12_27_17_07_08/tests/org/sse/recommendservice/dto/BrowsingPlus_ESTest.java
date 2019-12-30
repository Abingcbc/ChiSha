/*
 * This file was automatically generated by EvoSuite
 * Fri Dec 27 09:10:05 GMT 2019
 */

package org.sse.recommendservice.dto;

import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import org.sse.recommendservice.dto.BrowsingPlus;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class BrowsingPlus_ESTest extends BrowsingPlus_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setRecipeId((-1060L));
      browsingPlus0.hashCode();
      assertEquals((-1060L), browsingPlus0.getRecipeId());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setBornPlace((-1267L));
      browsingPlus0.hashCode();
      assertEquals((-1267L), browsingPlus0.getBornPlace());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setAge((-1848L));
      browsingPlus0.hashCode();
      assertEquals((-1848L), browsingPlus0.getAge());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setGender((-1L));
      browsingPlus0.hashCode();
      assertEquals((-1L), browsingPlus0.getGender());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setGender(941L);
      browsingPlus0.hashCode();
      assertEquals(941L, browsingPlus0.getGender());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setUserId((-1915L));
      browsingPlus0.hashCode();
      assertEquals((-1915L), browsingPlus0.getUserId());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setRecipeId((-401L));
      BrowsingPlus browsingPlus1 = new BrowsingPlus();
      boolean boolean0 = browsingPlus0.equals(browsingPlus1);
      assertEquals((-401L), browsingPlus0.getRecipeId());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      BrowsingPlus browsingPlus1 = new BrowsingPlus();
      browsingPlus1.setBornPlace((-2623L));
      boolean boolean0 = browsingPlus0.equals(browsingPlus1);
      assertEquals((-2623L), browsingPlus1.getBornPlace());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      BrowsingPlus browsingPlus1 = new BrowsingPlus();
      browsingPlus0.setAge(2821L);
      boolean boolean0 = browsingPlus0.equals(browsingPlus1);
      assertEquals(2821L, browsingPlus0.getAge());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setGender(1421L);
      BrowsingPlus browsingPlus1 = new BrowsingPlus();
      boolean boolean0 = browsingPlus0.equals(browsingPlus1);
      assertEquals(1421L, browsingPlus0.getGender());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setUserId(5680L);
      BrowsingPlus browsingPlus1 = new BrowsingPlus();
      boolean boolean0 = browsingPlus1.equals(browsingPlus0);
      assertEquals(5680L, browsingPlus0.getUserId());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      boolean boolean0 = browsingPlus0.equals(browsingPlus0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setUserId(5680L);
      long long0 = browsingPlus0.getUserId();
      assertEquals(5680L, long0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setUserId((-1915L));
      long long0 = browsingPlus0.getUserId();
      assertEquals((-1915L), long0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setRecipeId(2135L);
      long long0 = browsingPlus0.getRecipeId();
      assertEquals(2135L, long0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setRecipeId((-826L));
      long long0 = browsingPlus0.getRecipeId();
      assertEquals((-826L), long0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setGender(5680L);
      long long0 = browsingPlus0.getGender();
      assertEquals(5680L, long0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setGender((-1915L));
      long long0 = browsingPlus0.getGender();
      assertEquals((-1915L), long0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setBornPlace(1983L);
      long long0 = browsingPlus0.getBornPlace();
      assertEquals(1983L, long0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setBornPlace((-2623L));
      long long0 = browsingPlus0.getBornPlace();
      assertEquals((-2623L), long0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setAge(1L);
      long long0 = browsingPlus0.getAge();
      assertEquals(1L, long0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      browsingPlus0.setAge((-209L));
      long long0 = browsingPlus0.getAge();
      assertEquals((-209L), long0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      boolean boolean0 = browsingPlus0.canEqual(browsingPlus0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      Object object0 = new Object();
      boolean boolean0 = browsingPlus0.canEqual(object0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      long long0 = browsingPlus0.getGender();
      assertEquals(0L, long0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      long long0 = browsingPlus0.getAge();
      assertEquals(0L, long0);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      long long0 = browsingPlus0.getBornPlace();
      assertEquals(0L, long0);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      long long0 = browsingPlus0.getRecipeId();
      assertEquals(0L, long0);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      long long0 = browsingPlus0.getUserId();
      assertEquals(0L, long0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      BrowsingPlus browsingPlus1 = new BrowsingPlus();
      browsingPlus1.setRecipeId((-86L));
      boolean boolean0 = browsingPlus0.equals(browsingPlus1);
      assertEquals((-86L), browsingPlus1.getRecipeId());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      BrowsingPlus browsingPlus1 = new BrowsingPlus();
      browsingPlus1.setAge(34L);
      boolean boolean0 = browsingPlus0.equals(browsingPlus1);
      assertEquals(34L, browsingPlus1.getAge());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      BrowsingPlus browsingPlus1 = new BrowsingPlus();
      browsingPlus1.setGender((-1023L));
      boolean boolean0 = browsingPlus1.equals(browsingPlus0);
      assertEquals((-1023L), browsingPlus1.getGender());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      BrowsingPlus browsingPlus1 = new BrowsingPlus();
      browsingPlus1.setUserId(1529L);
      boolean boolean0 = browsingPlus1.equals(browsingPlus0);
      assertEquals(1529L, browsingPlus1.getUserId());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      Object object0 = new Object();
      boolean boolean0 = browsingPlus0.equals(object0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      BrowsingPlus browsingPlus1 = new BrowsingPlus();
      browsingPlus0.setBornPlace((-810L));
      boolean boolean0 = browsingPlus0.equals(browsingPlus1);
      assertEquals((-810L), browsingPlus0.getBornPlace());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      BrowsingPlus browsingPlus1 = new BrowsingPlus();
      boolean boolean0 = browsingPlus0.equals(browsingPlus1);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      BrowsingPlus browsingPlus0 = new BrowsingPlus();
      String string0 = browsingPlus0.toString();
      assertEquals("BrowsingPlus(userId=0, gender=0, age=0, bornPlace=0, recipeId=0)", string0);
  }
}