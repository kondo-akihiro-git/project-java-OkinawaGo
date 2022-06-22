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
<title>検索トップ画面(スポット検索)｜OkinawaGo</title>
</head>
<body>
	<div class="content">
		<h1>
			<a href="index.html"><img src="img/logo.jpg" alt="ロゴ"></a>
		</h1>

		<h2>ひめゆりの搭周辺のスポット</h2>
		<div class="wrapper pagenation_block">
			<dl class="box1">
				<dd>
					<a href="detail.html"><img src="img/02DSC04487.jpg"></a>
			</dl>
			</dd>
			<dl class="box2">
				<dd>
					<a href="##"><img src="img/02DSC03208_i.jpg"></a>
			</dl>
			</dd>
			<dl class="box3">
				<dd>
					<a href="##"><img src="img/038G8A1044_i.jpg"></a>
			</dl>
			</dd>
			<dl class="box4">
				<dd>
					<a href="##"><img src="img/01IMG_2382.jpg"></a>
			</dl>
			</dd>
			<dl class="box1">
				<dd>
					<a href="##"><img src="img/01IMG_2382.jpg"></a>
			</dl>
			</dd>
		</div>

	</div>

	<footer>
		<p></p>
	</footer>
	<script type="text/javascript">
		$(function() {
			$('.pagenation_block').paginathing({
				perPage : 4,//1ページあたりの件数
				prevText : '前へ',//前
				nextText : '次へ',//次
				activeClass : 'navi-active',
				firstText : '最初のページ', // "最初ページ"
				lastText : '最後のページ', // "最後のページ"

			})
		});
	</script>

</body>
</html>