<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head >
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>게시판</title>
</head >
<body>

<iframe name='action' width="0" height="0" frameborder="0" scrolling='yes'></iframe>




<table>
 <tr>
  <td>
   <table>
    <tr>
     <td><h1>공지사항</h1></td>
   
    </tr>
   </table>
   <select name="공지">      

                    <option value=1 >공지</option>

                    <option value=2 >중요</option>

                    <option value=3 >이벤트</option>

                   </select>

   <table>
    <tr>
    <td>등급<input name="RATING" size="10" maxlength="10">
    ${session.getAttribute("login").rating}
    
     아이디  <input name="USER_NO" size="10" maxlength="10">
      ${session.getAttribute("login").nickname}
    </td>
    <td>
      </tr>
    <tr>
    
     <td>제목<input name="NOTE_TITLE" size="50" maxlength="100"></td>
    </tr>
    <tr>
    
     <td><textarea name="NOTE_CONTENT" cols="50" rows="13"></textarea></td>
    </tr>
   </table>

   <table>
    <tr>
    <form action="NoticeList.jsp">
     <td><button>목록</button></td>
     </form>
     <form action="NoticeModified.jsp">
     <td><button>수정하기</button></a></td>
     </form>
     <form action="NoteAdd.jsp">
     <td><button>저장</button></td>
     </form>
    </tr>
   
   </table>

  </td>
 </tr>
</table>



</body>
</html>