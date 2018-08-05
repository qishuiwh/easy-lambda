package java8.stream.exercises;

import java.util.List;
import java.util.stream.Stream;

import java8.stream.Album;
import java8.stream.Artist;

import static java.util.stream.Collectors.toList;

/**
 *  @author : lihuan
 *  @date 创建时间：2018年8月5日 下午12:59:05 
 *  @version 1.0
 */
public class Question1 {
	public static int addUp(Stream<Integer> numbers) {
		return numbers.reduce(0, (acc, x) -> acc + x);
	}

	public static List<String> getNamesAndOrigins(List<Artist> artists) {
		return artists.stream().flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
				.collect(toList());
	}

	public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input) {
		return input.stream().filter(album -> album.getTrackList().size() <= 3).collect(toList());
	}
}
