package com.linxz.DesignPattern.适配器模式.audio;

import com.linxz.DesignPattern.适配器模式.audio.interfaces.MultiPlayer;

public class Mp4Player implements MultiPlayer {
    @Override
    public void playMp4(String fileName) {
        System.out.println("Mp4Player播放器正在播放："+fileName);
    }

    @Override
    public void playVlc(String fileName) {
        System.err.println("Mp4Player播放器暂不支持该文件格式："+fileName);
    }
}