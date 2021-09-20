import React, { useState } from 'react';
import {StyleSheet, TouchableHighlight, View, Image, Text, AsyncStorage, ActivityIndicator} from 'react-native'
import { TextInput } from 'react-native-paper';
import logo from '../../../assets/logo.png'
import api from '../../services/api';

export default function Login({navigation}) {

  const [ email, setEmail ] = useState();
  const [ password, setPassword ] = useState();
  const [ loading, setLoading ] = useState(false)

  async function auth() {
    setLoading(true)
    try {
      const response = await api.post('auth/login', {
        email,
        password
      })

      const { userId, token } = response.data;

      await AsyncStorage.multiSet([
        ['@ipet:userId', userId],
        ['@ipet:token', token]
      ])

      navigation.push('Home')

    } catch (error) {
      console.log(error)
      setLoading(false)
    }
  }
    return (
        <View style={styles.container}>
            <Image source={logo} style={ styles.logo } />

            <TextInput style={styles.email}
            label="E-mail"
            mode="outlined" 
            onChangeText={(value) => setEmail(value)}
            >
            </TextInput>
            

            <TextInput style={styles.senha}
            label="Senha"
            mode="outlined" 
            secureTextEntry={true} 
            onChangeText={(value) => setPassword(value)}
            >
            </TextInput>

            {
              loading ? <ActivityIndicator size="small" color="#EF233C" style={{ marginTop:20 }} />
              : 
              <TouchableHighlight style={[ styles.btnGeneral, styles.btnEntrar ]}
              onPress={() => auth()}>
                  <Text style={{ color: "#FFFFFF", fontSize: 18 }}> Entrar </Text>
              </TouchableHighlight>
            }

            

            <Text style={ styles.textlink }
            onPress={() => navigation.push('Registro')} >
             Registrar
            </Text>
            {/** Deixando desabilitado por enquanto (Gmail tá bloqueando nossos emails)
            <Text style={ styles.textlink }
            onPress={() => navigation.push('Forgot')}>
             Esqueceu sua senha?
            </Text>
            */}
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
  
    email: {
        width: "90%",
        height: 47,
        marginTop: 30,
      textAlign: "center",
      color: "#FFFFFF",
      fontSize: 18,
    },

    senha: {
        width: "90%",
        height: 47,
        marginTop: 10,
      textAlign: "center",
      color: "#FFFFFF",
      fontSize: 18,
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
        marginTop: 50,
        backgroundColor: "#EF233C",
        marginBottom: 10,
    },
  
    textlink: {
        marginTop: 8,
        textAlign: "center",
        color: "#FFFFFF",
        fontSize: 16,
        
    },
  
  });
