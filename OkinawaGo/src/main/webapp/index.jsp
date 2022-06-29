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
    <link rel="stylesheet" type="text/css" href="css/index.css">
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
   <title>検索トップ画面｜OkinawaGo</title>
</head>
<body>
<div class="content">
<h1><a href="index.jsp"><img src="img/logo.jpg" alt="ロゴ" ></a></h1>
			
			<%String mes = (String) request.getAttribute("alertMsg");%>
			<%if (mes != null) {%>
			<div class="error">
			<p><%=mes%></p>
			</div>
			<%}%>
		
<h2>フリーワード検索</h2>
<form action="search" method="post" class="input">
  <input type="search" name="toptext" class="input_var" required>
  <input type="submit" value="&#xf002;" class="fas">
</form>
<%@ page import="java.util.*"%>
<%@ page import="java.util.ArrayList,java.util.HashMap"%>
<%@ page import="main.java.com.crrypst.example.entity.Info_DTO"%>
<%@ page import="main.java.com.crrypst.example.dao.Okinawa_DAO"%>
<%@ page import="main.java.com.crrypst.example.userpage.base.BaseUser"%>
<%@ page import="main.java.com.crrypst.example.userpage.ShowInfoAction"%>
<%@ page import="main.java.com.crrypst.example.util.DbUtil"%>

<div class="recomend">
<a href="searchSpo.jsp">
<h2>スポット検索</h2>
<%
ShowInfoAction show = new ShowInfoAction();
int min = 1;
int max = 5;
Random random = new Random();
int num = random.nextInt(max + min) + min;
String area_id = Integer.valueOf(num).toString();
String s_g_id = "2";
List<Info_DTO> recom = new ArrayList<>();
recom = show.getRecommendlist(area_id,s_g_id);
%>
<div class="wrapper img">
<% 
for (int i = 0; i< recom.size(); i++ ) {
%>

<img src="img/<%=recom.get(i).getInfo_img()%>">

<%}%>
</div>
</a>


<a href="searchGul.jsp">
<h2>グルメ検索</h2>

<%
String s_g_id_g = "1";
List<Info_DTO> recom_g = new ArrayList<>();
recom_g = show.getRecommendlist(area_id,s_g_id_g);
%>
<div class="wrapper img">
<% 
for (int i = 0; i< recom_g.size(); i++ ) {
%>
<img src="img/<%=recom_g.get(i).getInfo_img()%>">

<%}%>
</div>
</a>

</div>
<div class="adLink"><a href="adLogin.jsp" target ="blank">管理者の方はこちら</a></div>
</div>

<footer>
<p>　</p>
</footer>
</body>
</html>
