import { useState } from "react";
import WeatherInfo from "./WeatherInfo";


function WeatherApp() {
    const [cityName, setCityName] = useState("");
    const [weatherData, setWeatherData] = useState({})
    const changeCityInput = (e) => {
        setCityName(e.target.value);
    }
    const fetchWeatherAPI = async () => {
        const APIurl = `https://api.openweathermap.org/data/2.5/weather?q=${cityName}&appid=75755c0668a6355fd896ad3a907d4dc1&units=metric`
        const resp = await fetch(APIurl);
        const respJson = await resp.json();
        setWeatherData(respJson);
    }

    let handleMouseOut = (e) => {
        fetchWeatherAPI();
    }

    return (
        <>
            <div className="container">
                <div className="row">
                    <div className="col-sm-12 text-center">
                        <h3 className="text-success">React Weather App Project</h3>
                    </div>
                    <div className="col-sm-12">
                        <div className="form-group">
                            <input type="text"
                                className="form-control"
                                placeholder="Enter City Name"
                                onChange={changeCityInput}
                                onMouseOut={handleMouseOut}
                                value={cityName} />
                        </div>

                        {/* Weather app info */}
                        <WeatherInfo cityName={cityName} weatherData={weatherData} />
                        {/* Weather app info */}
                    </div>
                </div>
            </div>
        </>
    )

}

export default WeatherApp;


