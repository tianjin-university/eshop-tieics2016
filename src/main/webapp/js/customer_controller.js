'use strict';
 
angular.module('myApp').controller('CustomerController', ['$scope', 'CustomerService', function($scope, CustomerService) {
    var self = this;
    self.user={
    		username:null,
    		password:'',
    		real_name:'',
    		gender:'',
    		birthday:'',
    		question:'',
    		answer:'',
    		rank_id:'',
    		score:'',
    		mobile:'',
    		email:'',
    		province:'',
    		city:'',
    		country:'',
    		adress:'',
    		zipcode:''};
    
    self.users=[];
 
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
 
 
    fetchAllUsers();
 
    function fetchAllUsers(){
        CustomerService.fetchAllUsers()
            .then(
            function(d) {
                self.users = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }
 
    function createUser(user){
        CustomerService.createUser(user)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    }
 
    function updateUser(user, username){
        CustomerService.updateUser(user, username)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    }
 
    function deleteUser(username){
        CustomerService.deleteUser(username)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    }
 
    function submit() {
        if(self.user.username===null){
            console.log('Saving New User', self.user);
            createUser(self.user);
        }else{
            updateUser(self.user, self.user.username);
            console.log('User updated with username ', self.user.username);
        }
        reset();
    }
 
    function edit(username){
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].username === username) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
    }
 
    function remove(username){
        if(self.user.username === username) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteUser(username);
    }
 
 
    function reset(){
    	self.user={
        		username:null,
        		password:'',
        		real_name:'',
        		gender:'',
        		birthday:'',
        		question:'',
        		answer:'',
        		rank_id:'',
        		score:'',
        		mobile:'',
        		email:'',
        		province:'',
        		city:'',
        		country:'',
        		adress:'',
        		zipcode:''};
        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);