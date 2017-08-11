<!--
Created by IntelliJ IDEA.
User: Liang Xing
Date: 17-8-9
Time: 下午7:27
To change this template use File | Settings | File Templates.
-->
'use strict';

angular.module('myApp').factory('OrderItemsService', ['$http', '$q', function ($http, $q) {

    var REST_SERVICE_URI_ORDER = 'http://localhost:8080/eshop/order/';
    var REST_SERVICE_URI_ORDER_ITEM = 'http://localhost:8080/eshop/orderItems/';

    var factory = {
        fetchAllOrders: fetchAllOrders,
        fetchOrderItems: fetchOrderItems
    };

    return factory;

    function fetchAllOrders(){
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI_ORDER)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while fetching all orders');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function fetchOrderItems(id) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI_ORDER_ITEM + id)
            .then(
                function (response) {
                    console.log(response.data);
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while fetching items of order');
                    deferred.reject(errResponse);
                }
            );
        console.log(deferred.promise);
        return deferred.promise;
    }

}]);