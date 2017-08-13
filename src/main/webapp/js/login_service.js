'use strict';
 
angular.module('myApp').factory('LoginService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:8080/eshop/login/';
 
    var factory = {
        fetchAllLogins: fetchAllLogins,
        createLogin: createLogin,
        updateLogin: updateLogin,
        deleteLogin: deleteLogin
    };
 
    return factory;
 
    function fetchAllLogins() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Logins');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createLogin(login) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, login)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Login');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateLogin(login, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, login)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Login');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteLogin(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Login');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);
