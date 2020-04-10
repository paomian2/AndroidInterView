package com.linxz.DesignPattern.适配器模式.audio.interfaces;

public interface MultiPlayer {
    void playMp4(String fileName);
    void playVlc(String fileName);
}