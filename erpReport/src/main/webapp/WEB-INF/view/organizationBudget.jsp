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
<title>机构收支查询</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<link href="resources/css/jquery-ui-themes.css" type="text/css"
	rel="stylesheet" />
<link href="resources/css/axure_rp_page.css" type="text/css"
	rel="stylesheet" />
<link href="data/styles.css" type="text/css" rel="stylesheet" />
<link href="files/organization_budget/styles.css" type="text/css"
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
<script src="files/organization_budget/data.js"></script>
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
		<!-- 机构收支状况查询 (动态面板) -->
		<div id="u20889" class="ax_default" data-label="机构收支状况查询">
			<div id="u20889_state0" class="panel_state" data-label="查询条件">
				<div id="u20889_state0_content" class="panel_state_content">
				<form id="mysearch">
					<!-- Unnamed (矩形) -->
					<div id="u20890" class="ax_default box_1">
						<div id="u20890_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u20891" class="text"
							style="display: none; visibility: hidden">
							<p>
								<span></span>
							</p>
						</div>
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u20892" class="ax_default box_1">
						<div id="u20892_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u20893" class="text" style="visibility: visible;">
							<p>
								<span class="a0">查询</span>
							</p>
						</div>
					</div>

					<!-- 查询按钮 (提交按钮) -->
					<div id="u20894" class="ax_default html_button" data-label="查询按钮">
						<input id="u20894_input" type="button" value="查询"/>
					</div>

					<!-- Unnamed (提交按钮) -->
					<div id="u20895" class="ax_default html_button">
						<input id="u20895_input" type="button" value="重置" />
					</div>

					<!-- Unnamed (文本框) -->
					<div id="u20896" class="ax_default text_field">
						<input id="u20896_input" name="startDate" type="text" editable="false"
							class="easyui-datebox" style="width: 190px" />
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u20897" class="ax_default label">
						<div id="u20897_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u20898" class="text" style="visibility: visible;">
							<p>
								<span>起始日期</span>
							</p>
						</div>
					</div>

					<!-- Unnamed (文本框) -->
					<div id="u20899" class="ax_default text_field">
						<input id="u20899_input" name="endDate" type="text" editable="false"
							class="easyui-datebox" style="width: 190px" />
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u20900" class="ax_default label">
						<div id="u20900_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u20901" class="text" style="visibility: visible;">
							<p>
								<span>业务名称</span>
							</p>
						</div>
					</div>

					<!-- 业务名称 (下拉列表框) -->
					<div id="u20902" class="ax_default droplist">
						<input type="text" id="u20902_input">
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u20903" class="ax_default label">
						<div id="u20903_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u20904" class="text" style="visibility: visible;">
							<p>
								<span>组织机构</span>
							</p>
						</div>
					</div>

					<!-- 组织机构 (下拉列表框) -->
					<div id="u20905" class="ax_default droplist">
						<input type="text" id="u20905_input">
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u20906" class="ax_default label">
						<div id="u20906_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u20907" class="text" style="visibility: visible;">
							<p>
								<span>终止日期</span>
							</p>
						</div>
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u20908" class="ax_default label">
						<div id="u20908_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u20909" class="text" style="visibility: visible;">
							<p>
								<span>&nbsp;</span>
							</p>
						</div>
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u20910" class="ax_default label">
						<div id="u20910_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u20911" class="text" style="visibility: visible;">
							<p>
								<span>收支类型&nbsp; </span>
							</p>
						</div>
					</div>

					<!-- 收支类型 (下拉列表框) -->
					<div id="u20912" class="ax_default droplist">
						<input type="text" id="u20912_input">
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u20913" class="ax_default label">
						<div id="u20913_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u20914" class="text" style="visibility: visible;">
							<p>
								<span>汇总方式</span>
							</p>
						</div>
					</div>

					<!-- 汇总方式 (下拉列表框) -->
					<div id="u20915" class="ax_default droplist" data-label="汇总方式">
						<select id="u20915_input">
							<option value="1">按业务类型汇总</option>
							<option value="2">按组织机构汇总</option>
						</select>
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u20916" class="ax_default box_1" style="display: none;">
						<div id="u20916_div" class=""></div>
						Unnamed ()
						<div id="u20917" class="text" style="visibility: visible;">
							<p>
								<span>业务类型汇总</span>
							</p>
						</div>
					</div>
					
					<!-- Unnamed (矩形) -->
						<!-- <div id="u21037" class="ax_default box_1">
							<div id="u21037_div" class=""></div>
							Unnamed ()
							<div id="u21038" class="text" style="visibility: visible;">
								<p>
									<span>业务类型汇总</span>
								</p>
							</div>
						</div> -->
						<!-- Unnamed (矩形) -->
						<div id="u21039" class="ax_default box_1" style="display: none;">
							<div id="u21039_div" class=""></div>
							Unnamed ()
							<div id="u21040" class="text" style="visibility: visible;">
								<p>
									<span>组织机构汇总</span>
								</p>
							</div>
						</div>
					</form>
				</div>
			</div>
			
			<div id="u20889_state1" class="panel_state" data-label="业务类型汇总"
				style="display: none; visibility: hidden;">
				
				<div id="u20889_state1_content" class="panel_state_content">

					<!-- Unnamed (矩形) -->
						<div id="u21037" class="ax_default box_1">
							<div id="u21037_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u21038" class="text" style="visibility: visible;">
								<p>
									<span>业务类型汇总</span>
								</p>
							</div>
						</div>
						<!-- Unnamed (矩形) -->
						<!-- <div id="u210391" class="ax_default box_1">
							<div id="u210391_div" class=""></div>
							Unnamed ()
							<div id="u210401" class="text" style="visibility: visible;">
								<p>
									<span>组织机构汇总</span>
								</p>
							</div>
						</div> -->
					<!-- Unnamed (矩形) -->
					<div id="u20918" class="ax_default box_1">
						<div id="u20918_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u20919" class="text"
							style="display: none; visibility: hidden">
							<p>
								<span></span>
							</p>
						</div>
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u20920" class="ax_default box_1">
						<div id="u20920_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u20921" class="text" style="visibility: visible;">
							<p>
								<span class="a1">查询</span>
							</p>
						</div>
					</div>

					<!-- Unnamed (矩形) -->
					<div id="u20922" class="ax_default box_1">
						<div id="u20922_div" class=""></div>
						<!-- Unnamed () -->
						<div id="u20923" class="text"
							style="display: none; visibility: hidden">
							<p>
								<span></span>
							</p>
						</div>
					</div>

					<!-- Unnamed (表格) -->
					<div id="u20924" class="ax_default">
						<div id="layb" class="easyui-layout"
							style="width: 1090px; height: 540px">
							<!-- 列表 -->
							<div region="center" id="b">
								<table id="business"></table>
							</div>
						</div>	
					</div>
				</div>
				
			</div>
			
			<div id="u20889_state2" class="panel_state" data-label="组织机构汇总"
					style="display: none; visibility: hidden;">
					<div id="u20889_state2_content" class="panel_state_content">
						<!-- Unnamed (矩形) -->
							<!-- <div id="u21132" class="ax_default box_1">
								<div id="u21132_div" class=""></div>
								Unnamed ()
								<div id="u21133" class="text" style="visibility: visible;">
									<p>
										<span>业务类型汇总</span>
									</p>
								</div>
							</div> -->

							<!-- Unnamed (矩形) -->
							<div id="u21134" class="ax_default box_1">
								<div id="u21134_div" class=""></div>
								<!-- Unnamed () -->
								<div id="u21135" class="text" style="visibility: visible;">
									<p>
										<span>组织机构汇总</span>
									</p>
								</div>
							</div>
						<!-- Unnamed (矩形) -->
						<div id="u21041" class="ax_default box_1">
							<div id="u21041_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u21042" class="text"
								style="display: none; visibility: hidden">
								<p>
									<span></span>
								</p>
							</div>
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u21043" class="ax_default box_1">
							<div id="u21043_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u21044" class="text" style="visibility: visible;">
								<p>
									<span class="a2">查询</span>
								</p>
							</div>
						</div>

						<!-- Unnamed (矩形) -->
						<div id="u21045" class="ax_default box_1">
							<div id="u21045_div" class=""></div>
							<!-- Unnamed () -->
							<div id="u21046" class="text"
								style="display: none; visibility: hidden">
								<p>
									<span></span>
								</p>
							</div>
						</div>

						<!-- Unnamed (表格) -->
						<div id="u21047" class="ax_default">
							<div id="layo" class="easyui-layout"
								style="width: 1090px; height: 540px">
								<!-- 列表 -->
								<div region="center" id="o">
									<table id="orgnization"></table>
								</div>
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
	  	$('#u20896_input').datebox('setValue', formatterDate(new Date(new Date().getTime()-24*60*60*1000)));
		$('#u20899_input').datebox('setValue', formatterDate(new Date(new Date().getTime()-24*60*60*1000)));
	  	$('#u20905_input').combobox({
			url:'<%=path%>/getOrgList?orgId='+orgId+'&schemaName='+schemaName ,
			valueField:'id',
			textField:'text',
			editable:false ,
			width : '190',
			onChange:function(value){
				$('#u20902_input').combobox({
					url:'<%=path%>/getBusinessList?businessType='+ $('#u20912_input').combobox('getValue')+'&schemaName='+schemaName+'&orgId='+value,
					valueField:'id',
					textField:'text',
					editable:false ,
					width : '190',
				});
			}
		});
		$('#u20912_input').combobox({
			valueField:'id',
			textField:'text',
			editable:false ,
			width : '190',
			panelHeight:'auto',
			data : [{"id":"0","text":"请选择","selected":true},{"id":"1","text":"收入"},{"id":"2","text":"支出"}],
			onChange:function(value){
				$('#u20902_input').combobox({
					url:'<%=path%>/getBusinessList?businessType='+ value+'&schemaName='+schemaName+'&orgId='+$('#u20905_input').combobox('getValue'),
					valueField:'id',
					textField:'text',
					editable:false ,
					width : '190',
				});
			}
		});
		$('#u20902_input').combobox({
			url:'<%=path%>/getBusinessList?orgId='+$('#u20905_input').combobox('getValue')+'&schemaName='+schemaName+'&businessType='+ $('#u20912_input').combobox('getValue'),
			valueField:'id',
			textField:'text',
			editable:false ,
			width : '190'
		});
		
		$('#u20894_input').click(function(event){
			var type=$('#u20915_input').val();
			var orgId=$('#u20905_input').combobox('getValue');
			var org=$('#orgId').val();
			var businessType=$('#u20912_input').combobox('getValue');
			var businessName=$('#u20902_input').combobox('getValue');
			var start=$('#u20896_input').datebox('getValue');
			var end=$('#u20899_input').datebox('getValue');
			var d1 = formatDatebox(start);
			var d2 = formatDatebox(end);
			if(start.length==0 || end.length==0){
				$.messager.alert('警告','必须选定时间段','warning');
				event.stopPropagation();  
				return false;
			}
			if(start.length>0 && end.length>0 && d1>d2){
				$.messager.alert('警告','结束时间要大于开始时间','warning');
				event.stopPropagation();
				return false;
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
			 if(type=='1'){
				$('#business').datagrid({
					idField:'businessType',		//只要创建数据表格 就必须要加 ifField
					fit:true,
					height:450,
					url:'/getOrganizationBudgetList',
					//fitColumns:true ,  
					//striped: true ,					//隔行变色特性 
					//nowrap: false ,				//折行显示 为true 显示在一会 
					loadMsg: '数据正在加载,请耐心的等待...' ,
					rownumbers:true,
					queryParams: {
						schemaName:schemaName,
						orgId:orgId,
						businessType:businessType,
						businessId:businessName,
			            type:type,
			            startDate:start,
			            endDate:end,
			            orgName:org
			        },
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
								width:265
							},
							{
								field:'businessType' ,
								title:'收支类型' ,
								width:265,
							},
							{
								field:'businessName', 
								title:'业务名称',  
								width:265,
								
							},
							{
								field:'money', 
								title:'金额',
								width:265,
							}
						]],
						pagination: true, 
						pageSize: 10,
						pageList:[10],
						/* onLoadSuccess:function(data){
							$.ajax({
								dataType : 'text',
								url: '/getOrganizationBudgetList',
								data:{
									schemaName:schemaName,
									orgId:orgId,
									businessType:businessType,
									businessId:businessName,
						            type:type,
						            startDate:start,
						            endDate:end,
						            orgName:org
								},
								type : 'get',
								success : function(data) {
									var o = eval('('+data+')')
									$('#business').datagrid('appendRow',{
										businessName: "总计",
										money : o.sumMoney,
									})
								}
							});
						} */
					});
				$(".datagrid-body").css("overflow-x","scroll");
				document.getElementById('u20916').style.display='none';
				document.getElementById('u20916').style.visibility='hidden';
				document.getElementById('u21039').style.display='none';
				document.getElementById('u21039').style.visibility='hidden';
				document.getElementById('u20889_state1').style.display='block';
				document.getElementById('u20889_state1').style.visibility='visible';
			 }else{
				 /**
					 *	初始化数据表格  
					 */
					$('#orgnization').datagrid({
						idField:'orgnization' ,		//只要创建数据表格 就必须要加 ifField
					//	title:'活动列表' ,
						//width:1300 ,
						fit:true ,
						height:450 ,
						url:'/getOrganizationBudgetList' ,
						//fitColumns:true ,  
						//striped: true ,					//隔行变色特性 
						//nowrap: false ,				//折行显示 为true 显示在一会 
						loadMsg: '数据正在加载,请耐心的等待...' ,
						rownumbers:true ,
						queryParams: {
							schemaName:schemaName,
							orgId:orgId,
					        type:type,
					        startDate:start,
					        endDate:end,
					        orgName:org
			            },   
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
												width:360
											},
											{
												field:'income' ,
												title:'其他收入金额' ,
												width:350 
											},
											{
												field:'expend' , 
												title:'其他支出金额' ,  
												width:350,
												
											}
										]],
										pagination: true , 
										pageSize: 10 ,
										pageList:[10] ,
									});
					$(".datagrid-body").css("overflow-x","scroll");
					document.getElementById('u20916').style.display='none';
					document.getElementById('u20916').style.visibility='hidden';
					document.getElementById('u21039').style.display='none';
					document.getElementById('u21039').style.visibility='hidden';
					document.getElementById('u20889_state2').style.display='block';
					document.getElementById('u20889_state2').style.visibility='visible';
		}
		})
	});
  
  function show_name(data){
	  $('#u20902_input').combobox({
			url:'<%=path%>/getBusinessList?schemaName='+schemaName+'&businessType='+ data,
			valueField:'id',
			textField:'text',
			editable:false,
			width : '190'		
		});
  }
  
  $('.a1').click(function(){
	  document.getElementById('u20916').style.display='block';
	  document.getElementById('u20916').style.visibility='visible';
	  document.getElementById('u21039').style.display='none';
	  document.getElementById('u21039').style.visibility='hidden';
	  /* document.getElementById('u21040').style.visibility='visible';
	  document.getElementById('u21132').style.visibility='visible';
	  document.getElementById('u21133').style.visibility='visible'; */
	  document.getElementById('u20889_state2').style.display='none';
	  document.getElementById('u20889_state2').style.visibility='hidden';
	  document.getElementById('u20889_state1').style.display='none';
	  document.getElementById('u20889_state1').style.visibility='hidden';
	  document.getElementById('u20889_state0').style.display='block';
	  document.getElementById('u20889_state0').style.visibility='visible';
  });
  
  $('.a2').click(function(){
	  document.getElementById('u20916').style.display='none';
	  document.getElementById('u20916').style.visibility='hidden';
	  document.getElementById('u21039').style.display='block';
	  document.getElementById('u21039').style.visibility='visible';
	  /* document.getElementById('u21040').style.visibility='visible';
	  document.getElementById('u21132').style.visibility='visible';
	  document.getElementById('u21133').style.visibility='visible'; */
	  document.getElementById('u20889_state2').style.display='none';
	  document.getElementById('u20889_state2').style.visibility='hidden';
	  document.getElementById('u20889_state1').style.display='none';
	  document.getElementById('u20889_state1').style.visibility='hidden';
	  document.getElementById('u20889_state0').style.display='block';
	  document.getElementById('u20889_state0').style.visibility='visible';
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
	$('#u20895_input').click(function(){ //重置按钮
		var orgId=$('#orgId').val();
	  	var openId=$('#openId').val();
	  	var schemaName=$('#schemaName').val();
	  	$('#mysearch').form('clear');
	  	$('#u20896_input').datebox('setValue', formatterDate(new Date(new Date().getTime()-24*60*60*1000)));
		$('#u20899_input').datebox('setValue', formatterDate(new Date(new Date().getTime()-24*60*60*1000)));
		$('#u20905_input').combobox({
			url:'<%=path%>/getOrgList?orgId='+orgId+'&schemaName='+schemaName,
			valueField:'id',
			textField:'text',
			editable:false,
			width : '190'
		});
		$('#u20912_input').combobox({
			valueField:'id',
			textField:'text',
			editable:false ,
			width : '190',
			panelHeight:'auto',
			data : [{"id":"0","text":"请选择","selected":true},{"id":"1","text":"收入"},{"id":"2","text":"支出"}],
			onChange:function(value){
				$('#u20902_input').combobox({
					url:'<%=path%>/getBusinessList?businessType='+ value+'&schemaName='+schemaName+'&orgId='+$('#u20905_input').combobox('getValue'),
					valueField:'id',
					textField:'text',
					editable:false ,
					width : '190',
				});
			}
		});
		$('#u20915_input').val('1')
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
