'use client'

import {useEffect, useState} from 'react';
import {Button} from "@/components/ui/button";
import {Input} from "@/components/ui/input";

// @ts-ignore
export function InputForm({ setWeatherData, setLoading }) {
    const [city, setCity] = useState(`${process.env.NEXT_PUBLIC_DEFAULT_CITY}`);

    const fetchWeather = async (event?: React.FormEvent) => {
        event?.preventDefault(); // Prevent the form from causing a page refresh
        setLoading(true);
        try {
            const response = await fetch(`${process.env.NEXT_PUBLIC_API_URL}weather/current?city=${city}`);
            if (!response.ok) {
                setLoading(true);
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const data = await response.json();
            setWeatherData(data);
        } catch (error) {
            console.error(error);
        }
        setLoading(false);
    };

    useEffect(() => {
        fetchWeather();
    }, []);

    return (
        <form className="p-5 flex items-center space-x-5" onSubmit={fetchWeather}>
            <Input type="text" value={city} onChange={(e) => setCity(e.target.value)}/>
            <Button className="btn btn-primary" type="submit">Fetch</Button>
        </form>
    );
}