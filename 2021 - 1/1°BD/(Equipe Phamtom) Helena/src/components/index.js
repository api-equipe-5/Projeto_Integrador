import React from 'react';
import { StyleSheet, View, Text, } from 'react-native';
import Weather from '../pages/ClimaAtual/Weahter';
import { API_KEY } from '../components/Util/WeatherAPIKey';
import GeoLocation from '@react-native-community/geolocation';
navigator.geolocation = require('@react-native-community/geolocation');
export default class App extends React.Component {
  state = {
    isLoading: true,
    temperature: 12,
    weatherCondition: 'Mist',
    error: null
  }

  componentDidMount() {
    navigator.geolocation.getCurrentPosition(
      position => {
        this.getWeather(position.coords.latitude, position.coords.longitude);
      },
      error => {
        console.log(error);
        this.setState({ error: 'Erro ao obter a atualização do clima' });  
      },{enableHighAccuracy: true, timeout: 50000}
    );
  }

  getWeather(lat = 25, lon = 25) {
    console.log(lat, lon, 'lat,lon')
    fetch(
      `http://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${API_KEY}&units=metric`
    ).then(resp => resp.json())
      .then(json => {
       console.log(json,'weather');
        this.setState({
          temperature: Math.round(json.main.temp).toFixed(),
          weatherCondition: json.weather[0].main,
          isLoading: false
        })
      })
  }
  render() {
    const { temperature, weatherCondition, isLoading } = this.state;
    return (
      <View style={styles.container}>
        {isLoading ? <Text>Getting Weather Data</Text> :
          <Weather weather={weatherCondition} temperature={temperature} />

        }
      </View>
    )
  }
}


const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff'
  }
});


