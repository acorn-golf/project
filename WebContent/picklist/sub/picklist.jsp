<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript" src="/teamSquirrel/jquery-3.4.1.js"></script> 
<script>
	$(document).ready(function(){
		// 전체선택
		$("#chkall").on("click",function(){
			$(".check").each(function(idx,ele){
				$(ele).prop("checked",$("#chkall").prop("checked"));
			});
		});
		
		// 하나라도 체크 풀면 전체선택 체크풀림
		$(".check").on("click",function(){
			if($(".check:checked").length == ${pickList.size()}){
				$("#chkall").prop("checked",true);
			}else{
				$("#chkall").prop("checked",false);
			}
		});
		
		$("#delete").on("click",function(event){
			if($(".check:checked").length == 0){
				event.preventDefault();
				alert('하나 이상 체크해라');
			}else{
				$("form").attr({"action":"DeletePickServlet","method":"post"});
			}
		});
		
	});
</script>
<h3>찜 목록 상품</h3>
<form action="OrderServlet" method="post">
<table border="1">
	<tr>
		<td><input type="checkbox" id="chkall"><font size="2">전체선택</font></td>
		<th colspan="2">골프장</th>
		<th>티업시간</th>
		<th>그린피</th>
		<th>구매</th>
	</tr>
	
	<c:forEach var="pList" items="${pickList}">
	<tr>
		<td><input type="checkbox" name="check" class="check" value="${pList.pick_no}" id="check${pList.pick_no}"></td>
		<td width="120"><img src="GOLFCC/${pList.loc_id}/${pList.cc_img}" border="0" align="middle" width="120" height="80" />
		</td>
		<td> 
		<table>
			<tr>
				<td><a href="#"><b>${pList.cc_name}</b></a></td>
				<td>${pList.p_maxpeople}명  ${pList.p_hole}홀&nbsp;&nbsp;<span style="color:blue">예약인원 : ${pList.pick_amount} 명<input type="hidden" name="g_amount" value="${pList.pick_amount}"></span></td>
			</tr>
			<tr>
				<td><font size="2" color="#4374D9">${pList.p_uploaddate}</font></td>
				<td><font size="2" color="#665b5f">캐디유무 : ${pList.p_caddyyn} 식사유무 : ${pList.p_babyn} 카트유무 : ${pList.p_cartyn}</font></td>
			</tr>
		</table>
		</td>
		<td><b>${pList.p_pdate}</b><br>${pList.nickname} ☎${pList.phone_id}</td>
		<td align="center">${pList.p_price} 만원<br>
		<c:if test="${pList.emergency eq '긴급'}">
		<b style="color:red">[${pList.emergency}]</b></c:if></td>
		<td><input type="submit" value="구매하기"><input type="hidden" name="p_id" value="${pList.p_id}"></td>
	</tr>
	</c:forEach>
	
	<tr>
		<td colspan="6" align="center">
			<c:set var="curPage" value="${curPage+1}"/> <%-- 1 --%>
			<c:set var="maxBlock" value="${maxBlock}"/> 
			<c:set var="minBlock" value="${minBlock+1}"/> 
			
			<c:if test="${curPage != 1}">
				<a href="PickListViewServlet?curPage=1">◀◀</a>&nbsp;&nbsp;
				<c:if test="${curPage>showBlock}"><a href="PickListViewServlet?curPage=${minBlock-1}">◁</a>&nbsp;&nbsp;</c:if>
			</c:if>
			&nbsp;&nbsp;
			
			<c:forEach var="i" begin="${minBlock}" end="${maxBlock}" step="1">
				<c:choose>
					<c:when test="${curPage eq i}">
						<span style="color:red">${i}</span>
					</c:when>
					<c:when test="${curPage != i}">
						<a href="PickListViewServlet?curPage=${i}">${i}</a>&nbsp;
					</c:when>
				</c:choose>	
			</c:forEach>&nbsp;&nbsp;
			
			<c:if test="${curPage != totalPage}">
				<c:if test="${curPage<=showBlock*perBlock}"><a href="PickListViewServlet?curPage=${maxBlock+1}">▷</a></c:if>
				<a href="PickListViewServlet?curPage=${totalPage}">▶▶</a>
			</c:if>
			
		</td>
	</tr>
</table>
<button id="delete">삭제</button>
</form>
