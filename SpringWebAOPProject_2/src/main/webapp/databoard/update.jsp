<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 960px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let fileIndex=0;
$(function(){
	$('#addBtn').click(function(){
		$('#user-table > tbody').append(
			'<tr id="m'+(fileIndex)+'">'
			+'<td width=20%>파일 '+(fileIndex+1)+'</td>'
			+'<td width=80%><input type=file name=files['+(fileIndex)+']</td>'
			+'</tr>'
		)
		fileIndex=fileIndex+1; //하나누를때마다 플러스
	})
	$('#removeBtn').click(function(){
		if(fileIndex>0)
		{
			$('#m'+(fileIndex-1)).remove(); //하나씩 빼기
			fileIndex=fileIndex-1
		}
	})
})
</script>
</head>
<body>
  <div class="container">
    <div class="row">
      <h3 class="text-center">수정하기</h3>
      <form method="post" action="update_ok.do"
        enctype="multipart/form-data"  
      > <!--  멀티파트폴 데이터가 잇어야 업로드가능 -->
      <table class="table">
        <tr>
          <th width=15% class="text-right">이름</th>
          <td width=85%>
            <input type=text name=name size=15 class="input-sm" required value="${vo.name }">
            <input type="hidden" name=no value="${vo.no }">
          </td>
        </tr>
        <tr>
          <th width=15% class="text-right">제목</th>
          <td width=85%>
            <input type=text name=subject size=50 class="input-sm" required value="${vo.subject }">
          </td>
        </tr>
        <tr>
          <th width=15% class="text-right">내용</th>
          <td width=85%>
            <textarea rows="5" cols="52" name=content required>${vo.content }</textarea>
          </td>
        </tr>
        <tr>
         <th width=15% class="text-right">첨부파일</th>
         <td width=85%>
          <table class="table">
           <tr>
            <td class="text-right">
             <input type=button value="추가"
               class="btn-xs btn-success" id="addBtn">
             <input type=button value="취소"
               class="btn-xs btn-info" id="removeBtn">
            </td>
           </tr>
          </table>
          <table class="table" id="user-table">
           <tbody>
            
           </tbody>
          </table>
         </td>
        </tr>
        <tr>
          <th width=15% class="text-right">비밀번호</th>
          <td width=85%>
            <input type=password name=pwd size=10 class="input-sm" required>
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
            <input type="submit" value="수정" class="btn-sm btn-success">
            <input type="button" value="취소" class="btn-sm btn-warning"
            onclick="javascript:history.back()">
          </td>
        </tr>
      </table>
      </form>
    </div>
   </div>
</body>
</html>