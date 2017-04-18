Ext.onReady(function() {

	Ext.apply(Ext.form.VTypes,{
		regexp: validaCampos,
		regexpText:'Password invalido'
	});
	
	var formLogin = Ext.create('Ext.form.Panel', {
		title : 'Acceso',
		bodyPadding : 5,
		width : 350,
		url : 'login',

		items : [ {
			xtype : 'textfield',
			fieldLabel : 'Usuario',
			name : 'usuario',
			allowBlank:false,
			blankText:'Campo requerido',
			vtype:'regexp'
		}, {
			xtype : 'textfield',
			fieldLabel : 'Contrase&ntilde;a',
			name : 'password',
			inputType : 'password',
			allowBlank:false,
			blankText:'Campo requerido',
			vtype:'regexp'
		} ],

		buttons : [ {
			text : 'Entrar',
			handler : function() {
				formLogin.getForm().submit(
						{
							method : 'POST',
							success : function(form, request) {
								window.location = 'admin.jsp';
							},
							failure : function(form, action) {
								Ext.Msg.alert('Error',
										'Usuario o password incorrecto');

							}
						});
			}
		} ]
	});

	formLogin.render("formLogin");
});