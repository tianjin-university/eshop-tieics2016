<%--
  Created by Eclipse.
  User: Li Ting
  Date: 17-8-11
  Time: 下午3:45
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <title>Products</title>
    <script src="<c:url value='js/angular.js'/>"></script>
    <script src="<c:url value='js/angular-resource.js'/>"></script>
    <script src="<c:url value='js/app.js' />"></script>
    <script src="<c:url value='js/productByCategory_service.js' />"></script>
    <script src="<c:url value='js/productByCategory_controller.js' />"></script>
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
<div class="generic-container" ng-controller="ProductByCategoryController as ctrl" style="margin-left: 10%">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">
            <label class="lead" for="category" >Please choose a category:</label>
            <select ng-model="ctrl.category" ng-change="changeCategory()"
                    id="category" class="form-control" style="width: 20%;">
                <option ng-repeat="u in ctrl.categorys" value="{{u.name}}">{{u.name}}</option>
            </select>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">
            <span class="lead">Products of categorys</span>
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
