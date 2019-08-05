<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script>
	function amountUpDown(num) {
		var tmp = document.getElementById("gamount");
		tmp.value = parseInt(num) + parseInt(tmp.value);
		if (parseInt(tmp.value) < 1)
			tmp.value = 1;
	}

	function reqCheck(action, myform) {

		if (validityF()) {
			if (action == 'order') {
				myform.action = "OrderAddServlet";
			} else if (action == 'cart') {
				myform.action = "CartAddServlet";
			}
			alert("예약하였습니다.");
		}else{
			alert("다시 확인해 주세요");
		}
	}
	function validityF() {
		var validityChk = false;
		validityChk = (document.getElementById("gsize").value == "사이즈선택");
		validityChk = (document.getElementById("gcolor").value == "색상선택");
		
		return !validityChk;
	}
</script>

<FORM name="goodRetrieveForm" method="GET" action="#">
	<input type="hidden" name="gImage" value="${productDTO.gimage}">
	<input type="hidden" name="gCode" value="${goodsRetrieve.gcode}">
	<input type="hidden" name="gName" value="${goodsRetrieve.gname}">
	<input type="hidden" name="gPrice" value="${goodsRetrieve.gprice}">

	<table width="100%" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
		</tr>
		<tr>
			<td>
				<table align="center" width="710" cellspacing="0" cellpadding="0"
					border="0" style='margin-left: 30px'>
					<tr>
						<td class="td_default"><font size="5"><b>- 상품 정보 -</b></font>
							&nbsp;</td>
					</tr>
					<tr>
						<td height="5"></td>
					</tr>
					<tr>
						<td height="1" colspan="8" bgcolor="CECECE"></td>
					</tr>
					<tr>
						<td height="10"></td>
					</tr>

					<tr>
						<td rowspan="7"><img
							src="/teamSquirrel/GOLFCC/${Golfcc.loc_id}/${Golfcc.cc_img}" border="0"
							align="center" width="300" /></td>
						<td class="td_title">제품코드</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'>${productDTO.p_id}
						</td>
					</tr>
					<tr>
						<td class="td_title">골프장 명</td>
						<td class="td_default" colspan="2" style='padding-left: 30px'>${Golfcc.cc_name}</td>
					</tr>
					<tr>
						<td class="td_title">가격</td>

						<td class="td_red" colspan="2" style='padding-left: 30px'>
							${productDTO.p_price}</td>
					</tr>
					<tr>
						<td class="td_title">배송비</td>
						<td colspan="2"><font color="#2e56a9" size="2"
							style='padding-left: 30px'><b> 판매자 정보</b> </font> <font size="2">
							<!-- 여기에 유저정보 --></font></td>
					</tr>
					<tr>
						<td class="td_title" rowspan="2">상품옵션</td>
						<td colspan="2" style='padding-left: 30px'>
						<c:if test='${p_bobyn.equals("Y")}'>밥줌 <br></c:if>
						<c:if test='${p_cartyn.equals("Y")}'>카트있음<br> </c:if>
						<c:if test='${p_caddyyn.equals("Y")}'>캐디있음<br> </c:if>
						</td>
					</tr>
					<tr>
						<td colspan="2" style='padding-left: 30px'>
						
						</td>
					</tr>

					<tr>
						<td class="td_title">인원 수</td>
						<td style="padding-left: 30px"><input type="text"
							name="gamount" value="1" id="gamount"
							style="text-align: right; height: 18px"> <img
							src="images/up.PNG" id="up" onclick="amountUpDown('1')"> <img
							src="images/down.PNG" id="down" onclick="amountUpDown('-1')"></td>
					</tr>
				</table>

			</td>
		</tr>
	</table>

	<br>
	<button onclick="reqCheck('order',goodRetrieveForm)">구매</button>
	&nbsp;&nbsp;
	<button onclick="reqCheck('cart',goodRetrieveForm)">장바구니</button>
</FORM>