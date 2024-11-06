package creationalDesignPattern.adapter;

public class VideoPlayer{

	private String format;
	private String filePath;
	private String resolution;
	
	void setFormat(String format) {
		this.format = format;
	}
	
	void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void playVideo(String format, String filePath, String resolution) {
		System.out.println("Playing video" + filePath + " as " + format + " in " + resolution);
	}
}
