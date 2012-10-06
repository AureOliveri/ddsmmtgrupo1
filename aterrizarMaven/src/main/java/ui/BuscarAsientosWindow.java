package main.java.ui;


import main.java.enumeraciones.Ciudad;
import main.java.modelos.ModeloBuscador;
import main.java.modelos.ModeloOperacion;
import main.java.modelos.ModeloPrincipal;
import main.java.modelos.ModeloSobreReserva;
import main.java.repositorios.RepositorioDestinos;
import main.java.repositorios.RepositorioOrigenes;
import main.java.vuelos.Asiento;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

public class BuscarAsientosWindow extends Dialog<ModeloBuscador> {

	public BuscarAsientosWindow(WindowOwner owner, ModeloBuscador model) {
		super(owner, model);
	}
	
	@Override
	protected void createMainTemplate(Panel mainPanel) {
		this.setTitle("Aterrizar.com");
		this.setTaskDescription("Ingresar parametros obligatorios de busqueda");

		super.createMainTemplate(mainPanel);
		this.createResultsGrid(mainPanel);
		this.createGridActions(mainPanel);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel searchFormPanel = new Panel(mainPanel);
		searchFormPanel.setLayout(new ColumnLayout(2));

		new Label(searchFormPanel).setText("Origen: (EZE, PER, AEO, _BS, SLA, _NY) ");
		Selector<Ciudad> selectorO = new Selector<Ciudad>(searchFormPanel).allowNull(false);
		selectorO //
			.bindItems(new ObservableProperty(RepositorioOrigenes.getInstance(), "ciudades"));
		selectorO.bindValueToProperty("busqueda.origen");

		new Label(searchFormPanel).setText("Destino: (USA, PER, USH, _BS, SLA, _NY) ");
		Selector<Ciudad> selectorD = new Selector<Ciudad>(searchFormPanel).allowNull(false);
		selectorD//
			.bindItems(new ObservableProperty(RepositorioDestinos.getInstance(), "ciudades"));
		selectorD.bindValueToProperty("busqueda.destino");
		
		new Label(searchFormPanel).setText("Fecha: (DD/MM/AAAA)");
		new TextBox(searchFormPanel).setWidth(75).bindValueToProperty("fecha");
		
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions) //
			.setCaption("Buscar")
			.onClick(new MessageSend(this.getModelObject(), "search"))
			.setAsDefault()
			.disableOnError();
	}
	
	protected void createResultsGrid(Panel mainPanel) {
		Table<Asiento> table = new Table<Asiento>(mainPanel, Asiento.class);
		table.setHeigth(150);
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
		
		NotNullObservable elementSelected = new NotNullObservable("asientoSeleccionado");
		editC.bindEnabled(elementSelected);
		editR.bindEnabled(elementSelected);
	}
	
	public void reservar() {
		Boolean reservaExitosa = this.getModelObject().reservar();
		if(reservaExitosa){
			this.openDialog(new MensajeWindow(this, this.getModelObject()));			
		} else {
			this.openDialog(new SobreReservaWindow(this, new ModeloSobreReserva(this.getModelObject().getAsientoSeleccionado())));
		}
	}
	
	public void comprar() {
		this.getModelObject().comprar();
		this.openDialog(new MensajeWindow(this, this.getModelObject()));
		this.getModelObject().search();
	}
	
	protected void openDialog(Dialog<?> dialog) {
		dialog.onAccept(new MessageSend(this.getModelObject(), "search"));
		dialog.open();
	}

}
