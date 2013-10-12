<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>TODOタスクの詳細画面</title>
<script type="text/javascript">
	window.onload = function() {
		var status = document.getElementById("status");
		status.selectedIndex = $
		{
			vo.status
		}
		;
	};
</script>
</head>
<body>
	<form id="sender" action="register" method="post">
		<table border="1">
			<tr>
				<th>番号</th>
				<td width="60"><c:choose>
						<c:when test="${vo.id > 0 }">
							<c:out value="${vo.id}" />
						</c:when>
						<c:otherwise>
					(新規)
				</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<th>タイトル</th>
				<td><input type="text" name="title"
					value="<c:out value="${vo.title}" />" size="20" /></td>
			</tr>
			<tr>
				<th>タスク内容</th>
				<td><input type="text" name="task"
					value="<c:out value="${vo.task}" />" maxlength="128" size="60" /></td>
			</tr>
			<tr>
				<th>期限</th>
				<td><input type="text" name="limitdate"
					value="<fmt:formatDate value="${vo.limitdate}" pattern="yyyy-MM-dd" />"
					size=10 /></td>
			</tr>
			<tr>
				<th>ユーザID</th>
				<td><input type="text" name="userid"
					value="<c:out value="${vo.userid}" />" size="10" /></td>
			</tr>
			<tr>
				<th>状況</th>
				<td><select name="status" id="status">
						<option value="0">未着手</option>
						<option value="1">着手</option>
						<option value="2">完了</option>
						<option value="3">凍結</option>
				</select></td>
			</tr>
			<c:if test="${vo.id != 0}">
				<tr>
					<th>添付ファイル</th>
					<td><a href="preUpload?id=<c:out value="${vo.id}"/>">アップロード</a>
						<c:choose>
							<c:when test="${vo.fileName != null }">
								<c:out value="${vo.fileName}" />
							</c:when>
							<c:otherwise>
				添付ファイルはありません。
			</c:otherwise>
						</c:choose></td>
				</tr>
			</c:if>
		</table>
		<input type="hidden" name="id" value="<c:out value="${vo.id}" />" />
		<c:choose>
			<c:when test="${vo.id > 0 }">
				<input type="submit" value="更新する" />
			</c:when>
			<c:otherwise>
				<input type="submit" value="登録する" />
			</c:otherwise>
		</c:choose>
	</form>

	<c:if test="${vo.id > 0 }">
		<form id="delete" action="delete" method="post">
			<input type="hidden" name="id" value="<c:out value="${vo.id}" />" />
			<input type="submit" value="削除する" />
		</form>
	</c:if>
	<br /> ●
	<a href="search">タスク一覧に戻る</a>
</body>
</html>