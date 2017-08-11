'status strict';

angular.module('myApp').controller(
		'StatusController',
		[
				'$scope',
				'StatusService',
				function($scope, StatusService) {
					var self = this;
					self.status = {
						id : null,
						name : '',
					};
					self.statuses = [];

					self.submit = submit;
					self.edit = edit;
					self.remove = remove;
					self.reset = reset;

					fetchAllStatuses();

					function fetchAllStatuses() {
						StatusService.fetchAllStatuses().then(function(d) {
							self.statuses = d;
						}, function(errResponse) {
							console.error('Error while fetching Statuses');
						});
					}

					function createStatus(status) {
						StatusService.createStatus(status).then(fetchAllStatuses,
								function(errResponse) {
									console.error('Error while creating Status');
								});
					}

					function updateStatus(status, id) {
						StatusService.updateStatus(status, id).then(fetchAllStatuses,
								function(errResponse) {
									console.error('Error while updating Status');
								});
					}

					function deleteStatus(id) {
						StatusService.deleteStatus(id).then(fetchAllStatuses,
								function(errResponse) {
									console.error('Error while deleting Status');
								});
					}

					function submit() {
						if (self.status.id === null) {
							console.log('Saving New Status', self.status);
							createStatus(self.status);
						} else {
							updateStatus(self.status, self.status.id);
							console.log('Status updated with id ', self.status.id);
						}
						reset();
					}

					function edit(id) {
						console.log('id to be edited', id);
						for (var i = 0; i < self.statuses.length; i++) {
							if (self.statuses[i].id === id) {
								self.status = angular.copy(self.statuses[i]);
								break;
							}
						}
					}

					function remove(id) {
						console.log('id to be deleted', id);
						if (self.status.id === id) {// clean form if the status to
							// be deleted is shown
							// there.
							reset();
						}
						deleteStatus(id);
					}

					function reset() {
						self.status = {
							id : null,
							name : ''
						};
						$scope.myForm.$setPristine(); // reset Form
					}

				} ]);
