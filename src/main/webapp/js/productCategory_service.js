'use strict';

angular.module('myApp').factory('ProductCategoryService', ['$http', '$q', function ($http, $q) {

    var REST_SERVICE_URI_PRODUCT_CATEGORY = 'http://localhost:8080/eshop/productCategory/';

    var factory = {
        fetchAllProducts: fetchAllProducts,

    };

    return factory;


    function fetchAllProducts(min_market_price,max_market_price,year,month,day) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI_PRODUCT_CATEGORY + min_market_price+'/'+max_market_price+'/'+year+'/'+month+'/'+day+'/')
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while fetching orders of customer');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);