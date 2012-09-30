package main.java.ui;

import main.java.modelos.ModeloOperacion;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class AterrizarWindow extends Window<ModeloOperacion>{ //TODO Cambiar Usuario de simWind x oper

	public AterrizarWindow(WindowOwner parent) {
		super(parent, new ModeloOperacion());
	}

	@Override
	public void createContents(Panel mainPanel) {

		this.setTitle("Aterrizar.com");

		mainPanel.setLayout(new VerticalLayout());

		Panel saludo = new Panel(mainPanel);
		saludo.setLayout(new HorizontalLayout());

		new Label(saludo).bindValueToProperty("saludo");

		new Label(mainPanel).setText("¿Que desea hacer?");

		Panel botonera = new Panel(mainPanel);
		botonera.setLayout(new ColumnLayout(3));
		

		new Button(botonera).setCaption("Ver Compras").onClick(new MessageSend(this, "verCompras"));
		new Button(botonera).setCaption("Ver Reservas").onClick(new MessageSend(this, "verReservas"));
		new Button(botonera).setCaption("Buscar Asientos").onClick(new MessageSend(this, "buscarAsientos"));

	}
	
	public void buscarAsientos() {
		this.openDialog(new BuscadorWindow(this, this.getModelObject().getUsuario()));
	}
	
	public void verReservas() {
		this.openDialog(new OperacionWindow(this, "Reservas"));
	}
	
	public void verCompras() {
		this.openDialog(new OperacionWindow(this, "Compras"));
	}

	protected void openDialog(Dialog<?> dialog) {
		dialog.onAccept(new MessageSend(this.getModelObject(), "search"));
		dialog.open();
	}


}


