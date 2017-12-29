<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>inventoryWarn</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<link href="resources/css/jquery-ui-themes.css" type="text/css"
	rel="stylesheet" />
<link href="resources/css/axure_rp_page.css" type="text/css"
	rel="stylesheet" />
<link href="data/styles.css" type="text/css" rel="stylesheet" />
<link href="files/inventoryWarn/styles.css" type="text/css"
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
<script src="files/inventoryWarn/data.js"></script>
<script src="resources/scripts/axure/legacy.js"></script>
<script src="resources/scripts/axure/viewer.js"></script>
<script src="resources/scripts/axure/math.js"></script>
<%@ include file="../../../page/public_base_new.jsp"%>
<script type="text/javascript">
      $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
      $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
      $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
    </script>
<style type="text/css">
p {
	background: #FFF;
}
</style>
</head>
<body>
	<input type="hidden" id="orgId" value="${orgId}" />
	<input type="hidden" id="openId" value="${openId}" />
	<input type="hidden" id="schemaName" value="${schemaName}" />
	<div id="base" class="">

		<!-- 库存预警查询面板 (动态面板) -->
		<div id="u11255" class="ax_default" data-label="库存预警查询面板">
			<div id="u11255_state0" class="panel_state" data-label="查询条件">
				<div id="u11255_state0_content" class="panel_state_content">
					<form id="mysearch">
						<!-- Unnamed (矩形) -->
						<div id="u11256" class="ax_default box_1">
							<div id="u11256_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11257" class="text"
								style="display: none; visibility: hidden">
								<p>
									<span></span>
								</p>
							</div>
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11258" class="ax_default box_1">
							<div id="u11258_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11259" class="text" style="visibility: visible;">
								<p>
									<span>查询</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11260" class="ax_default box_1" style="display: none;">
							<div id="u11260_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11261" class="text" style="visibility: hidden;">
								<p>
									<span>低库存</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (提交按钮) -->
						<div id="u11262" class="ax_default html_button">
							<input id="u11262_input" type="button" value="滞销"
								onclick="search('2')" />
						</div>

						<!-- Unnamed (提交按钮) -->
						<div id="u11263" class="ax_default html_button">
							<input id="u11263_input" type="button" value="重置" />
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11264" class="ax_default label">
							<div id="u11264_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11265" class="text" style="visibility: visible;">
								<p>
									<span>商品编号</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (文本框) -->
						<div id="u11266" class="ax_default text_field">
							<input id="u11266_input" type="text"  class="easyui-textbox"  data-options="prompt:'请输入商品编号'" />
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11267" class="ax_default label">
							<div id="u11267_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11268" class="text" style="visibility: visible;">
								<p>
									<span>品牌名称</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11269" class="ax_default label">
							<div id="u11269_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11270" class="text" style="visibility: visible;">
								<p>
									<span>型号名称</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11271" class="ax_default label">
							<div id="u11271_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11272" class="text" style="visibility: visible;">
								<p>
									<span>商品分类</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (下拉列表框) -->
						<div id="u11273" class="ax_default droplist">
							<input type="text" id="u11273_input">
						</div>

						<!-- Unnamed (下拉列表框) -->
						<div id="u11274" class="ax_default droplist">
							<input type="text" id="u11274_input">
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11275" class="ax_default label">
							<div id="u11275_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11276" class="text" style="visibility: visible;">
								<p>
									<span>组织机构</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (下拉列表框) -->
						<div id="u11277" class="ax_default droplist">
							<input type="text" id="u11277_input">
						</div>

						<!-- Unnamed (下拉列表框) -->
						<div id="u11278" class="ax_default droplist">
							<input type="text" id="u11278_input">
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11279" class="ax_default label">
							<div id="u11279_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11280" class="text" style="visibility: visible;">
								<p>
									<span>仓库</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (下拉列表框) -->
						<div id="u11281" class="ax_default droplist">
							<input type="text" id="u11281_input">
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11282" class="ax_default label">
							<div id="u11282_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11283" class="text" style="visibility: visible;">
								<p>
									<span>&nbsp;</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11284" class="ax_default label">
							<div id="u11284_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11285" class="text" style="visibility: visible;">
								<p>
									<span>商品名称</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (文本框) -->
						<div id="u11286" class="ax_default text_field">
							<input id="u11286_input" type="text"  class="easyui-textbox"  data-options="prompt:'请输入商品名称'" />
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u11287" class="ax_default box_1" style="display: none;">
							<div id="u11287_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u11288" class="text" style="visibility: hidden;">
								<p>
									<span>滞销查询</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (提交按钮) -->
						<div id="u11289" class="ax_default html_button">
							<input id="u11289_input" type="button" value="低库存"
								onclick="search('1')" />
						</div>
					</form>
				</div>
			</div>
			<div id="u11255_state1" class="panel_state" data-label="库存预警-低于安全库存"
				style="display: none; visibility: hidden;">
				<div id="u11255_state1_content" class="panel_state_content">

					<!-- Unnamed (矩形) -->
					<div id="u11290" class="ax_default box_1">
						<div id="u11290_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u11291" class="text"
							style="display: none; visibility: hidden">
							<p>
								<span></span>
							</p>
						</div>
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u11292" class="ax_default box_1">
						<div id="u11292_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u11293" class="text" style="visibility: visible;">
							<p>
								<span id="a">查询</span>
							</p>
						</div>
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u11294" class="ax_default box_1">
						<div id="u11294_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u11295" class="text"
							style="display: none; visibility: hidden">
							<p>
								<span></span>
							</p>
						</div>
					</div>

					<!-- Unnamed (表格) -->
					<div id="u11296" class="ax_default">
						<div id="layL" class="easyui-layout"
							style="width: 1090px; height: 520px">
							<!-- 列表 -->
							<div region="center" id="c">
								<table id="commodity"></table>
							</div>
						</div>
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u11363" class="ax_default box_1">
						<div id="u11363_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u11364" class="text" style="visibility: visible;">
							<p>
								<span>低库存</span>
							</p>
						</div>
					</div>

					<!-- Unnamed (矩形) -->
					<!-- <div id="u11365" class="ax_default box_1">
              <div id="u11365_div" class=""></div>
              Unnamed ()
              <div id="u11366" class="text" style="visibility: visible;">
                <p><span>滞销查询</span></p>
              </div>
            </div> -->


				</div>
			</div>
			<div id="u11255_state2" class="panel_state" data-label="库存预警-滞销商品"
				style="display: none; visibility: hidden;">
				<div id="u11255_state2_content" class="panel_state_content">

					<!-- Unnamed (矩形) -->
					<div id="u11369" class="ax_default box_1">
						<div id="u11369_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u11370" class="text"
							style="display: none; visibility: hidden">
							<p>
								<span></span>
							</p>
						</div>
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u11371" class="ax_default box_1">
						<div id="u11371_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u11372" class="text" style="visibility: visible;">
							<p>
								<span id="b">查询</span>
							</p>
						</div>
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u11373" class="ax_default box_1">
						<div id="u11373_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u11374" class="text"
							style="display: none; visibility: hidden">
							<p>
								<span></span>
							</p>
						</div>
					</div>

					<!-- Unnamed (表格) -->
					<div id="u11375" class="ax_default">
						<div id="layS" class="easyui-layout"
							style="width: 1090px; height: 520px">
							<!-- 列表 -->
							<div region="center" id="s">
								<table id="suppliers"></table>
							</div>
						</div>
					</div>



					<!-- Unnamed (矩形) -->
					<!-- <div id="u11468" class="ax_default box_1">
              <div id="u11468_div" class=""></div>
              Unnamed ()
              <div id="u11469" class="text" style="visibility: visible;">
                <p><span>低库存</span></p>
              </div>
            </div> -->

					<!-- Unnamed (矩形) -->
					<div id="u11470" class="ax_default box_1">
						<div id="u11470_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u11471" class="text" style="visibility: visible;">
							<p>
								<span>滞销查询</span>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="win" class="easyui-window" title="详情" maximizable="false"
		minimizable="false" style="width: 662px; height: 430px; padding: 1px;"
		closed="true">
		<div id="layD" class="easyui-layout"
			style="width: 645px; height: 390px">
			<!-- 列表 -->
				<table id="detail" class="easyui-datagrid"></table>
		</div>
	</div>
	<div id="win1" class="easyui-window" title="串号详情" maximizable="false"
		minimizable="false" style="width: 640px; height: 380px; padding: 1px;"
		closed="true">
		<div id="layDs" class="easyui-layout"
			style="width: 625px; height: 340px">
			<!-- 列表 -->
			<div region="center" id="ds">
				<table id="details" class="easyui-datagrid"></table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
  
  $(function(){ 
	    var orgId=$('#orgId').val();
	  	var openId=$('#openId').val();
	  	var schemaName=$('#schemaName').val();
		$('#u11277_input').combobox({
			url:'<%=path%>/getOrgList?orgId='+orgId+'&schemaName='+schemaName ,
			valueField:'id',
			textField:'text',
			editable:false ,
			width : '190',
			//panelHeight:'auto'
			onChange:function(value){
				$('#u11281_input').combobox({
					url:'<%=path%>/getWarehouseList?orgId='+value+'&schemaName='+schemaName ,
					valueField:'id',
					textField:'text',
					editable:false ,
					width : '190',
					//panelHeight:'auto'
				});
			}

		});
		$('#u11281_input').combobox({
			url:'<%=path%>/getWarehouseList?schemaName='+schemaName+'&orgId='
						+$('#u11277_input').combobox('getValue'),
			valueField:'id',
			textField:'text',
			editable:false ,
			width : '190',
			//panelHeight:'auto'
		});
		$('#u11273_input').combobox({
			url:'<%=path%>/getCatalogList?orgId='+orgId+'&schemaName='+schemaName ,
			valueField:'id',
			textField:'text',
			editable:true ,
			width : '190',
			//panelHeight:'auto',
			onChange:function(value){
		    		//品牌
					 $('#u11274_input').combobox({
					    valueField:'id', //值字段
					    textField:'text', //显示的字段
					    url:'<%=path%>/getBrandList?&catalogCode='+ value+'&schemaName='+schemaName+'&orgId='+orgId,
					   	editable:false,//不可编辑，只能选择
					   	//width: 200,
						width : '190',
						//panelHeight:'auto',
						onChange:function(value){
					    	if(value!=''&&value!=null){
					    		//型号
								 $('#u11278_input').combobox({
								    valueField:'id', //值字段
								    textField:'text', //显示的字段
								    url:'<%=path%>/getModelList?&brandCode='+ value+'&schemaName='+schemaName+'&orgId='+orgId,
								   	editable:false,//不可编辑，只能选择
								   	//width: 200,
									width : '190',
									//panelHeight:'auto'
								 }); 
						    }
					    	}
					 }); 
			    
		    	}
				
		});
		//品牌
		 $('#u11274_input').combobox({
				valueField:'id', //值字段
				textField:'text', //显示的字段
				url:'<%=path%>/getBrandList?schemaName='+schemaName+'&orgId='+orgId+'&catalogCode='
						+$('#u11273_input').combobox('getValue'),
				editable:false,//不可编辑，只能选择
				width : '190',
				//panelHeight:'auto'
			}); 
		 $('#u11278_input').combobox({
			    valueField:'id', //值字段
			    textField:'text', //显示的字段
			    url:'<%=path%>/getModelList?schemaName='+schemaName+'&orgId='+orgId+'&brandCode='
			    		+ $('#u11274_input').combobox('getValue'),
			   	editable:false,//不可编辑，只能选择
			   	//width: 200,
				width : '190',
				//panelHeight:'auto'
			 }); 
	  }); 
  
  function search(type){
	  var orgId=$('#u11277_input').combobox('getValue');
	  var org=$('#orgId').val();
	  var schemaName=$('#schemaName').val();
	  var commodityCode=$('#u11266_input').val();
	  var commodityName=$('#u11286_input').val();
	  var brandName=$('#u11274_input').combobox('getValue');
	  var catalogName=$('#u11273_input').combobox('getValue');
	  var modelName=$('#u11278_input').combobox('getValue');
	  var schemaName=$('#schemaName').val();
	  var warehouseId=$('#u11281_input').combobox('getValue');
	//采用jquery easyui loading css效果
		function ajaxLoading(){
		    $("<div class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",height:$(window).height()}).appendTo("body");
		    $("<div class=\"datagrid-mask-msg\"></div>").html("正在处理，请稍候。。。").appendTo("body").css({display:"block",left:($(document.body).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2});
		 }
		 function ajaxLoadEnd(){
		     $(".datagrid-mask").remove();
		     $(".datagrid-mask-msg").remove();            
		}
		 if(type==1){
			 /**
				 *	初始化数据表格  
				 */
				$('#commodity').datagrid({
					idField:'commodityCode' ,		//只要创建数据表格 就必须要加 ifField
				//	title:'活动列表' ,
					//width:1300 ,
					fit:true ,
					//width:'auto',              
					//height:'auto',   
					url:'/getInventoryWarnList' ,
					//fitColumns:true ,  
					//striped: true ,					//隔行变色特性 
					//nowrap: false ,				//折行显示 为true 显示在一会 
					loadMsg: '数据正在加载,请耐心的等待...' ,
					rownumbers:true ,
					emptyMsg: '<div style="text-align:center;color:red">没有相关记录！</div>',
					nowrap:false,
					 queryParams: { 
						orgId:orgId,
						//operationType:operationType,
						commodityName:commodityName,
						commodityCode:commodityCode,
						brandName:brandName,
						catalogName:catalogName,
						modelName:modelName,
		                type:type  ,
		                orgName:org,
		                warehouseId:warehouseId,
		                schemaName:schemaName
		              }  ,   
					//singleSelect:true ,				//单选模式 
					//remoteSort: false ,
					//sortName: 'salary' ,
					//sortOrder: 'desc' ,
					onClickRow: function (rowIndex, rowData) {
				                    $(this).datagrid('unselectRow', rowIndex);
				   					},
				   rowStyler: function() {
				   					　　return 'height: 50px';
				   					},
					
					columns:[[
						{
							field:'orgName' , 
							title:'组织机构' ,    
							align : 'center',
							width:150
						},{
							field:'whName' ,
							title:'仓库名称' ,
							align : 'center',
							width:120 
						},
						{
							field:'commodityCode' , 
							title:'商品编码' ,  
							align : 'center',
							width:200,
							
						}  ,
						
						{
							field:'commodityName' , 
							title:'商品名称' ,
							width:180,
							align : 'center',
						},
						
						{
							field:'inventoryNum' , 
							title:'库存量' ,
							width:100,
							align : 'center',
						},
						{
							field:'safeInventory' , 
							title:'安全库存' ,
							align : 'center',
							width:100,
						},
						{
							field:'ID' , 
							title:'串号/批次' ,
							align : 'center',
							width:100,
							formatter: function(value,row){
								if(row.inventoryNum!='0'){
									return '<a href="javascript:void(0)" onclick=details("'+ schemaName +'","'+ row.commodityId+'","'+ row.whId+'")>查看</a>'
								}else{
									return '-'
								}
							}
						},
						{
							field:'catalogName' , 
							title:'分类名称' , 
							align : 'center',
							width:150,
							
						},{
							field:'brandName' , 
							title:'品牌名称' , 
							align : 'center',
							width:150,
							
						},{
							field:'modelName' , 
							title:'型号名称' , 
							align : 'center',
							width:150,
							
						},{
							field:'whId' ,
							title:'仓库id' ,
							align : 'center',
							width:120 ,
							hidden:true
						},{
							field:'commodityId' , 
							title:'商品ID' ,  
							width:200,
							hidden:true
						}  ,{
							field:'spec' , 
							title:'规格' , 
							align : 'center',
							width:200,
							formatter: function(value){
								if(value==null)return;
								var strs= new Array(); //定义一数组 
								var a=' <br/>'
								strs=value.split("/"); //字符分割 
								for (i=0;i<strs.length ;i++ ) 
								{ 
									 a+=strs[i]+'<br/>'
								}
								return '<span>'+a+'</span>'
							}
						}
					]] ,
					pagination: true , 
					pageSize: 10 ,
					pageList:[10] ,
				});
				//document.getElementById('u11260').style.visibility='visible';
				//document.getElementById('u11287').style.visibility='hidden';
		   		//document.getElementById('u11288').style.visibility='hidden';
			 	$(".datagrid-body").css("overflow-x","scroll");
			 	document.getElementById('u11287').style.display='none';
				document.getElementById('u11288').style.visibility='hidden';
				document.getElementById('u11260').style.display='none';
			 	document.getElementById('u11261').style.visibility='hidden';
			 	document.getElementById('u11255_state0').style.display='none';
				document.getElementById('u11255_state0').style.visibility='hidden';
				document.getElementById('u11255_state2').style.display='none';
				document.getElementById('u11255_state2').style.visibility='hidden';
				document.getElementById('u11255_state1').style.display='block';
				document.getElementById('u11255_state1').style.visibility='visible';
		 }else{
			 /**
				 *	初始化数据表格  
				 */
				 var myview =$('#suppliers').datagrid({
					idField:'commodityName' ,		//只要创建数据表格 就必须要加 ifField
				//	title:'活动列表' ,
					//width:'auto' ,
					fit:true ,
					//height:'auto' ,
					url:'/getInventoryWarnList' ,
					//fitColumns:true ,  
					//striped: true ,					//隔行变色特性 
					//nowrap: false ,				//折行显示 为true 显示在一会 
					loadMsg: '数据正在加载,请耐心的等待...' ,
					rownumbers:true ,
					nowrap:false,
					emptyMsg: '<div style="text-align:center;color:red">没有相关记录！</div>',
					 queryParams: { 
						orgId:orgId,
						//operationType:operationType,
						commodityName:commodityName,
						commodityCode:commodityCode,
						brandName:brandName,
						catalogName:catalogName,
						modelName:modelName,
		                type:type  ,
		                orgName:org,
		                warehouseId:warehouseId,
		                schemaName:schemaName
		              }  ,   
					//singleSelect:true ,				//单选模式 
					//remoteSort: false ,
					//sortName: 'salary' ,
					//sortOrder: 'desc' ,
					onClickRow: function (rowIndex, rowData) {
				                    $(this).datagrid('unselectRow', rowIndex);
				   					},
					
				   					columns:[[
										{
											field:'orgName' , 
											title:'组织机构' ,       
											width:150,
											align: 'center'
										},{
											field:'whName' ,
											title:'仓库名称' ,
											align : 'center',
											width:120 
										},
										{
											field:'commodityCode' , 
											title:'商品编码' ,  
											align : 'center',
											width:200,
											
										}  ,
										{
											field:'commodityName' , 
											title:'商品名称' ,
											width:180,
											align : 'center',
										},
										{
											field:'infoType' , 
											title:'串号/批次' ,
											width:180,
											align : 'center',
											formatter: function(value,row){
												if(value=='2'){
													return row.infoContent
												}else if(value=='1'){
													return '<a href="javascript:void(0)" onclick=detailss("'+ schemaName +'","'+ row.commodityId+'","'+ row.whId+'","'+ row.unsalableDays+'","'+ row.supplierId+'")>查看</a>'
													//return  "<a href='javascript:void(0);' title='删除'  onclick=\"detailss('"+row.infoContent+"','"+row.supplier+"','"+row.inventoryInTime+"','"+row.unsalableDays+"')\">查看</a>";
												}
											}
										},
										/* {
											field:'inventoryNum' , 
											title:'库存量' ,
											align : 'center',
											width:100,
										}, */
										/* {
											field:'safeInventory' , 
											title:'安全库存' ,
											align : 'center',
											width:100,
											
										}, */
										
										{
						              field : 'inventoryInTime',
						              title : '首次入库日期',
						              align : 'center',
						              width : 150 ,
						              formatter:function(value,row){
						            	  if(value!=null){
						            		  if(row.infoType=='1'){
							            		   return '-'
							            	   }else{
							            		   return value.substring(0,10)
							            	   }
						            	  }
						               }
						           },{
						               field : 'unsalableDays',
						               title : '滞销天数',
						               align : 'center',
						               width : 100 ,
						               formatter: function(value,row){
						            	   if(row.infoType=='1'){
						            		   return '-'
						            	   }else{
						            		   return DateDiff(row.inventoryInTime);
						            	   }
						               }
						            },{
										field:'operationType' ,
										title:'购销方式' ,
										width:120 ,
										align : 'center',
										formatter: function(value,row){
											if(value=='1'){
												return '购销'
											}else if(value=='2'){
												return '代销'
											}else{
												return '-'
											}
										}
									},{
										field:'supplier' ,
										title:'供应商' ,
										align : 'center',
										width:120 ,
										formatter: function(value){
											if(value==null){
												return '-'
											}else{
												return value
											}
										}
									},{
										field:'supplierId' ,
										title:'供应商Id' ,
										width:120 ,
										hidden:true
									},{
											field:'catalogName' , 
											title:'分类名称' , 
											align : 'center',
											width:150,
											
										},{
											field:'brandName' , 
											title:'品牌名称' , 
											align : 'center',
											width:150,
											
										},{
											field:'modelName' , 
											title:'型号名称' , 
											align : 'center',
											width:150,
											
										},{
											field:'whId' ,
											title:'仓库id' ,
											align : 'center',
											width:120 ,
											hidden:true
										},
										{
											field:'infoContent' , 
											title:'串号/批次内容' ,
											width:100,
											align : 'center',
											hidden:true
										},
										{
											field:'commodityId' , 
											title:'商品ID' ,  
											width:200,
											hidden:true
										}  ,{
											field:'spec' , 
											title:'规格' , 
											align : 'center',
											width:200,
											formatter: function(value){
												var strs= new Array(); //定义一数组 
												var a=' <br/>'
												strs=value.split("/"); //字符分割 
												for (i=0;i<strs.length ;i++ ) 
												{ 
													 a+=strs[i]+'<br/>'
												}
												return '<span>'+a+'</span>'
											}
										}
									]] ,
									pagination: true , 
									pageSize: 10 ,
									pageList:[10] ,
								});
				
			 	$(".datagrid-body").css("overflow-x","scroll");
			 	/* document.getElementById('u11287').style.display='none';
				document.getElementById('u11288').style.visibility='hidden';
				document.getElementById('u11260').style.display='none';
			 	document.getElementById('u11261').style.visibility='hidden'; */
			 	document.getElementById('u11255_state0').style.display='none';
				document.getElementById('u11255_state0').style.visibility='hidden';
				document.getElementById('u11255_state1').style.display='none';
				document.getElementById('u11255_state1').style.visibility='hidden';
				document.getElementById('u11255_state2').style.display='block';
				document.getElementById('u11255_state2').style.visibility='visible';
		 }
		 
		//$('#commodity').datagrid('load' ,serializeForm($('#mysearch')));
  }
  $('#u11292').click(function(){
	  
	  document.getElementById('u11255_state2').style.display='none';
	  document.getElementById('u11255_state2').style.visibility='hidden';
	  document.getElementById('u11255_state1').style.display='none';
	  document.getElementById('u11255_state1').style.visibility='hidden';
	  document.getElementById('u11255_state0').style.display='block';
	  document.getElementById('u11255_state0').style.visibility='visible';
	  document.getElementById('u11287').style.display='none';
	  document.getElementById('u11288').style.visibility='hidden';
	  document.getElementById('u11260').style.display='block';
 	  document.getElementById('u11261').style.visibility='visible';
	  $('#win').window('close');
	});
  $('#u11371').click(function(){
	  
	  document.getElementById('u11255_state2').style.display='none';
	  document.getElementById('u11255_state2').style.visibility='hidden';
	  document.getElementById('u11255_state1').style.display='none';
	  document.getElementById('u11255_state1').style.visibility='hidden';
	  document.getElementById('u11255_state0').style.display='block';
	  document.getElementById('u11255_state0').style.visibility='visible';
	  document.getElementById('u11287').style.display='block';
 	  document.getElementById('u11288').style.visibility='visible';
 	  document.getElementById('u11260').style.display='none';
	  document.getElementById('u11261').style.visibility='hidden';
	$('#win1').window('close');
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
	$('#u11263_input').click(function(){
		 var orgId=$('#orgId').val();
		  	var openId=$('#openId').val();
		  	var schemaName=$('#schemaName').val();
		  	$('#mysearch').form('clear');
			$('#u11277_input').combobox({
				url:'<%=path%>/getOrgList?orgId='+orgId+'&schemaName='+schemaName ,
				valueField:'id',
				textField:'text',
				editable:false ,
				width : '190',
				//panelHeight:'auto'
				onChange:function(value){
					$('#u11281_input').combobox({
						url:'<%=path%>/getWarehouseList?orgId='+value+'&schemaName='+schemaName ,
						valueField:'id',
						textField:'text',
						editable:false ,
						width : '190',
						//panelHeight:'auto'
					});
				}

			});
			$('#u11281_input').combobox({
				url:'<%=path%>/getWarehouseList?schemaName='+schemaName+'&orgId='
							+$('#u11277_input').combobox('getValue'),
				valueField:'id',
				textField:'text',
				editable:false ,
				width : '190',
				//panelHeight:'auto'
			});
			$('#u11273_input').combobox({
				url:'<%=path%>/getCatalogList?orgId='+orgId+'&schemaName='+schemaName ,
				valueField:'id',
				textField:'text',
				editable:true ,
				width : '190',
				//panelHeight:'auto',
				onChange:function(value){
			    	if(value!='0'){
			    		//品牌
						 $('#u11274_input').combobox({
						    valueField:'id', //值字段
						    textField:'text', //显示的字段
						    url:'<%=path%>/getBrandList?&catalogCode='+ value+'&schemaName='+schemaName+'&orgId='+orgId,
						   	editable:false,//不可编辑，只能选择
						   	//width: 200,
							width : '190',
							//panelHeight:'auto',
							onChange:function(value){
						    	if(value!=''&&value!=null){
						    		//型号
									 $('#u11278_input').combobox({
									    valueField:'id', //值字段
									    textField:'text', //显示的字段
									    url:'<%=path%>/getModelList?&brandCode='+ value+'&schemaName='+schemaName+'&orgId='+orgId,
									   	editable:false,//不可编辑，只能选择
									   	//width: 200,
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
			 $('#u11274_input').combobox({
					valueField:'id', //值字段
					textField:'text', //显示的字段
					url:'<%=path%>/getBrandList?schemaName='+schemaName+'&orgId='+orgId+'&catalogCode='
							+$('#u11273_input').combobox('getValue'),
					editable:false,//不可编辑，只能选择
					width : '190',
					//panelHeight:'auto'
				}); 
			 $('#u11278_input').combobox({
				    valueField:'id', //值字段
				    textField:'text', //显示的字段
				    url:'<%=path%>/getModelList?schemaName='+schemaName+'&orgId='+orgId+'&brandCode='
				    		+ $('#u11274_input').combobox('getValue'),
				   	editable:false,//不可编辑，只能选择
				   	//width: 200,
					width : '190',
					//panelHeight:'auto'
				 }); 
	})
	//详情
		function details(schemaName,id,warehouseId) {
		/**
		 *	初始化数据表格  
		 */
		$('#detail').datagrid({
			idField:'infoContent' ,		//只要创建数据表格 就必须要加 ifField
			fit:true ,
			//height:450 ,
			url:'/getDetail?schemaName='+schemaName+'&commodityId='+id+'&whId='+warehouseId+'&type=1',
			loadMsg: '数据正在加载,请耐心的等待...' ,
			//nowrap:false,
			onClickRow: function (rowIndex, rowData) {
		                    $(this).datagrid('unselectRow', rowIndex);
		   					},
			columns:[[
				{
					field:'infoContent' , 
					title:'串号/批次' ,   
					align : 'center',
					width:120,
					formatter: function(value){
						if(value==null){
							return '-';
						}else{
							var str = value.replace(/(.{13})/g,'$1<br/>');
							return str;
						}
					}
				},{
					field:'quantity' ,
					title:'数量' ,
					align : 'center',
					width:80 
				},
				{
					field:'operationType' , 
					title:'购销方式' ,  
					align : 'center',
					width:60,
					formatter: function(value){
						if(value=='1'){
							return '购销';
						}else if(value=='2'){
							return '代销';
						}
					}
				}  ,
				{
					field:'inventoryInTime' , 
					title:'初次入库时间' ,  
					width:200,
					align : 'center',
					formatter: function(value,row){
						if(row.infoContent==null){
							return '-';
						}else{
							return value.substring(0,10);
						}
					}
				}  ,
				{
					field:'supplier' , 
					title:'供应商' ,
					align : 'center',
					width:180
				}
			]] ,
		});
		$("#win").window('open');
	}
	//详情
	function detailss(schemaName,id,warehouseId,unsalableDays,supplierId) {
	/**
	 *	初始化数据表格  
	 */
	 $('#details').datagrid({
			idField:'infoContent' ,		//只要创建数据表格 就必须要加 ifField
			fit:true,
			//height:'auto' ,
			url:'/getDetail?schemaName='+schemaName+'&commodityId='+id+'&unsalableDays='+unsalableDays+'&supplierId='+supplierId+'&whId='+warehouseId+'&type=2' ,
			loadMsg: '数据正在加载,请耐心的等待...' ,
			//nowrap:false,
			onClickRow: function (rowIndex, rowData) {
		                    $(this).datagrid('unselectRow', rowIndex);
		   					},
			columns:[[
				{
					field:'infoContent' , 
					title:'串号' ,   
					align : 'center',
					width:160,
					formatter: function(value){
						var str = value.replace(/(.{13})/g,'$1<br/>');
						return str;
					}
				},
				
				{
					field:'inventoryInTime' , 
					title:'初次入库时间' ,  
					width:200,
					align : 'center',
					formatter:formatDatebox
				}  ,
				{
					field:'supplier' , 
					title:'供应商' ,
					align : 'center',
					width:180
				},
				{
					field:'unsalableDays' , 
					title:'滞销天数' ,
					align : 'center',
					width:80,
					formatter: function(value,row){
						if(value!=null){
							var t = DateDiff(row.inventoryInTime);
							return t
						}
					}
				}
			]],
		});
	$("#win1").window('open');
}
	
	//计算天数差的函数，通用  
	   function  DateDiff(s1){  
		   s1=s1.substring(0,10);
		   s1 = new Date(s1);
		   s2 = new Date();//当前日期
		   var days = s2.getTime() - s1.getTime();
		   var time = parseInt(days / (1000 * 60 * 60 * 24));
	       return  time  
	   }  
	   
  </script>
</html>