package com.linxz.DesignPattern.适配器模式.audio;

import com.linxz.DesignPattern.适配器模式.audio.interfaces.MultiPlayer;

public class VlcPlayer implements MultiPlayer {
    @Override
    public void playMp4(String fileName) {
        System.err.println("VlcPlayer播放器暂不支持该文件格式："+fileName);
    }

    @Override
    public void playVlc(String fileName) {
        System.out.println("VlcPlayer播放器正在播放："+fileName);
    }
}
