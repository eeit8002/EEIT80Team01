<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="item.category.model.*"  %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
ItemCategoryService service = new ItemCategoryService();
List<ItemCategoryBean> list = service.selectCategory(null);//<ItemCategoryBean>
pageContext.setAttribute("list",list);
%>

<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<title>MVC架構</title>

<!-- 搬來的 -->
<style>
  #txtSearch{width:300px}
  #div1{border:1px solid green;width:300px;display:none}
  ul{list-style-type:none;padding:5px 5px;margin:0px}
  .s1{background-color:yellow;
      cursor:pointer;
      text-decoration:underline}
  .s2{background-color:transparent;}
</style>


</head>
<body BGCOLOR="white">
<jsp:include page="commons/header.jsp" />

<!-- <h2 align="center">Ch04 MVC架構與存取資料庫</h2> --><br>
<div align="center">

<Form Action="queryAllMembers.do" method="GET" name="myData">

<!--    <input type="text" id="txtSearch1" name="keyword"> -->


<!-- autocom搬過來的 -->
分類<select name ="option">
<!-- <optgroup label="商品分類" > -->
<!-- <option ></option> -->
<!-- <option value="1">3c商品</option> -->
<!-- <option value="2">鞋子</option> -->
<!-- <option value="3">衣服</option> -->
<!-- <option value="4">汽車</option> -->
<!-- </select> -->

<c:forEach var="item" items="${list}">
<option value="${item.itemCategory}">${item.categoryName}</option>
</c:forEach>
<input type="text" id="txtSearch" name="keyword" autocomplete="off" > <div id="div1"></div>
   <input type="submit" value="查詢" id="submit" >
 
 

</Form>

</div>
<hr>
<jsp:include page="commons/footer.jsp" />









<!-- <form name="myData" action="First.jsp" method="get"> -->
<!-- <input type="text" id="txtSearch" name="keyword" autocomplete="off">autocomplete記憶 關鍵字 -->
<!-- <input type="submit" value="送出"> -->
<!-- <input type="button" value="查詢" id="bt"> -->
<!-- <div id="div1"></div> -->
<!-- </form> -->



<script>
  //將資料存到陣列中
  
  //讀出陣列中的資料
  //alert(datas.length);
  //alert(datas[2]);
  var show;
  var xmlHttp = null;                   //load事件必须等到网页中所有内容全部加载完毕之后才被执行。
  window.addEventListener("load",init,false);//addEventListener("事件",function,false)true
//   window.addEventListener("load",init,true);
  function init(){
	  var txt = document.getElementById("txtSearch");//抓type="text" id="txtSearch"
	  txt.addEventListener("keyup",getData,false); //keyup=在指定物件上偵測到鍵盤上被按住的鍵已放開
	  show = document.getElementById("div1");
  }
  
  function bt(){
	  var b =document.getElementById("bt");
	  b.addEventListener("keyup",getbt,false);
  }
  function getbt(){
	//Ajax..
  
	//步驟一建立Ajax物件
		xhr = new XMLHttpRequest();
		if (xhr != null) {
			//readyState屬性值改變時會觸發readystatechange事件
			//readyState => 0->1->2->3->4
			//returnData 是一個回呼函式(callback function)
			xhr.addEventListener("readystatechange", returnData);
			//步驟二對Server端發出要求
			xhr.open("get", "FirstServlet", true); //true表示同步
			xhr.send();
		} else {
			alert("請升級您的瀏覽器!!");
		}
	}
  
	function returnData() {
		//console.log(xhr.readyState);
		//console.log(xhr.responseText);
		//readyState==4表示資料已經從Server傳到Client端了
		if (xhr.readyState == 4) {
			//status==200表示Server端的程式執行沒有錯誤
			if (xhr.status == 200) {
				//步驟三接收Server端回應的結果
				var data = xhr.responseText;
				
				//顯示資料
				myDiv.innerHTML = data;
			} else {
				myDiv.innerHTML = xhr.status + ":" + xhr.statusText;
			}
		}
	}
  
  
  
  
  function getData(){
	  //Ajax...
	 
	 xmlHttp = new XMLHttpRequest();//ajax必要物件
	 var value1 = document.getElementById("txtSearch").value;//讀取輸入的值
		if(value1!=null && value1.length!=0){
	 		if(xmlHttp != null){
// 				var url="JsonSimpleDemo?keyword="+value1; 
				xmlHttp.addEventListener("readystatechange",returnData,false);
				xmlHttp.open("get","../JsonSimpleDemo?keyword="+value1,true);//	../JsonSimpleDemo?keyword=			
				xmlHttp.send(null);///ch04/ex04/queryAllMembers.do
			}
		} else{
			show.style.display="none";//Object.style.display=value   none沒值消失  block沒值還在
		}
  }
  
  function returnData(){

	  if(xmlHttp.readyState ==4){//4代表已接收到資料
		  if(xmlHttp.status == 200){//http狀態碼
		  var datas = JSON.parse(xmlHttp.responseText);
		     show.style.display="block";
		     if(show.childNodes.length > 0){
		    	 show.removeChild(show.childNodes[0]);
		     }
		     var eleUl = document.createElement("ul");
		     for(var j=0;j<datas.length;j++){
		  	    var txtLi = document.createTextNode(datas[j]);
		  	    var eleLi = document.createElement("li");
		  	    eleLi.appendChild(txtLi);
		  	    eleLi.addEventListener("mouseover",function(){this.className='s1'},false)
		  	    eleLi.addEventListener("mouseout",function(){this.className='s2'},false);
		  	    eleLi.addEventListener("click",function(){
		  	    	 document.myData.keyword.value = this.firstChild.nodeValue;  		  	  
		  		  	 show.style.display="none";
		  	    },false);
		  	    eleUl.appendChild(eleLi);
		     }
		     show.appendChild(eleUl);
		  }
	  }
	}
  
</script>

</head>












</body>
</html>
