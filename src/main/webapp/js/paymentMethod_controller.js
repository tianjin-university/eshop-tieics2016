'use strict';

angular.module('myApp').controller(
    'PaymentMethodController',
    [
        '$scope',
        'PaymentMethodService',
        function($scope, PaymentMethodService) {
            var self = this;
            self.paymentMethod = {
                id : null,
                name : ''
            }
            self.paymentMethods = [];

            self.submit = submit;
            self.edit = edit;
            self.remove = remove;
            self.reset = reset;

            fetchAllPaymentMethods();

            function fetchAllPaymentMethods() {
                PaymentMethodService.fetchAllPaymentMethods().then(function(d) {
                    self.paymentMethods = d;
                }, function(errResponse) {
                    console.error('Error while fetching PaymentMethods');
                });
            }

            function createPaymentMethod(paymentMethod) {
                PaymentMethodService.createPaymentMethod(paymentMethod).then(fetchAllPaymentMethods,
                    function(errResponse) {
                        console.error('Error while creating PaymentMethod');
                    });
            }

            function updatePaymentMethod(paymentMethod, id) {
                PaymentMethodService.updatePaymentMethod(paymentMethod, id).then(fetchAllPaymentMethods,
                    function(errResponse) {
                        console.error('Error while updating PaymentMethod');
                    });
            }

            function deletePaymentMethod(id) {
                PaymentMethodService.deletePaymentMethod(id).then(fetchAllPaymentMethods,
                    function(errResponse) {
                        console.error('Error while deleting PaymentMethod');
                    });
            }

            function submit() {
                if (self.paymentMethod.id === null) {
                    console.log('Saving New PaymentMethod', self.paymentMethod);
                    createPaymentMethod(self.paymentMethod);
                } else {
                    updatePaymentMethod(self.paymentMethod, self.paymentMethod.id);
                    console.log('PaymentMethod updated with id ', self.paymentMethod.id);
                }
                reset();
            }

            function edit(id) {
                console.log('id to be edited', id);
                for (var i = 0; i < self.paymentMethods.length; i++) {
                    if (self.paymentMethods[i].id === id) {
                        self.paymentMethod = angular.copy(self.paymentMethods[i]);
                        break;
                    }
                }
            }

            function remove(id) {
                console.log('id to be deleted', id);
                if (self.paymentMethod.id === id) {// clean form if the paymentMethod to
                    // be deleted is shown
                    // there.
                    reset();
                }
                deletePaymentMethod(id);
            }

            function reset() {
                self.paymentMethod = {
                    id : null,
                    name : ''
                };
                $scope.myForm.$setPristine(); // reset Form
            }

        } ]);
