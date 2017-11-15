package com.lidiabazhenova;

import java.io.ByteArrayOutputStream;

abstract class CaptureTest {
    public abstract void test(ByteArrayOutputStream outContent,
                              ByteArrayOutputStream errContent) throws Exception;
}
