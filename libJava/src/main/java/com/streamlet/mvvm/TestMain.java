package com.streamlet.mvvm;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Linxz
 * 创建日期：2021年07月16日 2:27 PM
 * version：
 * 描述：
 */
public class TestMain {

    private final Map<String, Object> mBagOfTags = new HashMap<>();

    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        testMain.mBagOfTags.put("0",0);
        testMain.mBagOfTags.put("1",1);
        testMain.mBagOfTags.put("2",2);
        System.out.println(testMain.mBagOfTags);
        testMain.clear();
        System.out.println(testMain.mBagOfTags);
    }

    final void clear() {
        // Since clear() is final, this method is still called on mock objects
        // and in those cases, mBagOfTags is null. It'll always be empty though
        // because setTagIfAbsent and getTag are not final so we can skip
        // clearing it
        if (mBagOfTags != null) {
            synchronized (mBagOfTags) {
                for (Object value : mBagOfTags.values()) {
                    // see comment for the similar call in setTagIfAbsent
                    closeWithRuntimeException(value);
                }
            }
        }
    }

    private static void closeWithRuntimeException(Object obj) {
        if (obj instanceof Closeable) {
            try {
                System.out.println(obj);
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
