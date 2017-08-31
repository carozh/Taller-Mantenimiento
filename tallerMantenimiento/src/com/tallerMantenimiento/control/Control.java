package com.tallerMantenimiento.control;

import java.util.ArrayList;

public interface Control<Entity> {
	public ArrayList<Entity> list() throws Throwable;
	//ES UNA CLASE GENERICA con una estructura dinamica
	//Ademas que esta lanzando excepciones
	public void insert(Entity entity) throws Throwable;
	public void search(Entity entity) throws Throwable;
	public void update(Entity entity) throws Throwable;
}
