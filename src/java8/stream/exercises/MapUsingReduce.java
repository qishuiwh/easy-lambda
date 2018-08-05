package java8.stream.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;


/**
 *  @author : lihuan
 *  @date 创建时间：2018年8月5日 下午12:58:26 
 *  @version 1.0
 */
public class MapUsingReduce {

	public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
		return stream.reduce(new ArrayList<O>(), (acc, x) -> {
			List<O> newAcc = new ArrayList<>(acc);
			newAcc.add(mapper.apply(x));
			return newAcc;
		}, (List<O> left, List<O> right) -> {
			List<O> newLeft = new ArrayList<>(left);
			newLeft.addAll(right);
			return newLeft;
		});
	}

}
