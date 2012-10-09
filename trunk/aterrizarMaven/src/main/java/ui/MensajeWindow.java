package main.java.ui;

import main.java.modelos.ModeloBuscador;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

public class MensajeWindow extends Dialog<ModeloBuscador> {

	public MensajeWindow(WindowOwner owner, ModeloBuscador model) {
		super(owner, model);
	}
	
	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Aterrizar.com");
		
		mainPanel.setLayout(new VerticalLayout());

		Panel info = new Panel(mainPanel);
		info.setLayout(new HorizontalLayout());

		new Label(info).bindValueToProperty("label");
		
		Panel botonera = new Panel(mainPanel);
		botonera.setLayout(new ColumnLayout(1));
		
		Button cerrar = new Button(botonera);
		cerrar.setCaption(this.getModelObject().getBoton());
		cerrar.onClick(new MessageSend(this, "close"));
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		// TODO Auto-generated method stub
		
	}

	
}
