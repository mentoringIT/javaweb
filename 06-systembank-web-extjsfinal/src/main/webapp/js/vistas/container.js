var viewGrid;
Ext.onReady(function() {

	var container = Ext.create('Ext.panel.Panel', {
		width : '100pct',
		height : Ext.getBody().getViewSize().height * 1,
		title : 'Administraci&oacute;n de clientes',
		layout : 'border',
		items : [ {
			title : 'South Region is resizable',
			region : 'south', // position for region
			xtype : 'panel',
			height : 100,
			split : true, // enable resizing
			margins : '0 5 5 5'
		}, {
			// xtype: 'panel' implied by default
			title : 'Admisnitraci&oacute;n de cat&aacute;logos',
			region : 'west',
			xtype : 'panel',
			margins : '5 0 0 5',
			width : 200,
			collapsible : true, // make collapsible
			id : ' ',
			layout : 'fit',
			html : '<div id="menu"></div>'
		}, {
			title : 'Center Region',
			region : 'center', // center region is required, no width/height
			// specified
			xtype : 'panel',
			layout : 'fit',
			margins : '5 5 0 0',
			html : '<div id="viewGrid"></div>'
		} ]
	});

	viewGrid = Ext.create('Ext.panel.Panel',{
		width:'100pct',
		height:600,
		items:{
			html:'<div id="consultas"></div>'
		}
	});

	container.render("container");
	viewGrid.render("viewGrid");
});
