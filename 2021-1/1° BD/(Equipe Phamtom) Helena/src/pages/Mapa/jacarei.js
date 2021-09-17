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
        {key: 1,  coords:{latitude:-23.3022241,longitude:-45.9741617},pinColor:'red', titulo: 'Parque dos Eucaliptos' },
        {key: 2,  coords:{latitude:-23.3005473,longitude:-45.9658306},pinColor:'red', titulo: 'Parque da Cidade' },
        {key: 3, coords:{latitude:-23.3167467,longitude:-45.964027},  pinColor:'red', titulo: 'Parque Santo Antonio' },
		    {key: 4, coords:{latitude:-23.3093813,longitude:-45.9715177}, pinColor:'red', titulo: 'Praça Jardim Liberdade' },
		    {key: 5, coords:{latitude:-23.2963263,longitude:-45.9773673}, pinColor:'red', titulo: 'Jacareí Shopping Center' },
		    {key: 6, coords:{latitude:-23.2858802,longitude:-45.9516793}, pinColor:'red', titulo: 'Havan Jacareí' },
		    {key: 7, coords:{latitude:-23.3035747,longitude:-45.9671899}, pinColor:'red', titulo: 'Promo Vale' },
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
