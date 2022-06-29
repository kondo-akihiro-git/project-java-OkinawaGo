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
<link rel="stylesheet" type="text/css" href="css/ad.css">
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
<title>管理者スポット/グルメ検索ページ｜OkinawaGo</title>
</head>
<body>
	<div class="content">
		<span class="login_name"><p>
				ログイン：<%=session.getAttribute("LOGIN_Manager_nm")%></p></span>
		<h1>
			<a href="adSearch.jsp"><img src="img/logo.jpg" alt="ロゴ"></a>
		</h1>
		<%
		String mes = (String) request.getAttribute("alertMsg");
		%>
		<%
		if (mes != null) {
		%>
		<div class="error">
			<p><%=mes%></p>
		</div>
		<%
		}
		%>
		<form action="select" method="post" class="freeword_search">
			<input type="search" name="text" placeholder="店名/スポット名/住所/カテゴリ名"
				class="input_var"> <input type="submit" value="検索" required>
		</form>
		<div class="pagenation_block">
			<%@ page import="java.util.*"%>
			<%@ page import="java.util.ArrayList,java.util.HashMap"%>
			<%@ page import="main.java.com.crrypst.example.entity.Info_DTO"%>
			<%@ page import="main.java.com.crrypst.example.dao.Okinawa_DAO"%>
			<%@ page import="main.java.com.crrypst.example.entity.Info_DTO"%>
			<%@ page import="main.java.com.crrypst.example.userpage.base.BaseUser"%>
			<%@ page import="main.java.com.crrypst.example.util.DbUtil"%>
			<%
			ArrayList<Info_DTO> list = (ArrayList<Info_DTO>) request.getAttribute("spotInfolist");
			if (list == null) {
			%>
			<table>
			</table>
			<%
			} else if (list != null) {
			for (Info_DTO r : list) {
			%>
			<dl>
				<dd>
					<table class="adsearchbutton">
						<tr>
							<td><%=r.getInfo_nm()%></td>
							<td><form action="showinfo" method="post">
									<input type="submit" value="詳細"> 
									<input type="hidden" name="info_img" value="<%=r.getInfo_img()%>"> 
									<input type="hidden" name="info_id" value="<%=r.getInfo_id()%>">
									<input type="hidden" name="area_id" value="<%=r.getArea_id()%>">
									<input type="hidden" name="s_g_id" value="<%=r.getS_g_id()%>">
								</form></td>
							<td><form method="post" action="delete" >
									<input type="button" value="削除"  id="<%=r.getInfo_id()%>"> 
									<input type="hidden"value="<%=r.getInfo_nm()%>"  name="info_nm"> 
									<input type="hidden" value="<%=r.getInfo_id()%>" name="info_id" >
								</form></td>
							<td><form action="select" method="post">
									<input type="submit" value="コメント管理"> 
									<input type="hidden" value="<%=r.getInfo_id()%>" name="info_id">
								</form></td>
						</tr>
					</table>
				</dd>
			</dl>


			<%
			}
			%>
			<%
			}
			%>

		</div>


		<span class="insertButton"> <a href="adInsert_Input.jsp">スポット/グルメ追加</a>
		</span>

	</div>

	<footer>
		<p></p>
	</footer>

		<script type="text/javascript">
			$(function() {
				$('.pagenation_block').paginathing({//親要素のclassを記述
					perPage : 10,//1ページあたりの表示件数
					prevText : '<i class="fas fa-angle-left"></i>',//1つ前のページへ移動するボタンのテキスト
					nextText : '<i class="fas fa-angle-right"></i>',//1つ次のページへ移動するボタンのテキスト
					activeClass : 'navi-active',//現在のページ番号に任意のclassを付与できます
					firstText : '<i class="fas fa-angle-double-left"></i>', // "最初ページ"に移動するボタンのテキスト
					lastText : '<i class="fas fa-angle-double-right"></i>', // "最後のページ"に移動するボタンのテキスト

				})
			});
		</script>

	<script>
	<%
	if (list != null) {
	ArrayList<Info_DTO> list_sc = (ArrayList<Info_DTO>) request.getAttribute("spotInfolist");
	for (Info_DTO r : list_sc) {
	%>
			var button = document.getElementById('<%=r.getInfo_id()%>');
			console.log("formId:" + button.id);
			button.addEventListener('click', butotnClick);
			
			function butotnClick(event){
		        var next_element =  event.target.nextElementSibling;
		        var del_form = next_element.parentNode;
		        var com = window.confirm(next_element.value + 'を削除しますか？');
				if (com == true) {
					del_form.submit();
					return true;
				} else{
					return false;
				} 
		        
		    }
<% } }%>

	</script>
</body>
</html>

