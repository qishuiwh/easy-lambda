package pers.fancy.lambda.model;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 *  唱片集,歌曲，歌手或乐队
 *  @author : lihuan
 *  @date 创建时间：2018年8月5日 下午1:00:11 
 *  @version 1.0
 */
public class Album {
	
	private String name;
	private List<Song> songs;
	private List<Artist> musicians;

	public Album(String name, List<Song> tracks, List<Artist> musicians) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(tracks);
		Objects.requireNonNull(musicians);

		this.name = name;
		this.songs = new ArrayList<>(tracks);
		this.musicians = new ArrayList<>(musicians);
	}

	public String getName() {
		return name;
	}

	public Stream<Song> getTracks() {
		return songs.stream();
	}

	public List<Song> getTrackList() {
		return unmodifiableList(songs);
	}

	public Stream<Artist> getMusicians() {
		return musicians.stream();
	}

	public List<Artist> getMusicianList() {
		return unmodifiableList(musicians);
	}

	public Artist getMainMusician() {
		return musicians.get(0);
	}

	public Album copy() {
		List<Song> tracks = getTracks().map(Song::copy).collect(toList());
		List<Artist> musicians = getMusicians().map(Artist::copy).collect(toList());
		return new Album(name, tracks, musicians);
	}

}
