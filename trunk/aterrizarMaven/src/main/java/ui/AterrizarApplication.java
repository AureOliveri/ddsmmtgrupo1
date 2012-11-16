package main.java.ui;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import uqbar.arena.persistence.Configuration;

/**
 * Correr esta clase con el siguiente argument
 * 
 * -Djava.system.class.loader=org.uqbar.arena.aop.ArenaClassLoader
 */
public class AterrizarApplication extends Application {

	public static void main(String[] args) {
		Configuration.configure();
		new AterrizarApplication().start();
	}

	@Override
	protected Window<?> createMainWindow() {
		return new AterrizarWindow(this);
	}
}
