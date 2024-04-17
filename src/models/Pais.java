package models;

import java.util.ArrayList;

public class Pais {
	private String nombre;
	private ArrayList<String> provincias;
	
	public Pais(String nombre, ArrayList<String> provincias){
		this.nombre=nombre;
		this.provincias = provincias;
	}
	
	public String getNombre(){return this.nombre;}
	public ArrayList<String> getProvincias(){return this.provincias;}
	
	public void setNombre(String nombre) {this.nombre=nombre;}
	public void setProvincias(ArrayList<String> provincias) {this.provincias=provincias;}
}
