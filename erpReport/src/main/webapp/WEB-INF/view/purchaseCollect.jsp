<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>采购汇总汇总</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
     
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/采购汇总汇总/styles.css" type="text/css" rel="stylesheet"/>
    <script src="resources/scripts/jquery-1.7.1.min.js"></script>
    <script src="resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
    <script src="resources/scripts/axure/axQuery.js"></script>
    <script src="resources/scripts/axure/globals.js"></script>
    <script src="resources/scripts/axutils.js"></script>
    <script src="resources/scripts/axure/annotation.js"></script>
    <script src="resources/scripts/axure/axQuery.std.js"></script>
    <script src="resources/scripts/axure/doc.js"></script>
    <script src="data/document.js"></script>
    <script src="resources/scripts/axure/visibility.js"></script>
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
    
    <script src="resources/scripts/axure/style.js"></script>
    <script src="resources/scripts/axure/adaptive.js"></script>
    <script src="resources/scripts/axure/tree.js"></script>
    <script src="resources/scripts/axure/init.temp.js"></script>
    <script src="files/采购汇总汇总/data.js"></script>
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
		p {background:#FFF;}
	</style>
  </head>
 
  <body>
  	<input type="hidden" id="orgId" value="${orgId}"/>
	<input type="hidden" id="openId" value="${openId}"/>
	<input type="hidden" id="schemaName" value="${schemaName}"/>
    
	
	<div id="base" class="" >
      <!-- 商品采购报表 (动态面板) -->
      <div id="u7264" class="ax_default" data-label="商品采购报表">
        <div id="u7264_state0" class="panel_state" data-label="查询条件">
          <div id="u7264_state0_content" class="panel_state_content">
			<form id="mysearch" method="post">
            <!-- Unnamed (矩形) -->
            <div id="u7265" class="ax_default box_1">
              <div id="u7265_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7266" class="text" style="display: none; visibility: hidden">
                <p><span></span></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u7267" class="ax_default box_1">
              <div id="u7267_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7268" class="text" style="visibility: visible;">
                <p><label><span class="a">查询</span></label></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <!-- <div id="u7269" class="ax_default box_1">
              <div id="u7269_div" class=""></div>
              Unnamed ()
              <div id="u7270" class="text" style="visibility: visible;">
                <p><span>商品汇总</span></p>
              </div>
            </div> -->

            <!-- Unnamed (矩形) -->
            <!-- <div id="u7271" class="ax_default box_1">
              <div id="u7271_div" class=""></div>
              Unnamed ()
              <div id="u7272" class="text" style="visibility: visible;">
                <p><span>供应商汇总表</span></p>
              </div>
            </div> -->

            <!-- Unnamed (提交按钮) -->
            <div id="u7273" class="ax_default html_button">
              <input id="u7273_input" type="button" value="查询" onclick='search()'/>
            </div>

            <!-- Unnamed (提交按钮) -->
            <div id="u7274" class="ax_default html_button">
              <input id="u7274_input" type="button" value="重置" />
            </div>

            <!-- Unnamed (文本框) -->
            <div id="u7275" class="ax_default text_field">
              <input id="u7275_input" name="startDate" type="text"  class="easyui-datebox" editable="false"  style="width:190px"/>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u7276" class="ax_default label">
              <div id="u7276_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7277" class="text" style="visibility: visible;">
                <p><span>起始日期</span></p>
              </div>
            </div>

            <!-- Unnamed (文本框) -->
            <div id="u7278" class="ax_default text_field">
              <input id="u7278_input" name="endDate" type="text" class="easyui-datebox" editable="false"  style="width:190px"/>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u7279" class="ax_default label">
              <div id="u7279_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7280" class="text" style="visibility: visible;">
                <p><span>商品编号</span></p>
              </div>
            </div>

            <!-- Unnamed (文本框) -->
            <div id="u7281" class="ax_default text_field">
              <input id="u7281_input" name="commodityCode" type="text" placeholder="请输入商品编号"/>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u7282" class="ax_default label">
              <div id="u7282_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7283" class="text" style="visibility: visible;">
                <p><span>品牌名称</span></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u7284" class="ax_default label">
              <div id="u7284_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7285" class="text" style="visibility: visible;">
                <p><span>型号名称</span></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u7286" class="ax_default label">
              <div id="u7286_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7287" class="text" style="visibility: visible;">
                <p><span>商品分类</span></p>
              </div>
            </div>

            <!-- Unnamed (下拉列表框) -->
            <div id="u7288" class="ax_default droplist">
              <input id="u7288_input" name="catalogName" type="text">
            </div>

            <!-- Unnamed (下拉列表框) -->
            <div id="u7289" class="ax_default droplist">
              <input type="text" id="u7289_input" name="brandName">
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u7290" class="ax_default label">
              <div id="u7290_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7291" class="text" style="visibility: visible;">
                <p><span>组织机构</span></p>
              </div>
            </div>

            <!-- Unnamed (下拉列表框) -->
            <div id="u7292" class="ax_default droplist">
              <input type="text" id="org" name="orgId">
            </div>

            <!-- Unnamed (下拉列表框) -->
            <div id="u7293" class="ax_default droplist">
              <input type="text" id="u7293_input" name="modelName">
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u7294" class="ax_default label">
              <div id="u7294_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7295" class="text" style="visibility: visible;">
                <p style="background:#FFF;"><span style="margin-left: 15px;">&nbsp;终止日期</span></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u7296" class="ax_default label">
              <div id="u7296_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7297" class="text" style="visibility: visible;">
                <p><span>供应商</span></p>
              </div>
            </div>

            <!-- Unnamed (下拉列表框) -->
            <div id="u7298" class="ax_default droplist">
              <input id="supplierId" name="supplierId" type="text">
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u7299" class="ax_default label">
              <div id="u7299_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7300" class="text" style="visibility: visible;">
                <p><span>&nbsp;</span></p>
              </div>
            </div>

            <!-- Unnamed (下拉列表框) -->
            <div id="u7301" class="ax_default droplist">
              <input type="text" id="u7301_input" name="type">
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u7302" class="ax_default label">
              <div id="u7302_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7303" class="text" style="visibility: visible;">
                <p><span>汇总方式</span></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u7304" class="ax_default label">
              <div id="u7304_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7305" class="text" style="visibility: visible;">
                <p><span>商品名称</span></p>
              </div>
            </div>

            <!-- Unnamed (文本框) -->
            <div id="u7306" class="ax_default text_field">
              <input id="u7306_input" type="text" value="" placeholder="请输入商品名称"/>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u7307" class="ax_default label">
              <div id="u7307_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7308" class="text" style="visibility: visible;">
                <p><span>购销方式</span></p>
              </div>
            </div>

            <!-- Unnamed (下拉列表框) -->
            <div id="u7309" class="ax_default droplist">
              <input type="text" id="u7309_input" name="operationType">
            </div>
            </form>
          </div>
        </div>
        <div id="u7264_state1" class="panel_state" data-label="按商品汇总" style="display: none; visibility: hidden;">
          <div id="u7264_state1_content" class="panel_state_content">

            <!-- Unnamed (矩形) -->
            <div id="u7310" class="ax_default box_1">
              <div id="u7310_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7311" class="text" style="display: none; visibility: hidden">
                <p><span></span></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u7312" class="ax_default box_1">
              <div id="u7312_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7313" class="text" style="visibility: visible;">
                <p><label><span class="a">查询</span></label></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u7314" class="ax_default box_1">
              <div id="u7314_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7315" class="text" style="display: none; visibility: hidden">
                <p><span></span></p>
              </div>
            </div>

            <!-- Unnamed (表格) -->
            <div id="u7316" class="ax_default">
				<div id="layL" class="easyui-layout" style="width: 1090px; height:520px">
					<!-- 列表 -->
						<table id="commodity"></table>
				</div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u7527" class="ax_default box_1">
              <div id="u7527_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7528" class="text" style="visibility: visible;">
                <p><span>商品汇总</span></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <!-- <div id="u7529" class="ax_default box_1">
              <div id="u7529_div" class=""></div>
              Unnamed ()
              <div id="u7530" class="text" style="visibility: visible;">
                <p><span>供应商汇总表</span></p>
              </div>
            </div> -->
          </div>
        </div>
        <div id="u7264_state2" class="panel_state" data-label="按供应商汇总" style="display: none; visibility: hidden;">
          <div id="u7264_state2_content" class="panel_state_content">

            <!-- Unnamed (矩形) -->
            <div id="u7531" class="ax_default box_1">
              <div id="u7531_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7532" class="text" style="display: none; visibility: hidden">
                <p><span></span></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u7533" class="ax_default box_1">
              <div id="u7533_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7534" class="text" style="visibility: visible;">
                <p><label><span class="a">查询</span></label></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u7535" class="ax_default box_1">
              <div id="u7535_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7536" class="text" style="display: none; visibility: hidden">
                <p><span></span></p>
              </div>
            </div>

            <!-- Unnamed (表格) -->
            <div id="u7537" class="ax_default">
				  <div id="layA" class="easyui-layout" style="width: 1090px; height:520px">
					<!-- 列表 -->
					<!-- <div id="dataGridBox" style="position:absolute; left:0;right:0;bottom:0;"> -->
						<table id="suppliers"></table>
					
              		</div>
            	<!-- </div> -->
			</div>
            <!-- Unnamed (矩形) -->
            <!-- <div id="u7628" class="ax_default box_1">
              <div id="u7628_div" class=""></div>
              Unnamed ()
              <div id="u7629" class="text" style="visibility: visible;">
                <p><span>商品汇总</span></p>
              </div>
            </div> -->

            <!-- Unnamed (矩形) -->
            <div id="u7630" class="ax_default box_1">
              <div id="u7630_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u7631" class="text" style="visibility: visible;">
                <p><span>供应商汇总表</span></p>
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
		$('#org').combobox({
			url:'<%=path%>/getOrgList?orgId='+orgId+'&schemaName='+schemaName ,
			valueField:'id',
			textField:'text',
			editable:false ,
			//async: false,
			width : '190',
			//panelHeight:'auto'
			onChange:function(value){
				$('#supplierId').combobox({
					url:'<%=path%>/getAllSupplierList?orgId='+value+'&org='+orgId+'&schemaName='+schemaName , 
					valueField:'id',
					textField:'text',
					editable:false ,
					//async: false,
					width : '190',
					//panelHeight:'auto'
				});
			}

		});
		<%-- $('#supplierId').combobox({
			 url:'<%=path%>/getAllSupplierList?schemaName='+schemaName+'&org='+orgId+'&orgId=' 
					+$('#org').combobox('getValue') , 
			valueField:'id',
			textField:'text',
			editable:false ,
			async: false,
			width : '190',
			//panelHeight:'auto'
		}); --%>
		$('#u7288_input').combobox({
			url:'<%=path%>/getCatalogList?orgId='+orgId+'&schemaName='+schemaName ,
			valueField:'id',
			textField:'text',
			editable:true ,
			width : '190',
			//panelHeight:'auto',
			onChange:function(value){
		    	if(value!='0'){
		    		//品牌
					 $('#u7289_input').combobox({
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
								 $('#u7293_input').combobox({
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
		 $('#u7289_input').combobox({
		    valueField:'id', //值字段
		    textField:'text', //显示的字段
		    url:'<%=path%>/getBrandList?schemaName='+schemaName+'&orgId='+orgId+'&catalogCode='
		    		+ $('#u7288_input').combobox('getValue'),
		   	editable:false,//不可编辑，只能选择
		   	//width: 200,
			width : '190',
			//panelHeight:'auto',
		 });
		 $('#u7293_input').combobox({
			    valueField:'id', //值字段
			    textField:'text', //显示的字段
			    url:'<%=path%>/getModelList?schemaName='+schemaName+'&orgId='+orgId+'&brandCode='
			    		+ $('#u7289_input').combobox('getValue'),
			   	editable:false,//不可编辑，只能选择
			   	//width: 200,
				width : '190',
				//panelHeight:'auto'
			 }); 
		 $('#u7309_input').combobox({
				valueField:'id',
				textField:'text',
				editable:false ,
				width : '190',
				panelHeight:'auto',
				data : [{"id":"0","text":"请选择","selected":true},{"id":"1","text":"购销"},{"id":"2","text":"代销"}],
		 });
		 $('#u7301_input').combobox({
				valueField:'id',
				textField:'text',
				editable:false ,
				width : '190',
				panelHeight:'auto',
				data : [{"id":"1","text":"商品汇总","selected":true},{"id":"2","text":"供应商汇总"}],
		 });
		 }); 
  
  function search(){
	  var type=$('#u7301_input').combobox('getValue');
	  var orgId=$('#org').combobox('getValue');
	  var org=$('#orgId').val();
	  var schemaName=$('#schemaName').val();
	  var commodityCode=$('#commodityCode').val();
	  var commodityName=$('#u7306_input').val();
	  var brandName=$('#u7289_input').combobox('getValue');
	  var catalogName=$('#u7288_input').combobox('getValue');
	  var modelName=$('#u7293_input').combobox('getValue');
	  var start=$('#u7275_input').datebox('getValue');
	  var end=$('#u7278_input').datebox('getValue');
	  var supplierId=$('#supplierId').combobox('getValue');
	  var operationType=$('#u7309_input').combobox('getValue');
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
		 $(".datagrid-body").css("overflow-x","scroll");
		 if(type=='1'){
			 /**
				 *	初始化数据表格  
				 */
				$('#commodity').datagrid({
					idField:'commodityCode' ,		//只要创建数据表格 就必须要加 ifField
				//	title:'活动列表' ,
					width:1300 ,
					fit:true ,
					//height:450 ,
					url:'/getPurcaseCollect' ,
					//fitColumns:true,  
					//striped: true ,					//隔行变色特性 
					//nowrap: false ,				//折行显示 为true 显示在一会 
					loadMsg: '数据正在加载,请耐心的等待...' ,
					rownumbers:true ,
					//showFooter:true,
					nowrap:false,
					queryParams: { 
						orgId:orgId,
						supplierId:supplierId,
						operationType:operationType,
						commodityName:commodityName,
						commodityCode:commodityCode,
						brandName:brandName,
						catalogName:catalogName,
						modelName:modelName,
		                type:type  ,
		                startDate:start,
		                endDate:end,
		                orgName:org,
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
							align : 'center',
							width:150,
							height:50
						},{
							field:'supplier' ,
							title:'供应商' ,
							align : 'center',
							width:150 
						},{
							field:'operationType' ,
							title:'购销方式' ,
							align : 'center',
							width:80 ,
							formatter:function(value)	{
								if(value=='1'){
									return '购销'
								}else if(value=='2'){
									return '代销'
								}
							}
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
							align : 'center',
							width:180
						},
						
						{
							field:'actualPurchaseCount' , 
							title:'实际采购数量' ,
							width:100,
							align : 'center',
						},
						{
							field:'actualPurchaseAmount' , 
							title:'实际采购金额' ,
							align : 'center',
							width:100,
						},
						{
							field:'purchaseCount' , 
							title:'采购订单数量' ,
							align : 'center',
							width:100,
							
						},
						
						{
		              field : 'purchaseAmount',
		              title : '采购订单金额',
		              align : 'center',
		              width : 100 ,
		           },{
		               field : 'wareInCount',
		               title : '采购入库数量',
		               align : 'center',
		               width : 100 ,
		            },{
							field:'wareInAmount' , 
							title:'采购入库金额' ,
							align : 'center',
							width:100 ,
							
						},
						{
							field:'refundsCount' , 
							title:'采购退货数量' ,
							align : 'center',
							width:100  ,
							
						},
						{
							field:'refundsAmount' , 
							title:'采购退货金额' ,
							align : 'center',
							width:100  ,
							
						},{
							field:'exchangeOutCount' , 
							title:'换货出数量' , 
							align : 'center',
							width:100,
							
						},{
							field:'exchangeOutAmount' , 
							title:'换货出金额' , 
							align : 'center',
							width:100,
							
						},{
							field:'exchangeInCount' , 
							title:'换货入数量' , 
							align : 'center',
							width:100,
							
						},{
							field:'exchangeInAmount' , 
							title:'换货入金额' , 
							align : 'center',
							width:100,
							
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
							field:'spec' , 
							title:'规格' , 
							align : 'center',
							width:150,
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
					onLoadSuccess:function(data){  
				        if(data.total > 0) return;  
				        $(this).datagrid('appendRow', { orgName: '<div style="text-align:center;color:red">没有相关记录！</div>' ,spec:'/'}).datagrid('mergeCells', { index: 0, field: 'orgName', colspan: 9 });  
					},
					pagination: true , 
					pageSize: 10 ,
					pageList:[5,10,20,30] ,
					
				});
				$(".datagrid-body").css("overflow-x","scroll");
				document.getElementById('u7264_state1').style.display='block';
				document.getElementById('u7264_state1').style.visibility='visible';
		 }else{
			 /**
				 *	初始化数据表格  
				 */
				$('#suppliers').datagrid({
					idField:'commodityName' ,		//只要创建数据表格 就必须要加 ifField
				//	title:'活动列表' ,
					//width:1300 ,
					fit:true ,
					height:450 ,
					url:'/getPurcaseCollect' ,
					showFooter:true,
					//fitColumns:true ,  
					//striped: true ,					//隔行变色特性 
					//nowrap: false ,				//折行显示 为true 显示在一会 
					loadMsg: '数据正在加载,请耐心的等待...' ,
					rownumbers:true ,
					nowrap:false,
					queryParams: { 
						orgId:orgId,
						supplierId:supplierId,
						operationType:operationType,
						commodityName:commodityName,
						commodityCode:commodityCode,
						brandName:brandName,
						catalogName:catalogName,
						modelName:modelName,
		                type:type  ,
		                startDate:start,
		                endDate:end,
		                orgName:org,
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
							align : 'center',
							width:150
						},{
							field:'supplier' ,
							title:'供应商' ,
							align : 'center',
							width:120 
						},{
							field:'operationType' ,
							title:'购销方式' ,
							align : 'center',
							width:80 ,
							formatter:function(value)	{
								if(value=='1'){
									return '购销'
								}else if(value=='2'){
									return '代销'
								}
							}
						},
						
						
						{
							field:'actualPurchaseCount' , 
							title:'实际采购数量' ,
							align : 'center',
							width:100,
							//hidden:true
						},
						{
							field:'actualPurchaseAmount' , 
							title:'实际采购金额' ,
							align : 'center',
							width:100
						},
						{
							field:'purchaseCount' , 
							title:'采购订单数量' ,
							align : 'center',
							width:100,
							
						},
						
						{
		              field : 'purchaseAmount',
		              title : '采购订单金额',
		              align : 'center',
		              width : 160 ,
		           },{
		               field : 'wareInCount',
		               title : '采购入库数量',
		               align : 'center',
		               width : 100 ,
		            },{
							field:'wareInAmount' , 
							title:'采购入库金额' ,
							align : 'center',
							width:100 ,
							
						},
						{
							field:'refundsCount' , 
							title:'采购退货数量' ,
							align : 'center',
							width:100  ,
							
						},
						{
							field:'refundsAmount' , 
							title:'采购退货金额' ,
							align : 'center',
							width:100  ,
							
						},{
							field:'exchangeOutCount' , 
							title:'换货出数量' , 
							align : 'center',
							width:100,
							
						},{
							field:'exchangeOutAmount' , 
							title:'换货出金额' , 
							align : 'center',
							width:100,
							
						},{
							field:'exchangeInCount' , 
							title:'换货入数量' , 
							align : 'center',
							width:100,
							
						},{
							field:'exchangeInAmount' , 
							title:'换货入金额' , 
							align : 'center',
							width:100,
							
						}
					]] ,
					onLoadSuccess:function(data){  
				        if(data.total > 0) return;  
				        $(this).datagrid('appendRow', { orgName: '<div style="text-align:center;color:red">没有相关记录！</div>' ,spec:'/'}).datagrid('mergeCells', { index: 0, field: 'orgName', colspan: 9 });  
					},
					pagination: true , 
					pageSize: 10 ,
					pageList:[10] ,
				});
				$(".datagrid-body").css("overflow-x","scroll");
				document.getElementById('u7264_state2').style.display='block';
				document.getElementById('u7264_state2').style.visibility='visible';
		 }
		 
		//$('#commodity').datagrid('load' ,serializeForm($('#mysearch')));
  }
  $('.a').click(function(){
	  document.getElementById('u7264_state2').style.display='none';
		document.getElementById('u7264_state2').style.visibility='hidden';
		document.getElementById('u7264_state1').style.display='none';
		document.getElementById('u7264_state1').style.visibility='hidden';
		  	document.getElementById('u7264_state0').style.display='block';
			document.getElementById('u7264_state0').style.visibility='visible';
			
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
	$('#u7274_input').click(function(){
		var orgId=$('#orgId').val();
	  	var openId=$('#openId').val();
	  	var schemaName=$('#schemaName').val();
	  	$('#mysearch').form('clear');
		$('#org').combobox({
			url:'<%=path%>/getOrgList?orgId='+orgId+'&schemaName='+schemaName ,
			valueField:'id',
			textField:'text',
			editable:false ,
			width : '190',
			//panelHeight:'auto'

		});
		$('#supplierId').combobox({
			url:'<%=path%>/getAllSupplierList?orgId='+orgId+'&org='+orgId+'&schemaName='+schemaName ,
			valueField:'id',
			textField:'text',
			editable:false ,
			width : '190',
			//panelHeight:'auto'
		});
		$('#u7288_input').combobox({
			url:'<%=path%>/getCatalogList?orgId='+orgId+'&schemaName='+schemaName ,
			valueField:'id',
			textField:'text',
			editable:true ,
			width : '190',
			//panelHeight:'auto',
			onChange:function(value){
		    	if(value!='0'){
		    		//品牌
					 $('#u7289_input').combobox({
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
								 $('#u7293_input').combobox({
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
		 $('#u7289_input').combobox({
		    valueField:'id', //值字段
		    textField:'text', //显示的字段
		    url:'<%=path%>/getBrandList?schemaName='+schemaName+'&orgId='+orgId+'&catalogCode='
		    		+ $('#u7288_input').combobox('getValue'),
		   	editable:false,//不可编辑，只能选择
		   	//width: 200,
			width : '190',
			//panelHeight:'auto',
		 });
		 $('#u7293_input').combobox({
			    valueField:'id', //值字段
			    textField:'text', //显示的字段
			    url:'<%=path%>/getModelList?schemaName='+schemaName+'&orgId='+orgId+'&brandCode='
			    		+ $('#u7289_input').combobox('getValue'),
			   	editable:false,//不可编辑，只能选择
			   	//width: 200,
				width : '190',
				//panelHeight:'auto'
			 }); 
		 $('#u7309_input').combobox({
				valueField:'id',
				textField:'text',
				editable:false ,
				width : '190',
				panelHeight:'auto',
				data : [{"id":"0","text":"请选择","selected":true},{"id":"1","text":"购销"},{"id":"2","text":"代销"}],
		 });
		 $('#u7301_input').combobox({
				valueField:'id',
				textField:'text',
				editable:false ,
				width : '190',
				panelHeight:'auto',
				data : [{"id":"1","text":"商品汇总","selected":true},{"id":"2","text":"供应商汇总"}],
		 });
	})
  </script>
</html>
