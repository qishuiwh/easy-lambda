package pers.fancy.lambda.basic.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pers.fancy.lambda.model.Album;
import pers.fancy.lambda.model.Artist;
import pers.fancy.lambda.model.Song;


/** 
 * Stream类中的方法对应常见的集合操作，总结一些常用的stream操作样例代码
* @author : lh
* @date 创建时间：2018年8月5日 上午8:49:02 
* @version 1.0  
*/
public class Stream1 {
	
	/**
	 * 过滤List中字符串并计数 filter只描述stream，不产生新的集合，此种叫惰性求值（str不打印）.count终止流打印
	 * 和建造者模式相似（调用build才创建对象）
	 * @param params 
	 * @return 
	 * @throws 
	 */
	public static Long streamFilterCount() {
		List<String> list = new LinkedList<>();
		list.add("test1");
		list.add("right");
		long result = list.stream()
				.filter(str -> str.equals("right"))
				.count();
//		list.stream().filter(str -> {
//			System.out.println(str);
//			return str.equals("right");
//		}).count();
		System.out.println("filter: "+result);
		return result;
	}
	
	/**
	 * 请输入功能描述：Stream::collect
	 * @param params 
	 * @return 
	 * @throws 
	 */
	public static List<Object> streamCollectList(){
		List<Object> result = Stream.of("a","b","c")
				.collect(Collectors.toList());
		System.out.println("collect: "+result.size());
		return result;
	}
		
	/**
	 * 请输入功能描述：Stream::map
	 * @param params 
	 * @return 
	 * @throws 
	 */
	public static void streamMap() {
		List<String> result = Stream.of("a","b","C")
				.map(str -> str.toUpperCase())
				.collect(Collectors.toList());
		System.out.println("map: "+result.get(0)+result.get(1)+result.get(2));
	}
	
	
	/**
	 * 请输入功能描述：Stream:filter
	 * @param params 
	 * @return 
	 * @throws 
	 */
	public static void streamFilter() {
		List<String> result = Stream.of("1abc","abcd","2bcd")
				.filter(str -> Character.isDigit(str.charAt(0)))
				.collect(Collectors.toList());
		System.out.println("filter: "+result.size());
	}
	
	/**
	 * 请输入功能描述：Stream::flatMap
	 * @param params 
	 * @return 
	 * @throws 
	 */
	public static void streamFlatMap() {
		List<String> result = Stream.of(Arrays.asList("r1","r2","r3")
				,Arrays.asList("t1","t2","t3"))
				.flatMap(list -> list.stream())
				.collect(Collectors.toList());
		System.out.println("flatMap: "+result.size());
	}
	
	/**
	 * 请输入功能描述：Stream::min/max
	 * @param params 
	 * @return 
	 * @throws 
	 */
	public static void streamMin() {
		List<Song> list = Arrays.asList(new Song("t1",222),new Song("t2",333));
		Song result = list.stream()
				.max(Comparator.comparing(track -> track.getLength()))
				.get();
		System.out.println("min/max: "+result.getName());
	}
	
	/**
	 * 请输入功能描述：Stream::reduce
	 * @param params 
	 * @return 
	 * @throws 
	 */
	public static void streamReduce() {
		int count = Stream.of(1,2,3)
				.reduce(0, (x,y) -> x + y);
		System.out.println("reduce: " + count);
		BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
		int count2 = accumulator.apply(
				accumulator.apply(accumulator.apply(0, 1), 2), 3);
		System.out.println("reduce2: " + count2);
		int count3 = Stream.of(1,2,3)
				.reduce(Integer::sum).get();
		System.out.println("reduce3:" + count3);
	}
	
	/**
	 * 请输入功能描述：stream方法综合运用
	 * @param params 
	 * @return 
	 * @throws 
	 */
	public static void streamZH() {
		Album album = new Album("The",Arrays.asList(new Song("test",1)),
				Arrays.asList(new Artist("at","at2")));
		Set<String> origins = album.getMusicians()
				.filter(artist -> artist.getName().startsWith("The"))
				.map(artist -> artist.getNationality())
				.collect(Collectors.toSet());
		System.out.println("streamZH: "+origins.size());
	}
	
	public static void streamZH2(List<Album> albums) {
		
		albums.stream()
		.flatMap(album -> album.getTracks())
		.filter(track -> track.getLength() > 60)
		.map(track -> track.getName())
		.collect(Collectors.toSet());
		
	}
	
	/**
	 * 请输入功能描述：按一定规则拼接集合字符串
	 * @param params 
	 * @return 
	 * @throws 
	 */
	public static void streamJoin() {
		String result = Arrays.asList("str1","str2","str3")
		.stream()
		.filter(str -> str.contains("3"))
		.map(str -> str.toUpperCase())
		.collect(Collectors.joining(",","[","]"));
		System.out.println("join: "+result);
	}
	
	public static void main(String[] args) {
		
		streamFilterCount();
		streamCollectList();
		streamMap();
		streamFilter();
		streamFlatMap();
		streamMin();
		streamReduce();
		streamZH();
		streamJoin();
	}
	
}