<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.List"%>
<%@ page import="bitcamp.myapp.vo.Board"%>
<%@ page import="bitcamp.myapp.vo.AttachedFile"%>

<!DOCTYPE html>
<html lang='en'>
<head>
  <meta charset='UTF-8'>
  <title>비트캠프 데브옵스 5기</title>
</head>
<body>

<jsp:include page="/header.jsp"></jsp:include>

<%
  Board board = (Board) request.getAttribute("board");
%>

<%
      String title = "";
      int category = Integer.valueOf(request.getParameter("category"));
      title = category == 1 ? "게시글" : "가입인사";
%>

<h1><%=title%></h1>

<form action='/board/update' method='post' enctype='multipart/form-data'>
  <input name='category' type='hidden' value='<%=category%>'>

<div>
    번호: <input readonly name='no' type='text' value='<%=board.getNo()%>'>
</div>
<div>
    제목: <input name='title' type='text' value='<%=board.getTitle()%>'>
</div>
<div>
    내용: <textarea name='content'><%=board.getContent()%></textarea>
</div>
<div>
    작성자: <input readonly type='text' value='<%=board.getWriter().getName()%>'>
</div>

<div>
  <button>변경</button>
  <a href='/board/delete?category=<%=category%>&no=<%=board.getNo()%>'>[삭제]</a>
</div>
</form>

<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>