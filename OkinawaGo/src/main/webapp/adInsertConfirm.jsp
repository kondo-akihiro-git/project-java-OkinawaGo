<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <!-- Original CSS -->
    <link rel="stylesheet" type="text/css" href="css/ad.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
	
	<!--favicon-->
	<link href="favicon.ico" rel="shortcut icon">

<script>
  (function(d) {
    var config = {
      kitId: 'nvj0abk',
      scriptTimeout: 3000,
      async: true
    },
    h=d.documentElement,t=setTimeout(function(){h.className=h.className.replace(/\bwf-loading\b/g,"")+" wf-inactive";},config.scriptTimeout),tk=d.createElement("script"),f=false,s=d.getElementsByTagName("script")[0],a;h.className+=" wf-loading";tk.src='https://use.typekit.net/'+config.kitId+'.js';tk.async=true;tk.onload=tk.onreadystatechange=function(){a=this.readyState;if(f||a&&a!="complete"&&a!="loaded")return;f=true;clearTimeout(t);try{Typekit.load(config)}catch(e){}};s.parentNode.insertBefore(tk,s)
  })(document);
</script>
   <title>スポット/グルメ入力確認ページ｜OkinawaGo</title>
</head>
<body>
<div class="content">
<span class="login_name"><p>ログイン：<%=session.getAttribute("LOGIN_Manager_nm") %></p></span>
<h1><a href="adSearch.jsp"><img src="img/logo.jpg" alt="ロゴ" ></a></h1>

<table class="form">
<form action="addinfo" method="post">
<tr class="radiobotton">
<%String s_g_id =(String)request.getAttribute("s_g_id"); %>
<td><input type="radio" name="s_g_id" value="1" ${1 == s_g_id ? 'checked="checked"' : 'disabled="disabled"'}>スポット
<input type="radio" name="s_g_id" value="2" ${2 == s_g_id ? 'checked="checked"' : 'disabled="disabled"'}>グルメ</td>
</tr>
<tr>
<td><input type="text" name="info_nm" value="<%=request.getAttribute("info_nm") %>" readonly style="background-color: #d1d1d1"></td>
</tr>
<tr>
<td>
<% String area_id = (String)request.getAttribute("area_id"); %>
<select name="area_id" disabled>
<option value="1" ${1 == area_id ? 'selected="selected"' : ''}>やんばる周辺</option>
<option value="2" ${2 == area_id ? 'selected="selected"' : ''}>美ら海水族館周辺</option>
<option value="3" ${3 == area_id ? 'selected="selected"' : ''}>青の洞窟周辺</option>
<option value="4" ${4 == area_id ? 'selected="selected"' : ''}>アメリカンヴィレッジ周辺</option>
<option value="5" ${5 == area_id ? 'selected="selected"' : ''}>那覇市</option>
<option value="6" ${6 == area_id ? 'selected="selected"' : ''}>ひめゆりの搭周辺</option>
</select></td>
<input type="hidden" name="area_id" value="<%=request.getAttribute("area_id") %>">
</tr>
<tr>
<td><input type="text" name="post_code" value="<%=request.getAttribute("post_code") %>" readonly style="background-color: #d1d1d1"></td>
</tr>
<tr>
<td><input type="text" name="address" value="<%=request.getAttribute("address") %>" readonly style="background-color: #d1d1d1"></td>
</tr>

<% String[] cateList = (String[])request.getAttribute("cateList"); %>
<% if(cateList != null){ %>
<tr id="cateList">
<td  class="buttons">
<ul>

<li><input type="checkbox" name="cateList" value="1" 
<% for(String category_id :cateList){
	if(category_id.equals("1")){%>
		checked="checked"
	<% }%> 
	<% } %>onclick='return false;' >レストラン</li>
<li><input type="checkbox" name="cateList" value="2" 
<% for(String category_id :cateList){
	if(category_id.equals("2")){%>
		checked="checked"
	<% }%> 
	<% } %>onclick='return false;' >カフェ</li>
<li><input type="checkbox" name="cateList" value="3" 
<% for(String category_id :cateList){
	if(category_id.equals("3")){%>
		checked="checked"
	<% }%> 
	<% } %>onclick='return false;' >居酒屋</li>
<li><input type="checkbox" name="cateList" value="4" 
<% for(String category_id :cateList){
	if(category_id.equals("4")){%>
		checked="checked"
	<% }%> 
	<% } %>onclick='return false;' >ランチ</li>
<li><input type="checkbox" name="cateList" value="5" 
<% for(String category_id :cateList){
	if(category_id.equals("5")){%>
		checked="checked"
	<% }%> 
	<% } %>onclick='return false;' >ディナー</li>
<li><input type="checkbox" name="cateList" value="6" 
<% for(String category_id :cateList){
	if(category_id.equals("6")){%>
		checked="checked"
	<% }%> 
	<% } %>onclick='return false;' >沖縄料理</li>
<li><input type="checkbox" name="cateList" value="7" 
<% for(String category_id :cateList){
	if(category_id.equals("7")){%>
		checked="checked"
	<% }%> 
	<% } %>onclick='return false;' >スイーツ</li>
</ul>
</td>
</tr>
<% } %>
<tr>
<td><button type="button" name="info_img" value="<%=request.getAttribute("info_img") %>" readonly style="background-color: #d1d1d1">写真を選択</button>
<%=request.getAttribute("info_img") %>
<input type="hidden" name="info_img" value="<%=request.getAttribute("info_img") %>" >
</td>
</tr>
<tr>
<td>
<button type=“submit”>登録</button>
</td>
</tr>
</form>
</table>

<span class="back"><a href="javascript:history.back();"><i class="fas fa-arrow-left"></i>前のページへ戻る</a></span>
</div>

<footer>
<p>　</p>
</footer>
</body>
</html>

