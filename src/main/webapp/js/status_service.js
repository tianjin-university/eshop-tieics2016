'status strict';
 
angular.module('myApp').factory('StatusService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:8080/eshop/status/';
 
    var factory = {
        fetchAllStatuses: fetchAllStatuses,
        createStatus: createStatus,
        updateStatus: updateStatus,
        deleteStatus: deleteStatus
    };
 
    return factory;
 
    function fetchAllStatuses() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Statuses');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createStatus(user) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Status');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateStatus(user, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Status');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteStatus(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Status');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);
