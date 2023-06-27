package it.polito.tdp.itunes.model;

import java.util.ArrayList;
import java.util.List;

public class Track {
	private Integer trackId;
	private String name;
	private String composer;
	private int milliseconds;
	private int bytes;
	private double unitPrice;
	private List<Integer> playlists;
	
	public Track(Integer trackId, String name, String composer, int milliseconds, int bytes, double unitPrice, int playlist) {
		super();
		this.trackId = trackId;
		this.name = name;
		this.composer = composer;
		this.milliseconds = milliseconds;
		this.bytes = bytes;
		this.unitPrice = unitPrice;
		this.playlists= new ArrayList<Integer>();
		this.playlists.add(playlist);
		
	}
	


	public List<Integer> getPlaylists() {
		return playlists;
	}


	public void setPlaylists(List<Integer> playlists) {
		this.playlists = playlists;
	}
	
	public void addElementToPlaylists(int playlist) {
		this.playlists.add(playlist);
	}



	public Integer getTrackId() {
		return trackId;
	}
	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public int getMilliseconds() {
		return milliseconds;
	}
	public void setMilliseconds(int milliseconds) {
		this.milliseconds = milliseconds;
	}
	public int getBytes() {
		return bytes;
	}
	public void setBytes(int bytes) {
		this.bytes = bytes;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((trackId == null) ? 0 : trackId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Track other = (Track) obj;
		if (trackId == null) {
			if (other.trackId != null)
				return false;
		} else if (!trackId.equals(other.trackId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	
	
}
