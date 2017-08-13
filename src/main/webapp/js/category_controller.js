'use strict';

angular.module('myApp').controller(
		'CategoryController',
		[
				'$scope',
				'CategoryService',
				function($scope, CategoryService) {
					var self = this;
					self.category = {
						id : null,
						name : '',
						description : ''
					};
					self.categories = [];

					self.submit = submit;
					self.edit = edit;
					self.remove = remove;
					self.reset = reset;

					fetchAllCategories();

					function fetchAllCategories() {
						CategoryService.fetchAllCategories().then(function(d) {
							self.categories = d;
						}, function(errResponse) {
							console.error('Error while fetching Categories');
						});
					}

					function createCategory(category) {
						CategoryService.createCategory(category).then(fetchAllCategories,
								function(errResponse) {
									console.error('Error while creating Category');
								});
					}

					function updateCategory(category, id) {
						CategoryService.updateCategory(category, id).then(fetchAllCategories,
								function(errResponse) {
									console.error('Error while updating Category');
								});
					}

					function deleteCategory(id) {
						CategoryService.deleteCategory(id).then(fetchAllCategories,
								function(errResponse) {
									console.error('Error while deleting Category');
								});
					}

					function submit() {
						if (self.category.id === null) {
							console.log('Saving New Category', self.category);
							createCategory(self.category);
						} else {
							updateCategory(self.category, self.category.id);
							console.log('Category updated with id ', self.category.id);
						}
						reset();
					}

					function edit(id) {
						console.log('id to be edited', id);
						for (var i = 0; i < self.categories.length; i++) {
							if (self.categories[i].id === id) {
								self.category = angular.copy(self.categories[i]);
								break;
							}
						}
					}

					function remove(id) {
						console.log('id to be deleted', id);
						if (self.category.id === id) {// clean form if the category to
							// be deleted is shown
							// there.
							reset();
						}
						deleteCategory(id);
					}

					function reset() {
						self.category = {
							id : null,
							name : '',
							description : ''
						};
						$scope.myForm.$setPristine(); // reset Form
					}

				} ]);
