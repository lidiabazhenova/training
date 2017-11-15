package com.lidiabazhenova;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.lidiabazhenova.TestHelper.captureOutput;
import static org.testng.AssertJUnit.assertEquals;

public class SimpleTest {

    @Test
    public void testOutput() throws Exception {

        captureOutput(new CaptureTest() {
            @Override
            public void test(ByteArrayOutputStream outContent, ByteArrayOutputStream errContent) throws Exception {

                System.out.println("Enter pathname to save in such format: 'D://SomeDir'");
                assertEquals("Enter pathname to save in such format: 'D://SomeDir'\n", outContent.toString());
            }
        });
    }
}
