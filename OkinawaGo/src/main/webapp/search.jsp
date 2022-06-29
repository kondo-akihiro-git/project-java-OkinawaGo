<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">

<!-- Original CSS -->
<link rel="stylesheet" type="text/css" href="css/search.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">

<!--favicon-->
<link href="favicon.ico" rel="shortcut icon">
<!--jQuery-->
<script type='text/javascript'
	src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'
	id='jquery-js'></script>
<script src="js/paginathing.min.js"></script>
<script>
	(function(d) {
		var config = {
			kitId : 'nvj0abk',
			scriptTimeout : 3000,
			async : true
		}, h = d.documentElement, t = setTimeout(function() {
			h.className = h.className.replace(/\bwf-loading\b/g, "")
					+ " wf-inactive";
		}, config.scriptTimeout), tk = d.createElement("script"), f = false, s = d
				.getElementsByTagName("script")[0], a;
		h.className += " wf-loading";
		tk.src = 'https://use.typekit.net/' + config.kitId + '.js';
		tk.async = true;
		tk.onload = tk.onreadystatechange = function() {
			a = this.readyState;
			if (f || a && a != "complete" && a != "loaded")
				return;
			f = true;
			clearTimeout(t);
			try {
				Typekit.load(config)
			} catch (e) {
			}
		};
		s.parentNode.insertBefore(tk, s)
	})(document);
</script>
<title>検索結果画面｜OkinawaGo</title>
</head>
<body>
	<div class="content">
		<h1>
			<a href="index.jsp"><img src="img/logo.jpg" alt="ロゴ"></a>
		</h1>
		<%String area_nm = (String)request.getAttribute("area_nm"); %>
		<%String[] cate_nm = (String[])request.getAttribute("cate_nm"); %>
		<% if(request.getAttribute("text") != null){ %>
		<h2>フリーワード：<%=request.getAttribute("text") %></h2>
		<% }else if(request.getAttribute("area_nm") != null && cate_nm == null && request.getAttribute("check").equals("1")){ %>
		<h2><%=area_nm %>のスポット</h2>
		<% }else if(request.getAttribute("cate_nm") != null){ %>
		<h2><%=area_nm %>の
		<%for(int i = 0; i< cate_nm.length;i ++){
			if(cate_nm[i] != null){ %>
				<%=cate_nm[i] %>
			<% } %>
		<% } %>
		</h2>
		<% }else if(request.getAttribute("area_nm") != null && cate_nm == null && request.getAttribute("check").equals("2")) {%>
		<h2><%=area_nm %>のグルメ</h2>
		
		<% } %>
		<%@ page import="java.util.*"%>
		<%@ page import="java.util.ArrayList,java.util.HashMap"%>
		<%@ page import="main.java.com.crrypst.example.entity.Info_DTO"%>
		<%@ page import="main.java.com.crrypst.example.dao.Okinawa_DAO"%>
		<%@ page import="main.java.com.crrypst.example.entity.Info_id_img_DTO"%>
		<%@ page import="main.java.com.crrypst.example.userpage.base.BaseUser"%>
		<%@ page import="main.java.com.crrypst.example.util.DbUtil"%>
		<%String check = (String)request.getAttribute("check"); %>
		
		<% if(request.getAttribute("check").equals("2")){%>
		<div class="pagenation_block wrapper">
			<%
			ArrayList<Info_id_img_DTO> list = (ArrayList<Info_id_img_DTO>) request.getAttribute("infolist");
			for (Info_id_img_DTO r : list) {
			%>
			<form method="post" action="showinfo" class="input">
			<input type="image" src="img/<%=r.getInfo_img()%>"  class="inputimg">
			<input type="hidden" name="info_img" value="<%=r.getInfo_img()%>">
			<input type="hidden" name="info_id" value="<%=r.getInfo_id()%>">
			<input type="hidden" name="area_id" value="<%=r.getArea_id()%>">
			<input type="hidden" name="s_g_id" value="<%=r.getS_g_id()%>">
			</form>
		<%}%>
			
		</div>
		
		
		
		<% }else if(request.getAttribute("check").equals("1")){ %>
		<div class="pagenation_block wrapper">
			
			<%
			ArrayList<Info_DTO> list_spo = (ArrayList<Info_DTO>) request.getAttribute("infolist");
			for (Info_DTO r : list_spo) {
			%>
		
			<form method="post" action="showinfo" class="input">
			<input type="image" src="img/<%=r.getInfo_img()%>" class="img">
			<input type="hidden" name="info_img" value="<%=r.getInfo_img()%>">
			<input type="hidden" name="info_id" value="<%=r.getInfo_id()%>">
			<input type="hidden" name="area_id" value="<%=r.getArea_id()%>">
			<input type="hidden" name="s_g_id" value="<%=r.getS_g_id()%>">
			</form>
			<%}%>
		</div>
		<%}%>
			
		
		
		
		

	</div>

	<footer>
		<p></p>
	</footer>
		<script type="text/javascript">
			$(function() {
				$('.pagenation_block').paginathing({//親要素のclassを記述
					perPage : 4,//1ページあたりの表示件数
					prevText : '<i class="fas fa-angle-left"></i>',//1つ前のページへ移動するボタンのテキスト
					nextText : '<i class="fas fa-angle-right"></i>',//1つ次のページへ移動するボタンのテキスト
					activeClass : 'navi-active',//現在のページ番号に任意のclassを付与できます
					firstText : '<i class="fas fa-angle-double-left"></i>', // "最初ページ"に移動するボタンのテキスト
					lastText : '<i class="fas fa-angle-double-right"></i>', // "最後のページ"に移動するボタンのテキスト

				})
			});
		</script>

</body>
</html>