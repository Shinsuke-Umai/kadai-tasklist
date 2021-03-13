<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<label>タスク<br />
<input type="text" name="content" value="${task.content}" /> <%--NewServletのおまじない --%>
</label>
<br /><br />
<input type="hidden" name="_token" value="${_token}" /> <%--CSRF対策 --%>
<button type="submit">入力</button>

