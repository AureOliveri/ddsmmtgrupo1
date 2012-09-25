package main.java.ui;

import main.java.aerolineas.Aerolineas;
import main.java.usuarios.Usuario;
import main.java.usuarios.UsuarioVIP;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

public class AterrizarWindow extends SimpleWindow<Usuario>{ //TODO Cambiar Usuario de simWind x oper

	private static Usuario usuario = new Usuario("Aure", "35555555", new UsuarioVIP());
	
	public AterrizarWindow(WindowOwner parent) {
		super(parent, getUsuario());
	}

	@Override
	public void createContents(Panel mainPanel) {

		this.setTitle("Aterrizar.com");

		mainPanel.setLayout(new VerticalLayout());

		Panel saludo = new Panel(mainPanel);
		saludo.setLayout(new HorizontalLayout());

		new Label(saludo).setText("Hola");
		new Label(saludo).bindValueToProperty("nombre");

		new Label(mainPanel).setText("¿Que desea hacer?");

		Panel botonera = new Panel(mainPanel);
		botonera.setLayout(new ColumnLayout(3));
		

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

	public void setUsuario(Usuario usuario) {
		AterrizarWindow.usuario = usuario;
	}

	public static Usuario getUsuario() {
		return usuario;
	}

}


