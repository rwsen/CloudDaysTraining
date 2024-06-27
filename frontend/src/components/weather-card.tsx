import {Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle} from "@/components/ui/card";
import {InputForm} from "@/components/input-form";
import {Skeleton} from "@/components/ui/skeleton";
import {WeatherStats} from "@/components/weather-stats";
import {useState} from "react";

export function WeatherCard() {
    const [weatherData, setWeatherData] = useState(null);
    const [isLoading, setLoading] = useState(false);

    return (
        <Card className="w-full md:w-1/2 lg:w-1/3 h-full md:h-1/2 lg:h-1/3">
            <CardHeader>
                <CardTitle>Accelerator Cloud Days Weather App</CardTitle>
                <CardDescription>Get the current weather for your city!</CardDescription>
            </CardHeader>
            <CardContent>
                <InputForm setWeatherData={setWeatherData} setLoading={setLoading}/>

                {isLoading ? <Skeleton className="w-[200px] h-[200px]"></Skeleton>
                    : weatherData && <WeatherStats weatherData={weatherData}/>}
            </CardContent>
            <CardFooter>
                <p className="text-xs text-gray-500">v1 2024 (LG1 & LG2) </p>
            </CardFooter>

        </Card>
    );
}