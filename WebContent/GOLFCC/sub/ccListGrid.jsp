<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<table width="100%" cellspacing="0" cellpadding="0">

	<tr>
		<td>
			<table align="center" width="710" cellspacing="0" cellpadding="0"
				border="0">

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

					<c:forEach items="${CcGolfScoreList}" var="Golfcc" varStatus="status">
						<td>
							<table style='padding: 15px'>
								<tr>
									<td><a href="GoodsRetrieveServlet?gCode=${Golfcc.cc_id}">
											<c:if test="${Golfcc.cc_img != null}">
												<img
													src="/teamSquirrel/GOLFCC/${Golfcc.loc_id}/${Golfcc.cc_img}.jpg"
													border="0" align="center" width="200">
											</c:if> <c:if test="${empty Golfcc.cc_img}">
												<img
													src="/teamSquirrel/GOLFCC/noimg.jpg"
													border="0" align="center" width="200">
											</c:if>
									</a></td>
								</tr>
								<tr>

									<td height="10">
								</tr>
								<tr>
									<td class="td_default" align="center"><a class="a_black"
										href="">${Golfcc.cc_name}<br>
									</a> <font color="gray"> -------------------- </font></td>

								</tr>
								<tr>
									<td height="10">
								</tr>
								<tr>
									<td class="td_gray" align="center">${Golfcc.score}점</td>
								</tr>
								<tr>
									<td height="10">
								</tr>
								<tr>
									<td class="td_red" align="center"><font color="red"><strong>
												${Golfcc.cc_addr1} </strong></font></td>
								</tr>
							</table>
						</td>
						<c:if test="${status.count %4==0}">
							<tr>
								<td height="10">
							</tr>
						</c:if>

					</c:forEach>
					<!-- 반복끝-->
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td height="10">
	</tr>
</table>