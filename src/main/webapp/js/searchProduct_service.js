'use strict';
 
angular.module('myApp').factory('SearchProductService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI_SEARCH_PRODUCT = 'http://localhost:8080/eshop/searchProduct/';
 
    var factory = {
        fetchSpecifiedProducts: fetchSpecifiedProducts
    };
 
    return factory;
 
    function fetchSpecifiedProducts(productName, summary, detail) {
        var deferred = $q.defer();
        if(productName == "") productName = "_";
        if(summary == "") summary = "_";
        if(detail == "") detail = "_";
        $http.get(REST_SERVICE_URI_SEARCH_PRODUCT+ productName + '/' + summary + '/' + detail + '/')
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching specified products');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);
