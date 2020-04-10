package com.linxz.DesignPattern.适配器模式.audio;

import com.linxz.DesignPattern.适配器模式.audio.adapter.MediaAdapter;
import com.linxz.DesignPattern.适配器模式.audio.interfaces.MediaPlayer;

public class AudioPlayer implements MediaPlayer {

    private MediaAdapter adapter;

    public AudioPlayer(){
        adapter=new MediaAdapter();
    }


    @Override
    public void play(String fileName) {
        //如果这里面不使用适配器，那么这里面就要直接new Mp4Player,VlcPlayer，这样也就是播放器里面还装这播放器，不太符合逻辑
        //
        if (fileName.endsWith(".mp3")){
            System.out.println("AudioPlayer播放器正在播放："+fileName);
        }else {
            adapter.play(fileName);
        }
    }
}