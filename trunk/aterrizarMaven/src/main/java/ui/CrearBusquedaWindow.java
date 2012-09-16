package main.java.ui;

import main.java.busquedas.Buscador;
import main.java.busquedas.Busqueda;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;

import com.uqbar.commons.collections.Transformer;

public class CrearBusquedaWindow extends TransactionalDialog<Buscador> {

	public CrearBusquedaWindow(WindowOwner owner, Buscador model) {
		super(owner, model);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));

		new Label(form).setText("Orirgen: ");
		new TextBox(form);
//		.bindValueToProperty("origen");

		new Label(form).setText("Destino: ");
		new TextBox(form);
//		.bindValueToProperty("destino");

		new Label(form).setText("Fecha (AAAAMMDD): ");
		new TextBox(form);
		
		
		Table<Busqueda> table = new Table<Busqueda>(mainPanel, Busqueda.class);
		this.describeResultsGrid(table);
		
		
	}
	
	protected void describeResultsGrid(Table<Busqueda> table) {
		Column<Busqueda> aerolineaColum = new Column<Busqueda>(table);
		aerolineaColum.setTitle("Aerolinea");
		aerolineaColum.setFixedSize(150);
		aerolineaColum.bindContentsToProperty("aerolinea");

		Column<Busqueda> vueloColum = new Column<Busqueda>(table);
		vueloColum.setTitle("Vuelo");
		vueloColum.setFixedSize(100);
		vueloColum.bindContentsToProperty("vuelo");
		
		Column<Busqueda> asientoColum = new Column<Busqueda>(table);
		asientoColum.setTitle("Asiento");
		asientoColum.setFixedSize(100);
		asientoColum.bindContentsToProperty("asiento");

		Column<Busqueda> precioColumn = new Column<Busqueda>(table);
		precioColumn.setTitle("Precio");
		precioColumn.setFixedSize(100);
		precioColumn.bindContentsToProperty("precio");

		Column<Busqueda> ubicacionColumn = new Column<Busqueda>(table);
		ubicacionColumn.setTitle("Ubicacion");
		ubicacionColumn.setFixedSize(100);
		ubicacionColumn.bindContentsToProperty("ubicacion");
		
		Column<Busqueda> claseColumn = new Column<Busqueda>(table);
		claseColumn.setTitle("Clase");
		claseColumn.setFixedSize(100);
		claseColumn.bindContentsToProperty("clase");
		
	}


	@Override
	protected void addActions(Panel actions) {
		new Button(actions)
			.setCaption("Aceptar")
			.onClick(new MessageSend(this, "accept"))
			.setAsDefault()
			.disableOnError();

		new Button(actions) //
			.setCaption("Cancelar")
			.onClick(new MessageSend(this, "cancel"));
	}
}
