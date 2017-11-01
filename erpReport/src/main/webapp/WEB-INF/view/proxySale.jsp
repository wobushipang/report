<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>代销状况查询</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/代销状况查询/styles.css" type="text/css" rel="stylesheet"/>
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
    <script src="files/代销状况查询/data.js"></script>
    <script src="resources/scripts/axure/legacy.js"></script>
    <script src="resources/scripts/axure/viewer.js"></script>
    <script src="resources/scripts/axure/math.js"></script>
    <%@ include file="../../../page/public_base.jsp"%>
    <script type="text/javascript">
      $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
      $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
      $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
    </script>
  </head>
  <body>
  	<input type="hidden" id="orgId" value="${orgId}"/>
	<input type="hidden" id="openId" value="${openId}"/>
	<input type="hidden" id="schemaName" value="${schemaName}"/>
    <div id="base" class="">

      <!-- 代销状况查询 (动态面板) -->
      <div id="u20176" class="ax_default" data-label="代销状况查询">
        <div id="u20176_state0" class="panel_state" data-label="查询条件">
          <div id="u20176_state0_content" class="panel_state_content">
			<form id="mysearch">
            <!-- Unnamed (矩形) -->
            <div id="u20177" class="ax_default box_1">
              <div id="u20177_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20178" class="text" style="display: none; visibility: hidden">
                <p><span></span></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20179" class="ax_default box_1">
              <div id="u20179_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20180" class="text" style="visibility: visible;">
                <p><span class="a">查询</span></p>
              </div>
            </div>

            <!-- 查询按钮 (提交按钮) -->
            <div id="u20181" class="ax_default html_button" data-label="查询按钮">
              <input id="u20181_input" type="button" value="查询" onclick='search()'/>
            </div>

            <!-- Unnamed (提交按钮) -->
            <div id="u20182" class="ax_default html_button" data-label="重置按钮">
              <input id="u20182_input" type="button" value="重置" />
            </div>

            <!-- Unnamed (文本框) -->
            <div id="u20183" class="ax_default text_field">
              <input id="u20183_input" name="startDate" type="text" class="easyui-datebox" style="width:190px"/>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20184" class="ax_default label">
              <div id="u20184_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20185" class="text" style="visibility: visible;">
                <p><span>起始日期</span></p>
              </div>
            </div>

            <!-- Unnamed (文本框) -->
            <div id="u20186" class="ax_default text_field">
              <input id="u20186_input"  type="text" class="easyui-datebox" style="width:190px"/>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20187" class="ax_default label">
              <div id="u20187_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20188" class="text" style="visibility: visible;">
                <p><span>商品编号</span></p>
              </div>
            </div>

            <!-- Unnamed (文本框) -->
            <div id="u20189" class="ax_default text_field">
              <input id="u20189_input" type="text" placeholder="模糊查询"/>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20190" class="ax_default label">
              <div id="u20190_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20191" class="text" style="visibility: visible;">
                <p><span>品牌名称</span></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20192" class="ax_default label">
              <div id="u20192_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20193" class="text" style="visibility: visible;">
                <p><span>型号名称</span></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20194" class="ax_default label">
              <div id="u20194_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20195" class="text" style="visibility: visible;">
                <p><span>商品分类</span></p>
              </div>
            </div>

            <!-- Unnamed (下拉列表框) -->
            <div id="u20196" class="ax_default droplist">
              <input type="text" id="u20196_input">
            </div>

            <!-- Unnamed (下拉列表框) -->
            <div id="u20197" class="ax_default droplist">
              <input type="text" id="u20197_input">
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20198" class="ax_default label">
              <div id="u20198_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20199" class="text" style="visibility: visible;">
                <p><span>组织机构</span></p>
              </div>
            </div>

            <!-- Unnamed (下拉列表框) -->
            <div id="u20200" class="ax_default droplist">
              <input type="text" id="u20200_input">
            </div>

            <!-- Unnamed (下拉列表框) -->
            <div id="u20201" class="ax_default droplist">
              <input type="text" id="u20201_input">
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20202" class="ax_default label">
              <div id="u20202_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20203" class="text" style="visibility: visible;">
                <p><span>终止日期</span></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20204" class="ax_default label">
              <div id="u20204_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20205" class="text" style="visibility: visible;">
                <p><span>&nbsp;</span></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20206" class="ax_default label">
              <div id="u20206_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20207" class="text" style="visibility: visible;">
                <p><span>商品名称</span></p>
              </div>
            </div>

            <!-- Unnamed (文本框) -->
            <div id="u20208" class="ax_default text_field">
              <input id="u20208_input" type="text" placeholder="模糊查询"/>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20209" class="ax_default label">
              <div id="u20209_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20210" class="text" style="visibility: visible;">
                <p><span>供应商</span></p>
              </div>
            </div>

            <!-- Unnamed (下拉列表框) -->
            <div id="u20211" class="ax_default droplist">
              <input type="text" id="u20211_input">
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20212" class="ax_default label">
              <div id="u20212_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20213" class="text" style="visibility: visible;">
                <p><span>汇总方式</span></p>
              </div>
            </div>

            <!-- 汇总方式 (下拉列表框) -->
            <div id="u20214" class="ax_default droplist" data-label="汇总方式">
              <select id="u20214_input">
                <option value="1">按商品汇总</option>
                <option value="2">按供应商汇总</option>
              </select>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20215" class="ax_default box_1">
              <div id="u20215_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20216" class="text" style="visibility: visible;">
                <p><span>商品汇总</span></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20217" class="ax_default box_1">
              <div id="u20217_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20218" class="text" style="visibility: visible;">
                <p><span>供应商汇总</span></p>
              </div>
            </div>
            </form>
          </div>
        </div>
        
        <div id="u20176_state1" class="panel_state" data-label="商品汇总" style="display: none; visibility: hidden;">
          <div id="u20176_state1_content" class="panel_state_content">

            <!-- Unnamed (矩形) -->
            <div id="u20219" class="ax_default box_1">
              <div id="u20219_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20220" class="text" style="display: none; visibility: hidden">
                <p><span></span></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20221" class="ax_default box_1">
              <div id="u20221_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20222" class="text" style="visibility: visible;">
                <p><span class="a">查询</span></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20223" class="ax_default box_1">
              <div id="u20223_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20224" class="text" style="display: none; visibility: hidden">
                <p><span></span></p>
              </div>
            </div>

            <!-- Unnamed (表格) -->
            <div id="u20225" class="ax_default">
				<div id="layL" class="easyui-layout" style="width: 1250px; height:580px">
					<!-- 列表 -->
					<div region="center" id="c">
						<table id="commodity"></table>
					</div>
				</div>
              
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20590" class="ax_default box_1">
              <div id="u20590_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20591" class="text" style="visibility: visible;">
                <p><span>商品汇总</span></p>
              </div>
            </div>


            <!-- Unnamed (矩形) -->
            <div id="u20594" class="ax_default box_1">
              <div id="u20594_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20595" class="text" style="visibility: visible;">
                <p><span>供应商汇总</span></p>
              </div>
            </div>
          </div>
        </div>
        <div id="u20176_state2" class="panel_state" data-label="供应商汇总" style="display: none; visibility: hidden;">
          <div id="u20176_state2_content" class="panel_state_content">

            <!-- Unnamed (矩形) -->
            <div id="u20596" class="ax_default box_1">
              <div id="u20596_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20597" class="text" style="display: none; visibility: hidden">
                <p><span></span></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20598" class="ax_default box_1">
              <div id="u20598_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20599" class="text" style="visibility: visible;">
                <p><span class="a">查询</span></p>
              </div>
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20600" class="ax_default box_1">
              <div id="u20600_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20601" class="text" style="display: none; visibility: hidden">
                <p><span></span></p>
              </div>
            </div>

            <!-- Unnamed (表格) -->
            <div id="u20602" class="ax_default">
				<div id="layS" class="easyui-layout" style="width: 955px; height:580px">
					<!-- 列表 -->
					<div region="center" id="s">
						<table id="suppliers"></table>
					</div>
				</div>
              
            </div>

            <!-- Unnamed (矩形) -->
            <div id="u20883" class="ax_default box_1">
              <div id="u20883_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20884" class="text" style="visibility: visible;">
                <p><span>商品汇总</span></p>
              </div>
            </div>


            <!-- Unnamed (矩形) -->
            <div id="u20887" class="ax_default box_1">
              <div id="u20887_div" class=""></div>
              <!-- Unnamed () -->
              <div id="u20888" class="text" style="visibility: visible;">
                <p><span>供应商汇总</span></p>
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
		$('#u20200_input').combobox({
			url:'<%=path%>/getOrgList?orgId='+orgId+'&schemaName='+schemaName ,
			valueField:'id',
			textField:'text',
			editable:false ,
			width : '190',
			//panelHeight:'auto'
			onChange:function(value){
				$('#u20211_input').combobox({
					url:'<%=path%>/getSupplierList?orgId='+value+'&schemaName='+schemaName ,
					valueField:'id',
					textField:'text',
					editable:false ,
					width : '190',
					//panelHeight:'auto'
				});
			}

		});
		$('#u20211_input').combobox({
			url:'<%=path%>/getSupplierList?orgId='
					+$('#u20200_input').combobox('getValue')+'&schemaName='+schemaName ,
			valueField:'id',
			textField:'text',
			editable:false ,
			width : '190',
			//panelHeight:'auto'
		});
		$('#u20196_input').combobox({
			url:'<%=path%>/getCatalogList?orgId='+orgId+'&schemaName='+schemaName ,
			valueField:'id',
			textField:'text',
			editable:true ,
			width : '190',
			//panelHeight:'auto',
			onChange:function(value){
		    	if(value!='0'){
		    		//品牌
					 $('#u20197_input').combobox({
					    valueField:'id', //值字段
					    textField:'text', //显示的字段
					    url:'<%=path%>/getBrandList?&catalogCode='+ value+'&schemaName='+schemaName+'&orgId='+orgId,
					   	editable:true,//不可编辑，只能选择
					   	//width: 200,
						width : '190',
						//panelHeight:'auto',
						onChange:function(value){
					    	if(value!=''&&value!=null){
					    		//型号
								 $('#u20201_input').combobox({
								    valueField:'id', //值字段
								    textField:'text', //显示的字段
								    url:'<%=path%>/getModelList?&brandCode='+ value+'&schemaName='+schemaName+'&orgId='+orgId,
								   	editable:true,//不可编辑，只能选择
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
		 $('#u20197_input').combobox({
		    valueField:'id', //值字段
		    textField:'text', //显示的字段
		    url:'<%=path%>/getBrandList?schemaName='+schemaName+'&orgId='+orgId+'&catalogCode='
		    		+ $('#u20196_input').combobox('getValue'),
		   	editable:false,//不可编辑，只能选择
		   	//width: 200,
			width : '190',
			//panelHeight:'auto',
		 });
		 $('#u20201_input').combobox({
			    valueField:'id', //值字段
			    textField:'text', //显示的字段
			    url:'<%=path%>/getModelList?schemaName='+schemaName+'&orgId='+orgId+'&brandCode='
			    		+ $('#u20197_input').combobox('getValue'),
			   	editable:false,//不可编辑，只能选择
			   	//width: 200,
				width : '190',
				//panelHeight:'auto'
			 }); 
	  }); 
  
  function search(){
	  var type=$('#u20214_input').val();
	  var orgId=$('#u20200_input').combobox('getValue');
	  var org=$('#orgId').val();
	  var commodityCode=$('#u20189_input').val();
	  var commodityName=$('#u20208_input').val();
	  var brandName=$('#u20197_input').combobox('getValue');
	  var catalogName=$('#u20196_input').combobox('getValue');
	  var modelName=$('#u20201_input').combobox('getValue');
	  var start=$('#u20183_input').datebox('getValue');
	  var end=$('#u20186_input').datebox('getValue');
	  var supplierId=$('#u20211_input').combobox('getValue');
	  //var operationType=$('#u7309_input').val();
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
		 if(type=='1'){
			 /**
				 *	初始化数据表格  
				 */
				$('#commodity').datagrid({
					idField:'commodityCode' ,		//只要创建数据表格 就必须要加 ifField
				//	title:'活动列表' ,
					//width:1300 ,
					fit:true ,
					height:450 ,
					url:'/getProxySale' ,
					//fitColumns:true ,  
					//striped: true ,					//隔行变色特性 
					//nowrap: false ,				//折行显示 为true 显示在一会 
					loadMsg: '数据正在加载,请耐心的等待...' ,
					rownumbers:true ,
					 queryParams: { 
						orgId:orgId,
						supplierId:supplierId,
						//operationType:operationType,
						commodityName:commodityName,
						commodityCode:commodityCode,
						brandName:brandName,
						catalogName:catalogName,
						modelName:modelName,
		                type:type  ,
		                startDate:start,
		                endDate:end,
		                orgName:org
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
							field:'stockNum' , 
							title:'进货数量' ,
							width:100,
							align : 'center',
						},
						{
							field:'saleNum' , 
							title:'销售数量' ,
							align : 'center',
							width:100,
						},
						{
							field:'giftNum' , 
							title:'赠品数量' ,
							align : 'center',
							width:100,
							
						},
						
						{
		              field : 'inventoryNum',
		              title : '库存数量',
		              align : 'center',
		              width : 100 ,
		           },{
		               field : 'discountsAmount',
		               title : '优惠后销售金额',
		               align : 'center',
		               width : 120 ,
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
								var strs= new Array(); //定义一数组 
								var a=''
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
					pageList:[10] ,
				});
				document.getElementById('u20176_state0').style.display='none';
				document.getElementById('u20176_state0').style.visibility='hidden'
				document.getElementById('u20176_state2').style.display='none';
				document.getElementById('u20176_state2').style.visibility='hidden'
				document.getElementById('u20176_state1').style.display='block';
				document.getElementById('u20176_state1').style.visibility='visible';
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
					url:'/getProxySale' ,
					//fitColumns:true ,  
					//striped: true ,					//隔行变色特性 
					//nowrap: false ,				//折行显示 为true 显示在一会 
					loadMsg: '数据正在加载,请耐心的等待...' ,
					rownumbers:true ,
					 queryParams: { 
						orgId:orgId,
						supplierId:supplierId,
						//operationType:operationType,
						commodityName:commodityName,
						commodityCode:commodityCode,
						brandName:brandName,
						catalogName:catalogName,
						modelName:modelName,
		                type:type  ,
		                startDate:start,
		                endDate:end,
		                orgName:org
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
											field:'supplier' ,
											title:'供应商' ,
											align : 'center',
											width:120 
										},
										
										{
											field:'stockNum' , 
											title:'进货数量' ,
											width:100,
											align : 'center',
										},
										{
											field:'saleNum' , 
											title:'销售数量' ,
											align : 'center',
											width:100,
										},
										{
											field:'giftNum' , 
											title:'赠品数量' ,
											align : 'center',
											width:100,
											
										},
										
										{
						              field : 'inventoryNum',
						              title : '库存数量',
						              align : 'center',
						              width : 100 ,
						           },{
						               field : 'discountsAmount',
						               title : '优惠后销售金额',
						               align : 'center',
						               width : 120 ,
						            },{
							           field : 'chargeAmount',
							           title : '应计收费金额',
							           align : 'center',
							           width : 120 ,
							        },{
								       field : 'accountAmount',
								       title : '生成结算金额',
								       align : 'center',
								       width : 120 ,
								    },{
									   field : 'proceedsAmount',
									   title : '已收款金额',
									   align : 'center',
									   width : 100 ,
									   }
									]] ,
									onLoadSuccess:function(data){  
								        if(data.total > 0) return;  
								        $(this).datagrid('appendRow', { orgName: '<div style="text-align:center;color:red">没有相关记录！</div>' ,spec:'/'}).datagrid('mergeCells', { index: 0, field: 'orgName', colspan: 8 }); 
									},
									pagination: true , 
									pageSize: 10 ,
									pageList:[10] ,
								});
				document.getElementById('u20176_state0').style.display='none';
				document.getElementById('u20176_state0').style.visibility='hidden'
				document.getElementById('u20176_state1').style.display='none';
				document.getElementById('u20176_state1').style.visibility='hidden'
				document.getElementById('u20176_state2').style.display='block';
				document.getElementById('u20176_state2').style.visibility='visible';
		 }
		 
		//$('#commodity').datagrid('load' ,serializeForm($('#mysearch')));
  }
  $('.a').click(function(){
	  document.getElementById('u20176_state2').style.display='none';
		document.getElementById('u20176_state2').style.visibility='hidden';
		document.getElementById('u20176_state1').style.display='none';
		document.getElementById('u20176_state1').style.visibility='hidden';
		  	document.getElementById('u20176_state0').style.display='block';
			document.getElementById('u20176_state0').style.visibility='visible';
			
	  });
	$('#u20182_input').click(function(){
		var orgId=$('#orgId').val();
	  	var openId=$('#openId').val();
	  	var schemaName=$('#schemaName').val();
	  	$('#mysearch').form('clear');
		$('#u20200_input').combobox({
			url:'<%=path%>/getOrgList?orgId='+orgId+'&schemaName='+schemaName ,
			valueField:'id',
			textField:'text',
			editable:false ,
			width : '190',
			//panelHeight:'auto'

		});
		$('#u20211_input').combobox({
			url:'<%=path%>/getSupplierList?orgId='+orgId+'&schemaName='+schemaName ,
			valueField:'id',
			textField:'text',
			editable:false ,
			width : '190',
			panelHeight:'auto'
		});
		$('#u20196_input').combobox({
			url:'<%=path%>/getCatalogList?orgId='+orgId+'&schemaName='+schemaName ,
			valueField:'id',
			textField:'text',
			editable:true ,
			width : '190',
			//panelHeight:'auto',
			onChange:function(value){
		    	if(value!='0'){
		    		//品牌
					 $('#u20197_input').combobox({
					    valueField:'id', //值字段
					    textField:'text', //显示的字段
					    url:'<%=path%>/getBrandList?&catalogCode='+ value+'&schemaName='+schemaName+'&orgId='+orgId,
					   	editable:true,//不可编辑，只能选择
					   	//width: 200,
						width : '190',
						//panelHeight:'auto',
						onChange:function(value){
					    	if(value!=''&&value!=null){
					    		//型号
								 $('#u20201_input').combobox({
								    valueField:'id', //值字段
								    textField:'text', //显示的字段
								    url:'<%=path%>/getModelList?&brandCode='+ value+'&schemaName='+schemaName+'&orgId='+orgId,
								   	editable:true,//不可编辑，只能选择
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
		 $('#u20197_input').combobox({
		    valueField:'id', //值字段
		    textField:'text', //显示的字段
		    url:'<%=path%>/getBrandList?schemaName='+schemaName+'&orgId='+orgId+'&catalogCode='
		    		+ $('#u20196_input').combobox('getValue'),
		   	editable:false,//不可编辑，只能选择
		   	//width: 200,
			width : '190',
			//panelHeight:'auto',
		 });
		 $('#u20201_input').combobox({
			    valueField:'id', //值字段
			    textField:'text', //显示的字段
			    url:'<%=path%>/getModelList?schemaName='+schemaName+'&orgId='+orgId+'&brandCode='
			    		+ $('#u20197_input').combobox('getValue'),
			   	editable:false,//不可编辑，只能选择
			   	//width: 200,
				width : '190',
				//panelHeight:'auto'
			 }); 
		 $('#u20214_input').val('1')
	})
  </script>
</html>
