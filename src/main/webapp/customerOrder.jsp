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
    <script src="<c:url value='js/customerOrder_service.js' />"></script>
    <script src="<c:url value='js/customerOrder_controller.js' />"></script>
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
<div class="generic-container" ng-controller="CustomerOrderController as ctrl" style="margin-left: 10%">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">
            <label class="lead" for="customer" >Please choose a customer:</label>
            <select ng-model="ctrl.customer" ng-change="changeCustomer()"s
                    id="customer" class="form-control" style="width: 20%;">
                <option ng-repeat="u in ctrl.customers" value="{{u.username}}">{{u.username}}</option>
            </select>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">
            <span class="lead">Orders of customers</span>
        </div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Order Status</th>
                    <th>Total Price</th>
                    <th>Payment Method</th>
                    <th>Send Method</th>
                    <th>Place Time</th>
                    <th>Send Time</th>
                    <th>Invoice Item</th>
                    <th>Invoice Title</th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="u in ctrl.orders">
                    <td><span ng-bind="u.orderId"></span></td>
                    <td><span ng-bind="u.orderStatus"></span></td>
                    <td><span ng-bind="u.price"></span></td>
                    <td><span ng-bind="u.paymentMethod"></span></td>
                    <td><span ng-bind="u.sendMethod"></span></td>
                    <td><span ng-bind="u.placeTime"></span></td>
                    <td><span ng-bind="u.sendTime"></span></td>
                    <td><span ng-bind="u.invoiceItem"></span></td>
                    <td><span ng-bind="u.invoiceTitle"></span></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>
