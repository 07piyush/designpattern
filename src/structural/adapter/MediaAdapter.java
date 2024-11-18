package structural.adapter;

public class MediaAdapter implements MediaPlayer{
	
	//used composition to make video player adaptive to existing player.
	private VideoPlayer videoPlayer;
	
	public MediaAdapter() {
		this.videoPlayer = new VideoPlayer();
	}
	
	public void play(String format, String filePath) {
		String defaultResolution = "1080p";  // Default resolution
		videoPlayer.playVideo(format, filePath, defaultResolution);
	}

}
