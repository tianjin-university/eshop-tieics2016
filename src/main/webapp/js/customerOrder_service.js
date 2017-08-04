'use strict';

angular.module('myApp').factory('CustomerOrderService', ['$http', '$q', function ($http, $q) {

    var REST_SERVICE_URI_CUSTOMER = 'http://localhost:8080/eshop/customer/';
    var REST_SERVICE_URI_CUSTOMER_ORDER = 'http://localhost:8080/eshop/customerOrder/';

    var factory = {
        fetchAllCustomers: fetchAllCustomers,
        fetchCustomerOrders: fetchCustomerOrders
    };

    return factory;

    function fetchAllCustomers(){
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI_CUSTOMER)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while fetching All customers');
                    deferred.reject(errResponse);
                }
        );
        return deferred.promise;
    }

    function fetchCustomerOrders(username) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI_CUSTOMER_ORDER + username)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while fetching orders of customer');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);