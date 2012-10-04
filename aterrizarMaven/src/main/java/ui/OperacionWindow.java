package main.java.ui;

import main.java.modelos.ModeloOperacion;
import main.java.usuarios.Usuario;
import main.java.vuelos.Asiento;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

public class OperacionWindow extends Dialog<ModeloOperacion> {

	public OperacionWindow(WindowOwner owner, String label, Usuario usuario) {
		super(owner, new ModeloOperacion(label, usuario));
	}

	
	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Reservas de usuario");
		
		mainPanel.setLayout(new VerticalLayout());

		Panel saludo = new Panel(mainPanel);
		saludo.setLayout(new HorizontalLayout());

		new Label(saludo).bindValueToProperty("label");
		
		this.createResultsGrid(mainPanel);
		this.createGridActions(mainPanel);
		
	}
	
	protected void createResultsGrid(Panel mainPanel) {
		Table<Asiento> table = new Table<Asiento>(mainPanel, Asiento.class);
		table.setHeigth(100);
		table.setWidth(610);
		table.bindItemsToProperty("resultados");
		table.bindValueToProperty("asientoSeleccionado");
		this.describeResultsGrid(table);
	}
	
	protected void describeResultsGrid(Table<Asiento> table) {
		
		Column<Asiento> salidaColum = new Column<Asiento>(table);
		salidaColum.setTitle("Salida");
		salidaColum.setFixedSize(150);
		salidaColum.bindContentsToProperty("fecha");
		
		Column<Asiento> aerolineaColum = new Column<Asiento>(table);
		aerolineaColum.setTitle("Aerolinea");
		aerolineaColum.setFixedSize(150);
		aerolineaColum.bindContentsToProperty("nombreAerolinea");
		
		Column<Asiento> vueloColum = new Column<Asiento>(table);
		vueloColum.setTitle("Vuelo");
		vueloColum.setFixedSize(130);
		vueloColum.bindContentsToProperty("numeroDeVuelo");
		
		Column<Asiento> asientoColum = new Column<Asiento>(table);
		asientoColum.setTitle("Asiento");
		asientoColum.setFixedSize(80);
		asientoColum.bindContentsToProperty("numeroDeAsiento");

		Column<Asiento> precioColumn = new Column<Asiento>(table);
		precioColumn.setTitle("Precio");
		precioColumn.setFixedSize(100);
		precioColumn.bindContentsToProperty("precioFinal");

	}

	protected void createGridActions(Panel mainPanel) {
		Panel actionsPanel = new Panel(mainPanel);
		actionsPanel.setLayout(new HorizontalLayout());

		Button remove = new Button(actionsPanel);
		remove.setCaption("Cerrar");
		remove.onClick(new MessageSend(this, "close"));
		
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		// TODO Auto-generated method stub
		
	}

	
}
