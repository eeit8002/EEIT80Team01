<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Question page list (supporter part)</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/support/manage/question/listUnansweredQuestionsServlet.jsp">列出尚未回覆的問題(Servlet偽裝，會跳轉到listQuestions.jsp)</a>
<a href="${pageContext.request.contextPath}/support/manage/question/supportQuestionDetail.do?qno=">列出問題的內容(Servlet，會自動跳轉到jsp)</a>
</body>
</html>