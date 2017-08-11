<!--
Created by IntelliJ IDEA.
User: Liang Xing
Date: 17-8-9
Time: 下午7:27
To change this template use File | Settings | File Templates.
-->
'use strict';

angular.module('myApp').controller(
    'OrderItemsController',
    [
        '$scope',
        'OrderItemsService',
        function ($scope, OrderItemsService) {
            var self = this;
            self.items = [];
            self.orders = [];
            self.order = '';

            fetchAllOrders();

            $scope.changeOrder = function () {
                self.items = [];
                fetchOrderItems(self.order);
            };

            function fetchAllOrders() {
                OrderItemsService.fetchAllOrders().then(function (d) {
                    self.orders = d;
                }, function (errResponse) {
                    console.error('Error while fetching all orders');
                });
            }

            function fetchOrderItems(id) {
                OrderItemsService.fetchOrderItems(id).then(function (d) {
                    self.items = d;
                }, function (errResponse) {
                    console.error('Error while fetching items of order');
                });
            }

        }]);
