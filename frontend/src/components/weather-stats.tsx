'use client'

import {Separator} from "@/components/ui/separator";
import {Badge} from "@/components/ui/badge";

// @ts-ignore
export function WeatherStats({ weatherData }) {
    return (
        <div className="p-5">
            <h2 className="text-lg font-medium">Weather Stats for <b className="text-blue-600">{weatherData?.name}</b></h2>
            <div className="flex items-center space-x-5">

                <img src={`https://openweathermap.org/img/wn/${weatherData?.weather[0].icon}.png`}
                     alt="weather icon"/>

                <p className="text-md text-muted-foreground">
                    {weatherData?.weather[0].description}
                </p>
            </div>
            <Separator className="my-4"/>
            <div className="flex h-5 items-center space-x-4 text-sm">
                <div>
                    <Badge>Temperature: {weatherData?.main.temp}°C</Badge>
                </div>
                <Separator orientation="vertical"/>
                <div>
                    <Badge variant="secondary">Feels Like: {weatherData?.main.feels_like}°C</Badge>
                </div>
                <Separator orientation="vertical"/>
                <div>
                    <Badge variant="secondary">Humidity: {weatherData?.main.humidity}%</Badge>
                </div>
            </div>
            <Separator className="my-4"/>
            <div className="flex h-5 items-center space-x-4 text-sm">
                <div>
                    <Badge variant="secondary">Min: {weatherData?.main.temp_min}°C</Badge>
                </div>
                <Separator orientation="vertical"/>
                <div>
                    <Badge variant="secondary">Max: {weatherData?.main.temp_max}°C</Badge>
                </div>
                <Separator orientation="vertical"/>
                <div>
                    <Badge variant="secondary">Pressure: {weatherData?.main.pressure} hPa</Badge>
                </div>
            </div>
        </div>
    );
}