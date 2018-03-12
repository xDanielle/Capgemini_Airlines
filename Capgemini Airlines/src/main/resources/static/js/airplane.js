// AJAX gebruiken om backend data in te laden naar jquery
$(document).ready(function(){
    console.log("Airplane.js is being used");
    getData();
});


api = "http://localhost:8080/api/planes/";

function getData(){
$(document).ready(function(){

    $.ajax({
            url : api + "get",
            type : "get",
            success: function(data){

            var planeTableContent = "";

            $.each(data, function(index, current) {
            console.log("each function is initiated");

            // Make variable which consists of the currentfuel, so we can change it later when we use the tank button
            var fuelBlockID = "current fuel" + current.id;


            // columnRow is being created with all the values out of the database
            	var columnRow = "<tr><td>" +
                current.id + "</td><td>" +
                current.namePlane + "</td><td>" +
                current.locationPlane + "</td><td id='fuelBlockID'>" +
                current.currentFuel + "</td><td>" +
                "<button type='button' class='btn btn-primary' onclick='addFuel(" + current.id + ")'> Add Fuel </button>" + "</td><td>" +
                "<button type='button' class='btn btn-primary' onclick='goFly(" + current.id + ")'> Fly little plane! </button>" + "</td><td>"
                + "<button type='button' class='btn btn-danger' data-toggle='modal' data-target='#deletePlaneModal' id='"+ current.id + "' onclick='deletePlane(" + current.id + ")'> Delete </button>" + "</td></tr>";

                planeTableContent += columnRow;
                console.log(columnRow);
            });



            console.log(planeTableContent);

            $("#planeTable").empty();
            $("#planeTable").append(planeTableContent);

            }

        });

    });
}

function postData(){
	// The postData function is triggered by the add new room button. This function has to post the filled in data into the table.

    // First we need to put the values of the input fields into variables
    var inputNamePlane = $("#namePlane").val();
    var inputLocationPlane = $("#locationPlane").val();
    var inputAmountOfFuel = $("#amountOfFuel").val();



    // Here we make a new object
    var newPlaneObject = {
    namePlane : inputNamePlane,
    currentFuel : inputAmountOfFuel,
    locationPlane : inputLocationPlane
    };

    // Make the object readable for the backend by parsing it to JSON
    var newPlane = JSON.stringify(newPlaneObject);
    console.log(newPlane);

    // Save the actual data to the repository
    $.ajax({
        url : api + "save",
        type : "post",
        data : newPlane,
        contentType : "application/json",
        success: function(data){
            console.log("Success post!");
            getData();
        }

    });
};



function deletePlane(id){

$("#deleteThisPlane").html("Are you sure you want to delete plane #" + id + "?");

    $("#finalDelete").click(function(){

                console.log("function modalDeletePlane is being used")

                $.ajax({
                        url : api + id,
                        type : "delete",
                        contentType : "application/json",
                        success : function() {
                            console.log("Deletion is initiated");

                            $("#planeTable").html("");

                            getData();
                            }

                });
            });
}

function addFuel(id){
    console.log("fuel added");

    inputAmountOfFuel = 5000;

    var fuelObject = {
                        id : id,
                        currentFuel : inputAmountOfFuel
                        };

    console.log(fuelObject);
    var newFuelObjectUpdate = JSON.stringify(fuelObject);
    console.log(newFuelObjectUpdate);

            $.ajax({
                url : api + "flight/" + id,
                type : "put",
                data : newFuelObjectUpdate,
                contentType : "application/json",
                success : function(data){
                    console.log("successful put")

                    getData();

                }
            });
}


function goFly(id){
    console.log("plane flies");
    console.log(id);


    var fuelObject = {
                        id : id,
                        currentFuel : (currentFuel - 2000)
                        };

    console.log(fuelObject);
    var newFuelObjectUpdate = JSON.stringify(fuelObject);
    console.log(newFuelObjectUpdate);

            $.ajax({
                url : api + id,
                type : "put",
                data : newFuelObjectUpdate,
                contentType : "application/json",
                success : function(data){
                    console.log("successful put")

                    getData();
                }
            });
}



