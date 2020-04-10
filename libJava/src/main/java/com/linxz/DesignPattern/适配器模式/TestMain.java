package com.linxz.DesignPattern.适配器模式;

import com.linxz.DesignPattern.适配器模式.audio.AudioPlayer;

public class TestMain {

    //将一个接口转换为客户希望的另一个接口，适配器模式使接口不兼容的那些类可以一起工作，其别名为包装器(Wrapper)。


    //意图：将一个类的接口转换成客户希望的另外一个接口。适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
    //主要解决：主要解决在软件系统中，常常要将一些"现存的对象"放到新的环境中，而新环境要求的接口是现对象不能满足的。
    //何时使用： 1、系统需要使用现有的类，而此类的接口不符合系统的需要。 2、想要建立一个可以重复使用的类，用于与一些彼此之间没有太大关联的一些类，
    //包括一些可能在将来引进的类一起工作，这些源类不一定有一致的接口。 3、通过接口转换，将一个类插入另一个类系中。（比如老虎和飞禽，现在多了一个飞虎，
    //在不增加实体的需求下，增加一个适配器，在里面包容一个虎对象，实现飞的接口。）
    //如何解决：继承或依赖（推荐）。




    //eg:我们有一个 MediaPlayer 接口和一个实现了 MediaPlayer 接口的实体类 Mp3Player。默认情况下，Mp3Player 可以播放 mp3 格式的音频文件。
    //我们还有另一个接口 AdvancedMediaPlayer 和实现了 AdvancedMediaPlayer 接口的实体类。该类可以播放 vlc 和 mp4 格式的文件。
    //我们想要让 Mp3Player 播放其他格式的音频文件。为了实现这个功能，我们需要创建一个实现了 MediaPlayer 接口的适配器类 MediaAdapter，并使用 AdvancedMediaPlayer 对象来播放所需的格式。
    //Mp3Player 使用适配器类 MediaAdapter 传递所需的音频类型，不需要知道能播放所需格式音频的实际类。AdapterPatternDemo，我们的演示类使用 Mp3Player 类来播放各种格式。


    //eg:想让AudioPlayer拥有播放vlc和mp4格式的播放器


    public static void main(String[] args) {

//        Mp3Player mp3Player = new Mp3Player();
//
//        mp3Player.play("beyond the horizon.mp3");
//        mp3Player.play( "alone.mp4");
//        mp3Player.play( "far far away.vlc");
//        mp3Player.play( "mind me.avi");

        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("beyond the horizon.mp3");
        audioPlayer.play( "alone.mp4");
        audioPlayer.play( "far far away.vlc");
        audioPlayer.play( "mind me.avi");
    }
}