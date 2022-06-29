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
		<table class="form">
			<form action="input" method="post" name="inp" >
				<tr class="radiobotton">
					<td><input type="radio" name="s_g_id" value="1" required id= "a"
						onclick="document.getElementById('cate').style.display = 'none';">スポット
						<input type="radio" name="s_g_id" value="2" required id= "a"
						onclick="document.getElementById('cate').style.display = 'inline';">グルメ</td>
				</tr>
				<tr>
					<td><input type="text" name="info_nm" required
						placeholder="名前"></td>
				</tr>
				<tr>
					<td><select name="area_id">
							<option value="1" >やんばる周辺</option>
							<option value="2" >美ら海水族館周辺</option>
							<option value="3" >青の洞窟周辺</option>
							<option value="4">アメリカンヴィレッジ周辺</option>
							<option value="5">那覇市</option>
							<option value="6">ひめゆりの搭周辺</option>


					</select></td>
				</tr>
				<tr>
					<td><input type="text" name="post_code" required
						placeholder="郵便番号"></td>
				</tr>
				<tr>
					<td><input type="text" name="address" required
						placeholder="住所"></td>
				</tr>
				<tr id="cate">
					<td class="buttons">
						<ul>
							<li><input type="checkbox" name="category_id" class="check"
								value="1">レストラン</li>
							<li><input type="checkbox" name="category_id" class="check"
								value="2" >カフェ</li>
							<li><input type="checkbox" name="category_id" class="check"
								value="3" >居酒屋</li>
							<li><input type="checkbox" name="category_id" class="check"
								value="4">ランチ</li>
							<li><input type="checkbox" name="category_id" class="check"
								value="5" >ディナー</li>
							<li><input type="checkbox" name="category_id" class="check"
								value="6" >沖縄料理</li>
							<li><input type="checkbox" name="category_id" class="check"
								value="7" >スイーツ</li>
						</ul>
					</td>
				</tr>
				<tr>
					<td><input type="file" id="avatar" name="info_img" required
						accept="image/png, image/jpeg"></td>
				</tr>
				<tr>
					<td>
						<button type=“submit” onClick="return isCheck()">登録内容確認</button> 
						<script>
						/* window.addEventListener('DOMContentLoaded', function(){
							var input_genders = document.querySelectorAll("input[name=s_g_id]");
							for(var element of input_genders) {
								element.addEventListener('change',function(){
									if( this.checked ) {
										console.log(this.value);
									}
								});
							}
							});
 */						function isCheck() {
	 for(var i=0; i<document.inp.s_g_id.length;i++){
	        if(document.inp.s_g_id[i].checked){
	            console.log(document.inp.s_g_id[i].value + "が選択されました。");
	            var num = document.inp.s_g_id[i].value;
				//console.log(num);
				if(num==2){
			    let arr_checkBoxes = document.getElementsByClassName("check");
			    console.log(arr_checkBoxes);
			    let count = 0;
			    for (let i = 0; i < arr_checkBoxes.length; i++) {
			        if (arr_checkBoxes[i].checked) {
			            count++;
			        }
			    }
			    if (count > 0) {
			        return true;
			    } else {
			        window.alert("1つ以上選択してください。");
			        return false;
			    };
			}
	        }
	    }
							
							
						}
						</script>
</td>
</tr>
</form>
</table>

<span class="back"><a href="javascript:history.back();"><i class="fas fa-arrow-left"></i>前のページへ戻る</a></span>
</div>

</body>
</html>

