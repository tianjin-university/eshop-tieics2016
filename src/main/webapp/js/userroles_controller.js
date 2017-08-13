'use strict';

angular.module('myApp').controller(
		'UserRolesController',
		[
				'$scope',
				'UserRolesService',
				function($scope, UserRolesService) {
					var self = this;
					self.userrole = {
						id : null,
						username : '',
						rolename : ''
					};
					self.userroles = [];

					self.submit = submit;
					self.edit = edit;
					self.remove = remove;
					self.reset = reset;

					fetchAllUserRoles();

					function fetchAllUserRoles() {
						UserRolesService.fetchAllUserRoles().then(function(d) {
							self.userroles = d;
						}, function(errResponse) {
							console.error('Error while fetching UserRoles');
						});
					}

					function createUserRoles(userrole) {
						UserRolesService.createUserRoles(userrole).then(fetchAllUserRoles,
								function(errResponse) {
									console.error('Error while creating UserRoles');
								});
					}

					function updateUserRoles(userrole, id) {
						UserRolesService.updateUserRoles(userrole, id).then(fetchAllUserRoles,
								function(errResponse) {
									console.error('Error while updating UserRoles');
								});
					}

					function deleteUserRoles(id) {
						UserRolesService.deleteUserRoles(id).then(fetchAllUserRoles,
								function(errResponse) {
									console.error('Error while deleting UserRoles');
								});
					}

					function submit() {
						if (self.userrole.id === null) {
							console.log('Saving New UserRoles', self.userrole);
							createUserRoles(self.userrole);
						} else {
							updateUserRoles(self.userrole, self.userrole.id);
							console.log('UserRoles updated with id ', self.userrole.id);
						}
						reset();
					}

					function edit(id) {
						console.log('id to be edited', id);
						for (var i = 0; i < self.userroles.length; i++) {
							if (self.userroles[i].id === id) {
								self.userrole = angular.copy(self.userroles[i]);
								break;
							}
						}
					}

					function remove(id) {
						console.log('id to be deleted', id);
						if (self.userrole.id === id) {
							reset();
						}
						deleteUserRoles(id);
					}

					function reset() {
						self.userrole = {
							id : null,
							username : '',
							rolename : ''
						};
						$scope.myForm.$setPristine(); // reset Form
					}

				} ]);
