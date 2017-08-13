/**
 * created by LiTing(2016229068) 2016/08/11 17:30
 */
'use strict';

angular.module('myApp').controller(
    'ProductByCategoryController',
    [
        '$scope',
        'ProductByCategoryService',
        function ($scope, ProductByCategoryService) {
            var self = this;
            self.products = [];
            self.categorys = [];
            self.category ='';

            fetchAllCategorys();

            $scope.changeCategory = function () {
                self.products = [];
                fetchAllProductsByCategory(self.category);
            };
            
            function fetchAllCategorys() {
            	ProductByCategoryService.fetchAllCategorys().then(function (d) {
                    self.categorys = d;
                }, function (errResponse) {
                    console.error('Error while fetching all categorys');
                });
            }

            function fetchAllProductsByCategory(name) {
                ProductByCategoryService.fetchAllProductsByCategory(name).then(function (d) {
                    self.products= d;
                }, function (errResponse) {
                    console.error('Error while fetching products of category');
                });
            }

        }]);
