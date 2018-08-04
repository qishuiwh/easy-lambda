package java8.basic;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/** 
* lambda常见表达形式
* @author : lihuan
* @date 创建时间：2018年8月4日 下午10:42:36 
* @version 1.0  
*/
public class Styles {
	
	
	//lambda表达式也被称为闭包
	//Map<String,String> map = new HashMap<>(); <>可进行类型推断
	public static void main(String[] args) {
		Runnable noparams = () -> System.out.println("lambda no params style!");
		Runnable runbody = () -> {
			System.out.println("code1");
			System.out.println("code2");
		};
		
		//TestInterface onparams = test -> System.out.println("lambda one params style!");
		TestInterface oneparams2 = (str) -> {
			System.out.println(str);
		}; 
		
		BinaryOperator<Long> add = (x,y) -> x + y;
		BinaryOperator<Long> add2 = (Long x,Long y) -> x + y;
		
		System.out.println(add.apply(10000L, 1111111111L));
		
		runbody.run();
		oneparams2.test("hello oneparams2");
		noparams.run();
		
	}
}
