package com.linxz.DesignPattern.适配器模式.audio.adapter;

import com.linxz.DesignPattern.适配器模式.audio.Mp4Player;
import com.linxz.DesignPattern.适配器模式.audio.VlcPlayer;
import com.linxz.DesignPattern.适配器模式.audio.interfaces.MediaPlayer;
import com.linxz.DesignPattern.适配器模式.audio.interfaces.MultiPlayer;

public class MediaAdapter implements MediaPlayer {

    private MultiPlayer multiPlayer;

    @Override
    public void play(String fileName) {
        if (fileName.endsWith(".mp4")){
            multiPlayer=new Mp4Player();
            multiPlayer.playMp4(fileName);
        }else if (fileName.endsWith(".vlc")){
            multiPlayer=new VlcPlayer();
            multiPlayer.playVlc(fileName);
        }else{
            System.err.println("暂不支持该文件格式:"+fileName);
        }
    }
}