<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>golf-hi</title>

<link rel="stylesheet" href="assets/css/style.min.css">
<link rel="stylesheet" href="assets/css/modules.css">

<!-- Canonical URL usage -->
<link rel="canonical" href="https://aperitif.io/">

<!-- Facebook Open Graph -->
<meta property="og:url" content="https://aperitif.io/" />
<meta property="og:title"
	content="Aperitif | The web template generator" />
<meta property="og:description"
	content="Aperitif is a rapid web template generation tool." />
<meta property="og:image"
	content="https://aperitif.io/img/aperitif-facebook.png" />
<meta property="og:image:width" content="1200" />
<meta property="og:image:height" content="630" />

<!-- Twitter Cards -->
<meta name="twitter:card" content="summary_large_image">
<meta name="twitter:site" content="@Aperitif">
<meta name="twitter:creator" content="@Aperitif">
<meta name="twitter:title"
	content="Aperitif - The web template generator">
<meta name="twitter:description"
	content="Aperitif is a rapid web template generation tool.">
<meta name="twitter:image"
	content="https://aperitif.io/img/aperitif-card.png">

<!-- Google Structured Data -->
<script type="application/ld+json">
	{
	"@context" : "http://schema.org",
	"@type" : "SoftwareApplication",
	"name" : "Aperitif",
	"image" : "https://aperitif.io/img/aperitif-logo.svg",
	"url" : "https://aperitif.io/",
	"author" : {
	  "@type" : "Person",
	  "name" : "Octavector"
	},
	"datePublished" : "2017-MM-DD",
	"applicationCategory" : "HTML"
	}
	</script>
</head>
<!-- End Head -->

<body class="default">

	<!--
START MODULE AREA 1: header1
-->
	<header class="MOD_HEADER1">
		<div data-layout="_r">
			<div data-layout="al16 de10" class="MOD_HEADER1_Title">
				<h1 class="MOD_HEADER1_TextLogo">GolfHi</h1>
				<p class="MOD_HEADER1_Slogan">너무 졸리다</p>
			</div>
		</div>
	</header>
	<!--
END MODULE AREA 1: Header 1
-->

	<!--
START MODULE AREA 2: Menu 1
-->
	<section class="MOD_MENU" data-theme="_bgp">
		<div data-layout="_r" class="nopadding">
			<nav class="MOD_MENU_Nav">
				<p class="MOD_MENU_Title">Menu</p>
				<svg class="MOD_MENU_Button"
					xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
					width="30px" height="30px" viewBox="0 0 30 30"
					enable-background="new 0 0 30 30" xml:space="preserve">
        <rect width="30" height="6" />
        <rect y="24" width="30" height="6" />
        <rect y="12" width="30" height="6" />
      </svg>
				<ul class="AP_Menu_List">
					<!-- 반복 준비    -->
					<c:import var="menuInfo" url="/show/top/sub/mainForminfo.xml" />
					<x:parse xml="${menuInfo}" var="output" />
					<!-- 로그인한 유저에 따라 보여줄 정보를 다르게 표기. 판단은   여기서 -->

					<c:choose>
						<c:when test="${login eq null}">
						<c:set var="resultMenu" value="$output/not_login/Menu" />
						</c:when>
						<c:when test="${login.rating eq'U' }">
							<c:set var="resultMenu" value="ratingUser" />
						</c:when>
						<c:when test="${login.rating eq'M' }">
							<c:set var="resultMenu" value="ratingManager" />
						</c:when>
						<c:when test="${login.rating eq'A' }">
							<c:set var="resultMenu" value="ratingAdmin" />
						</c:when>
						<c:otherwise>
							<c:set var="resultMenu" value="not_login" />
						</c:otherwise>
					</c:choose>
					<%System.out.println(request.getAttribute("resultMenu")); %>
					<x:forEach select="'${resultMenu}'" var="aa" >
						<x:out select="text()"/>
					</x:forEach>

					<li><a href="#" data-theme="_bgp">Menu Item</a></li>
					<li><a href="#" data-theme="_bgp">Menu Item</a>
						<ul>
							<li><a href="#" data-theme="_bgpd">Sub-Menu Item</a></li>
							<li><a href="#" data-theme="_bgpd">Sub-Menu Item long
									title</a></li>
							<li><a href="#" data-theme="_bgpd">Sub-Menu Item</a></li>
						</ul></li>
					<li><a href="#" data-theme="_bgp">Menu Item</a></li>
					<li><a href="#" data-theme="_bgp">Menu Item</a></li>
					<li><a href="#" data-theme="_bgp">Menu Item</a></li>
					<li><a href="#" data-theme="_bgp">Menu Item</a>
						<ul>
							<li><a href="#" data-theme="_bgpd">Sub-Menu Item</a></li>
							<li><a href="#" data-theme="_bgpd">Sub-Menu Item long
									title</a></li>
							<li><a href="#" data-theme="_bgpd">Sub-Menu Item</a></li>
						</ul></li>
				</ul>
			</nav>
		</div>
	</section>
	<!--
END MODULE AREA 2: Menu 1
-->

	<script src="assets/js/index.js"></script>
</body>

</html>
