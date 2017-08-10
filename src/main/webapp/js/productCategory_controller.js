'use strict';

angular.module('myApp').controller(
    'ProductCategoryController',
    [
        '$scope',
        'ProductCategoryService',
        function ($scope, ProductCategoryService) {
            var self = this;
            self.products = [];
            self.min_market_price='';
            self.max_market_price = '';
            self.year = '';
            self.month = '';
            self.day = '';

            self.changeProducts = changeProducts;

            //fetchAllProducts(market_price,year,month,day);

            function changeProducts() {
                self.products = [];
                fetchAllProducts(self.min_market_price,self.max_market_price,self.year,self.month,self.day);
            }

            function fetchAllProducts(min_market_price,max_market_price,year,month,day) {
                ProductCategoryService.fetchAllProducts(min_market_price,max_market_price,year,month,day).then(function (d) {
                    self.products= d;
                    //console.log(d);
                }, function (errResponse) {
                    console.error('Error while fetching orders of customer');
                });
            }

        }]);
