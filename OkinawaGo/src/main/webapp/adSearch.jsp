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
<script src="paginathing.min.js"></script>
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
		<span class="login_name"><p>ログイン：${ sessionScope.LOGIN_EMP.LOGIN.loginad }</p></span>
		<h1>
			<a href="adLogin.html"><img src="img/logo.jpg" alt="ロゴ"></a>
		</h1>
		<div class="error">
			<%String mes = (String) request.getAttribute("alertMsg");%>
			<%if (mes != null) {%>
			<%=mes%>
			<%}%>
		</div>
		<form action="select" method="post" class="freeword_search">
			<input type="search" name="text" placeholder="店名/スポット名/住所"
				class="input_var"> <input type="submit" value="検索">
		</form>
		<div class="pagenation_block">
			<%@ page import="java.util.ArrayList" %>
			<%@ page import="java.util.List" %>
			<% if(request.getAttribute("searchlist") != null){ %>
			<% } %>

					<dl>
						<dd>
							<table>
								<tr>
									<td>タイトル</td>
									<td><form action="select" method="post">
											<input type="submit" value="情報掲載ID"
												name="info_id">詳細
										</form></td>
									<td><form onClick="buttonClick()" method="post">
											<input type="submit" value="情報掲載ID"
												name="info_id>">削除
										</form></td>
									<td><form action="select" method="post">
											<input type="submit" value="情報掲載ID"
												name="info_id">コメント管理
										</form></td>
								</tr>
							</table>
						</dd>
					</dl>
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
						function buttonClick() {
					if (window.confirm('<%=request.getAttribute("name")
				%>を削除しますか？')) {
				window.open('delete'); return true; } }
				</script>
</body>
</html>

