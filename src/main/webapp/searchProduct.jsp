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
    <script src="<c:url value='js/searchProduct_service.js' />"></script>
    <script src="<c:url value='js/searchProduct_controller.js' />"></script>
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
<div class="container" ng-controller="SearchProductController as ctrl">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="lead">Product Form</span>
        </div>
        <div class="formcontainer">
            <form name="myForm" class="form-horizontal">
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="productName">Product Name</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.productName" name="productName"
                                   class="form-control input-sm" />
                            <div class="has-error" ng-show="myForm.productName.$invalid">
                                <span ng-show="myForm.productName.$error.required">This is a required field.</span>
                            </div>
                        </div>
                    </div>

                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="summary">summary</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.summary" name="summary"
                                   class="form-control input-sm" />
                            <div class="has-error" ng-show="myForm.summary.$invalid">
                                <span ng-show="myForm.summary.$error.required">This is a required field.</span>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="detail">Detail</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.detail" name="detail"
                                   class="form-control input-sm" />
                            <div class="has-error" ng-show="myForm.detail.$invalid">
                                <span ng-show="myForm.datail.$error.required">This is a required field.</span>   
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-actions floatRight">
                        <button type="button" ng-click="ctrl.showProducts()"
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
                    <th>id</th>
                    <th>category</th>
                    <!-- <th>categoryDescription</th> -->
                    <th>name</th>
                    <th>image</th>
                    <th>pubDate</th>                   
                    <th>marketPrice</th>
                    <th>isOnSale</th>
                    <th>discount</th>
                    <th>stockCount</th>
                    <th>saleCount</th>
                    <th>summary</th>
                    <th>detail</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="u in ctrl.products">
                    <td><span ng-bind="u.id"></span></td>
                    <td><span ng-bind="u.categoryName"></span></td>
                    <!-- <td><span ng-bind="u.categoryDescription"></span></td> -->  
                    <td><span ng-bind="u.productName"></span></td>
                    <td><span ng-bind="u.image"></span></td>
                    <td><span ng-bind="u.pubDate"></span></td>
                    <td><span ng-bind="u.marketPrice"></span></td>
                    <td><span>{{u.isOnSale ? 'Yes' : 'No'}}</span></td>
                    <td><span ng-bind="u.discount"></span></td>
                    <td><span ng-bind="u.stockCount"></span></td>
                    <td><span ng-bind="u.saleCount"></span></td>
                    <td><span ng-bind="u.summary"></span></td>
                   	<td><span ng-bind="u.detail"></span></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>