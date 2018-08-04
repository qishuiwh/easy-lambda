package java8.collector;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import java8.stream.Artist;

/** 
* @author : lihuan
* @date 创建时间：2018年8月4日 下午9:05:12 
* @version 1.0  
*/
public class StringExamplesTest {
	
	@Test
	public void formatArtistsTest() {
		
		List<Artist> artists = new LinkedList<Artist>();
		Artist artist = new Artist("lihuan","China");
		artists.add(artist);
		artists.add(artist);
		artists.add(artist);
		artists.add(artist);
		String result = StringExamples.formatArtists(artists);
		List<String> list = new ArrayList<String>();
		list.add("shushu");
		list.add("shushu2");
		String result2 = StringExamples.formatString(list);
		System.out.println(result + result2);
		
		
	}
}
