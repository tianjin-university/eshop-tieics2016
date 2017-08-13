<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User_Roles</title>
    <script src="<c:url value='js/angular.js'/>"></script>
	<script src="<c:url value='js/angular-resource.js'/>"></script>
	<script src="<c:url value='js/app.js' />"></script>
	<script src="<c:url value='js/userroles_service.js' />"></script>
	<script src="<c:url value='js/userroles_controller.js' />"></script>
	<style>
		input.ng-valid {
			background-color: lightgreen;
		}
		input.ng-invalid {
			background-color: pink;
		}
	</style>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/app.css"></link>
</head>
<body ng-app="myApp" class="ng-cloak">
	<div class="generic-container" ng-controller="UserRolesController as ctrl">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">User_Roles Form</span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.userrole.id" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="username">UserName</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.userrole.username" name="username"
									class="form-control input-sm"
									placeholder="Enter the user_name" required />
								<div class="has-error" ng-show="myForm.username.$invalid">
									<span ng-show="myForm.name.$error.required">This is a required field.</span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="rolename">RoleName</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.userrole.rolename" name="rolename"
									class="form-control input-sm"
									placeholder="Enter the role_name" required />
								<div class="has-error" ng-show="myForm.rolename.$invalid">
									<span ng-show="myForm.score.$error.required">This is a required field.</span>
								</div>									
							</div>
						</div>
					</div>
				
					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="{{!ctrl.userrole.id ? 'Add' : 'Update'}}"
								class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
							<button type="button" ng-click="ctrl.reset()"
								class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of User_Roles</span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>UserName</th>
							<th>RoleName</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="u in ctrl.userroles">
							<td><span ng-bind="u.id"></span></td>
							<td><span ng-bind="u.username"></span></td>
							<td><span ng-bind="u.rolename"></span></td>
							<td>
								<button type="button" ng-click="ctrl.edit(u.id)"
									class="btn btn-success custom-width">Edit</button>
								<button type="button" ng-click="ctrl.remove(u.id)"
									class="btn btn-danger custom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>