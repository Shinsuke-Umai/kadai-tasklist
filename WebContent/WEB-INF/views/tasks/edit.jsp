<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>id：${task.id} のタスク編集ページ</h2>

        <form method="POST" action="${pageContext.request.contextPath}/update">
            <c:import url="_form.jsp" />
        </form>

        <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p>
        <p><a href="#" onclick="confirmDestroy();">このメッセージを削除する</a></p>
        <form method="POST" action="${pageContext.request.contextPath}/destroy"> <%--削除するサーブレットに遷移させる記載 --%>
            <input type="hidden" name="_token" value="${_token}" />      <%--csrf対策 --%>        <%--formはjavaやphpが必要 --%>
        </form>
        <script>
        function confirmDestroy() {
            if(confirm("本当によろしいいですか？")) {
                document.forms[1].submit();    <%--削除するときの確認用にフォームをつくる--%>
            }
        }
        </script>
    </c:param>
</c:import>