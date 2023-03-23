var days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"];
var weather = ["Sunny", "Partly Sunny", "Partly Cloudy", "Cloudy", "Raining", "Snowing", "Thunderstorm", "Foggy"];

var minTemp = 0;
var maxTemp = 100;

// div variable created to see how debug works, div = "<div id = '" is part of the debug

var div;

generateWeather();

function generateWeather() {

    for (var i = 0; i < days.length; i++) {
        var weatherToday = weather[Math.floor(Math.random() * weather.length)];
        var tempToday = Math.floor(Math.random() * (maxTemp - minTemp) + minTemp);
        div = "<div id = '" +
            days[i] + "'class ='" + weatherToday + "'><b>Forecast for " + days[i] +
            ":</br><br><br>" + weatherToday + " and " + tempToday + " degrees Fahrenheit.</div>";
        document.getElementById("5DayWeather").innerHTML += div;
    }
}

alert("Reload the page to produce new weather conditions");
