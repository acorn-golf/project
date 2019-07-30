<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>게시판</title>
</head>
<body>

	<iframe name='action' width="0" height="0" frameborder="0"
		scrolling='yes'></iframe>



	<form action="/teamSquirrel/NoticeUIService">
		<table>
			<tr>
				<td>
					<table>
						<tr>
							<td><h1>공지사항</h1></td>

						</tr>
					</table> <select name="division" id="division">

						<option value="공지" selected>공지</option>

						<option value="중요">중요</option>

						<option value="이벤트">이벤트</option>

				</select>

					<table>
						<tr>
							<td>등급:${login.rating}
								 아이디:${login.nickname}
							</td>
							<td>
						</tr>
						<tr>

							<td>제목<input id="note_title"name="note_title" size="50" maxlength="100"></td>
						</tr>
						<tr>

							<td><textarea id="note_content" name="note_content" cols="50" rows="13"></textarea></td>
							
						</tr>
					</table>

					<table>
						<tr>

							<td><button>목록</button></td>

							<td><input type="submit" value="저장"></td>

						</tr>

					</table>
					

				</td>
			</tr>
		</table>
		</form>
</body>
</html>