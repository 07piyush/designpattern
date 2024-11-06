package structuralDesignPattern.adapter;

public class AudioPlayer implements MediaPlayer{

	private MediaAdapter videoAdapter = new MediaAdapter();
	
	public void play(String format, String filePath) {
		if(format.equalsIgnoreCase("mp3")) {
			System.out.println("Playing audio" + filePath + "as" + format);
		}
		else if(format.equalsIgnoreCase("mp4")){
			videoAdapter.play(format, filePath);
		}
		else {
			System.out.println("Invalid file format.");
		}
	}
}
