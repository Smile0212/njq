/**
 * 
 */

$(function() {


	$("#dg").datagrid({
		width : 700,
		height : 250,
		nowrap : true,
		striped : true,
		border : true,
		fit : true,
		fitColumns : true,


		url : 'userList.do',


		
		singleSelect : true,
		pagination : true,
		rownumbers : true,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		toolbar : [ {
			text : '添加',
			iconCls : 'icon-add',
			handler : function() {

			}
		}, '-', {
			text : '修改',
			iconCls : 'icon-edit',
			handler : function() {
			}
		}, '-', {
			text : '删除',
			iconCls : 'icon-remove',
			handler : function() {
			}
		} ],
	});

	var p = $('#dg').datagrid('getPager');
	$(p).pagination({
		pageSize : 10,
		pageList : [ 5, 10, 15 ],
		beforePageText : '第',
		afterPageText : '页   共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});

});