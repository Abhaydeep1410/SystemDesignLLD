package designpattern.sturucturalpattern;

// in this user will create object of specific video even if it is already downloaded
// so we need to add a proxy layer
/* class RealVideoDownloader{
    private String name;
    RealVideoDownloader(){ this.name=name;}
    void download(){
        System.out.println("downloading video.....");
    }
}*/

import java.util.HashMap;
import java.util.Map;

interface VideoDownloader{
    String download(String name);
}
class RealVideoDownloader implements VideoDownloader{
    @Override
    public String download(String name){
        System.out.println("downloading video....."+name);
        return "video";
    }
}

class ProxyVideoDownloader implements VideoDownloader{
    private static final Map<String,String> cache=new HashMap<>();
    RealVideoDownloader realVideoDownloader;


    @Override
    public String download(String name) {
            if(cache.containsKey(name)){
                System.out.println("downloading video from cache" );
                return cache.get(name);
            }
            realVideoDownloader = new RealVideoDownloader();
            String video=realVideoDownloader.download(name);
            cache.put(name,video);
            return video;
    }
}

public class ProxyPattern {
    public static void main(String[] args) {
        VideoDownloader video=new ProxyVideoDownloader();
        video.download("abc");

        VideoDownloader video2=new ProxyVideoDownloader();
        video2.download("abc");
    }
}
