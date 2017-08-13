'use strict';
 
angular.module('myApp').factory('UserRolesService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:8080/eshop/user_roles/';
 
    var factory = {
    	fetchAllUserRoles: fetchAllUserRoles,
    	createUserRoles: createUserRoles,
    	updateUserRoles: updateUserRoles,
    	deleteUserRoles: deleteUserRoles
    };
 
    return factory;
 
    function fetchAllUserRoles() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching UserRoles');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createUserRoles(userrole) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, userrole)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating UserRoles');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateUserRoles(userrole, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, userrole)
            .then(
            function (response) {  
            	console.log('----------',response.data);
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating UserRoles');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteUserRoles(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting UserRoles');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);
