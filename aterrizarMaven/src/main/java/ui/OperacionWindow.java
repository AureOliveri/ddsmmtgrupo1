package main.java.ui;

import main.java.busquedas.Busqueda;

import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

public class OperacionWindow extends TransactionalDialog<Busqueda> {

	public OperacionWindow(WindowOwner owner, Busqueda model) {
		super(owner, model);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		// TODO Auto-generated method stub
		
	}
	

}
