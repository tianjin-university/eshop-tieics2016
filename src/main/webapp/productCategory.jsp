<%--
  Created by IntelliJ IDEA.
  User: zj
  Date: 17-8-9
  Time: 下午4:53
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
    <title>Products</title>
    <script src="<c:url value='js/angular.js'/>"></script>
    <script src="<c:url value='js/angular-resource.js'/>"></script>
    <script src="<c:url value='js/app.js' />"></script>
    <script src="<c:url value='js/productCategory_service.js' />"></script>
    <script src="<c:url value='js/productCategory_controller.js' />"></script>
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
<div class="container" ng-controller="ProductCategoryController as ctrl">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="lead">Product Form</span>
        </div>
        <div class="formcontainer">
            <form name="myForm" class="form-horizontal">
                <!--<input type="hidden" ng-model="ctrl.market_price" />-->
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="min_market_price">Min Market Price</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.min_market_price" name="min_market_price"
                                   class="form-control input-sm"
                                   placeholder="Enter the min market price" required step="0.01" />
                            <div class="has-error" ng-show="myForm.min_market_price.$invalid">
                                <span ng-show="myForm.max_market_price.$error.required">This is a required field.</span>
                            </div>
                        </div>
                    </div>

                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="max_market_price">Max Market Price</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.max_market_price" name="max_market_price"
                                   class="form-control input-sm"
                                   placeholder="Enter the max market price" required step="0.01" />
                            <div class="has-error" ng-show="myForm.max_market_price.$invalid">
                                <span ng-show="myForm.max_market_price.$error.required">This is a required field.</span>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="year">Year</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.year" name="year"
                                   class="form-control input-sm"
                                   placeholder="Enter the Year" required ng-pattern="/^\d{4}*$/" />
                            <div class="has-error" ng-show="myForm.year.$invalid">
                                <span ng-show="myForm.year.$error.required">This is a required field.</span>
                                <span ng-show="myForm.year.$error.pattern">This field needs a non-negative integer.</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="month">Month</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.month" name="month"
                                   class="form-control input-sm"
                                   placeholder="Enter the Month" required ng-pattern="/^\d{2}*$/" />
                            <div class="has-error" ng-show="myForm.month.$invalid">
                                <span ng-show="myForm.month.$error.required">This is a required field.</span>
                                <span ng-show="myForm.month.$error.pattern">This field needs a non-negative integer.</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="day">Day</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.day" name="Day"
                                   class="form-control input-sm"
                                   placeholder="Enter the Day" required ng-pattern="/^\d{2}*$/" />
                            <div class="has-error" ng-show="myForm.day.$invalid">
                                <span ng-show="myForm.day.$error.required">This is a required field.</span>
                                <span ng-show="myForm.day.$error.pattern">This field needs a non-negative integer.</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-actions floatRight">
                        <!--<input type="submit" value="{{!ctrl.rank.id ? 'Add' : 'Update'}}"
                               class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">-->
                        <button type="button" ng-click="ctrl.changeProducts()"
                                class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Query</button>
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
                    <th>productId</th>
                    <th>productName</th>
                    <th>pubDate</th>
                    <th>categoryName</th>
                   <!-- <th>categoryDescription</th>
                    <th>image</th>-->

                    <th>marketPrice</th>
                    <th>isOnSale</th>
                    <th>discount</th>

                    <th>stockCount</th>
                    <th>saleCount</th>
                    <th>summary</th>
                    <!--<th>detail</th>-->
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="u in ctrl.products">
                    <td><span ng-bind="u.productId"></span></td>
                    <td><span ng-bind="u.productName"></span></td>
                    <td><span ng-bind="u.pubDate"></span></td>
                    <td><span ng-bind="u.categoryName"></span></td>
                    <!--<td><span ng-bind="u.categoryDescription"></span></td>
                    <td><span ng-bind="u.image"></span></td>-->

                    <td><span ng-bind="u.marketPrice"></span></td>
                    <td><span>{{u.isOnSale ? 'Yes' : 'No'}}</span></td>
                    <td><span ng-bind="u.discount"></span></td>

                    <td><span ng-bind="u.stockCount"></span></td>
                    <td><span ng-bind="u.saleCount"></span></td>
                    <td><span ng-bind="u.summary"></span></td>
                   <!-- <td><span ng-bind="u.detail"></span></td>-->
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>






