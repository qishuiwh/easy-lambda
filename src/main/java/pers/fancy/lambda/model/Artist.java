package pers.fancy.lambda.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

/**
 *  艺术家或者乐队
 *  @author : lihuan
 *  @date 创建时间：2018年8月5日 下午1:00:18 
 *  @version 1.0
 */
public class Artist {

	private String name;
	private List<Artist> members;
	private String nationality;

	public Artist(String name, String nationality) {
		this(name, Collections.emptyList(), nationality);
	}

	public Artist(String name, List<Artist> members, String nationality) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(members);
		Objects.requireNonNull(nationality);
		this.name = name;
		this.members = new ArrayList<>(members);
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}

	public Stream<Artist> getMembers() {
		return members.stream();
	}

	public String getNationality() {
		return nationality;
	}

	public boolean isSolo() {
		return members.isEmpty();
	}

	public boolean isFrom(String nationality) {
		return this.nationality.equals(nationality);
	}

	@Override
	public String toString() {
		return getName();
	}

	public Artist copy() {
		List<Artist> members = getMembers().map(Artist::copy).collect(toList());
		return new Artist(name, members, nationality);
	}
}
