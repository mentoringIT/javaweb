var gridClientes;
var renderGridClientes;
Ext
		.onReady(function() {

			Ext.define('BancoModel', {
				extend : 'Ext.data.Model',
				fields : [ {
					name : 'nombre',
					type : 'string'
				}, {
					name : 'idBanco',
					type : 'int'
				} ]
			});

			var storeBancos = Ext.create('Ext.data.Store', {
				model : 'BancoModel',
				autoLoad : true,
				autoSync : true,
				proxy : {
					type : 'ajax',
					api : {
						read : 'bancos'
					},
					reader : {
						root : 'bancos'
					}
				}
			});

			Ext.define('ClienteModel', {
				extend : 'Ext.data.Model',
				fields : [ {
					name : 'idCliente',
					type : 'int'
				}, {
					name : 'nombre',
					type : 'string'
				}, {
					name : 'apaterno',
					type : 'string'
				}, {
					name : 'amaterno',
					type : 'string'
				}, {
					name : 'edad',
					type : 'int'
				}, {
					name : 'idBanco',
					type : 'int'
				} ]
			});

			var storeClientes = Ext
					.create(
							'Ext.data.Store',
							{
								model : 'ClienteModel',
								autoLoad : true,
								autoSync : true,
								proxy : {
									type : 'ajax',
									api : {
										read : 'clientes',
										update : 'actualizar',
										destroy : 'eliminar',
										create : 'guardar'
									},
									reader : {
										root : 'clientes'
									},
									afterRequest : function(request, response) {
										if (request.operation.response.responseText == '{success:true}') {
											Ext.MessageBox
													.show({
														title : 'Informacion',
														msg : 'Actualizacion realizada',
														buttons : Ext.MessageBox.OK,
														icons : Ext.MessageBox.INFO
													});
										} else if (request.operation.response.responseText == '{failure:true}') {
											Ext.MessageBox.show({
												title : 'Error',
												msg : 'Error al Actualizar',
												buttons : Ext.MessageBox.OK,
												icons : Ext.MessageBox.ERROR
											});
										}
									}
								}
							});

			var rowEdit = Ext.create('Ext.grid.plugin.RowEditing', {
				clicksToEdit : 1
			});

			
			var nameToFind;
			function searchCriteria(textField, e, eOpts) {
				nameToFind = textField.value;
			}
			function searchStore() {
				var user = gridClientes.store.findRecord('nombre', nameToFind);
				gridClientes.getView().focusRow(user.index);

				var tr = gridClientes.getView().getNode(user.index);
				el = Ext.get(tr).select('td');
				el.addCls('red-back');
			}	
			
			function getPDFFile(){
				
				window.location.href='ServletPDFClientes'
				
			}
			
			gridClientes = Ext.create('Ext.grid.Panel', {
				title : 'Simpsons',
				store : storeClientes,
				plugins : [ rowEdit ],
				columns : [
						{
							text : 'id',
							dataIndex : 'idCliente'
						},
						{
							text : 'Nombre',
							dataIndex : 'nombre',
							editor : 'textfield'
						},
						{
							text : 'Apellido P.',
							dataIndex : 'apaterno',
							editor : 'textfield'
						},
						{
							text : 'Apellido M.',
							dataIndex : 'amaterno',
							editor : 'textfield'
						},
						{
							text : 'Edad',
							dataIndex : 'edad',
							editor : 'textfield'
						},
						{
							text : 'Banco',
							dataIndex : 'idBanco',
							editor : {
								xtype : 'combobox',
								store : storeBancos,
								query : 'local',
								displayField : 'nombre',
								valueField : 'idBanco',
								editable : false
							},
							renderer : function(value, metadata, record) {
								return storeBancos.getAt(storeBancos.find(
										'idBanco', value, 0)).data.nombre;
							}
						}, {
							text : 'Eliminar',
							xtype : 'actioncolumn',
							sortable : false,
							menuDisabled : true,
							items : [ {
								icon : 'js/vistas/images/delete.ico',
								handler : function(grid, rowIndex, colIndex) {
									storeClientes.removeAt(rowIndex);
								}
							} ]
						} ],
						tbar : [ {
							xtype : 'textfield',
							name : 'searchField',
							hideLabel : true,
							width : 200,
							enableKeyEvents : true,
							listeners : {
								keypress : {
									fn : searchCriteria,
									scope : this,
									buffer : 100
								}
							}
						},
						
						 {
							xtype : 'button',
							text : 'buscar',
							iconCls : 'icon-search',
							tooltip : 'Buscar clientes por nombre',
							handler : searchStore
						}
						,{
							xtype : 'button',
							text : 'PDF',
							iconCls : 'icon-pdf',
							tooltip : 'Find Previous Row',
							handler : getPDFFile
						}

						, {
							text : 'Agregar Cliente',
							handler : function() {
								storeClientes.suspendAutoSync();
								rowEdit.cancelEdit();
								var r = Ext.create('ClienteModel', {
									idCliente : 0,
									apaterno : "nuevo",
									amaterno : "nuevo",
									nombre : "nuevo",
									edad : 18,
									idBanco : 6
								});
								storeClientes.insert(0, r);
								rowEdit.startEdit(0, 0);
								storeClientes.resumeAutoSync();
							}
						} ],
				height : 200,
				width : '100pct'
			});
		});
