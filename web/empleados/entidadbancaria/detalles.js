
var app = angular.module("app", []);

function EntidadBancariaDetailController($scope, $http) {

    $scope.titulo = "Banco";
    
    var ideb;
    
    $scope.entidadBancaria = {
        idEntidadBancaria: "",
        nombre: "",
        codigoEntidad: ""
    };

    $scope.buscarRegistro = function(id) {
        $http({
            method: "GET",
            url: contextPath + "/api/EntidadBancaria/" + id
        }).success(function(data) {
            $scope.entidadBancaria = data;
        }).error(function(status) {
            alert("Error " + status);
        });
    };



    $scope.borrarRegistro = function(id) {
        $http({
            method: "DELETE",
            url: contextPath + "/api/EntidadBancaria/" + id
        }).success(function() {
            alert("¡Registro borrado!");
        }).error(function() {
            alert("Error " + status);
        });
    };


    $scope.insertarRegistro = function() {

        $http({
            method: "POST",
            url: contextPath + "/api/EntidadBancaria/",
            data: $scope.entidadBancaria
        }).success(function() {
            alert("¡Registro insertado!");
        }).error(function(status) {
            alert("Error " + status);
        });
    };

    $scope.modificarRegistro = function() {
        $http({
            method: "PUT",
            url: contextPath + "/api/EntidadBancaria/",
            data: $scope.entidadBancaria
        }).success(function() {
            alert("¡Registro modificado!");
        }).error(function() {
            alert("¡Que no va!");
        });
    };

}

