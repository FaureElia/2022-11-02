package it.polito.tdp.itunes.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.itunes.db.ItunesDAO;

public class Model {
	private ItunesDAO dao;
	private Graph <Track, DefaultEdge> grafo;
	
	public Model() {
		this.dao=new ItunesDAO();
	}

	public List<Genre> getGenres() {
		return this.dao.getAllGenres();
		
		
	}

	public List<Set<Track>> creaGrafo(Genre genre, double min, double max) {
		if(min<this.dao.getMin(genre) || max>this.dao.getMax(genre)) {
			return null;
		}
		this.grafo=new SimpleGraph<>(DefaultEdge.class);
		List<Track> vertici=this.dao.getTracks(genre, min, max);
		Graphs.addAllVertices(this.grafo, vertici);
		for(Track t1: this.grafo.vertexSet()) {
			for (Track t2: this.grafo.vertexSet()){
				if(t1.getTrackId()>t2.getTrackId() && t1.getPlaylists().size()==t2.getPlaylists().size()) {
					this.grafo.addEdge(t2, t1);
				}
				
			}
		}
		System.out.println("grafico con vertici: "+this.grafo.vertexSet().size());
		System.out.println("grafico con archi: "+this.grafo.edgeSet().size());
		
		ConnectivityInspector <Track, DefaultEdge> inspector=new ConnectivityInspector(this.grafo);
		List<Set<Track>> componentiConnesse= inspector.connectedSets();
		
		
		return componentiConnesse;
		
			
	}
	
	public int numeroPlaylist(Set<Track> componenteConnessa) {
		Set<Integer> playlist=new HashSet<>();
		for (Track t: componenteConnessa) {
			for(Integer i: t.getPlaylists()) {
				if(!playlist.contains(i)) {
					playlist.add(i);
				}
			}
		}
		return playlist.size();
	}
	
	public int getVertici() {
		return this.grafo.vertexSet().size();
		
	}
	
	public int getNodi() {
		return this.grafo.edgeSet().size();
	}
	
	
	
}
