<%--
  Created by IntelliJ IDEA.
  User: niubinghui
  Date: 17-8-9
  Time: 下午7:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
    <title>Order</title>
    <script src="<c:url value='js/angular.js'/>"></script>
    <script src="<c:url value='js/angular-resource.js'/>"></script>
    <script src="<c:url value='js/app.js' />"></script>
    <script src="<c:url value='js/order_service.js' />"></script>
    <script src="<c:url value='js/order_controller.js' />"></script>
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
<div class="generic-container" ng-controller="OrderController as ctrl">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="lead">Order Form</span>
        </div>
        <div class="formcontainer">
            <form ng-submit="ctrl.submit()" name="myForm"
                  class="form-horizontal">
                <input type="hidden" ng-model="ctrl.order.customerId" />
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="customerId">CustomerId</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.order.customerId" name="customerId"
                                   class="form-control input-sm"
                                   placeholder="Enter the order customer id" required />
                            <div class="has-error" ng-show="myForm.customerId.$invalid">
                                <span ng-show="myForm.customerId.$error.required">This field needs a customer name.</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="statusId">StatusId</label>
                        <div class="col-md-7">
                            <input type="number" ng-model="ctrl.order.statusId" name="statusId"
                                   class="form-control input-sm"
                                   placeholder="Enter the order status id" required min="0" max="3" step="1" />
                            <div class="has-error" ng-show="myForm.statusId.$invalid">
                                <span ng-show="myForm.statusId.$error.required">This is a required integer.</span>
                                <span ng-show="myForm.statusId.$error.min">This field should not be less than 0.</span>
                                <span ng-show="myForm.statusId.$error.max">This field should not be greater than 3.</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="price">Price</label>
                        <div class="col-md-7">
                            <input type="number" ng-model="ctrl.order.price" name="price"
                                   class="form-control input-sm"
                                   placeholder="Enter the order price" required min="0" max="100000" step="0.01"/>
                            <div class="has-error" ng-show="myForm.price.$invalid">
                                <span ng-show="myForm.price.$error.required">This is a required field</span>
                                <span ng-show="myForm.price.$error.min">This field should not be less than 0.</span>
                                <span ng-show="myForm.price.$error.max">This field should not be greater than 100000.</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="paymentMethodId">PaymentMethodId</label>
                        <div class="col-md-7">
                            <input type="number" ng-model="ctrl.order.paymentMethodId" name="paymentMethodId"
                                   class="form-control input-sm"
                                   placeholder="Enter the order payment method id" required min="0" max="5" step="1" />
                            <div class="has-error" ng-show="myForm.paymentMethodId.$invalid">
                                <span ng-show="myForm.paymentMethodId.$error.required">This is a required an integer.</span>
                                <span ng-show="myForm.paymentMethodId.$error.min">This field should not be less than 0.</span>
                                <span ng-show="myForm.paymentMethodId.$error.max">This field should not be greater than 5.</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="sendMethodId">SendMethodId</label>
                        <div class="col-md-7">
                            <input type="number" ng-model="ctrl.order.sendMethodId" name="sendMethodId"
                                   class="form-control input-sm"
                                   placeholder="Enter the order send method id" required min="0" max="5" step="1" />
                            <div class="has-error" ng-show="myForm.sendMethodId.$invalid">
                                <span ng-show="myForm.sendMethodId.$error.required">This is a required an integer.</span>
                                <span ng-show="myForm.sendMethodId.$error.min">This field should not be less than 0.</span>
                                <span ng-show="myForm.sendMethodId.$error.max">This field should not be greater than 5.</span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="placeTime">PlaceTime</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.order.placeTime" name="placeTime"
                                   class="form-control input-sm"
                                   placeholder="Enter the order place time" />
                            <div class="has-error" ng-show="myForm.placeTime.$invalid">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="sendTime">SendTime</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.order.sendTime" name="sendTime"
                                   class="form-control input-sm"
                                   placeholder="Enter the order send time" />
                            <div class="has-error" ng-show="myForm.sendTime.$invalid">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="invoiceTitle">InvoiceTitle</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.order.invoiceTitle" name="invoiceTitle"
                                   class="form-control input-sm"
                                   placeholder="Enter the order invoice title" required />
                            <div class="has-error" ng-show="myForm.invoiceTitle.$invalid">
                                <span ng-show="myForm.invoiceTitle.$error.required">This field needs a invoice title.</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="invoiceItem">InvoiceItem</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.order.invoiceItem" name="invoiceItem"
                                   class="form-control input-sm"
                                   placeholder="Enter the order invoice item" required />
                            <div class="has-error" ng-show="myForm.invoiceItem.$invalid">
                                <span ng-show="myForm.invoiceItem.$error.required">This field needs a invoice item.</span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" value="{{!ctrl.order.id ? 'Add' : 'Update'}}"
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
            <span class="lead">List of Orders</span>
        </div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>CustomerId</th>
                    <th>StatusId</th>
                    <th>Price</th>
                    <th>PaymentMethodId</th>
                    <th>SendMethodId</th>
                    <th>PlaceTime</th>
                    <th>SendTime</th>
                    <th>InvoiceTitle</th>
                    <th>InvoiceItem</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="u in ctrl.orders">
                    <td><span ng-bind="u.id"></span></td>
                    <td><span ng-bind="u.customerId"></span></td>
                    <td><span ng-bind="u.statusId"></span></td>
                    <td><span ng-bind="u.price"></span></td>
                    <td><span ng-bind="u.paymentMethodId"></span></td>
                    <td><span ng-bind="u.sendMethodId"></span></td>
                    <td><span ng-bind="u.placeTime"></span></td>
                    <td><span ng-bind="u.sendTime"></span></td>
                    <td><span ng-bind="u.invoiceTitle"></span></td>
                    <td><span ng-bind="u.invoiceItem"></span></td>
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
