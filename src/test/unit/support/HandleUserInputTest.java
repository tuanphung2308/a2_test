package test.unit.support;

import org.junit.Test;
import support.HandleUserInput;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HandleUserInputTest { 

//@Before
//public void before() throws Exception {
//
//}

//@After
//public void after() throws Exception {
//}

/** 
* 
* Method: run() 
* 
*/ 
@Test
public void testRun() throws Exception {
    String input = "1";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    assertEquals("1", Character.toString((char) in.read()));
}

    /**
* 
* Method: hashCode() 
* 
*/ 
@Test
public void testHashCode() throws Exception {
//TODO: Test goes here...
    HandleUserInput handleUserInput = new HandleUserInput();
    Integer expected = 580024961;
    assertEquals((long)expected,(long)handleUserInput.hashCode());
}
//
///**
//*
//* Method: equals(Object var1)
//*
//*/
//@Test
//public void testEquals() throws Exception {
////TODO: Test goes here...
//}
//
///**
//*
//* Method: uncaughtException(Thread var1, Throwable var2)
//*
//*/
//@Test
//public void testUncaughtException() throws Exception {
////TODO: Test goes here...
//}
//
//
}
