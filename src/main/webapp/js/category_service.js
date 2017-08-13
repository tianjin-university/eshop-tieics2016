'use strict';
 
angular.module('myApp').factory('CategoryService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:8080/eshop/category/';
 
    var factory = {
        fetchAllCategories: fetchAllCategories,
        createCategory: createCategory,
        updateCategory: updateCategory,
        deleteCategory: deleteCategory
    };
 
    return factory;
 
    function fetchAllCategories() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Categories');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createCategory(category) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, category)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Category');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateCategory(category, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, category)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Category');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteCategory(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Category');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);
