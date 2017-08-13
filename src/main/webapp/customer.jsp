<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Customers</title>

    <script src="<c:url value='js/angular.js'/>"></script>
    <script src="<c:url value='js/angular-resource.js'/>"></script>
    <script src="<c:url value='js/app.js' />"></script>
    <script src="<c:url value='js/customer_service.js' />"></script>
    <script src="<c:url value='js/customer_controller.js' />"></script>
    <style>
        input.ng-valid {
            background-color: lightblue;
        }
        input.ng-invalid{
            background-color: red;
        }

    </style>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/app.css"></link>
</head>
<body ng-app="myApp" class="ng-cloak">
<div class="container" ng-controller="CustomerController as ctrl">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Customer Registration Form </span></div>
        <div class="formcontainer">
            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="uname">UserName</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.user.username" id="username" class="username form-control input-sm" placeholder="Enter your username" required ng-minlength="3"/>
                            <div class="has-error" ng-show="myForm.$dirty">
                                <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="password">Password</label>
                        <div class="col-md-7">
                            <input type="password" ng-model="ctrl.user.password" id="password" class="form-control input-sm" placeholder="Enter your password" required ng-minlength="4"/>
                            <div class="has-error" ng-show="myForm.$dirty">
                                <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                <span ng-show="myForm.uname.$error.minlength">Minimum length required is 4</span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="real_name">Real Name</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.user.real_name" id="real_name" class="realname form-control input-sm" placeholder="Enter your real name" required/>
                            <div class="has-error" ng-show="myForm.$dirty">
                                <span ng-show="myForm.email.$error.required">This is a required field</span>
                                <span ng-show="myForm.email.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="gender">Gender</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.user.gender" id="gender" class="gender form-control input-sm" placeholder="Enter your F or M" required/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="birthday">Birthday</label>
                        <div class="col-md-7">
                            <input type="date" ng-model="ctrl.user.birthday" id="birthday" class="birthday form-control input-sm"  required/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="question">Question</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.user.question" id="question" class="question form-control input-sm" placeholder="Enter your question"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="answer">Answer</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.user.answer" id="answer" class="answer form-control input-sm" placeholder="Enter your answer"/>
                        </div>
                    </div>
                </div>
                <input type="hidden" ng-model="ctrl.user.rank_id" value="1" />
                <input type="hidden" ng-model="ctrl.user.score" value="0" />

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="mobile">Mobile</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.user.mobile" id="mobile" class="mobile form-control input-sm" placeholder="Enter your mobile number"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="email">Email</label>
                        <div class="col-md-7">
                            <input type="email" ng-model="ctrl.user.email" id="email" class="email form-control input-sm" placeholder="Enter your email"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="province">Province</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.user.province" id="province" class="province form-control input-sm" placeholder="Enter your province"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="city">City</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.user.city" id="city" class="city form-control input-sm" placeholder="Enter your city"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="country">Country</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.user.country" id="country" class="country form-control input-sm" placeholder="Enter your country"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="address">Address</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.user.address" id="address" class="address form-control input-sm" placeholder="Enter your address"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="zipcode">Zipcode</label>
                        <div class="col-md-7">
                            <input type="number" ng-model="ctrl.user.zipcode" id="zipcode" class="zipcode form-control input-sm" placeholder="Enter your zipcode" ng-length="6"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit"  value="Add/Update" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Customers </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Real Name</th>
                    <th>Gender</th>
                    <th>Birthday</th>
                    <th>Question</th>
                    <th>Answer</th>
                    <th>Rank ID</th>
                    <th>Score</th>
                    <th>Mobile</th>
                    <th>Email</th>
                    <th>Province</th>
                    <th>City</th>
                    <th>Country</th>
                    <th>Address</th>
                    <th>Zipcode</th>

                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="u in ctrl.users">
                    <td><span ng-bind="u.username"></span></td>
                    <td style="word-break:break-all"><span ng-bind="u.password"></span></td>
                    <td><span ng-bind="u.read_name"></span></td>
                    <td><span ng-bind="u.gender"></span></td>
                    <td><span ng-bind="u.birthday"></span></td>
                    <td style="word-break:break-all"><span ng-bind="u.question"></span></td>
                    <td><span ng-bind="u.answer"></span></td>
                    <td><span ng-bind="u.rank_id"></span></td>
                    <td><span ng-bind="u.score"></span></td>
                    <td><span ng-bind="u.mobile"></span></td>
                    <td style="word-break:break-all"><span ng-bind="u.email"></span></td>
                    <td><span ng-bind="u.province"></span></td>
                    <td><span ng-bind="u.city"></span></td>
                    <td><span ng-bind="u.country"></span></td>
                    <td style="word-break:break-all"><span ng-bind="u.address"></span></td>
                    <td><span ng-bind="u.zipcode"></span></td>
                    <td>
                        <button type="button" ng-click="ctrl.edit(u.username)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.username)" class="btn btn-danger custom-width">Remove</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>