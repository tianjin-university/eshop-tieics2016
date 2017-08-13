'use strict';

angular.module('myApp').factory('ItemService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/eshop/item/';

    var factory = {
        fetchAllItems: fetchAllItems,
        createItem: createItem,
        updateItem: updateItem,
        deleteItem: deleteItem
    };

    return factory;

    function fetchAllItems() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while fetching Item');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function createItem(item) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, item)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while creating Item');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }


    function updateItem(item, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, item)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while updating Item');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function deleteItem(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while deleting Item');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);
