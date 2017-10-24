$(function(){
	//重置mydialog的表单验证
	$('#mydialog').dialog({
		onClose:function(){
			$('#myform .easyui-validatebox').validatebox('remove'); //删除验证;
		},
		onOpen:function(){
			$('#myform .easyui-validatebox').validatebox('reduce'); //恢复
		}
	});
});
     function openOperateWindow(url,wtitle){
    	$("#iframe").attr("src",url);
    	$('#w').window({modal:true,title:wtitle});	            
    	$('#w').window('open');
    }

     //加载等待样式  msg : 正在加载，请稍后...
     function createWait(msg) {
    	 var h = document.body.clientHeight; 
		 $("<div class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",height:h}).appendTo("body"); 
		 $("<div class=\"datagrid-mask-msg\"></div>").html(msg).appendTo("body").css({display:"block",
		  left:($(document.body).outerWidth(true) - 190) / 2,
		  top:(h - 45) / 2});    	 
     }
     
     //加载完成关闭
     function closeWait() {
    	 $('.datagrid-mask-msg').remove();
	     $('.datagrid-mask').remove();
     }
     
  // 自定义的校验器
  $.extend($.fn.validatebox.defaults.rules, {   
  		midLength: {   
  	 			validator: function(value, param){   
  								return value.length >= param[0] && value.length <= param[1];    
  				},   
  				message: ''  
  		} ,
  		equalLength : {
  	 			validator: function(value, param){   
  	 				
  								return value.length >= param[0] && value.length <= param[1];    
  				},   
  				message: '密码必须为4个字符!'  
  		}
  }); 

  /** 
   * @author yuanwei.yi 
   */  
  $.extend($.fn.validatebox.defaults.rules, {    
      /*必须和某个字段相等*/  
      equalTo: {  
          validator:function(value,param){  
              return $(param[0]).val() == value;  
          },  
          message:'字段不匹配'  
      }  
  });  


  /*该方法使日期列的显示符合阅读习惯*/
  //datagrid中用法：{ field:'StartDate',title:'开始日期', formatter: formatDatebox, width:80}
  function formatDatebox(value) {
      if (value == null || value == '') {
          return '';
      }
      var dt = parseToDate(value);
      
      return dt.format("yyyy-MM-dd").toString(); 
  }

  /*转换日期字符串为带时间的格式*/
  function formatDateBoxFull(value) {
      if (value == null || value == '') {
          return '';
      }
      var dt = parseToDate(value);
      return dt.format("yyyy-MM-dd hh:mm:ss").toString();
  }

  //辅助方法(转换日期)
  function parseToDate(value) {
      if (value == null || value == '') {
          return undefined; 
      }

      var dt;
      if (value instanceof Date) {
          dt = value;
      }
      else {
          if (!isNaN(value)) {
              dt = new Date(value);
          }
          else if (value.indexOf('/Date') > -1) {
              value = value.replace(/\/Date\((-?\d+)\)\//, '$1');
              dt = new Date();
              dt.setTime(value);
          } else if (value.indexOf('/') > -1) {
              dt = new Date(Date.parse(value.replace(/-/g, '/')));
          } else {
              dt = new Date(value);
          }
      }
      return dt;
  }

  //为Date类型拓展一个format方法，用于格式化日期
  Date.prototype.format = function (format) //author: meizz 
  {
      var o = {
          "M+": this.getMonth() + 1, //month 
          "d+": this.getDate(),    //day 
          "h+": this.getHours(),   //hour 
          "m+": this.getMinutes(), //minute 
          "s+": this.getSeconds(), //second 
          "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter 
          "S": this.getMilliseconds() //millisecond 
      };
      if (/(y+)/.test(format))
          format = format.replace(RegExp.$1,
                  (this.getFullYear() + "").substr(4 - RegExp.$1.length));
      for (var k in o)
          if (new RegExp("(" + k + ")").test(format))
              format = format.replace(RegExp.$1,
                      RegExp.$1.length == 1 ? o[k] :
                          ("00" + o[k]).substr(("" + o[k]).length));
      return format;
  };
   
  $.extend($.fn.datagrid.defaults.editors, {
	  datebox : {
	    init : function(container, options) {
	      var input = $('<input type="text">').appendTo(container);
	      input.datebox(options);
	      return input;
	    },
	    destroy : function(target) {
	      $(target).datebox('destroy');
	    },
	    getValue : function(target) {
	      return $(target).datebox('getValue');//获得旧值
	    },
	    setValue : function(target, value) {
	      $(target).datebox('setValue', formatDatebox(value));//设置新值的日期格式
	    },
	    resize : function(target, width) {
	      $(target).datebox('resize', width);
	    }
	  }
	});
   
  /**
   * easyUI验证动态清除与恢复
   */
  $.extend($.fn.validatebox.methods, {  
	    remove: function(jq, newposition){
	        return jq.each(function(){
	            $(this).removeClass("validatebox-text validatebox-invalid").unbind('focus').unbind('blur');
	        });  
	    },
	    reduce: function(jq, newposition){  
	        return jq.each(function(){  
	           var opt = $(this).data().validatebox.options;
	           $(this).addClass("validatebox-text").validatebox(opt);
	        });  
	    }   
	});
 
//处理键盘事件 禁止后退键（Backspace）密码或单行、多行文本框除外
	function banBackSpace(e) {
		var ev = e || window.event;//获取event对象
		var obj = ev.target || ev.srcElement;//获取事件源

		var t = obj.type || obj.getAttribute('type');//获取事件源类型
		//获取作为判断条件的事件类型
		var vReadOnly = obj.getAttribute('readonly');
		var vEnabled = obj.getAttribute('enabled');
		//处理null值情况
		vReadOnly = (vReadOnly == null) ? false : vReadOnly;
		vEnabled = (vEnabled == null) ? true : vEnabled;
		//当敲Backspace键时，事件源类型为密码或单行、多行文本的，
		//并且readonly属性为true或enabled属性为false的，则退格键失效
		var flag1 = (ev.keyCode == 8
				&& (t == "password" || t == "text" || t == "textarea") && (vReadOnly == "readonly" || vReadOnly == true || vEnabled != true)) ? true
				: false;
		
		//当敲Backspace键时，事件源类型非密码或单行、多行文本的，则退格键失效
		var flag2 = (ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea") ? true
				: false;
		//判断
		if (flag2) {
			return false;
		}
		if (flag1) {
			return false;
		}
	}
	
	//禁止后退键 作用于Firefox、Opera
	document.onkeypress = banBackSpace;
	//禁止后退键 作用于IE、Chrome
	document.onkeydown = banBackSpace;
