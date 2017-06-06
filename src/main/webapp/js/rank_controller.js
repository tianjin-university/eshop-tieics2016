'use strict';

angular.module('myApp').controller(
		'RankController',
		[
				'$scope',
				'RankService',
				function($scope, RankService) {
					var self = this;
					self.rank = {
						id : null,
						name : '',
						score : '',
						discount : ''
					};
					self.ranks = [];

					self.submit = submit;
					self.edit = edit;
					self.remove = remove;
					self.reset = reset;

					fetchAllRanks();

					function fetchAllRanks() {
						RankService.fetchAllRanks().then(function(d) {
							self.ranks = d;
						}, function(errResponse) {
							console.error('Error while fetching Ranks');
						});
					}

					function createRank(rank) {
						RankService.createRank(rank).then(fetchAllRanks,
								function(errResponse) {
									console.error('Error while creating Rank');
								});
					}

					function updateRank(rank, id) {
						RankService.updateRank(rank, id).then(fetchAllRanks,
								function(errResponse) {
									console.error('Error while updating Rank');
								});
					}

					function deleteRank(id) {
						RankService.deleteRank(id).then(fetchAllRanks,
								function(errResponse) {
									console.error('Error while deleting Rank');
								});
					}

					function submit() {
						if (self.rank.id === null) {
							console.log('Saving New Rank', self.rank);
							createRank(self.rank);
						} else {
							updateRank(self.rank, self.rank.id);
							console.log('Rank updated with id ', self.rank.id);
						}
						reset();
					}

					function edit(id) {
						console.log('id to be edited', id);
						for (var i = 0; i < self.ranks.length; i++) {
							if (self.ranks[i].id === id) {
								self.rank = angular.copy(self.ranks[i]);
								break;
							}
						}
					}

					function remove(id) {
						console.log('id to be deleted', id);
						if (self.rank.id === id) {// clean form if the rank to
							// be deleted is shown
							// there.
							reset();
						}
						deleteRank(id);
					}

					function reset() {
						self.rank = {
							id : null,
							name : '',
							score : '',
							discount : ''
						};
						$scope.myForm.$setPristine(); // reset Form
					}

				} ]);
