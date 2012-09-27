package main.java.ui;


import main.java.modelos.BuscadorModel;
import main.java.vuelos.Asiento;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

public class BuscarAsientosWindow extends Dialog<BuscadorModel> {

	public BuscarAsientosWindow(WindowOwner owner, BuscadorModel model) {
		super(owner, model);
		this.getModelObject().search();
	}
	
	@Override
	protected void createMainTemplate(Panel mainPanel) {
		this.setTitle("Buscador de Asientos");
		this.setTaskDescription("Ingrese los parámetros de búsqueda");

		super.createMainTemplate(mainPanel);
		this.createResultsGrid(mainPanel);
		this.createGridActions(mainPanel);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel searchFormPanel = new Panel(mainPanel);
		searchFormPanel.setLayout(new ColumnLayout(2));

		new Label(searchFormPanel).setText("Origen: ");
		new TextBox(searchFormPanel).bindValueToProperty("busqueda.origen");

		new Label(searchFormPanel).setText("Destino: ");
		new TextBox(searchFormPanel).bindValueToProperty("busqueda.destino");

		new Label(searchFormPanel).setText("Fecha: ");
		new TextBox(searchFormPanel).bindValueToProperty("busqueda.fechaV");
		
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions) //
			.setCaption("Buscar")
			.onClick(new MessageSend(this.getModelObject(), "search"))
			.setAsDefault();
	}
	
	protected void createResultsGrid(Panel mainPanel) {
		Table<Asiento> table = new Table<Asiento>(mainPanel, Asiento.class);
		table.setHeigth(300);
		table.setWidth(660);
		table.bindItemsToProperty("busqueda.resultado");
		table.bindValueToProperty("asientoSeleccionado");
		this.describeResultsGrid(table);
	}
	
	protected void describeResultsGrid(Table<Asiento> table) {
		
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

		Column<Asiento> ubicacionColumn = new Column<Asiento>(table);
		ubicacionColumn.setTitle("Ubicacion");
		ubicacionColumn.setFixedSize(100);
		ubicacionColumn.bindContentsToProperty("ubicacion");
		
		Column<Asiento> claseColumn = new Column<Asiento>(table);
		claseColumn.setTitle("Clase");
		claseColumn.setFixedSize(100);
		claseColumn.bindContentsToProperty("claseDeAsiento");
		
	}

	protected void createGridActions(Panel mainPanel) {
		Panel actionsPanel = new Panel(mainPanel);
		actionsPanel.setLayout(new HorizontalLayout());

		Button editC = new Button(actionsPanel);
		editC.setCaption("Comprar");
		editC.onClick(new MessageSend(this, "comprar"));

		Button editR = new Button(actionsPanel);
		editR.setCaption("Reservar");
		editR.onClick(new MessageSend(this, "reservar"));

		Button remove = new Button(actionsPanel);
		remove.setCaption("Cerrar");
		remove.onClick(new MessageSend(this, "close"));
	}


//	@Override
//	protected void addActions(Panel actions) {
//		new Button(actions)
//			.setCaption("Aceptar")
//			.onClick(new MessageSend(this, "accept"))
//			.setAsDefault()
//			.disableOnError();
//
//		new Button(actions) //
//			.setCaption("Cancelar")
//			.onClick(new MessageSend(this, "cancel"));
//	}
}
