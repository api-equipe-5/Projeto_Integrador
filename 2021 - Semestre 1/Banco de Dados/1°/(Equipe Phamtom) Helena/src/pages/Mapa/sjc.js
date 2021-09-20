import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Linking} from 'react-native';
import MapView, { Marker } from 'react-native-maps';

/*
SP: -23.5492243   -46.5813785
DF: -15.8080374  -47.8750231
CG: -20.4695225 -54.6016767
*/
export default class App extends Component {
  constructor(props){
    super(props);
    this.state = {
      region:{
        latitude:-23.1791,
        longitude:-45.8872,
        latitudeDelta:0.0922,
        longitudeDelta:0.0421       
      },
      markers:[
        {key: 1,  coords:{latitude:-23.1878222,longitude:-45.8886825}, pinColor:'red', titulo: 'Banhado' },
        {key: 2,  coords:{latitude:-23.206598,longitude:-45.9528229}, pinColor:'red', titulo: 'Parque Técnológico - Univap' },
        {key: 3, coords:{latitude:-23.1715639,longitude:-45.8899985}, pinColor:'red', titulo: 'Parque Roberto Burle' },
		    {key: 4, coords:{latitude:-23.1808672,longitude:-45.886671}, pinColor:'red', titulo: 'Mercado Municipal' },
		    {key: 5, coords:{latitude:-23.1973739,longitude:-45.8974538}, pinColor:'red', titulo: 'Parque Vicentina Aranha' },
		    {key: 6, coords:{latitude:-23.1999426,longitude:-45.8921348}, pinColor:'red', titulo: 'Parque Santos Dumont' },
		    {key: 7, coords:{latitude:-23.217603,longitude:-45.906459}, pinColor:'red', titulo: 'Parque Ulisses Guimarães' },
		    {key: 8, coords:{latitude:-23.1982065,longitude:-45.8883887}, pinColor:'red', titulo: 'Catedral São Dimas' },
		    {key: 9, coords:{latitude:-23.1843083,longitude:-45.8876614}, pinColor:'red', titulo: 'Praça Afonso Pena' },
		    {key: 10, coords:{latitude:-23.1635173,longitude:-45.9115702}, pinColor:'red', titulo: 'Parque Alberto Simões'},
        {key: 11, coords:{latitude:-23.184143,longitude:-45.886032}, pinColor:'red', titulo: 'Shopping Centro' },
        {key: 12, coords:{latitude:-23.2240803,longitude:-45.8904532}, pinColor:'red', titulo: 'Poliesportivo João do Pulo' },
        {key: 13, coords:{latitude:-23.2040676,longitude:-45.8719407}, pinColor:'red', titulo: 'CTA-Centro Tecnológico Aeroespacial' },
        {key: 14, coords:{latitude:-23.199733,longitude:-45.8815116}, pinColor:'red', titulo: 'Center Vale Shopping' },
        {key: 15, coords:{latitude:-23.1888111,longitude:-45.8710917}, pinColor:'red', titulo: 'Estádio Martins Pereira' },
        {key: 16, coords:{latitude:-23.2545217,longitude:-45.91215}, pinColor:'red', titulo: 'Estádio do Vale do Sol' },
        {key: 17, coords:{latitude:-23.2319122,longitude:-45.9206268}, pinColor:'red', titulo: 'Parque Jardim das Indústrias' },
        {key: 18, coords:{latitude:-23.2173773,longitude:-45.8916944}, pinColor:'red', titulo: 'Vale Sul Shopping' },
        {key: 19, coords:{latitude:-23.2468037,longitude:-45.8597202}, pinColor:'red', titulo: 'Aeroclube de São José dos Campos' },
        {key: 20, coords:{latitude:-23.2249204,longitude:-45.8615235}, pinColor:'red', titulo: 'Aeroporto Internacional Professor Urbano Ernesto Stumpf' },
        {key: 21, coords:{latitude:-23.2041192,longitude:-45.9087384}, pinColor:'red', titulo: 'Colinas Shopping' },
        {key: 22, coords:{latitude:-23.2051407,longitude:-45.9060625}, pinColor:'red', titulo: 'Ponte Estaiada' },
        {key: 23, coords:{latitude:-23.2049782,longitude:-45.9055628}, pinColor:'red', titulo: 'Chaparral' },
        {key: 24, coords:{latitude:-23.2015123,longitude:-45.8998814}, pinColor:'red', titulo: 'Praça Prof. Flávio R. Craveiro' },
        {key: 25, coords:{latitude:-23.1929601,longitude:-45.7922967}, pinColor:'red', titulo: 'Centro Poliesportivo José Carlos das Neves' },
        {key: 26, coords:{latitude:-23.2734801,longitude:-45.8654406}, pinColor:'red', titulo: 'Centro Esportivo - Parque Interlagos' },
        {key: 27, coords:{latitude:-23.2724482,longitude:-45.8640597}, pinColor:'red', titulo: 'Praça Ayrton Senna da Silva' },
        {key: 28, coords:{latitude:-23.2736377,longitude:-45.8631923}, pinColor:'red', titulo: 'Lago do interlagos' },
      ]
    };

  }

  render() {
    const {region, markers} = this.state;

    return (
      <View style={styles.container}>
        <Text>{region.latitude} | {region.longitude}</Text>

        <MapView
          style={styles.mapa}
          region={region}
          showsUserLocation
          >
          
           {
             markers.map((marker)=>{
             return(
                <Marker key={marker.key} coordinate={marker.coords} title={marker.titulo} icon={marker.img} >
                  
                </Marker>

             );
           })
           }       

        </MapView>

      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  mapa:{
    width:'100%',
    height:'100%',
    marginTop: 15
  }
});
