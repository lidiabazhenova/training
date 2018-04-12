package com.catalog;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class ImmutableVsUnmodifiable {



    @Test
    public void testList() {

        List<String> modifiableList = new ArrayList<String>();
        modifiableList.add("a");

        System.out.println("modifiableList:"+modifiableList);
        System.out.println("--");


        //unModifiableList
        assertEquals(1, modifiableList.size());

        List<String> unModifiableList=Collections.unmodifiableList(
                modifiableList);

        modifiableList.add("b");

        boolean exceptionThrown=false;
        try {
            unModifiableList.add("b");
            fail("add supported for unModifiableList!!");
        } catch (UnsupportedOperationException e) {
            exceptionThrown=true;
            System.out.println("unModifiableList.add() not supported");
        }
        assertTrue(exceptionThrown);

        System.out.println("modifiableList:"+modifiableList);
        System.out.println("unModifiableList:"+unModifiableList);

        assertEquals(2, modifiableList.size());
        assertEquals(2, unModifiableList.size());
        System.out.println("--");

        //immutableList
        List<String> immutableList= Collections.unmodifiableList(
                new ArrayList<String>(modifiableList));

        modifiableList.add("c");

        exceptionThrown=false;
        try {
            immutableList.add("c");
            fail("add supported for immutableList!!");
        } catch (UnsupportedOperationException e) {
            exceptionThrown=true;
            System.out.println("immutableList.add() not supported");
        }
        assertTrue(exceptionThrown);


        System.out.println("modifiableList:"+modifiableList);
        System.out.println("unModifiableList:"+unModifiableList);
        System.out.println("immutableList:"+immutableList);
        System.out.println("--");

        assertEquals(3, modifiableList.size());
        assertEquals(3, unModifiableList.size());
        assertEquals(2, immutableList.size());

    }
}
