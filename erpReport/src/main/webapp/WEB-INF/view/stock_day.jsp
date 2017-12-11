<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>库存日报表</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<link href="resources/css/jquery-ui-themes.css" type="text/css"
	rel="stylesheet" />
<link href="resources/css/axure_rp_page.css" type="text/css"
	rel="stylesheet" />
<link href="data/styles.css" type="text/css" rel="stylesheet" />
<link href="files/stock_day/styles.css" type="text/css" rel="stylesheet" />
<script src="resources/scripts/jquery-1.7.1.min.js"></script>
<script src="resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
<script src="resources/scripts/axure/axQuery.js"></script>
<script src="resources/scripts/axure/globals.js"></script>
<script src="resources/scripts/axutils.js"></script>
<script src="resources/scripts/axure/annotation.js"></script>
<script src="resources/scripts/axure/axQuery.std.js"></script>
<script src="resources/scripts/axure/doc.js"></script>
<script src="data/document.js"></script>
<script src="resources/scripts/messagecenter.js"></script>
<script src="resources/scripts/axure/events.js"></script>
<script src="resources/scripts/axure/recording.js"></script>
<script src="resources/scripts/axure/action.js"></script>
<script src="resources/scripts/axure/expr.js"></script>
<script src="resources/scripts/axure/geometry.js"></script>
<script src="resources/scripts/axure/flyout.js"></script>
<script src="resources/scripts/axure/ie.js"></script>
<script src="resources/scripts/axure/model.js"></script>
<script src="resources/scripts/axure/repeater.js"></script>
<script src="resources/scripts/axure/sto.js"></script>
<script src="resources/scripts/axure/utils.temp.js"></script>
<script src="resources/scripts/axure/variables.js"></script>
<script src="resources/scripts/axure/drag.js"></script>
<script src="resources/scripts/axure/move.js"></script>
<script src="resources/scripts/axure/visibility.js"></script>
<script src="resources/scripts/axure/style.js"></script>
<script src="resources/scripts/axure/adaptive.js"></script>
<script src="resources/scripts/axure/tree.js"></script>
<script src="resources/scripts/axure/init.temp.js"></script>
<script src="files/stock_day/data.js"></script>
<script src="resources/scripts/axure/legacy.js"></script>
<script src="resources/scripts/axure/viewer.js"></script>
<script src="resources/scripts/axure/math.js"></script>
<%@ include file="../../../page/public_base_new.jsp"%>
<script type="text/javascript">
      $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
      $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
      $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
    </script>
</head>
<body>
	<input type="hidden" id="orgId" value="${orgId}" />
	<input type="hidden" id="openId" value="${openId}" />
	<input type="hidden" id="schemaName" value="${schemaName}" />

	<div id="base" class="">
		<!-- 库存日报表查询面板 (动态面板) -->
		<div id="u11070" class="ax_default" data-label="库存日报表查询面板">
			<div id="u11070_state0" class="panel_state" data-label="查询条件">
				<div id="u11070_state0_content" class="panel_state_content">
					<form id="mysearch" method="post">
						<!-- Unnamed (矩形) -->
						<div id="u11071" class="ax_default box_1">
							<div id="u11071_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11072" class="text"
								style="display: none; visibility: hidden">
								<p>
									<span></span>
								</p>
							</div>
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11073" class="ax_default box_1">
							<div id="u11073_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11074" class="text" style="visibility: visible;">
								<p>
									<span class="a">查询</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11075" class="ax_default box_1">
							<div id="u11075_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11076" class="text" style="visibility: visible;">
								<p>
									<span>库存日报表</span>
								</p>
							</div>
						</div>

						<!-- 查询按钮 (提交按钮) -->
						<div id="u11077" class="ax_default html_button">
							<input id="u11077_input" type="button" value="查询"
								onclick='search()' />
						</div>

						<!-- 重置按钮 (提交按钮) -->
						<div id="u11078" class="ax_default html_button">
							<input id="u11078_input" type="button" value="重置" />
						</div>

						<!-- 商品编号 (矩形) -->
						<div id="u11079" class="ax_default label">
							<div id="u11079_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11080" class="text" style="visibility: visible;">
								<p>
									<span>商品编号</span>
								</p>
							</div>
						</div>

						<!-- 商品编号 (文本框) -->
						<div id="u11081" class="ax_default text_field">
							<input id="u11081_input" name="commodityCode" type="text"
								placeholder="请输入商品编号" />
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11082" class="ax_default label">
							<div id="u11082_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11083" class="text" style="visibility: visible;">
								<p>
									<span>品牌名称</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11084" class="ax_default label">
							<div id="u11084_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11085" class="text" style="visibility: visible;">
								<p>
									<span>型号名称</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11086" class="ax_default label">
							<div id="u11086_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11087" class="text" style="visibility: visible;">
								<p>
									<span>商品分类</span>
								</p>
							</div>
						</div>

						<!-- 商品分类 (下拉列表框) -->
						<div id="u11088" class="ax_default droplist">
							<input type="text" id="u11088_input">
						</div>

						<!-- 品牌名称 (下拉列表框) -->
						<div id="u11089" class="ax_default droplist">
							<input type="text" id="u11089_input">
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11090" class="ax_default label">
							<div id="u11090_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11091" class="text" style="visibility: visible;">
								<p>
									<span>组织机构</span>
								</p>
							</div>
						</div>

						<!-- 组织机构 (下拉列表框) -->
						<div id="u11092" class="ax_default droplist">
							<input type="text" id="u11092_input">
						</div>

						<!-- 型号名称 (下拉列表框) -->
						<div id="u11093" class="ax_default droplist">
							<input type="text" id="u11093_input">
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11094" class="ax_default label">
							<div id="u11094_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11095" class="text" style="visibility: visible;">
								<p>
									<span>仓库</span>
								</p>
							</div>
						</div>

						<!-- 仓库名称 (下拉列表框) -->
						<div id="u11096" class="ax_default droplist">
							<input type="text" id="u11096_input">
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11097" class="ax_default label">
							<div id="u11097_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11098" class="text" style="visibility: visible;">
								<p>
									<span>&nbsp;</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11099" class="ax_default label">
							<div id="u11099_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11100" class="text" style="visibility: visible;">
								<p>
									<span>商品名称</span>
								</p>
							</div>
						</div>

						<!-- 商品名称 (文本框) -->
						<div id="u11101" class="ax_default text_field">
							<input id="u11101_input" name="commodityName" type="text"
								placeholder="请输入商品名称" />
						</div>

						<!-- 起始日期 (文本框) -->
						<div id="u11102" class="ax_default text_field">
							<input id="u11102_input" name="startDate" type="text" editable="false"
								class="easyui-datebox" style="width: 190px" />
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11103" class="ax_default label">
							<div id="u11103_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11104" class="text" style="visibility: visible;">
								<p>
									<span>起始日期</span>
								</p>
							</div>
						</div>

						<!-- 终止日期 (文本框) -->
						<div id="u11105" class="ax_default text_field">
							<input id="u11105_input" name="endDate" type="text" editable="false"
								class="easyui-datebox" style="width: 190px" />
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11106" class="ax_default label">
							<div id="u11106_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11107" class="text" style="visibility: visible;">
								<p>
									<span>终止日期</span>
								</p>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div id="u11070_state1" class="panel_state" data-label="库存日报表"
				style="display: none; visibility: hidden;">
				<div id="u11070_state1_content" class="panel_state_content">

					<!-- Unnamed (矩形) -->
					<div id="u11108" class="ax_default box_1">
						<div id="u11108_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u11109" class="text"
							style="display: none; visibility: hidden">
							<p>
								<span></span>
							</p>
						</div>
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u11110" class="ax_default box_1">
						<div id="u11110_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u11111" class="text" style="visibility: visible;">
							<p>
								<span class="a">查询</span>
							</p>
						</div>
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u11112" class="ax_default box_1">
						<div id="u11112_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u11113" class="text"
							style="display: none; visibility: hidden">
							<p>
								<span></span>
							</p>
						</div>
					</div>

					<!-- Unnamed (表格) -->
					<div id="u11114" class="ax_default">
						<div id="lays" class="easyui-layout"
							style="width: 1090px; height: 540px">
							<!-- 列表 -->
							<div region="center" id="s">
								<table id="stock"></table>
							</div>
						</div>
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u11253" class="ax_default box_1">
						<div id="u11253_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u11254" class="text" style="visibility: visible;">
							<p>
								<span>库存日报表</span>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
$(function(){
	var orgId=$('#orgId').val();
	var openId=$('#openId').val();
	var schemaName=$('#schemaName').val();
	//组织机构
	$('#u11092_input').combobox({
		url:'<%=path%>/getOrgList?orgId='+orgId+'&schemaName='+schemaName ,
		valueField:'id',
		textField:'text',
		editable:false ,
		width : '190',
		//panelHeight:'auto'
		onChange:function(value){
			$('#u11096_input').combobox({
				url:'<%=path%>/getWarehouseList?orgId='+value+'&schemaName='+schemaName ,
				valueField:'id',
				textField:'text',
				editable:false,
				width:'190',
				//panelHeight:'auto'
			});
		}
	});
	//仓库名称
	$('#u11096_input').combobox({
		url:'<%=path%>/getWarehouseList?schemaName='+schemaName+'&orgId=' 
			+$('#u11092_input').combobox('getValue'),
		valueField:'id',
		textField:'text',
		editable:false,
		width:'190',
		//panelHeight:'auto'
	});
	//商品分类
	$('#u11088_input').combobox({
		url:'<%=path%>/getCatalogList?orgId='+orgId+'&schemaName='+schemaName,
		valueField:'id',
		textField:'text',
		editable:true,
		width:'190',
		//panelHeight:'auto',
		onChange:function(value){
		    if(value!='0'){
		    	//品牌
				$('#u11089_input').combobox({
					valueField:'id', //值字段
					textField:'text', //显示的字段
					url:'<%=path%>/getBrandList?&catalogCode='+ value+'&schemaName='+schemaName+'&orgId='+orgId,
					editable:false,//不可编辑，只能选择
					width:'190',
					//panelHeight:'auto',
					onChange:function(value){
						if(value!=''&&value!=null){
						    //型号
							$('#u11093_input').combobox({
								valueField:'id', //值字段
								textField:'text', //显示的字段
								url:'<%=path%>/getModelList?&brandCode='+ value+'&schemaName='+schemaName+'&orgId='+orgId,
								editable:false,//不可编辑，只能选择
								width:'190',
								//panelHeight:'auto'
							}); 
						}
					 }
				}); 
			}
		}
	});
	//品牌
	$('#u11089_input').combobox({
		valueField:'id', //值字段
		textField:'text', //显示的字段
		url:'<%=path%>/getBrandList?schemaName='+schemaName+'&orgId='+orgId+'&catalogCode='
			+ $('#u11088_input').combobox('getValue'),
		editable:false,//不可编辑，只能选择
		width:'190',
		//panelHeight:'auto',
	});
	//型号
	$('#u11093_input').combobox({
		valueField:'id', //值字段
		textField:'text', //显示的字段
		url:'<%=path%>/getModelList?schemaName='+schemaName+'&orgId='+orgId+'&brandCode='
			+ $('#u11089_input').combobox('getValue'),
		editable:false,//不可编辑，只能选择
		width:'190',
		//panelHeight:'auto'
	});
});

function search(){
	var schemaName=$('#schemaName').val();
	var orgId=$('#u11092_input').combobox('getValue');
	var warehouseName=$('#u11096_input').combobox('getValue');
	var org=$('#orgId').val();
	var commodityCode=$('#u11081_input').val();
	var commodityName=$('#u11101_input').val();
	var catalogName=$('#u11088_input').combobox('getValue');
	var brandName=$('#u11089_input').combobox('getValue');
	var modelName=$('#u11093_input').combobox('getValue');
	var start=$('#u11102_input').datebox('getValue');
	var end=$('#u11105_input').datebox('getValue');
	var d1 = formatDatebox(start);
	var d2 = formatDatebox(end);
	if(start.length==0 || end.length==0){
		$.messager.alert('警告','必须选择时间范围','warning');
		return;
	}
	if(start && end && d1>d2){
		$.messager.alert('警告','结束时间要大于开始时间','warning');
		return;
	}
	
	//采用jquery easyui loading css效果
	function ajaxLoading(){
		$("<div class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",height:$(window).height()}).appendTo("body");
		$("<div class=\"datagrid-mask-msg\"></div>").html("正在处理，请稍候。。。").appendTo("body").css({display:"block",left:($(document.body).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2});
	}
	function ajaxLoadEnd(){
		$(".datagrid-mask").remove();
		$(".datagrid-mask-msg").remove();            
	}
	$('#stock').datagrid({
		idField:'stockDay',	//只要创建数据表格 就必须要加 ifField
		fit:true,
		height:540,
		url:'/getStockDay',
		//fitColumns:true ,  
		//striped: true ,	//隔行变色特性 
		//nowrap: false ,	//折行显示 为true 显示在一会 
		loadMsg: '数据正在加载,请耐心等待...',
		rownumbers:true,
		showFooter:true,
		queryParams: {
			schemaName:schemaName,
			orgId:orgId,
			warehouseName:warehouseName,
			commodityName:commodityName,
			commodityCode:commodityCode,
			catalogName:catalogName,
			brandName:brandName,
			modelName:modelName,
			startDate:start,
			endDate:end,
			orgName:org
		},  
		onClickRow: function (rowIndex, rowData) {
			$(this).datagrid('unselectRow', rowIndex);
		},
		rowStyler: function() {
			return 'height: 50px';
		},
		columns:[[
		{
			field:'orgName', 
			title:'组织机构', 
			align:'center',
			width:150
		},
		{
			field:'whName',
			title:'仓库名称',
			align:'center',
			width:120
		},
		{
			field:'commodityCode', 
			title:'商品编码', 
			align:'center',
			width:200	
		},
		{
			field:'commodityName', 
			title:'商品名称',
			align:'center',
			width:180
		},
		{
			field:'beginQuantity', 
			title:'期初库存量',
			align:'center',
			width:100
		},
		{
			field:'purchaseIn' , 
			title:'采购入库量' ,
			align:'center',
			width:100
		},
		{
			field:'purchaseReturn' , 
			title:'采购退货量' ,
			align:'center',
			width:100
		},
		{
		   	field:'purchaseExpendIn',
			title:'采购换货入库量',
			align:'center',
			width:120
		},
		{
			field:'purchaseExpendOut',
			title:'采购换货出库量',
			align:'center',
			width:120
		},
		{
			field:'allotOut', 
			title:'调拨出库数量',
			align:'center',
			width:100
		},
		{
			field:'allotIn', 
			title:'调拨入库数量',
			align:'center',
			width:100
		},
		{
			field:'profitQuantity', 
			title:'盘盈数量',
			align:'center',
			width:100
		},
		{
			field:'lossQuantity', 
			title:'盘亏数量', 
			align:'center',
			width:100
		},
		{
			field:'trimQuantity', 
			title:'调整量', 
			align:'center',
			width:100
		},
		{
			field:'saleOut', 
			title:'销售出库量', 
			align:'center',
			width:100
		},
		{
			field:'saleReturn', 
			title:'销售退货量', 
			align:'center',
			width:100
		},
		{
			field:'saleExpendOut', 
			title:'销售换货出库量', 
			align:'center',
			width:120
		},
		{
			field:'saleExpendIn', 
			title:'销售换货入库量', 
			align:'center',
			width:120
		},
		{
			field:'finalQuantity', 
			title:'期末库存量', 
			align:'center',
			width:100
		},
		{
			field:'catalogName', 
			title:'分类名称', 
			align:'center',
			width:150
		},
		{
			field:'brandName', 
			title:'品牌名称', 
			align:'center',
			width:150	
		},
		{
			field:'modelName', 
			title:'型号名称', 
			align:'center',
			width:150
		},
		{
			field:'spec', 
			title:'规格', 
			align:'center',
			width:150,
			formatter:function(value){
				var strs= new Array(); //定义一数组 
				var a='<br/>'
				if(value != null){
					strs=value.split("/"); //字符分割 
					for (i=0;i<strs.length ;i++ ) 
					{ 
						 a+=strs[i]+'<br/>'
					}
				}
				return '<span>'+a+'</span>'
			}
		}
		]],
		pagination:true, 
		pageSize:10,
		pageList:[10],	
	});
	$(".datagrid-body").css("overflow-x","scroll");
	document.getElementById('u11070_state1').style.display='block';
	document.getElementById('u11070_state1').style.visibility='visible';
}

//查询按钮点击事件
$('.a').click(function(){
	document.getElementById('u11070_state1').style.display='none';
	document.getElementById('u11070_state1').style.visibility='hidden';
	document.getElementById('u11070_state0').style.display='block';
	document.getElementById('u11070_state0').style.visibility='visible';
});

//js方法：序列化表单 			
function serializeForm(form){
	var obj = {};
	$.each(form.serializeArray(),function(index){
		if(obj[this['name']]){
			obj[this['name']] = obj[this['name']] + ','+this['value'];
		} else {
			obj[this['name']] =this['value'];
		}
	});
	return obj;
}

//重置按钮
$('#u11078_input').click(function(){
	var orgId=$('#orgId').val();
	var openId=$('#openId').val();
	var schemaName=$('#schemaName').val();
	$('#mysearch').form('clear');
	$('#u11092_input').combobox({
		url:'<%=path%>/getOrgList?orgId='+orgId+'&schemaName='+schemaName,
		valueField:'id',
		textField:'text',
		editable:false,
		width : '190',
		//panelHeight:'auto'
	});
	$('#u11096_input').combobox({
		url:'<%=path%>/getWarehouseList?orgId='+orgId+'&schemaName='+schemaName,
		valueField:'id',
		textField:'text',
		editable:false ,
		width:'190',
		//panelHeight:'auto'
	});
	//商品分类
	$('#u11088_input').combobox({
		url:'<%=path%>/getCatalogList?orgId='+orgId+'&schemaName='+schemaName ,
		valueField:'id',
		textField:'text',
		editable:true ,
		width:'190',
		//panelHeight:'auto',
		onChange:function(value){
			if(value!='0'){
				//商品品牌
				$('#u11089_input').combobox({
					valueField:'id', //值字段
					textField:'text', //显示的字段
					url:'<%=path%>/getBrandList?&catalogCode='+ value+'&schemaName='+schemaName+'&orgId='+orgId,
					editable:true,//不可编辑，只能选择
					//width: 200,
					width : '190',
					//panelHeight:'auto',
					onChange:function(value){
						if(value!=''&&value!=null){
							//商品型号
							$('#u11093_input').combobox({
								valueField:'id', //值字段
								textField:'text', //显示的字段
								url:'<%=path%>/getModelList?&brandCode='+ value+'&schemaName='+schemaName+'&orgId='+orgId,
								editable:true,//不可编辑，只能选择
								width : '190',
								//panelHeight:'auto'
							}); 
						}
					}
				}); 
			}
		}
	});
	//品牌
	$('#u11089_input').combobox({
		valueField:'id', //值字段
		textField:'text', //显示的字段
		url:'<%=path%>/getBrandList?schemaName='+schemaName+'&orgId='+orgId+'&catalogCode='
			+ $('#u11088_input').combobox('getValue'),
		editable:true,//不可编辑，只能选择
		//width: 200,
		width : '190',
		//panelHeight:'auto',
	});
	//型号
	$('#u11093_input').combobox({
		valueField:'id', //值字段
		textField:'text', //显示的字段
		url:'<%=path%>/getModelList?schemaName='+schemaName+'&orgId='+orgId+'&brandCode='
			+ $('#u11089_input').combobox('getValue'),
		editable : true,//不可编辑，只能选择
		width : '190',
		//panelHeight:'auto'
	});
});
</script>
</html>
