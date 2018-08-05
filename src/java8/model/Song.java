package java8.model;

/**
 *  
 *  @author : lihuan
 *  @date 创建时间：2018年8月5日 下午1:01:01 
 *  @version 1.0
 */
public class Song {
	
	private final String name;
	private final int length;

	public Song(String name, int length) {
		this.name = name;
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public int getLength() {
		return length;
	}

	public Song copy() {
		return new Song(name, length);
	}
}
