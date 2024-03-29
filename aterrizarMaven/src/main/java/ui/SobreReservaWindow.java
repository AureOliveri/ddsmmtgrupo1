package main.java.ui;


import main.java.modelos.ModeloSobreReserva;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

public class SobreReservaWindow extends Dialog<ModeloSobreReserva> {

	public SobreReservaWindow(WindowOwner owner, ModeloSobreReserva model) {
		super(owner, model);
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Aterrizar.com");
		mainPanel.setLayout(new VerticalLayout());
		new Label(mainPanel).bindValueToProperty("mensajeReservado");
		new Label(mainPanel).setText("¿Que desea hacer?");
		Panel botonera = new Panel(mainPanel);
		botonera.setLayout(new ColumnLayout(2));
		new Button(botonera).setCaption("SobreReservar").onClick(
				new MessageSend(this, "sobreReservar"));
		new Button(botonera).setCaption("Seguir Buscando").onClick(
				new MessageSend(this, "close"));
	}

	public void sobreReservar() {
		this.getModelObject().sobreReservar();
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
	}
}
