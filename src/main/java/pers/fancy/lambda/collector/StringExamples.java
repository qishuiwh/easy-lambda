package pers.fancy.lambda.collector;

import java.util.List;
import java.util.stream.Collectors;

import pers.fancy.lambda.model.Artist;

/**
 *  基于java8的字符串拼接常用案例
 *  @author : lihuan
 *  @date 创建时间：2018年8月4日 下午9:36:46 
 *  @version 1.0
 */
public class StringExamples {
	
	//使用流和收集器格式化艺术家姓名 ------------java8
	public static String formatArtists(List<Artist> artists) {
		String result = artists.stream().map(artist -> artist.getName())
				.collect(Collectors.joining(", ", "[", "]"));
		return result;
	}
	
	//模仿formatArtists
	public static String formatString(List<String> list) {
		String result = list.stream().map(str -> str.toString())
				.collect(Collectors.joining(",", "[", "]"));
		
		String result2 = list.stream().map(String::toString)
				.collect(Collectors.joining(",", "[", "]"));
		return result+result2;
	}
	
	
	//使用for循环格式化艺术家姓名-----------old1
	public static String formatArtistsForLoop(List<Artist> artists) {
		StringBuilder builder = new StringBuilder("[");
		for (Artist artist : artists) {
			if (builder.length() > 1)
				builder.append(", ");

			String name = artist.getName();
			builder.append(name);
		}
		builder.append("]");
		String result = builder.toString();
		return result;
	}
	
	//使用forEach和StringBuilder格式化艺术家姓名
	public static String formatArtistsRefactor1(List<Artist> artists) {
		StringBuilder builder = new StringBuilder("[");
		artists.stream().map(Artist::getName).forEach(name -> {
			if (builder.length() > 1)
				builder.append(", ");

			builder.append(name);
		});
		builder.append("]");
		String result = builder.toString();
		return result;
	}
	
	//使用reduce和StringBuilder格式化艺术家姓名
	public static String formatArtistsRefactor2(List<Artist> artists) {
		StringBuilder reduced = artists.stream().map(Artist::getName).reduce(new StringBuilder(), (builder, name) -> {
			if (builder.length() > 0)
				builder.append(", ");

			builder.append(name);
			return builder;
		}, (left, right) -> left.append(right));

		reduced.insert(0, "[");
		reduced.append("]");
		String result = reduced.toString();
		return result;
	}
	
	//使用reduce和StringCombiner类格式化艺术家姓名
	public static String formatArtistsRefactor3(List<Artist> artists) {
		StringCombiner combined = artists.stream().map(Artist::getName)
				.reduce(new StringCombiner(", ", "[", "]"),
				StringCombiner::add, StringCombiner::merge);

		String result = combined.toString();
		return result;
	}
	
	//使用reduce操作，将工作代理给StringCombiner对象
	public static String formatArtistsRefactor4(List<Artist> artists) {
		String result = artists.stream().map(Artist::getName)
				.reduce(new StringCombiner(", ", "[", "]"), 
						StringCombiner::add, StringCombiner::merge).toString();
		return result;
	}
	
	//使用定制的收集器收集字符串
	public static String formatArtistsRefactor5(List<Artist> artists) {
		String result = artists.stream().map(Artist::getName)
				.collect(new StringCollector(", ", "[", "]"));
		return result;
	}
	

	public static String formatArtistsReducing(List<Artist> artists) {
		String result = artists.stream().map(Artist::getName)
				.collect(Collectors.reducing(new StringCombiner(", ", "[", "]"),
						name -> new StringCombiner(", ", "[", "]").add(name), 
						StringCombiner::merge))
				.toString();
		return result;
	}

	
}
