<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/header.jsp"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-10">
			<form role="form" class="form-horizontal" action="${ctx }/${action }" method="post">
				<input name="id" value="${user.id }" type="hidden" />
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">姓名：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名..." value="${user.name}">
					</div>
				</div>
				<div class="form-group">
					<label for="age" class="col-sm-2 control-label">年龄：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄..." value="${user.age }">
					</div>
				</div>
				<div class="form-group">
					<label for="address" class="col-sm-2 control-label">地址：</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="address" name="address" placeholder="请输入地址..." value=${user.address }>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input class="btn btn-primary" type="submit" id="subBtn" value="保存">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/footer.jsp"%>