package main.java.ui;

import main.java.usuarios.Usuario;
import main.java.usuarios.UsuarioVIP;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Search;

public class AterrizarWindow extends SimpleWindow<Usuario>{

	public AterrizarWindow(WindowOwner parent) {
		super(parent, new Usuario("Aure", "35555555", new UsuarioVIP()));
	}

	@Override
	public void createContents(Panel mainPanel) {

		this.setTitle("Aterrizar.com");

		mainPanel.setVerticalLayout();

		Panel saludo = new Panel(mainPanel);
		saludo.setHorizontalLayout();

		new Label(saludo).setText("Hola");
		new Label(saludo).bindValueToProperty("nombre");

		new Label(mainPanel).setText("¿Que desea hacer?");

		Panel botonera = new Panel(mainPanel);
		botonera.setLayoutInColumns(3);

		new Button(botonera).setCaption("Ver Compras").onClick(new MessageSend(this, "verCompras"));
		new Button(botonera).setCaption("Ver Reservas").onClick(new MessageSend(this, "verReservas"));
		new Button(botonera).setCaption("Buscar Asientos").onClick(new MessageSend(this, "buscarAsientos"));

	}
	
	public void buscarAsientos() {
		this.openDialog(new BuscarAsientosWindow(this));
	}
	
//	public void verReservas() {
//		this.openDialog(new OperacionWindow(this, "Reservas"));
//	}
//	
//	public void verCompras() {
//		this.openDialog(new OperacionWindow(this, "Compras"));
//	}

	protected void openDialog(Dialog<?> dialog) {
		dialog.onAccept(new MessageSend(this.getModelObject(), "search"));
		dialog.open();
	}


	@Override
	protected void addActions(Panel actionsPanel) {
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		// TODO Auto-generated method stub
		
	}


}


