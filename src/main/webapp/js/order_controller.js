'use strict';

angular.module('myApp').controller(
    'OrderController',
    [
        '$scope',
        'OrderService',
        function($scope, OrderService) {
            var self = this;
            self.order = {
                id : null,
                customerId : '',
                statusId : '',
                price : '',
                paymentMethodId : '',
                sendMethodId : '',
                placeTime : '',
                sendTime : '',
                invoiceTitle : '',
                invoiceItem : ''
            };
            self.orders = [];

            self.submit = submit;
            self.edit = edit;
            self.remove = remove;
            self.reset = reset;

            fetchAllOrders();

            function fetchAllOrders() {
                OrderService.fetchAllOrders().then(function(d) {
                    self.orders = d;
                }, function(errResponse) {
                    console.error('Error while fetching Orders');
                });
            }

            function createOrder(order) {
                OrderService.createOrder(order).then(fetchAllOrders,
                    function(errResponse) {
                        console.error('Error while creating Order');
                    });
            }

            function updateOrder(order, id) {
                OrderService.updateOrder(order, id).then(fetchAllOrders,
                    function(errResponse) {
                        console.error('Error while updating Order');
                    });
            }

            function deleteOrder(id) {
                OrderService.deleteOrder(id).then(fetchAllOrders,
                    function(errResponse) {
                        console.error('Error while deleting Order');
                    });
            }

            function submit() {
                if (self.order.id === null) {
                    console.log('Saving New Order', self.order);
                    createOrder(self.order);
                } else {
                    updateOrder(self.order, self.order.id);
                    console.log('Order updated with id ', self.order.id);
                }
                reset();
            }

            function edit(id) {
                console.log('id to be edited', id);
                for (var i = 0; i < self.orders.length; i++) {
                    if (self.orders[i].id === id) {
                        self.order = angular.copy(self.orders[i]);
                        break;
                    }
                }
            }

            function remove(id) {
                console.log('id to be deleted', id);
                if (self.order.id === id) {// clean form if the rank to
                    // be deleted is shown
                    // there.
                    reset();
                }
                deleteOrder(id);
            }

            function reset() {
                self.order = {
                    id : null,
                    customerId : '',
                    statusId : '',
                    price : '',
                    paymentMethodId : '',
                    sendMethodId : '',
                    placeTime : '',
                    sendTime : '',
                    invoiceTitle : '',
                    invoiceItem : ''
                };
                $scope.myForm.$setPristine(); // reset Form
            }

        } ]);
