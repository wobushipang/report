<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
  String _contextPath = request.getContextPath();
  request.setAttribute("CONTEXT_PATH", _contextPath);
  
  String _basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+_contextPath+"/";
  request.setAttribute("BASE_PATH", _basePath);
%>

<link rel="icon" href="<%=_basePath%>images/icon/logo.ico" type="image/icon" />

<script type="text/javascript" src="${BASE_PATH}js/plugin/jquery/jquery.js"></script>
<script type="text/javascript" src="${BASE_PATH}js/plugin/jquery/jquery.idTabs.min.js" ></script>
<script type="text/javascript" src="${BASE_PATH}js/plugin/jQuery easyUI/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="${BASE_PATH}js/plugin/jQuery easyUI/extension/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${BASE_PATH}js/plugin/jQuery easyUI/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${BASE_PATH}js/plugin/jQuery easyUI/extension/datagrid-cellediting.js" ></script>
<script type="text/javascript" src="${BASE_PATH}js/plugin/validation/jquery.validate.js" ></script>
<script type="text/javascript" src="${BASE_PATH}js/plugin/validation/messages_cn.js" ></script>
<script type="text/javascript" src="${BASE_PATH}js/common/common.js" ></script>

<%-- <script type="text/javascript" src="${BASE_PATH}js/echarts/echarts.js" ></script>
<script type="text/javascript" src="${BASE_PATH}js/echarts/china.js" ></script> --%>


<link rel="stylesheet" type="text/css" href="${BASE_PATH}js/plugin/jQuery easyUI/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${BASE_PATH}js/plugin/jQuery easyUI/extension/easyui.css" />
<link rel="stylesheet" type="text/css" href="${BASE_PATH}css/jquery.autocomplete.css" />
<link rel="stylesheet" type="text/css" href="${BASE_PATH}css/page.css" />
<link rel="stylesheet" type="text/css" href="${BASE_PATH}css/default.css" />
<link rel="stylesheet" type="text/css" href="${BASE_PATH}css/validation.css" />
<link rel="stylesheet" type="text/css" href="${BASE_PATH}css/common.css" />

<link rel="stylesheet" type="text/css" href="${BASE_PATH}js/plugin/jQueryUI/css/default.css" />


