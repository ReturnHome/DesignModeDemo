package com.weconex.designmodedemo.action5_适配器模式;

/**
 * Created by lifeng on 2018/2/2.
 * @desc 适配器模式 作为两个不兼容接口之间的桥梁
 *  意思是将两个不兼容的接口不能一起工作的可以一起工作
 */

public class AdapterPatternDemo {

    public void test(){
        //通过AudioPlayer来模拟播放不同文件
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3","智多星.mp3");
        audioPlayer.play("mp4","信息港.mp4");
        audioPlayer.play("vlc","大猩猩.vlc");
        audioPlayer.play("avi","反击.avi");
    }
}

//媒体播放器
interface MediaPlayer{
    void play(String audioType,String fileName);
}

//更高级的媒体播放器
interface AdvancedMediaPlayer{

    void playVlc(String fileName);

    void playMp4(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer{

    @Override
    public void playVlc(String fileName) {
        System.out.println("VlcPlayer.playVlc fileName:" + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //TODO Nothing
    }
}

class Mp4Player implements AdvancedMediaPlayer{

    @Override
    public void playVlc(String fileName) {
        //TODO Nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Mp4Player.playMp4 fileName:" + fileName);
    }
}

/**
 * 创建MediaPlayer的适配器类
 */
class MediaAdapter implements MediaPlayer{

   private AdvancedMediaPlayer mAdvancedMediaPlayer;

    public MediaAdapter(String audioType) {
        //TODO 在这里就将两个原本毫无关联的接口关联起来了
        if(audioType.equalsIgnoreCase("vlc")) {
            mAdvancedMediaPlayer = new VlcPlayer();
        } else if(audioType.equalsIgnoreCase("mp4")) {
            mAdvancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")) {
            mAdvancedMediaPlayer.playVlc(fileName);
        } else if(audioType.equalsIgnoreCase("mp4")){
            mAdvancedMediaPlayer.playMp4(fileName);
        }
    }
}

/**
 * 创建MediaPlayer接口的实现类
 */
class AudioPlayer implements MediaPlayer{

    private MediaAdapter mMediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        //内置功能 播放mp3 
        if(audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 fileName: "+ fileName);
        } else
            //适配器提供了其他功能 播放vlc && mp4格式的文件
            if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mMediaAdapter = new MediaAdapter(audioType);
            mMediaAdapter.play(audioType,fileName);
        } else {
            System.out.println("Invalid media. "+
                    audioType + " format not supported");
        }
    }
}

