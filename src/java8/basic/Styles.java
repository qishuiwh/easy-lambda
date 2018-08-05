package java8.basic;

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
		//无参数，单行
		Runnable noparams = () -> System.out.println("lambda no params style!");
		noparams.run();
		//一参，单行
		TestInterface onparams = test -> System.out.println(test);
		onparams.test("a param a line");
		
		//无参 多行
		Runnable runbody = () -> {
			System.out.println("code1");
			System.out.println("code2");
		};
		runbody.run();
		//多参 多行
		TestInterface2 t2 = (str1, str2) -> {
			System.out.println(str1);
			System.out.println(str2);
		};
		t2.test2("param1", "param2");
		
		//返回 函数体 
		BinaryOperator<Long> add = (x,y) -> x + y;
		BinaryOperator<Long> add2 = (Long x,Long y) -> {
			x = x + y;
			return x*y;
		};
		System.out.println(add.apply(10000L, 1111111111L));
		System.out.println(add2.apply(4L, 8L));
		
		
	}
}
