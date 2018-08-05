package java8.collector;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 自定义收集器
 * @author : lihuan
 * @date 创建时间：2018年8月4日 下午9:50:22
 * @version 1.0
 */
public class StringCollector implements Collector<String, StringCombiner, String> {

	private static final Set<Characteristics> characteristics = Collections.emptySet();

	private final String delim;
	private final String prefix;
	private final String suffix;

	public StringCollector(String delim, String prefix, String suffix) {
		this.delim = delim;
		this.prefix = prefix;
		this.suffix = suffix;
	}

	// Supplier是创建容器的工厂
	@Override
	public Supplier<StringCombiner> supplier() {
		return () -> new StringCombiner(delim, prefix, suffix);
	}

	// accumulator将当前元素累加到收集器。
	@Override
	public BiConsumer<StringCombiner, String> accumulator() {
		return StringCombiner::add;
	}

	// combiner合并两个容器
	@Override
	public BinaryOperator<StringCombiner> combiner() {
		return StringCombiner::merge;
	}

	// finisher返回收集操作的最终结果
	@Override
	public Function<StringCombiner, String> finisher() {
		return StringCombiner::toString;
	}

	@Override
	public Set<Characteristics> characteristics() {
		return characteristics;
	}

}
