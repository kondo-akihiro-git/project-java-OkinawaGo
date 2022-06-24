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
   <title>スポット/グルメ追加入力ページ｜OkinawaGo</title>
</head>
<body>
<div class="content">
<span class="login_name"><p>ログイン：${ sessionScope.LOGIN_EMP.LOGIN.loginad }</p></span>
<h1><a href="adLogin.jsp"><img src="img/logo.jpg" alt="ロゴ" ></a></h1>

<table class="form">
<form action="input" method="post">
<tr class="radiobotton">
<td><input type="radio" name="s_g_id" value="スポット" required 
onclick="document.getElementById('cate').style.display = 'none';" >スポット
<input type="radio" name="s_g_id" value="グルメ" required 
onclick="document.getElementById('cate').style.display = 'inline';">グルメ</td>
</tr>
<tr>
<td><input type="text" name="info_nm" required placeholder="名前"></td>
</tr>
<tr>
<td>
<select name="area_id">
<option value="1">やんばる周辺</option>
<option value="2">アメリカンヴィレッジ周辺</option>
<option value="3">ひめゆりの搭周辺</option>
<option value="4">那覇市</option>
<option value="5">美ら海水族館周辺</option>
<option value="6">青の洞窟周辺</option>
</select></td>
</tr>
<tr>
<td><input type="text" name="post_cord" required placeholder="郵便番号"></td>
</tr>
<tr>
<td><input type="text" name="address" required placeholder="住所"></td>
</tr>
<tr id="cate">
<td  class="buttons">
<ul>
<li><input type="checkbox" name="category_id" value="1">レストラン</li>
<li><input type="checkbox" name="category_id" value="2">カフェ</li>
<li><input type="checkbox" name="category_id" value="3">居酒屋</li>
<li><input type="checkbox" name="category_id" value="4">ランチ</li>
<li><input type="checkbox" name="category_id" value="5">ディナー</li>
<li><input type="checkbox" name="category_id" value="6">沖縄料理</li>
<li><input type="checkbox" name="category_id" value="7">スイーツ</li>
</ul>
</td>
</tr>
<tr>
<td><input type="file" id="avatar" name="info_img" required accept="image/png, image/jpeg"></td>
</tr>
<tr>
<td>
<button type=“submit”>登録内容確認</button>
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

