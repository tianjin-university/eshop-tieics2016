'use strict';
 
angular.module('myApp').factory('RankService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:8080/eshop/rank/';
 
    var factory = {
        fetchAllRanks: fetchAllRanks,
        createRank: createRank,
        updateRank: updateRank,
        deleteRank: deleteRank
    };
 
    return factory;
 
    function fetchAllRanks() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Ranks');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createRank(rank) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, rank)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Rank');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateRank(rank, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, rank)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Rank');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteRank(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Rank');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);
