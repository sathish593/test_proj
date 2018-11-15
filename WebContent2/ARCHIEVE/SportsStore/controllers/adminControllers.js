﻿angular.module("sportsStoreAdmin")
    .constant("authUrl", "https://api.parse.com/1/login")
    .constant("ordersUrl", "https://api.parse.com/1/classes/Orders")
    .run(function ($http) {
    	$http.defaults.headers.common["X-Parse-Application-Id"]
        = "DDhn4YXQ3sezLYA8bN8hWBNY1Dx4xJ8R7IFmcVAw";
    $http.defaults.headers.common["X-Parse-REST-API-Key"]
        = "0tgFI2G7U28OtGu6RFvPdFJpK5WIsFnkbD3Og93o";
    })

.controller("authCtrl", function ($scope, $http, $location, authUrl) {

    $scope.authenticate = function (user, pass) {
        $http.get(authUrl, {
            params: {
                username: user,
                password: pass
            },
        }).success(function (data) {
            $scope.$broadcast("sessionToken", data.sessionToken);
            $http.defaults.headers.common["X-Parse-Session-Token"]
                = data.sessionToken;
            $location.path("/main");
        }).error(function (response) {
            $scope.authenticationError = response.error || response;
        });
    }
})
.controller("mainCtrl", function ($scope) {

    $scope.screens = ["Products", "Orders"];
    $scope.current = $scope.screens[0];

    $scope.setScreen = function (index) {
        $scope.current = $scope.screens[index];
    };

    $scope.getScreen = function () {
        return $scope.current == "Products"
            ? "views/adminProducts.html" : "views/adminOrders.html";
    };
})
.controller("ordersCtrl", function ($scope, $http, ordersUrl) {

    $http.get(ordersUrl)
        .success(function (data) {
            $scope.orders = data.results;
        })
        .error(function (response) {
            $scope.error = response.error || response;
            console.log(error);
        });

    $scope.selectedOrder;

    $scope.selectOrder = function (order) {
        $scope.selectedOrder = order;
    };

    $scope.calcTotal = function (order) {
        var total = 0;
        for (var i = 0; i < order.products.length; i++) {
            total +=
                order.products[i].count * order.products[i].price;
        }
        return total;
    }
});


