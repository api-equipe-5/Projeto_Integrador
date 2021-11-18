import React, { useState } from 'react';
import {StyleSheet, TouchableHighlight, View, Image, Text, AsyncStorage} from 'react-native'
import { TextInput, BottomNavigation } from 'react-native-paper';
import logo from '../../../assets/logo.png'
import api from '../../services/api';
import { registerRootComponent } from 'expo';

export default function Login({navigation}) {

  const [ email, setEmail ] = useState()
  const [ token, setToken ] = useState()
  const [ password, setPassword ] = useState()

  async function resetPassword() {
    try {
      const response = await api.post('/auth/reset_password', {
        email,
        token,
        password
      })

    navigation.push('Login')

    } catch (error) {
      console.log(error)
    }
  }

  return (

  <View style={ styles.container } >
  
    <Image source={logo} style={ styles.logo }> 
        </Image>

    <TextInput
    style ={ styles.input }
    label = 'E-mail'
    mode = 'outlined'
    onChangeText={(value) => setEmail(value)} 
        />
    
    <TextInput
    style ={ styles.input }
    label = 'Token'
    mode = 'outlined'
    onChangeText={(value) => setToken(value)}
        />
    
    <TextInput
    style ={ styles.input }
    label = 'Senha'
    mode = 'outlined'
    onChangeText={(value) => setPassword(value)}
        />

    <TouchableHighlight style={[ styles.btnRegistro, styles.btnGeneral ]}
    onChangeText={() => resetPassword()} >
        <Text style ={{ color: '#FFF' } }> Resetar </Text>
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

  btnGeneral: {
    width: "90%",
    height: 47,
    borderWidth: 1,
    borderColor: "#2B2D42",
    borderRadius: 7,
    justifyContent: "center",
    alignItems: "center"
    },
  
  btnRegistro: {
    backgroundColor: "#EF233C",
    marginTop: 17
  },
  
  logo: {
    width: 150,
    height: 150,
    marginTop: 30,
    marginBottom: 30
  },

  input: {
    marginTop: 17,
    textAlignVertical: 'center',
    color: '#FFFFFF',
    fontSize: 16,
    height: 47,
    width: "90%"

  },

  texto: {
    textAlign: "center",
    color: "#FFFFFF",
    fontSize: 16,
    marginTop: 50
  }

})