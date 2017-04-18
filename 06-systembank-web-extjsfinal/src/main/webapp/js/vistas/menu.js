Ext.onReady(function() {

		
	function clientesHandler(){
		viewGrid.removeAll(false,false);
		viewGrid.add({
			html:'<div id="consultas"></div>'
		});
		
		if(!renderGridClientes){
			gridClientes.render("consultas");
			renderGridClientes = true;
		}
		viewGrid.add(gridClientes);
	}
	
	function bancosHandler(){
		viewGrid.removeAll(false,false);
		viewGrid.add({
			html:'<div id="consultas"></div>'
		});	
	}
	
	
	var menu = Ext.create('Ext.menu.Menu', {
		width : '100pct',
		plain : true,
		floating : false, // usually you want this set to True (default)
		items : [ {
			text : 'Clientes',
			handler:clientesHandler
		}, {
			text : 'Bancos',
			handler:bancosHandler
		} ]
	});
	
	menu.render("menu");
});