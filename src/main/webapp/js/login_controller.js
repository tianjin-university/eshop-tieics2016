'use strict';

angular.module('myApp').controller(
		'LoginController',
		[
				'$scope',
				'LoginService',
				function($scope, LoginService) {
					var self = this;
					self.login = {
						id : null,
						name : '',
						ipAddr : '',
						loginTime : ''
					};
					self.logins = [];

					self.submit = submit;
					self.edit = edit;
					self.remove = remove;
					self.reset = reset;

					fetchAllLogins();

					function fetchAllLogins() {
						LoginService.fetchAllLogins().then(function(d) {
							self.logins = d;
						}, function(errResponse) {
							console.error('Error while fetching Logins');
						});
					}

					function createLogin(login) {
						LoginService.createLogin(login).then(fetchAllLogins,
								function(errResponse) {
									console.error('Error while creating Login');
								});
					}

					function updateLogin(login, id) {
						LoginService.updateLogin(login, id).then(fetchAllLogins,
								function(errResponse) {
									console.error('Error while updating Login');
								});
					}

					function deleteLogin(id) {
						LoginService.deleteLogin(id).then(fetchAllLogins,
								function(errResponse) {
									console.error('Error while deleting Login');
								});
					}

					function submit() {
						if (self.login.id === null) {
							console.log('Saving New Login', self.login);
							createLogin(self.login);
						} else {
							updateLogin(self.login, self.login.id);
							console.log('Login updated with id ', self.login.id);
						}
						reset();
					}

					function edit(id) {
						console.log('id to be edited', id);
						for (var i = 0; i < self.logins.length; i++) {
							if (self.logins[i].id === id) {
								self.login = angular.copy(self.logins[i]);
								break;
							}
						}
					}

					function remove(id) {
						console.log('id to be deleted', id);
						if (self.login.id === id) {// clean form if the login to
							// be deleted is shown
							// there.
							reset();
						}
						deleteLogin(id);
					}

					function reset() {
						self.login = {
							id : null,
							name : '',
							ipAddr : '',
							loginTime : ''
						};
						$scope.myForm.$setPristine(); // reset Form
					}

				} ]);
