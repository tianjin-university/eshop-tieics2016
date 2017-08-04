'use strict';

angular.module('myApp').controller(
    'CustomerOrderController',
    [
        '$scope',
        'CustomerOrderService',
        function ($scope, CustomerOrderService) {
            var self = this;
            self.orders = [];
            self.customers = [];
            self.customer = '';

            fetchAllCustomers();

            $scope.changeCustomer = function () {
                self.orders = [];
                fetchCustomerOrders(self.customer);
            };

            function fetchAllCustomers() {
                CustomerOrderService.fetchAllCustomers().then(function (d) {
                    self.customers = d;
                }, function (errResponse) {
                    console.error('Error while fetching all customers');
                });
            }

            function fetchCustomerOrders(username) {
                CustomerOrderService.fetchCustomerOrders(username).then(function (d) {
                    self.orders = d;
                }, function (errResponse) {
                    console.error('Error while fetching orders of customer');
                });
            }

        }]);
