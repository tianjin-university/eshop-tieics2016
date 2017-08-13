'use strict';

angular.module('myApp').factory('PaymentMethodService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/eshop/paymentMethod/';

    var factory = {
        fetchAllPaymentMethods: fetchAllPaymentMethods,
        createPaymentMethod: createPaymentMethod,
        updatePaymentMethod: updatePaymentMethod,
        deletePaymentMethod: deletePaymentMethod
    };

    return factory;

    function fetchAllPaymentMethods() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while fetching PaymentMethods');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function createPaymentMethod(paymentMethod) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, paymentMethod)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while creating PaymentMethod');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }


    function updatePaymentMethod(paymentMethod, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, paymentMethod)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while updating PaymentMethod');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function deletePaymentMethod(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while deleting PaymentMethod');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);
