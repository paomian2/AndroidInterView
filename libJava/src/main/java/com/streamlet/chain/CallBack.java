package com.streamlet.chain;

import java.io.IOException;

/**
 * @author Linxz
 * 创建日期：2021年07月19日 2:53 PM
 * version：
 * 描述：
 */
public interface CallBack {
    void onResponse(Response response) throws IOException;
}
