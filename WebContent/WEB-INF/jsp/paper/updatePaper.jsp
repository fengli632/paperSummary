<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新论文总结</title>

</head>
<body>

<div class=paper-box>
<span class="title-span">论文总结</span>
	<div class="paper-content">
		<sf:form  method="post" modelAttribute="paperSummary" enctype="multipart/form-data">

		<p class="paper-text">论文题目:</p>
		<sf:textarea class="sf-textarea-sm" path="name"/><sf:errors path="name"/> 
		<br/> 
		
  	 	<p class="paper-text">论文类别:</p>
		<sf:select path="paperCategory" class="select-category" >
			<%-- <sf:option value="智能家居">智能家居</sf:option> --%>
			<option>---请选择---</option>
			<c:forEach items="${Pcategory }" var="pc">
				<sf:option  value="${pc.categoryId }">${pc.categoryName}</sf:option>
			</c:forEach>
			
		</sf:select> 
		
		
		<p class="paper-text">重要性:</p>
		<sf:select path="significance" class="select-category">
			<sf:option value="★">★</sf:option>
			<sf:option value="★★">★★</sf:option>
			<sf:option value="★★★">★★★</sf:option>
			<sf:option value="★★★★">★★★★</sf:option>
			<sf:option value="★★★★★">★★★★★</sf:option>
		</sf:select>
		
		
		<p class="paper-text">发表时间:</p>
		<sf:textarea class="sf-textarea-sm" path="publishTime"/>
		<br/> 
		
		<p class="paper-text">关键字(请用分号分隔):</p>
		<sf:textarea class="sf-textarea-sm" path="keyWords"/>
		<br/> 
		
	 	<p class="paper-text">作者:</p>
		<sf:textarea class="sf-textarea-sm" path="author"/>
		<br/> 
		
		<p class="paper-text">期刊/会议(期刊包括卷号,第几期,页码):</p>
		<sf:textarea class="sf-textarea-sm" path="periodical"/>
		<br/> 
		
		<p class="paper-text">目标:(论文要解决的问题)</p>
		<sf:textarea class="sf-textarea-sm" path="goal"/>
		<br/> 
		
		<p class="paper-text">方法:(何种算法？如何解决的的？)</p>
		<sf:textarea class="sf-textarea-big" path="method"/>
		<br/> 
		
		<p class="paper-text">结果:(***性能提升了多少？)</p>
		<sf:textarea class="sf-textarea-big" path="result"/>
		<br/> 
		
		<p class="paper-text">不足之处:(到底哪些地方存在缺陷)</p>
		<sf:textarea class="sf-textarea-big" path="shortcomings"/>
		<br/> 
		
		<p class="paper-text">展望:(还未完成的事情有哪些？)</p>
		<sf:textarea class="sf-textarea-big" path="outlook"/>
		<br/> 
		
		<%-- <p class="paper-text">重要性:</p>
		<sf:textarea class="sf-textarea-big" path="significance"/>
		<br/>  --%>
		
		<p class="paper-text">思考:(自己对于这篇论文的看法)</p>
		<sf:textarea class="sf-textarea-big" path="thought"/>
		<br/>  
		
 		<p class="paper-text">上传论文:</p>
 		<div class="search-input">		
				<div class="upload">
					<input class="search-input-content" type="file" name="attach"  >
				</div>		
		</div>
		<br><br><br><br>
		
			<input  class="bt-submit-input" type="submit" value="提交" >
		 <br>

		</sf:form>
	</div>

	</div>

</body>
</html>