<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<nav>
    <ul class="pagination">
        <li <c:if test="${pageInfo.isFirstPage }">class="disabled"</c:if>>
            <a href="${ctx }/list?name=${param.name}&pageNo=1&pageSize=10"">首页</a>
        </li>

        <li <c:if test="${pageInfo.isFirstPage }">class="disabled"</c:if>>
            <a href="${ctx }/list?name=${param.name}&pageNo=${pageInfo.pageNum-1}&pageSize=10">上一页</a>
        </li>

        <c:forEach var="page" begin="1" end="${pageInfo.pages }">
            <li <c:if test="${page==param.pageNo or (pageInfo.isFirstPage and page == 1) }">class="active"</c:if>><a
                    href="${ctx }/list?name=${param.name}&pageNo=${page}&pageSize=10">${page }</a></li>
        </c:forEach>

        <li <c:if test="${pageInfo.isLastPage }">class="disabled"</c:if>>
            <a href="${ctx }/list?name=${param.name}&pageNo=${pageInfo.pageNum+1}&pageSize=10">下一页</a>
        </li>

        <li <c:if test="${pageInfo.isLastPage }">class="disabled"</c:if>>
            <a href="${ctx }/list?name=${param.name}&pageNo=${pageInfo.pages}&pageSize=10"">末页</a>
        </li>
    </ul>
</nav>