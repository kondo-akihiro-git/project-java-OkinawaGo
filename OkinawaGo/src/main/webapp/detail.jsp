<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<!doctype html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>


    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <!-- Original CSS -->
    <link rel="stylesheet" type="text/css" href="css/detail.css">
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
   <title>詳細結果画面｜OkinawaGo</title>
</head>

<body>

<div class="content">
<h1><a href="index.html"><img src="img/logo.jpg" alt="ロゴ" ></a></h1>
<a href="javascript:history.back();"><i class="fas fa-arrow-left"></i>前のページへ戻る</a>
<div class="topImg"><img src="img/02DSC04487.jpg" alt="？？の写真"></div>
<c:if test = "${ list != null}" }>
<c:forEach items = "${ list }" var = "list"> 
<h2><c:out value = "${ list.info_nm }" /></h2>
<table>
<tr>
<td rowspan="2" class="addressTd">場所</td>
<td><c:out value = "${ list.post_code}"/></td>
</tr>
<tr>
<td><c:out value = "${ list.address}"/></td>
</tr>
</table>
</c:forEach>
</c:if>
<table id='messages'>

<c:if test = "${ commentList != null } ">
<c:forEach items = "${ commentList }" var = "list">
</table>

<h3>コメント</h3>
<table>
<tr>
<td><c:out value = "${ list.comment_nm}"/></td>
<td><c:out value = "${ list.comment_tx}"/></td>
<td class="commentImg" ><img src="img/01IMG_2382.jpg"></td>
</tr>
<tr>
<td><c:out value = "${ list.comment_nm}"/></td>
<td><c:out value = "${ list.comment_tx}"/></td>
<td class="commentImg"><img src="img/038G8A1044_i.jpg"></td>
</tr>
</table>
</c:if>
</c:forEach>

<form action="detail.html" method="post" id="commentForm" name="commentForm">
<p><input type="text" name="????" required maxlength="20" placeholder="ユーザー名（20字まで）"  class="comment_name"></p>
<textarea name="?????" required  maxlength="140" placeholder="本文（140字まで）" class="comment_text"></textarea>
<p><input type="file" id="avatar" name="avatar" accept="image/png, image/jpeg"></p>
<div class="submit_button"><button type="submit" value="????" id="button" name="name">コメント投稿</button></div>
</form>

    
    
<div class="recomend">
<h3>周辺のグルメ</h3>
<div class="wrapper">
  <div class="box1"><a href="###"><img src="img/ogasuta458A8086.jpg" alt="グルメの写真"></a></div>
  <div class="box2"><a href="detail_kekkaGul.html"><img src="img/img_001.jpg" alt="グルメの写真"></a></div>
  <div class="box3"><a href="###"><img src="img/oki_062.jpg" alt="グルメの写真"></a></div>
</div>
</div>

<script>
var element = document.getElementById( "commentForm" );
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
<p>　</p>
</footer>
<script src="js/weatherForcast.js"></script>
</body>
</html>
