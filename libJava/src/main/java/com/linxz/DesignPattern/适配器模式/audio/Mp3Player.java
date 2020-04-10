package com.linxz.DesignPattern.适配器模式.audio;

import com.linxz.DesignPattern.适配器模式.audio.interfaces.MediaPlayer;

public class Mp3Player implements MediaPlayer {

    @Override
    public void play(String fileName) {
        if (fileName.endsWith(".mp3")){
            System.out.println("Mp3Player播放器正在播放："+fileName);
        }else {
            System.err.println("Mp3Player播放器暂不支持该文件格式");
        }
    }
}