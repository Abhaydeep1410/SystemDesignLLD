package designpattern.sturucturalpattern;


// in these videoQuality and player are tightly coupled and N number of classes we need to create
/*
class Mobile2kPlayer{}
class Web2kPlayer{}
class Mobile3kPlayer{}
class Web3kPlayer{}
*/

interface VideoQuality{
    void getQuality();
}

class k2Quality implements VideoQuality{
    @Override
    public void getQuality() {

    }
}
class k3Quality implements VideoQuality{
    @Override
    public void getQuality() {

    }
}


abstract class VideoPlayer{
    protected VideoQuality video;
    VideoPlayer(VideoQuality videoQuality){
        this.video=videoQuality;
    }
    public abstract void play();
}

class MobilePlayer extends VideoPlayer{

    MobilePlayer(VideoQuality videoQuality) {
        super(videoQuality);
    }

    public void play(){}
}
class Weblayer extends VideoPlayer{

    Weblayer(VideoQuality videoQuality) {
        super(videoQuality);
    }
    public void play(){}
}


public class BridgePattern {
    public static void main(String[] args) {
        VideoPlayer videoPlayer=new MobilePlayer(new k3Quality());
        videoPlayer.play();
    }
}
