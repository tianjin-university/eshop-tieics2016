<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<title>login</title>
	<script src="<c:url value='js/angular.js'/>"></script>
	<script src="<c:url value='js/angular-resource.js'/>"></script>
	<script src="<c:url value='js/app.js' />"></script>
	<script src="<c:url value='js/login_service.js' />"></script>
	<script src="<c:url value='js/login_controller.js' />"></script>
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
	<div class="generic-container" ng-controller="LoginController as ctrl">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">login Form</span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" username="myForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.login.id" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="username">Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.login.username" username="username"
									class="form-control input-sm"
									placeholder="Enter the login username" required />
								<div class="has-error" ng-show="myForm.username.$invalid">
									<span ng-show="myForm.username.$error.required">This is a required field.</span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="ipAddr">ipAddr</label>
							<div class="col-md-7">
								<input type="String" ng-model="ctrl.login.ipAddr" username="ipAddr"
									class="form-control input-sm"
									placeholder="Enter the ipAddr"  />
								<div class="has-error" ng-show="myForm.ipAddr.$invalid">
									<span ng-show="myForm.ipAddr.$error.required">This is a required field.</span>
									<span ng-show="myForm.ipAddr.$error.pattern">This field needs a non-negative integer.</span>
								</div>									
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="loginTime">loginTime</label>
							<div class="col-md-7">
								<input type="Date" ng-model="ctrl.login.loginTime" username="loginTime"
									class="form-control input-sm"
									placeholder="Enter the loginTime" />
								<div class="has-error" ng-show="myForm.loginTime.$invalid">
									<span ng-show="myForm.loginTime.$error.required">This is a required field</span>
									<span ng-show="myForm.loginTime.$error.min">This field should not be less than 0.</span>
									<span ng-show="myForm.loginTime.$error.max">This field should not be greater than 1.</span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="{{!ctrl.login.id ? 'Add' : 'Update'}}"
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
				<span class="lead">List of logins</span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>ipAddr</th>
							<th>loginTime</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="u in ctrl.logins">
							<td><span ng-bind="u.id"></span></td>
							<td><span ng-bind="u.username"></span></td>
							<td><span ng-bind="u.ipAddr"></span></td>
							<td><span ng-bind="u.loginTime"></span></td>
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
