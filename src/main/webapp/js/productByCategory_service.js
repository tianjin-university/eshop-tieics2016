/**
 * created by LiTing(2016229068) 2016/08/11 17:30
 */
'use strict';

angular.module('myApp').factory('ProductByCategoryService', ['$http', '$q', function ($http, $q) {

    var REST_SERVICE_URI_PRODUCT_CATEGORY = 'http://localhost:8080/eshop/productByCategory/';
    var REST_SERVICE_URI_CATEGORY = 'http://localhost:8080/eshop/category/';

    var factory = {
            fetchAllProductsByCategory: fetchAllProductsByCategory,
            fetchAllCategorys: fetchAllCategorys
    };

    return factory;

    function fetchAllCategorys(){
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI_CATEGORY)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while fetching All categorys');
                    deferred.reject(errResponse);
                }
        );
        return deferred.promise;
    }

    function fetchAllProductsByCategory(name) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI_PRODUCT_CATEGORY + name)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while fetching products of category');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);