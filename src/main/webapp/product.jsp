<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<title>Product</title>
	<script src="<c:url value='js/angular.js'/>"></script>
	<script src="<c:url value='js/angular-resource.js'/>"></script>
	<script src="<c:url value='js/app.js' />"></script>
	<script src="<c:url value='js/product_service.js' />"></script>
	<script src="<c:url value='js/product_controller.js' />"></script>
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
	<div class="generic-container" ng-controller="ProductController as ctrl">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Product Form</span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.product.id" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="categoryId">categoryId	</label>
							<div class="col-md-7">
								<input type="number" ng-model="ctrl.product.categoryId	" name="categoryId	"
									class="form-control input-sm"
									placeholder="Enter the category id	" required />
								<div class="has-error" ng-show="myForm.categoryId.$invalid">
									<span ng-show="myForm.categoryId.$error.required">This is a required field.</span>
									
								</div>									
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="image">image</label>
							<div class="col-md-7">
								<input type="number" ng-model="ctrl.product.image" name="image"
									class="form-control input-sm"
									placeholder="Enter the image" />
								
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="name">name</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.product.name" name="name"
									class="form-control input-sm"
									placeholder="Enter the name" required/>
								<div class="has-error" ng-show="myForm.name.$invalid">
									<span ng-show="myForm.name.$error.required">This is a required field</span>
									
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="marketPrice">marcket Price</label>
							<div class="col-md-7">
								<input type="number" ng-model="ctrl.product.marketPrice" name="image"
									class="form-control input-sm"
									placeholder="Enter the market price" required min="0" max="10000000000000000000" step="0.01"/>
								<div class="has-error" ng-show="myForm.marketPrice.$invalid">
									<span ng-show="myForm.marketPrice.$error.required">This is a required field</span>
									<span ng-show="myForm.marketPrice.$error.min">This field should not be less than 0.</span>
									<span ng-show="myForm.marketPrice.$error.max">This field should not be greater than 10000000000000000000.</span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="isOnSale">is on sale</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.product.isOnSale" name="isOnSale"
									class="form-control input-sm"
									placeholder="Enter true or false" required ng-pattern="/(true)|(false)/" />
								<div class="has-error" ng-show="myForm.isOnSale.$invalid">
									<span ng-show="myForm.isOnSale.$error.required">This is a required field</span>
									
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="discount">discount</label>
							<div class="col-md-7">
								<input type="number" ng-model="ctrl.product.discount" name="discount"
									class="form-control input-sm"
									placeholder="Enter the discount" required min="0" max="1" step="0.01"/>
								    <span ng-show="myForm.discount.$error.min">This field should not be less than 0.</span>
									<span ng-show="myForm.discount.$error.max">This field should not be greater than 1.</span>
							</div>
		
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="pubDate">pub ate</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.product.pubDate" name="pubDate"
									class="form-control input-sm"
									placeholder="Enter the pubDate" required ng-pattern="/^\d{4}(\-|\/|\.)\d{1,2}\1\d{1,2}$/" />
								<div class="has-error" ng-show="myForm.pubDate.$invalid">
									<span ng-show="myForm.pubDate.$error.pattern">This field needs a date like yyyy-MM-dd.</span>
									<span ng-show="myForm.pubDate.$error.required">This is a required field</span>
									</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="stockCount">stock count</label>
							<div class="col-md-7">
								<input type="number" ng-model="ctrl.product.stockCount" name="stockCount"
									class="form-control input-sm"
									placeholder="Enter the stock count" required/>
								<div class="has-error" ng-show="myForm.stockCount.$invalid">
									<span ng-show="myForm.stockCount.$error.required">This is a required field</span>
									</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="saleCount">sale count</label>
							<div class="col-md-7">
								<input type="number" ng-model="ctrl.product.saleCount" name="saleCount"
									class="form-control input-sm"
									placeholder="Enter the saleCount" required
									/>
								<div class="has-error" ng-show="myForm.saleCount.$invalid">
									<span ng-show="myForm.saleCount.$error.required">This is a required field</span>
									</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="summary">summary</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.product.summary" name="summary"
									class="form-control input-sm"
									placeholder="Enter the summary" required/>
								<div class="has-error" ng-show="myForm.summary.$invalid">
									<span ng-show="myForm.summary.$error.required">This is a required field</span>
									
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="detail">detail</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.product.detail" name="detail"
									class="form-control input-sm"
									placeholder="Enter the detail" />
								
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="{{!ctrl.product.id ? 'Add' : 'Update'}}"
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
				<span class="lead">List of Products</span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>category id</th>
							<th>image</th>
							<th>name</th>
							<th>market price</th>
							<th>is on sale</th>
							<th>discount</th>
							<th>pub date</th>
							<th>stock count</th>
							<th>sale count</th>
							<th>summary</th>
							<th>detail</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="u in ctrl.products">
							<td><span ng-bind="u.id"></span></td>
							<td><span ng-bind="u.categoryId"></span></td>
							<td><span ng-bind="u.image"></span></td>
							<td><span ng-bind="u.name"></span></td>
							<td><span ng-bind="u.marketPrice"></span></td>
							<td><span ng-bind="u.isOnSale"></span></td>
							<td><span ng-bind="u.discount"></span></td>
							<td><span ng-bind="u.pubDate"></span></td>
							<td><span ng-bind="u.stockCount"></span></td>
							<td><span ng-bind="u.saleCount"></span></td>
							<td><span ng-bind="u.summary"></span></td>
							<td><span ng-bind="u.detail"></span></td>
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
