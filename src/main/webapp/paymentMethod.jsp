<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
    <title>PaymentMethod</title>
    <script src="<c:url value='js/angular.js'/>"></script>
    <script src="<c:url value='js/angular-resource.js'/>"></script>
    <script src="<c:url value='js/app.js' />"></script>
    <script src="<c:url value='js/paymentMethod_service.js' />"></script>
    <script src="<c:url value='js/paymentMethod_controller.js' />"></script>
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
<div class="generic-container" ng-controller="PaymentMethodController as ctrl">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="lead">PaymentMethod Form</span>
        </div>
        <div class="formcontainer">
            <form ng-submit="ctrl.submit()" name="myForm"
                  class="form-horizontal">
                <input type="hidden" ng-model="ctrl.paymentMethod.id" />
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="name">Name</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.paymentMethod.name" name="name"
                                   class="form-control input-sm"
                                   placeholder="Enter the paymentMethod name" required />
                            <div class="has-error" ng-show="myForm.name.$invalid">
                                <span ng-show="myForm.name.$error.required">This is a required field.</span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" value="{{!ctrl.paymentMethod.id ? 'Add' : 'Update'}}"
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
            <span class="lead">List of PaymentMethods</span>
        </div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>

                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="u in ctrl.paymentMethods">
                    <td><span ng-bind="u.id"></span></td>
                    <td><span ng-bind="u.name"></span></td>

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
