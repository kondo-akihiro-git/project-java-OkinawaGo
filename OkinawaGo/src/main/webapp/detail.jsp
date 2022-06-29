<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>


<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">

<!-- Original CSS -->
<link rel="stylesheet" type="text/css" href="css/detail.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">

<!--favicon-->
<link href="favicon.ico" rel="shortcut icon">

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
<title>詳細結果画面｜OkinawaGo</title>
</head>

<body>

	<div class="content">
		<h1>
			<a href="index.jsp"><img src="img/logo.jpg" alt="ロゴ"></a>
		</h1>
		<a href="javascript:history.back();"><i class="fas fa-arrow-left"></i>前のページへ戻る</a>
		<%@ page import="java.util.*"%>
		<%@ page import="java.util.ArrayList,java.util.HashMap"%>
		<%@ page import="main.java.com.crrypst.example.entity.Info_DTO"%>
		<%@ page import="main.java.com.crrypst.example.dao.Okinawa_DAO"%>
		<%@ page import="main.java.com.crrypst.example.entity.Comment_DTO"%>
		<%@ page import="main.java.com.crrypst.example.entity.Menu_DTO"%>
		<%@ page import="main.java.com.crrypst.example.userpage.base.BaseUser"%>
		<%@ page import="main.java.com.crrypst.example.util.DbUtil"%>
		
		<%
			ArrayList<Info_DTO> list = (ArrayList<Info_DTO>) request.getAttribute("list");
			for (Info_DTO r : list) {
		%>
		<div class="topImg">
			<img src="img/<%=r.getInfo_img()%>" alt="<%=r.getInfo_nm() %>の写真">
		</div>
		<h2><%=r.getInfo_nm()%></h2>
		<table>
			<tr>
				<td rowspan="2" class="addressTd">場所</td>
				<td><%=r.getPost_code()%> </td>
			</tr>
			<tr>
				<td><%=r.getAddress() %></td>
			</tr>
		</table>
		<% } %>
		
		
		
		
		<% String check = (String)request.getAttribute("s_g_id"); %>
		<% if(check.equals("2")){ %>
		<%
		ArrayList<Menu_DTO> menulist = (ArrayList<Menu_DTO>) request.getAttribute("pricelist");
		if(menulist.size() != 0){ 
		%>
		<table>
		<td class="addressTd">メニュー</td>
		<% for (Menu_DTO r : menulist) {%>
		<tr>
				<td class="addressTd"><%=r.getPrice_nm()%> </td>
				<td>&yen<%=r.getPrice() %></td>
				
		</tr>
		<% } %>
		</table>
		<% } else if(menulist.size() == 0){%>
		<% } %>
		<% }if(check.equals("1")){ %>
		<% } %>
		

		
		<table id='messages'>
		</table>
		
		
		
		
		<h3>コメント</h3>

		<table class="comment">
		<%
			ArrayList<Comment_DTO> list_com = (ArrayList<Comment_DTO>) request.getAttribute("commentList");
			for (Comment_DTO r : list_com) {
		%>		
			<tr>
				<td><%=r.getComment_nm() %></td>
				<td><%=r.getComment_tx() %></td>
				
				<% if(r.getComment_img() != null){%>
				
				<td class="commentImg"><img src="/okinawago/upload/<%=r.getComment_img() %>"></td>
				<% }else if(r.getComment_img() == null){ %>
					<td></td>
				<% } %>
			</tr>
			<% } %>
		</table>


		<form action="comment" method="post" id="commentForm"
			name="commentForm" enctype="multipart/form-data" class="com">
			<p>
				<input type="text" name="comment_nm" required maxlength="20"
					placeholder="ユーザー名（20字まで）" class="comment_name">
			</p>
			<textarea name="comment_tx" required maxlength="140"
				placeholder="本文（140字まで）" class="comment_text"></textarea>
			<p>
				<input type="file" id="avatar" name="comment_img" accept="image/png, image/jpeg">
			</p>
			<input type="hidden" name="info_id" value="<%=request.getAttribute("info_id") %>">
			<input type="hidden" name="info_img" value="<%=request.getAttribute("info_img")%>">
			<input type="hidden" name="area_id" value="<%=request.getAttribute("area_id")%>">
			<input type="hidden" name="s_g_id" value="<%=request.getAttribute("s_g_id")%>">
			<div class="submit_button">
				<button type="submit" id="button" name="name">コメント投稿</button>
			</div>
		</form>



		<div class="recomend">
		<%if(request.getAttribute("s_g_id").equals("1")){ %>
			<h3>周辺のグルメ</h3>
			<%}else if(request.getAttribute("s_g_id").equals("2")){ %>
			<h3>周辺のスポット</h3>
			<%} %>
			<div class="wrapper">
			<%
			ArrayList<Info_DTO> recomlist = (ArrayList<Info_DTO>) request.getAttribute("recomlist");
			for (int i = 0; i< recomlist.size(); i++ ) {
			%>
			
			<form method="post" action="showinfo">
			<input type="image" class="inputimg" src="img/<%=recomlist.get(i).getInfo_img()%>"  class="inputimg">
			<input type="hidden" name="info_img" value="<%=recomlist.get(i).getInfo_img()%>">
			<input type="hidden" name="info_id" value="<%=recomlist.get(i).getInfo_id()%>">
			<input type="hidden" name="area_id" value="<%=recomlist.get(i).getArea_id()%>">
			<input type="hidden" name="s_g_id" value="<%=recomlist.get(i).getS_g_id()%>">
			</form>
			
			<%}%>

</div>
		</div>

		<script>
			var element = document.getElementById("commentForm");
			const button = document.getElementById("button");

			button.addEventListener("click", click);
			function click() {
				var click = element.checkValidity();
				if (click) {
					alert('投稿しました！');
				}
			}
		</script>

	</div>




	<footer>
		<p></p>
	</footer>
	<script src="js/weatherForcast.js"></script>
</body>
</html>
