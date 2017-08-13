'use strict';

angular.module('myApp').factory('CustomerService', ['$http', '$q', function ($http, $q) {

    var REST_SERVICE_URI_CUSTOMER = 'http://localhost:8080/eshop/customer/';

    var factory = {
        fetchAllUsers: fetchAllUsers,
        createUser: createUser,
        updateUser:updateUser,
        deleteUser:deleteUser
    };
    
    return factory;

    function fetchAllUsers(){
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

    function createUser(user) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI_CUSTOMER, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function updateUser(user, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI_CUSTOMER+id, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    
    function deleteUser(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI_CUSTOMER+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);