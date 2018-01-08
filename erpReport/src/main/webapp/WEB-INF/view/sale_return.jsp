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
<title>销售毛利查询</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<link href="resources/css/jquery-ui-themes.css" type="text/css"
	rel="stylesheet" />
<link href="resources/css/axure_rp_page.css" type="text/css"
	rel="stylesheet" />
<link href="data/styles.css" type="text/css" rel="stylesheet" />
<link href="files/sale_return/styles.css" type="text/css"
	rel="stylesheet" />
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
<script src="files/sale_return/data.js"></script>
<script src="resources/scripts/axure/legacy.js"></script>
<script src="resources/scripts/axure/viewer.js"></script>
<script src="resources/scripts/axure/math.js"></script>
<%@ include file="../../../page/public_base_new.jsp"%>
<script type="text/javascript">
	$axure.utils.getTransparentGifPath = function() {
		return 'resources/images/transparent.gif';
	};
	$axure.utils.getOtherPath = function() {
		return 'resources/Other.html';
	};
	$axure.utils.getReloadPath = function() {
		return 'resources/reload.html';
	};
</script>
</head>
<body>
	<input type="hidden" id="orgId" value="${orgId}" />
	<input type="hidden" id="openId" value="${openId}" />
	<input type="hidden" id="schemaName" value="${schemaName}" />
	<div id="base" class="">
		<!-- 销售状况汇总查询表 (动态面板) -->
		<div id="u16023" class="ax_default" data-label="销售状况汇总查询表">
			<div id="u16023_state0" class="panel_state" data-label="查询条件">
				<div id="u16023_state0_content" class="panel_state_content">
					<form id="mysearch" method="post">

						<!-- Unnamed (矩形) -->
						<div id="u16024" class="ax_default box_1">
							<div id="u16024_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u16025" class="text"
								style="display: none; visibility: hidden">
								<p>
									<span></span>
								</p>
							</div>
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u16026" class="ax_default box_1">
							<div id="u16026_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u16027" class="text" style="visibility: visible;">
								<p>
									<span class="a">查询</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u16028" class="ax_default box_1">
							<div id="u16028_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u16029" class="text" style="visibility: visible;">
								<p>
									<span>销售毛利</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (提交按钮) -->
						<div id="u16030" class="ax_default html_button">
							<input id="u16030_input" type="button" value="查询" onclick="search()"/>
						</div>

						<!-- Unnamed (提交按钮) -->
						<div id="u16031" class="ax_default html_button">
							<input id="u16031_input" type="button" value="重置" />
						</div>

						<!-- 起始日期 (文本框) -->
						<div id="u16032" class="ax_default text_field">
							<input id="u16032_input" name="startDate" type="text" editable="false"
								class="easyui-datebox" style="width: 190px" />
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u16033" class="ax_default label">
							<div id="u16033_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u16034" class="text" style="visibility: visible;">
								<p>
									<span>起始日期</span>
								</p>
							</div>
						</div>

						<!-- 终止日期 (文本框) -->
						<div id="u16035" class="ax_default text_field">
							<input id="u16035_input" name="endDate" type="text" editable="false"
								class="easyui-datebox" style="width: 190px" />
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u16036" class="ax_default label">
							<div id="u16036_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u16037" class="text" style="visibility: visible;">
								<p>
									<span>商品编号</span>
								</p>
							</div>
						</div>

						<!-- 商品编号 (文本框) -->
						<div id="u16038" class="ax_default text_field">
							<input id="u16038_input" name="commodityCode" type="text" class="easyui-textbox" data-options="prompt:'请输入商品编号'" />
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u16039" class="ax_default label">
							<div id="u16039_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u16040" class="text" style="visibility: visible;">
								<p>
									<span>品牌名称</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u16041" class="ax_default label">
							<div id="u16041_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u16042" class="text" style="visibility: visible;">
								<p>
									<span>型号名称</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u16043" class="ax_default label">
							<div id="u16043_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u16044" class="text" style="visibility: visible;">
								<p>
									<span>商品分类</span>
								</p>
							</div>
						</div>

						<!-- 商品分类  (下拉列表框) -->
						<div id="u16045" class="ax_default droplist">
							<input type="text" id="u16045_input">
						</div>

						<!-- 品牌名称 (下拉列表框) -->
						<div id="u16046" class="ax_default droplist">
							<input type="text" id="u16046_input">
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u16047" class="ax_default label">
							<div id="u16047_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u16048" class="text" style="visibility: visible;">
								<p>
									<span>组织机构</span>
								</p>
							</div>
						</div>

						<!-- 组织机构 (下拉列表框) -->
						<div id="u16049" class="ax_default droplist">
							<input type="text" id="u16049_input">
						</div>

						<!-- 型号名称 (下拉列表框) -->
						<div id="u16050" class="ax_default droplist">
							<input type="text" id="u16050_input">
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u16051" class="ax_default label">
							<div id="u16051_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u16052" class="text" style="visibility: visible;">
								<p>
									<span>终止日期</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u16053" class="ax_default label">
							<div id="u16053_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u16054" class="text" style="visibility: visible;">
								<p>
									<span>&nbsp;</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u16055" class="ax_default label">
							<div id="u16055_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u16056" class="text" style="visibility: visible;">
								<p>
									<span>商品名称</span>
								</p>
							</div>
						</div>

						<!-- 商品名称 (文本框) -->
						<div id="u16057" class="ax_default text_field">
							<input id="u16057_input" name="commodityName" type="text" class="easyui-textbox" data-options="prompt:'请输入商品名称'" />
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u16058" class="ax_default label">
							<div id="u16058_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u16059" class="text" style="visibility: hidden;">
								<p>
									<span>注：销售日报表用来查询指定时间段内的销售状况(购销商品)，目前只有串号/批次管理商品可支持销售毛利的计算</span>
								</p>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div id="u16023_state1" class="panel_state" data-label="销售毛利"
				style="display: none; visibility: hidden;">
				<div id="u16023_state1_content" class="panel_state_content">

					<!-- Unnamed (矩形) -->
					<div id="u16060" class="ax_default box_1">
						<div id="u16060_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u16061" class="text"
							style="display: none; visibility: hidden">
							<p>
								<span></span>
							</p>
						</div>
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u16062" class="ax_default box_1">
						<div id="u16062_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u16063" class="text" style="visibility: visible;">
							<p>
								<span class="a">查询</span>
							</p>
						</div>
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u16064" class="ax_default box_1">
						<div id="u16064_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u16065" class="text"
							style="display: none; visibility: hidden">
							<p>
								<span></span>
							</p>
						</div>
					</div>

					<!-- Unnamed (表格) -->
					<div id="u16066" class="ax_default">
						<div id="lays" class="easyui-layout"
							style="width: 1090px; height: 540px;">
							<!-- 列表 -->
							<div region="center" id="g">
								<table id="gross"></table>
							</div>
						</div>
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u16431" class="ax_default box_1">
						<div id="u16431_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u16432" class="text" style="visibility: visible;">
							<p>
								<span>销售毛利</span>
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
	$('#u16032_input').datebox('setValue', formatterDate(new Date(new Date().getTime()-24*60*60*1000)));
	$('#u16035_input').datebox('setValue', formatterDate(new Date(new Date().getTime()-24*60*60*1000)));
	//组织机构
	$('#u16049_input').combobox({
		url:'<%=path%>/getOrgList?orgId='+orgId+'&schemaName='+schemaName ,
		valueField:'id',
		textField:'text',
		editable:false ,
		width : '190'
		//panelHeight:'auto'
	});
	//商品分类
	$('#u16045_input').combobox({
		url:'<%=path%>/getCatalogList?orgId='+orgId+'&schemaName='+schemaName,
		valueField:'id',
		textField:'text',
		editable:true,
		width:'190',
		//panelHeight:'auto',
		onChange:function(value){
		    //if(value!='0'){
		    	//品牌
				$('#u16046_input').combobox({
					valueField:'id', //值字段
					textField:'text', //显示的字段
					url:'<%=path%>/getBrandList?&catalogCode='+ value+'&schemaName='+schemaName+'&orgId='+orgId,
					editable:false,//不可编辑，只能选择
					width:'190',
					//panelHeight:'auto',
					onChange:function(value){
						if(value!=''&&value!=null){
						    //型号
							$('#u16050_input').combobox({
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
			//}
		}
	});
	//品牌
	$('#u16046_input').combobox({
		valueField:'id', //值字段
		textField:'text', //显示的字段
		url:'<%=path%>/getBrandList?schemaName='+schemaName+'&orgId='+orgId+'&catalogCode='
			+ $('#u16045_input').combobox('getValue'),
		editable:false,//不可编辑，只能选择
		width:'190',
		//panelHeight:'auto',
	});
	//型号
	$('#u16050_input').combobox({
		valueField:'id', //值字段
		textField:'text', //显示的字段
		url:'<%=path%>/getModelList?schemaName='+schemaName+'&orgId='+orgId+'&brandCode='
			+ $('#u16046_input').combobox('getValue'),
		editable:false,//不可编辑，只能选择
		width:'190',
		//panelHeight:'auto'
	});
});

function search(){
	var schemaName=$('#schemaName').val();
	var org=$('#orgId').val();
	var orgId=$('#u16049_input').combobox('getValue');
	var commodityCode=$('#u16038_input').val();
	var commodityName=$('#u16057_input').val();
	var catalogName=$('#u16045_input').combobox('getValue');
	var brandName=$('#u16046_input').combobox('getValue');
	var modelName=$('#u16050_input').combobox('getValue');
	var start=$('#u16032_input').datebox('getValue');
	var end=$('#u16035_input').datebox('getValue');
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
	$('#gross').datagrid({
		idField:'saleReturn',	//只要创建数据表格 就必须要加 ifField
		fit:true,
		height:540,
		url:'/getSaleReturn',
		//fitColumns:true ,  
		//striped: true ,	//隔行变色特性 
		//nowrap: false ,	//折行显示 为true 显示在一会 
		loadMsg: '数据正在加载,请耐心等待...',
		rownumbers:true,
		emptyMsg: '<div style="text-align:center;color:red">没有相关记录！</div>',
		//showFooter:true,
		nowrap:false,
		queryParams: {
			schemaName:schemaName,
			orgId:orgId,
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
			field:'saleNum', 
			title:'销售数量',
			align:'center',
			width:100
		},
		{
			field:'giftNum', 
			title:'赠品数量',
			align:'center',
			width:100
		},
		{
			field:'saleSum', 
			title:'销售金额',
			align:'center',
			width:100
		},
		/* {
		   	field:'discountSaleSum',
			title:'优惠后销售金额',
			align:'center',
			width:120
		}, */
		{
			field:'saleCost',
			title:'销售成本',
			align:'center',
			width:100
		},
		{
			field:'saleGross', 
			title:'销售毛利',
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
			width:200	
		},
		{
			field:'modelName', 
			title:'型号名称', 
			align:'center',
			width:200
		},
		{
			field:'spec' , 
			title:'规格' , 
			align : 'center',
			width:200,
			formatter: function(value){
				var strs= new Array(); //定义一数组 
				var a=' <br/>'
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
	document.getElementById('u16023_state1').style.display='block';
	document.getElementById('u16023_state1').style.visibility='visible';
}

//查询按钮点击事件
$('.a').click(function(){
	document.getElementById('u16023_state1').style.display='none';
	document.getElementById('u16023_state1').style.visibility='hidden';
	document.getElementById('u16023_state0').style.display='block';
	document.getElementById('u16023_state0').style.visibility='visible';
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
$('#u16031_input').click(function(){
	var orgId=$('#orgId').val();
	var openId=$('#openId').val();
	var schemaName=$('#schemaName').val();
	$('#mysearch').form('clear');
	$('#u16032_input').datebox('setValue', formatterDate(new Date(new Date().getTime()-24*60*60*1000)));
	$('#u16035_input').datebox('setValue', formatterDate(new Date(new Date().getTime()-24*60*60*1000)));
	$('#u16049_input').combobox({
		url:'<%=path%>/getOrgList?orgId='+orgId+'&schemaName='+schemaName,
		valueField:'id',
		textField:'text',
		editable:false,
		width : '190'
		//panelHeight:'auto'
	});
	//商品分类
	$('#u16045_input').combobox({
		url:'<%=path%>/getCatalogList?orgId='+orgId+'&schemaName='+schemaName ,
		valueField:'id',
		textField:'text',
		editable:true ,
		width:'190',
		//panelHeight:'auto',
		onChange:function(value){
			if(value!='0'){
				//商品品牌
				$('#u16046_input').combobox({
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
							$('#u16050_input').combobox({
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
	$('#u16046_input').combobox({
		valueField:'id', //值字段
		textField:'text', //显示的字段
		url:'<%=path%>/getBrandList?schemaName='+schemaName+'&orgId='+orgId+'&catalogCode='
			+ $('#u16045_input').combobox('getValue'),
		editable:true,//不可编辑，只能选择
		//width: 200,
		width : '190',
		//panelHeight:'auto',
	});
	//型号
	$('#u16050_input').combobox({
		valueField:'id', //值字段
		textField:'text', //显示的字段
		url:'<%=path%>/getModelList?schemaName='+schemaName+'&orgId='+orgId+'&brandCode='
			+ $('#u16046_input').combobox('getValue'),
		editable : true,//不可编辑，只能选择
		width : '190',
		//panelHeight:'auto'
	});
});
//得到当前日期
formatterDate = function(date) {
	var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
	var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0"
		+ (date.getMonth() + 1);
	return date.getFullYear() + '-' + month + '-' + day;
	};
</script>
</html>
