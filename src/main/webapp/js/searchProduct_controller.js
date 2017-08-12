'use strict';

angular.module('myApp').controller(
    'SearchProductController',
    [
        '$scope',
        'SearchProductService',
        function ($scope, SearchProductService) {
            var self = this;
            self.products = [];
            self.productName ='';
            self.summary = '';
            self.detail = '';

            self.showProducts = showProducts;

            function showProducts() {
                self.products = [];
                fetchSpecifiedProducts(self.productName, self.summary, self.detail);
            }

            function fetchSpecifiedProducts(productName, summary, detail) {
                SearchProductService.fetchSpecifiedProducts(productName, summary, detail).then(function (d) {
                    self.products= d;
                }, function (errResponse) {
                    console.error('Error while fetching specified products');
                });
            }

        }]);
