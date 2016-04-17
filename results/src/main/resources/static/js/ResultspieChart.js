/**
 * Created by Roberto on 17/4/16.
 */

var ctx = document.getElementById("chart").getContext("2d");
/*TODO queda cargar los datos desde codigo*/
var data = [
    {
        value: 300,
        color:"#F7464A",
        highlight: "#FF5A5E",
        label: "PSOE"
    },
    {
        value: 50,
        color: "#00B4FF",
        highlight: "#5AD3D1",
        label: "PP"
    },
    {
        value: 100,
        color: "#FF9100",
        highlight: "#FFC870",
        label: "CIUDADANOS"
    },
    {
        value: 150,
        color: "#B900FF",
        highlight: "#B900FF",
        label: "PODEMOS"
    }
]

var pieOptions = {
    //Boolean - Whether we should show a stroke on each segment
    segmentShowStroke : true,

    scaleBackdropPaddingY: 2,
    //Number - The backdrop padding to the side of the label in pixels
    scaleBackdropPaddingX: 2,
    //Boolean - Show line for each value in the scale
    scaleShowLine: true,

    //String - The colour of each segment stroke
    segmentStrokeColor : "#fff",

    //Number - The width of each segment stroke
    segmentStrokeWidth : 2,
    animateScale : true
}

var myPieChart = new Chart(ctx).Pie(data,pieOptions);