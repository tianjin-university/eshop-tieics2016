'use strict';

angular.module('myApp').factory('OrderService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/eshop/order/';

    var factory = {
        fetchAllOrders: fetchAllOrders,
        createOrder: createOrder,
        updateOrder: updateOrder,
        deleteOrder: deleteOrder
    };

    return factory;

    function fetchAllOrders() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while fetching Orders');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function createOrder(order) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, order)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while creating Order');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }


    function updateOrder(order, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, order)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while updating Order');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function deleteOrder(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while deleting Order');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);
