<%--
  Created by IntelliJ IDEA.
  User: Liang Xing
  Date: 17-8-9
  Time: 下午7:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <title>Orders</title>
    <script src="<c:url value='js/angular.js'/>"></script>
    <script src="<c:url value='js/angular-resource.js'/>"></script>
    <script src="<c:url value='js/app.js' />"></script>
    <script src="<c:url value='js/orderItems_service.js' />"></script>
    <script src="<c:url value='js/orderItems_controller.js' />"></script>
    <style>
        input.ng-valid {
            background-color: lightgreen;
        }

        input.ng-invalid {
            background-color: pink;
        }
    </style>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/app.css">
</head>
<body ng-app="myApp" class="ng-cloak">
<div class="generic-container" ng-controller="OrderItemsController as ctrl" style="margin-left: 10%">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">
            <label class="lead" for="order" >Please choose an order:</label>
            <select ng-model="ctrl.order" ng-change="changeOrder()"
                    id="order" class="form-control" style="width: 20%;">
                <option ng-repeat="u in ctrl.orders" value="{{u.id}}">{{u.id}}</option>
                <!--<option value="1">1</option>-->
            </select>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">
            <span class="lead">Items of orders</span>
        </div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Item ID</th>
                    <th>Order ID</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Product Count</th>
                    <th>Product Price</th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="u in ctrl.items">
                    <td><span ng-bind="u.id"></span></td>
                    <td><span ng-bind="u.orderId"></span></td>
                    <td><span ng-bind="u.productId"></span></td>
                    <td><span ng-bind="u.productName"></span></td>
                    <td><span ng-bind="u.productCount"></span></td>
                    <td><span ng-bind="u.productPrice"></span></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>
