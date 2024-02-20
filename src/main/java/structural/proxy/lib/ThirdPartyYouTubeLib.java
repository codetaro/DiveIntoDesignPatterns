package structural.proxy.lib;

import java.util.HashMap;

public interface ThirdPartyYouTubeLib {
    HashMap<String, Video> pupularVideos();
    Video getVideo(String videoId);
}
