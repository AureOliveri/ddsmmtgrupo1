package main.java.ui;

import main.java.usuarios.Usuario;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.MainWindow;

public class AterrizarWindow extends MainWindow<Usuario>{

	public AterrizarWindow() {
		super(new Usuario());
	}

	@Override
	public void createContents(Panel mainPanel) {

		this.setTitle("Aterrizar.com");

		mainPanel.setVerticalLayout();

		Panel saludo = new Panel(mainPanel);
		saludo.setHorizontalLayout();

		new Label(saludo).setText("Hola XXXXXX");
//      new Label(saludo).bindValueToProperty("nombre");

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
	
	protected void openDialog(Dialog<?> dialog) {
		dialog.onAccept(new MessageSend(this.getModelObject(), "search"));
		dialog.open();
	}


	public static void main(String[] args) {
		new AterrizarWindow().startApplication();
	}


}


