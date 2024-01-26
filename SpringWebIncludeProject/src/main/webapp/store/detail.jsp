<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body>
  <div class="container">
   <div class="row">
    <table class="table">
     <tr>
       <td width="30%" class="text-center" rowspan="8">
        <img src="${vo.poster }" style="width: 290px;height: 400px">
       </td>
       <td colspan="2">
        <h3>${vo.name }</h3>
       </td>
     </tr>
     <tr>
      <th width="20%" class="text-right">부제목</th>
      <td width="50%">${vo.sub }</td>
     </tr>
     <tr>
      <th width="20%" class="text-right">가격대</th>
      <td width="50%">${vo.price }</td>
     </tr>
     <tr>
       <td colspan="3" class="text-right">
        <a href="javascript:history.back()" class="btn btn-xs btn-primary">목록</a>
       </td>
     </tr>
    </table>
   </div>
   <div style="height: 20px"></div>

  </div>
</body>
</html>