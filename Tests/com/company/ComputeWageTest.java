package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

class ComputeWageTest {


    ComputeWage obj = new ComputeWage();

    @BeforeEach
    public void initEach(){

        ByteArrayInputStream in = new ByteArrayInputStream("John\n35".getBytes());
        System.setIn(in);

    }

    @org.junit.jupiter.api.Test
    void acceptData() {

        obj.acceptData();

        assertEquals("John", obj.getName());

        assertEquals(35, obj.getHours());



    }

    @org.junit.jupiter.api.Test
    void computeWagewithout() {

        obj.acceptData();
        obj.computeWage();

        assertEquals(525,obj.getGtotal());


    }


    @org.junit.jupiter.api.Test
    void computeWagewithot() {

        obj.acceptData();
        obj.computeWage();


        ByteArrayInputStream in = new ByteArrayInputStream("John\n45".getBytes());
        System.setIn(in);

        obj.acceptData();
        obj.computeWage();


        assertEquals(682.5,obj.getGtotal());


    }


    @Test
    public void testException() throws UnsupportedEncodingException {

        ByteArrayInputStream in = new ByteArrayInputStream("John\nxx\n35".getBytes());
        System.setIn(in);

        PrintStream standardOut = System.out;
        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));


        obj.acceptData();

        Assert.assertTrue(new String(captor.toByteArray(), "UTF-8").contains("You did not enter a valid number"));


        System.setOut(standardOut);



    }


    @org.junit.jupiter.api.Test
    void display() {


        obj.acceptData();
        obj.computeWage();

        PrintStream standardOut = System.out;
        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        obj.display();

        assertEquals("The total wage of John is 525.0", captor.toString().trim());



        System.setOut(standardOut);


    }
}