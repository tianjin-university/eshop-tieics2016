'use strict';

angular.module('myApp').factory('SendMethodService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/eshop/sendMethod/';

    var factory = {
        fetchAllSendMethods: fetchAllSendMethods,
        createSendMethod: createSendMethod,
        updateSendMethod: updateSendMethod,
        deleteSendMethod: deleteSendMethod
    };

    return factory;

    function fetchAllSendMethods() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while fetching SendMethods');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function createSendMethod(sendMethod) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, sendMethod)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while creating SendMethod');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }


    function updateSendMethod(sendMethod, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, sendMethod)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while updating SendMethod');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function deleteSendMethod(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while deleting SendMethod');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);
