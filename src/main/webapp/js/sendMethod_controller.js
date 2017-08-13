'use strict';

angular.module('myApp').controller(
    'SendMethodController',
    [
        '$scope',
        'SendMethodService',
        function($scope, SendMethodService) {
            var self = this;
            self.sendMethod = {
                id : null,
                name : '',
                score : '',
                discount : ''
            };
            self.sendMethods = [];

            self.submit = submit;
            self.edit = edit;
            self.remove = remove;
            self.reset = reset;

            fetchAllSendMethods();

            function fetchAllSendMethods() {
                SendMethodService.fetchAllSendMethods().then(function(d) {
                    self.sendMethods = d;
                }, function(errResponse) {
                    console.error('Error while fetching SendMethods');
                });
            }

            function createSendMethod(sendMethod) {
                SendMethodService.createSendMethod(sendMethod).then(fetchAllSendMethods,
                    function(errResponse) {
                        console.error('Error while creating SendMethod');
                    });
            }

            function updateSendMethod(sendMethod, id) {
                SendMethodService.updateSendMethod(sendMethod, id).then(fetchAllSendMethods,
                    function(errResponse) {
                        console.error('Error while updating SendMethod');
                    });
            }

            function deleteSendMethod(id) {
                SendMethodService.deleteSendMethod(id).then(fetchAllSendMethods,
                    function(errResponse) {
                        console.error('Error while deleting SendMethod');
                    });
            }

            function submit() {
                if (self.sendMethod.id === null) {
                    console.log('Saving New SendMethod', self.sendMethod);
                    createSendMethod(self.sendMethod);
                } else {
                    updateSendMethod(self.sendMethod, self.sendMethod.id);
                    console.log('SendMethod updated with id ', self.sendMethod.id);
                }
                reset();
            }

            function edit(id) {
                console.log('id to be edited', id);
                for (var i = 0; i < self.sendMethods.length; i++) {
                    if (self.sendMethods[i].id === id) {
                        self.sendMethod = angular.copy(self.sendMethods[i]);
                        break;
                    }
                }
            }

            function remove(id) {
                console.log('id to be deleted', id);
                if (self.sendMethod.id === id) {// clean form if the sendMethod to
                    // be deleted is shown
                    // there.
                    reset();
                }
                deleteSendMethod(id);
            }

            function reset() {
                self.sendMethod = {
                    id : null,
                    name : '',
                    score : '',
                    discount : ''
                };
                $scope.myForm.$setPristine(); // reset Form
            }

        } ]);
