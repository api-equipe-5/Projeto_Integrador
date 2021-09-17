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
        latitude:-23.2968856,
        longitude:-45.975549,
        latitudeDelta:0.0922,
        longitudeDelta:0.0421       
      },
      markers:[
        {key: 1, coords:{latitude:-23.3059113,longitude:-45.9645289},pinColor:'#2c5f99', titulo: 'ibis Jacareí', deion: 'Preço: R$ 194,00 reais'}, // Jacareí 1
        {key: 2,  coords:{latitude:-23.304581,longitude:-45.9765788},pinColor:'#2c5f99', titulo: 'America Hotel Jacareí', deion:'R$ 138,00 reais' }, // Jacareí 2
        {key: 3, coords:{latitude:-23.306249,longitude:-45.9786153},  pinColor:'#2c5f99', titulo: 'Hotel Brisa Rio' , deion:'Preço: R$ 178,00 reais'}, // Jacareí 3
		    {key: 4, coords:{latitude:-23.297728,longitude:-45.8973867}, pinColor:'#2c5f99', titulo: 'Chalé Rancho Aratama', deion:'Preço: R$ 210 reais' }, // Jacaréi 4
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
          loadingEnabled
          showsUserLocation={true}
          >

           {
             markers.map((marker)=>{
             return(
              <Marker key={marker.key} coordinate={marker.coords} title={marker.titulo} icon={marker.img} pinColor={marker.pinColor} description={marker.deion}>
                  
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
