package java8.basic.stream;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java8.stream.Artist;

/** 
* @author : lihuan
* @date 创建时间：2018年8月5日 上午11:32:30 
* @version 1.0  
*/
public class Stream2 {
	
	/**
	 * 请输入功能描述：按一定规则拼接集合字符串
	 * @param params 
	 * @return 
	 * @throws 
	 */
	public static void streamJoin() {
		String result = Arrays.asList("str1","str2","str3")
		.stream()
		.map(str -> str.toString())
		.collect(Collectors.joining(",","[","]"));
		System.out.println(result);
	}
	
	
	
	public static void main(String[] args) {
		streamJoin();
	}
	
	ThreadLocal<DateFormat> localFormatter = ThreadLocal.withInitial(() -> new SimpleDateFormat());// 高阶函数withInitial
	AtomicInteger threadId = new AtomicInteger();
	ThreadLocal<Integer> localId = ThreadLocal.withInitial(() -> threadId.getAndIncrement());

}
