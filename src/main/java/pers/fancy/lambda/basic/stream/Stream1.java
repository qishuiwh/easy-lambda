package pers.fancy.lambda.basic.stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pers.fancy.lambda.basic.Person;
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
	public static void streamFilterCount() {
		List<String> list = new LinkedList<>();
		list.add("test1");
		list.add("right");
		list.stream().filter(str -> {
			System.out.println(str);
			return str.equals("right");
		}).map(str->str.toUpperCase())
				.forEach(System.out::println);

		//合并多个List为Stream
		List<String> result = Stream.of(Arrays.asList("r1","r2","r3")
				,Arrays.asList("t1","t2","t3"))
				.flatMap(list2 -> list2.stream())
				.collect(Collectors.toList());
		System.out.println("flatMap: "+result.size());

		//找Stream最大最小值
		List<Song> list4 = Arrays.asList(new Song("t1",222),new Song("t2",333));
		Song result4 = list4.stream()
				.max(Comparator.comparing(track -> track.getLength()))
				.get();


		//reduce操作
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
	 * Stream转List Set Map
	 * @param params 
	 * @return 
	 * @throws 
	 */
	public static void streamCollectList(){
		//List
		List<Object> result = Stream.of("a","b","c")
				.collect(Collectors.toList());

		//Set
		Set<Object> result2 = Stream.of("a","b","c","c","d")
				.collect(Collectors.toSet());

		//Map
		List<Person> list = new ArrayList();
		list.add(new Person(1, "mang1"));
		list.add(new Person(2, "mang2"));
		list.add(new Person(3, "mang3"));
		Map<Integer, Person> map1 = list.stream()
				.collect(Collectors.toMap(Person::getId, Function.identity()));

		Map<Integer, String> map2 = list.stream()
				.collect(Collectors.toMap(Person::getId, Person::getName));
		System.out.println(map1.size());
	}

	
	/**
	 * 请输入功能描述：按一定规则拼接集合字符串
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
	

	
}
