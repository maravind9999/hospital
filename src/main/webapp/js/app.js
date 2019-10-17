var app = angular.module('myApp', ['ngRoute','ngMaterial', 'ngMessages']);
var depart = null;
var departid = null;
var doctor = null;
var doctorid = null;
var appointDate=null;
/////////////////
////////////
app.config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'resource/department.html',
        controller: 'depController'
    }).when('/doctor/', {
        templateUrl: 'resource/doctor.html',
        controller: 'docController'
    }).when('/availability', {
        templateUrl: 'resource/availability.html',
        controller: 'availabilityController'
    }).when('/appointment', {
        templateUrl: 'resource/appointment.html',
        controller: 'appointmentController',
    });
});
app.controller("depController", function ($scope, $http) {
    if (depart != null)
    {
        $scope.depart = depart;
        $scope.doctor = doctor;
        $scope.IsVisible = true;
      $scope.appointDate =appointDate;
    }
    $http({
        method: 'GET',
        url: 'http://localhost:8080/hospital/getDepartments'//url:'resource/department.json'  //
    }).then(function successCallback(response) {
        $scope.depList = response.data;
    }, function errorCallback(response) {
        console.log(response.statusText);
    });

});
app.controller("docController", function ($scope, $http) {

    $scope.depart = depart;
    if (doctor != null)
    {
        $scope.IsVisible = true;
        $scope.doctor = doctor;
        $scope.appointDate =appointDate;
    }
    $http({
        method: 'GET',
        url : 'http://localhost:8080/hospital/getDoctorsByDepId/'+departid //url: 'resource/doctor.json', //
    }).then(function successCallback(response) {
        $scope.docList = response.data;
    }, function errorCallback(response) {
        console.log(response.statusText);
    });
});
app.controller("availabilityController", function ($scope, $location, $http) {
 var month = new Date().getMonth();
    month=month+1;
    var year = new Date().getFullYear();
       $http({
        method: 'GET',
        url : 'http://localhost:8080/hospital/getAvailableTimeByDocIdAndMonthAndYear/'+doctorid+'/'+month+'/'+year //url: 'resource/doctor.json', //
    }).then(function successCallback(response) {
        $scope.dateList = response.data;
       calendar(response.data.date);
    }, function errorCallback(response) {
        console.log(response.statusText);
    });
    
    $scope.depart = depart;
    $scope.doctor = doctor;
 if (appointDate != null)
    {
        $scope.IsVisible = true;
       $scope.appointDate =appointDate ;
    }
 
    ///////////////////////
 function calendar(date){
	 var selectedDays = date;alert(selectedDays);
     var daysAvailableThisMonth = selectedDays.split(',');
                $scope.myDate = new Date();
                $scope.minDate = new Date(
                	      $scope.myDate.getFullYear(),
                	      $scope.myDate.getMonth() - 2,
                	      $scope.myDate.getDate());

                	  $scope.maxDate = new Date(
                	      $scope.myDate.getFullYear(),
                	      $scope.myDate.getMonth() + 2,
                	      $scope.myDate.getDate());

                function formattedDate(day) {
                    var currentMonth = new Date().getMonth();
                    var currentYr = new Date().getFullYear();
                    return {day: new Date(currentYr, currentMonth, day), available: false};
                }

                function getDaysInMonth(month, year) {
                    var date = new Date(year, month, 1);
                    var days = [];
                    while (date.getMonth() === month) {
                        //you can set the default flag as you like but itll help filtering.
                        days.push({
                            day: new Date(date),
                            available: true
                        });
                        date.setDate(date.getDate() + 1);
                    }
                    return days;
                }
                var currentMonthDayArray = getDaysInMonth(new Date().getMonth(), new Date().getFullYear());

                daysAvailableThisMonth.forEach(function (day, index) {
                    daysAvailableThisMonth[index] = formattedDate(day);
                });

                currentMonthDayArray.forEach(function (available) {
                    daysAvailableThisMonth.forEach(function (date) {
                        if (date.day.getTime() == available.day.getTime()) {
                            available.available = false;
                        }
                    })
                });
                $scope.availabie = function (date) {
                    for (var i = 0; i < currentMonthDayArray.length; i++) {
                        if (currentMonthDayArray[i].day.getTime() === date.getTime() && currentMonthDayArray[i].available === false) {
                            return true;
                        }
                    }
                };
}

    /////////////////////////
    /////////////////////

    //////////////////
});
app.controller("appointmentController", function ($scope, $http) {

    $scope.depart = depart;
        $scope.doctor = doctor;
        $scope.appointDate =appointDate;
 
});
app.controller('myController', ['$scope', function ($scope) {
        $scope.selectDepart = function (dep) {
            depart = "Dempart :" + dep.name;
            departid = dep.id;
            $scope.depart = depart;
            $scope.departid = dep.id;
        };

        $scope.selectDoctor = function (doc) {
            doctor = "Doctor :" + doc.name;
            doctorid = doc.id;
            $scope.doctor = doctor;
            $scope.doctorid = doc.id;
        };

        $scope.ShowHide = function () {
            $scope.IsVisible = true;
        }
        $scope.selectDate = function (date) {
            appointDate="Selectd Appointment Date: "+date ;
            $scope.appointDate =appointDate ;
        }
        
    }]);


