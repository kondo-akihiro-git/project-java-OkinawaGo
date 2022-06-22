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
<span class="login_name"><p>ログイン：山田</p></span>
<h1><a href="adLogin.html"><img src="img/logo.jpg" alt="ロゴ" ></a></h1>

<table class="form">
<form action="adInsert.html" method="post">
<tr class="radiobotton">
<td><input type="radio" name="####" value="??"  onclick="return false;" checked>スポット
<input type="radio" name="####" value="??" disabled>グルメ</td>
</tr>
<tr>
<td><input type="text" name="name" value="楽しいパークOkinawa" readonly style="background-color: #d1d1d1"></td>
</tr>
<tr>
<td>
<select name="area" disabled>
<option value="###" selected>やんばる周辺</option>
<option value="###">アメリカンヴィレッジ周辺</option>
<option value="###">ひめゆりの搭周辺</option>
<option value="###">那覇市</option>
<option value="###">美ら海水族館周辺</option>
<option value="###">青の洞窟周辺</option>
</select></td>
</tr>
<tr>
<td><input type="text" name="postcode" value="901-0225 " readonly style="background-color: #d1d1d1"></td>
</tr>
<tr>
<td><input type="text" name="address" value="沖縄県沖縄県国頭村字比地５−１" readonly style="background-color: #d1d1d1"></td>
</tr>
<tr>
<td><button type="button" name="##" value="01IMG_2382.jpg" readonly style="background-color: #d1d1d1">写真を選択</button>
01IMG_2382.jpg
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
