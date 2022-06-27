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
<title>管理者ログインページ</title>
</head>
<body>
<div class="content">
<h1><a href="adLogin.jsp"><img src="img/logo.jpg" alt="ロゴ" ></a></h1>

			<%String mes = (String) request.getAttribute("alertMsg");%>
			<%if (mes != null) {%>
			<div class="error">
			<p><%=mes%></p>
			</div>
			<%}%>
<form action="login" method="post" class="form">
<p><input type="email" placeholder="メールアドレス" name="mail" required/></p>
<p><input type="password" placeholder="パスワード" name="pass" required/></p>
<button type=“submit”>ログイン</button>
</form>
</div>
<footer>
<p></p>
</footer>
</body>
</html>