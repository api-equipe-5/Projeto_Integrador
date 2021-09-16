import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Linking} from 'react-native';
import MapView, { Marker } from 'react-native-maps';

export default class App extends Component {
 
  constructor(props){
    super(props);
    this.state = {
      region:{
        latitude:-23.2133576,
        longitude:-45.8859015,
        latitudeDelta:0.0922,
        longitudeDelta:0.0421       
      },
      markers:[
        {key: 1, coords:{latitude:-23.2055363,longitude:-45.9051972},pinColor:'#2c5f99', titulo: 'Hotel Ibis Colinas', deion: 'Preço: R$ 194,00 reais'},
        {key: 2, coords:{latitude:-23.20287413,longitude:-45.8852426},pinColor:'#2c5f99', titulo: 'Hotel Nacional Inn - SJC', deion:'Preço: R$ 171,00 reais' },
        {key: 3, coords:{latitude:-23.2140487,longitude:-45.8933824},  pinColor:'#2c5f99', titulo: 'Ibis São José dos Campos Dutra' , deion:'Preço: R$ 124,00 reais'},
		    {key: 4, coords:{latitude:-23.2056745,longitude:-45.8855952}, pinColor:'#2c5f99', titulo: 'Novotel São José dos Campos', deion:'Preço: R$ 225 reais' },
		    {key: 5, coords:{latitude:-23.205553,longitude:-45.9073524}, pinColor:'#2c5f99', titulo: 'Mercure São José dos Campos Hotel', deion:'Preço: R$ 212,00 reais '  },
		    {key: 6, coords:{latitude:-23.1814175,longitude:-45.9516793}, pinColor:'#2c5f99', titulo: 'Cynn Hotels', deion:'Preço: R$ 89,00'   },
		    {key: 7, coords:{latitude:-23.1775385,longitude:-45.8367423}, pinColor:'#2c5f99', titulo: 'Blanco Palace Hotel', deion:'Preço: R$ 129,00 reais '    },
        {key: 8, coords:{latitude:-23.2148217,longitude:-45.909358}, pinColor:'#2c5f99', titulo: 'Mondrian Suite Hotel', deion:'Preço: R$ 329,00 reais'},
        {key: 9, coords:{latitude:-23.1889319,longitude:-45.8789118}, pinColor:'#2c5f99', titulo: 'Plaza Hotel São José dos Campos', deion:'Preço: R$ 97,00 reais'},
        {key: 10, coords:{latitude:-23.1844463,longitude:-45.8539998}, pinColor:'#2c5f99', titulo: 'Di Giulio Hotel', deion:'Preço: R$ 104,00 reais'},
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
  },

});