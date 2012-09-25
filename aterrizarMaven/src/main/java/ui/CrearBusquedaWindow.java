package main.java.ui;

import java.awt.Color;

import main.java.busquedas.Buscador;
import main.java.busquedas.Busqueda;
import main.java.vuelos.Asiento;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Search;

import com.uqbar.commons.collections.Transformer;

public class CrearBusquedaWindow extends TransactionalDialog<Busqueda> {

	public CrearBusquedaWindow(WindowOwner owner, Busqueda model) {
		super(owner, model);
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

		new Label(searchFormPanel).setText("Orirgen: ");
		new TextBox(searchFormPanel).bindValueToProperty("origen");

		new Label(searchFormPanel).setText("Destino: ");
		new TextBox(searchFormPanel);
//		.bindValueToProperty("destino");

		new Label(searchFormPanel).setText("Fecha: ");
		new TextBox(searchFormPanel);
		
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions) //
			.setCaption("Buscar")
			.onClick(new MessageSend(this, Search.SEARCH));
	}
	
	protected void createResultsGrid(Panel mainPanel) {
		Table<Asiento> table = new Table<Asiento>(mainPanel, Asiento.class);
//		table.bindItemsToProperty("asiento");
		this.describeResultsGrid(table);
	}
	
	protected void describeResultsGrid(Table<Asiento> table) {
		Column<Asiento> aerolineaColum = new Column<Asiento>(table);
		aerolineaColum.setTitle("Aerolinea");
		aerolineaColum.setFixedSize(150);
		aerolineaColum.bindContentsToProperty("aerolinea");

		Column<Asiento> vueloColum = new Column<Asiento>(table);
		vueloColum.setTitle("Vuelo");
		vueloColum.setFixedSize(100);
		vueloColum.bindContentsToProperty("vuelo");
		
		Column<Asiento> asientoColum = new Column<Asiento>(table);
		asientoColum.setTitle("Asiento");
		asientoColum.setFixedSize(100);
		asientoColum.bindContentsToProperty("asiento");

		Column<Asiento> precioColumn = new Column<Asiento>(table);
		precioColumn.setTitle("Precio");
		precioColumn.setFixedSize(100);
		precioColumn.bindContentsToProperty("precio");

		Column<Asiento> ubicacionColumn = new Column<Asiento>(table);
		ubicacionColumn.setTitle("Ubicacion");
		ubicacionColumn.setFixedSize(100);
		ubicacionColumn.bindContentsToProperty("ubicacion");
		
		Column<Asiento> claseColumn = new Column<Asiento>(table);
		claseColumn.setTitle("Clase");
		claseColumn.setFixedSize(100);
		claseColumn.bindContentsToProperty("clase");
		
	}

	protected void createGridActions(Panel mainPanel) {
		Panel actionsPanel = new Panel(mainPanel);
		actionsPanel.setLayout(new HorizontalLayout());

		Button edit = new Button(actionsPanel);
		edit.setCaption("Aceptar");
		edit.onClick(new MessageSend(this, "cancel"));

		Button remove = new Button(actionsPanel);
		remove.setCaption("Cancelar");
		remove.onClick(new MessageSend(this, "cancel"));

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
