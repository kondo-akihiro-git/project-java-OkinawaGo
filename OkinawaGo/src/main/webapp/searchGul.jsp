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
    <link rel="stylesheet" type="text/css" href="css/searchX.css">
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
   <title>グルメ検索画面｜OkinawaGo</title>
</head>

<body>
<div class="content">
<h1><a href="index.html"><img src="img/logo.jpg" alt="ロゴ" ></a></h1>
	     <c:if test="${alartMsg != null}">
			<div class="error">
				<c:forEach items="${ alartMsg }" var="errList">
					<c:out value="${errList}" />
				</c:forEach>
			</div>
		</c:if>
<h2>フリーワード検索</h2>
<form action="select" method="post" class="freeword_search">
  <input type="search" name="goutext" class="input_var">
  <input type="submit" value="&#xf002;" class="fas">
</form>
<h2>グルメ検索</h2>
<div class="imagemap">
<img src="img/map.jpg" alt="マップ">
</div>

<form action="select" class="buttons" >
<li>地域</li>
<ul>
<li><input type="radio" name="id" value="area_ya">やんばる周辺</li>
<li><input type="radio" name="id" value="are_am">アメリカンヴィレッジ周辺</li>
<li><input type="radio" name="id" value="area_he">ひめゆりの搭周辺</li>
<li><input type="radio" name="id" value="area_na">那覇市</li>
<li><input type="radio" name="id" value="area_ch">美ら海水族館周辺</li>
<li><input type="radio" name="id" value="area_ao">青の洞窟周辺</li>
</ul>
<li>カテゴリー</li>
<ul>
<li><input type="checkbox" name="category" value="restaurant">レストラン</li>
<li><input type="checkbox" name="category" value="cafe">カフェ</li>
<li><input type="checkbox" name="category" value="izakaya">居酒屋</li>
<li><input type="checkbox" name="category" value="lunch">ランチ</li>
<li><input type="checkbox" name="category" value="dinner">ディナー</li>
<li><input type="checkbox" name="category" value="okicook">沖縄料理</li>
<li><input type="checkbox" name="category" value="sweets">スイーツ</li>
</ul>
<div class="submit_button"><button type="submit">検索</button></div>
</form>


</div>

<footer>
<p>　</p>
</footer>
</body>
</html>