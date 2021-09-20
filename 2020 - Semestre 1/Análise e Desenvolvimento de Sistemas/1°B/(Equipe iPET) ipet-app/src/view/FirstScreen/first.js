import React from 'react';
import { 
  StyleSheet,
  Text,
  View,
  Image,
  TouchableHighlight
} from 'react-native';

import logo from '../../../assets/logo.png'

export default function First({navigation}) {
  return (
    <View style={styles.container}>
      <Image source={logo} style={ styles.logo } />

      <Text style={ styles.slogan }>
        O iPet é a melhor opção de gerenciamento de seus pets no mercado. Possui interface intuitiva e moderna e com ele você pode guardar todos os dados e informações importantes do seu pet, incluindo histórico de doenças, controle de vacinas, remédios parasitários e vermífugos.
          </Text>
      
      <TouchableHighlight style={ styles.btnGeneral }
      onPress={() => navigation.push('Login')}>
        <Text style={ styles.btnEntrar }> Entrar </Text>
      </TouchableHighlight> 

      <TouchableHighlight style={[ styles.btnGeneral, styles.btnRegistrar ]}
      onPress={() => navigation.push('Registro')}>
        <Text style={{ color: "#FFFFFF" }}> Registre-se </Text>
      </TouchableHighlight>
    </View>
  );
}


const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#8D99AE',
    alignItems: 'center',
    justifyContent: 'center',
  },

  logo: {
    width: 150,
    height: 150,
    marginTop: 50
  },

  slogan: {
    textAlign: "center",
    color: "#FFFFFF",
    fontSize: 16,
    marginTop: 50,
    marginBottom: 120
  },

  btnGeneral: {
    width: "90%",
    height: 47,
    borderWidth: 1,
    borderColor: "#2B2D42",
    borderRadius: 7,
    justifyContent: "center",
    alignItems: "center"
  },

  btnEntrar: {
    color: "#2B2D42"
  },

  btnRegistrar: {
    backgroundColor: "#EF233C",
    marginTop: 10
  }

});
