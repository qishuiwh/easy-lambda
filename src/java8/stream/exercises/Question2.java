package java8.stream.exercises;

import java.util.List;

import java8.stream.Artist;

/**
 *  @author : lihuan
 *  @date 创建时间：2018年8月5日 下午12:59:41 
 *  @version 1.0
 */
public class Question2 {
	public static int countBandMembersInternal(List<Artist> artists) {
		return artists.stream()
				.map(artist -> artist.getMembers()
				.count())
				.reduce(0L, Long::sum).intValue();
	}
}
