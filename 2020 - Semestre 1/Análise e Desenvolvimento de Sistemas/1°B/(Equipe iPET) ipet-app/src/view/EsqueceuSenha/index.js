import React, { useState } from 'react';
import {StyleSheet, TouchableHighlight, View, Image, Text, AsyncStorage} from 'react-native'
import { TextInput, BottomNavigation } from 'react-native-paper';
import logo from '../../../assets/logo.png'
import api from '../../services/api';

export default function Login({navigation}) {
  
  const [ email, setEmail ] = useState()

  async function sendMail() {
    console.log(email)
    try {
      const response = await api.post('/auth/forgot_password', {
        email,
      })

    await AsyncStorage.multiSet([
      ['@ipet:email', email]
    ])
    
    navigation.push('ResetarSenha')
  
  } catch (error) {
    console.log(error)
  }
}

return (
<View style={ styles.container } >
  <Image source={logo} style={ styles.logo }>
     </Image>

  <Text style={ styles.texto }>
    Após informar seu e-mail, enviaremos uma mensagem com as instruções de como recuperar sua senha. 
    </Text>

  <TextInput 
  label = 'E-mail'
  mode = 'outlined'
  style ={ styles.input }
  onChangeText={(value) => setEmail(value)}
  />

  <TouchableHighlight style={[ styles.btnRegistro, styles.btnGeneral ]}
  onPress={() => sendMail()}>
    <Text style={{ color: "#FFFFFF" }}> Enviar e-mail </Text> 
  </TouchableHighlight>

</View>

  )}
  
const styles = StyleSheet.create({ 
  container: {
    flex: 1,
    backgroundColor: '#8D99AE',
    alignItems: 'center',
    justifyContent: 'center',
    },
  
  btnRegistro: {
    backgroundColor: "#EF233C",
    marginTop: 17
  },

  logo: {
    width: 150,
    height: 150,
    marginTop: 50
    },

  texto: {
    textAlign: "center",
    color: "#FFFFFF",
    fontSize: 16,
    marginTop: 50
    },

  input: {
    marginTop: 50,
    color: '#FFFFFF',
    fontSize: 16,
    height: 47,
    width: "90%"
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

})