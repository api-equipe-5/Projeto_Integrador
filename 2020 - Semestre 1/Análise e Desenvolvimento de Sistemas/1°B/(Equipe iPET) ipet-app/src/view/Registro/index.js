import React, { useState } from 'react';
import { TextInput } from 'react-native-paper';
import { 
  StyleSheet,
  Text,
  View,
  Image,
  TouchableHighlight,
  AsyncStorage,
  ActivityIndicator
} from 'react-native';

import api from '../../services/api'

import logo from '../../../assets/logo.png'

export default function Registro({navigation}) {

    const [ name, setName ] = useState()
    const [ email, setEmail ] = useState()
    const [ password, setPassword ] = useState()
    const [ loading, setLoading ] = useState(false)

    async function register() {
        setLoading(true)
        try {
            const response = await api.post('/auth/register', {
                name,
                email,
                password
            })

            const { userId, token } = response.data;

            await AsyncStorage.multiSet ([
                ['@ipet:userId', userId],
                ['@ipet:token', token],
            ])

            navigation.push('Home')

        }   catch (error) {
            console.log(error)
            setLoading(false)
        }
      }
    

    return (
    <View style={ styles.container } >

        <Image source={logo} style= { styles.logo } />

        <TextInput 
        label = 'Nome'
        mode = 'outlined'
        style ={ styles.input }
        onChangeText={(value) => setName(value)} 

        />

        <TextInput 
        label = 'E-mail'
        mode = 'outlined'
        style ={ styles.input }
        onChangeText={(value) => setEmail(value)} 

        />

        <TextInput secureTextEntry={true} 
        label = 'Senha'
        mode = 'outlined'
        style ={ styles.input }
        onChangeText={(value) => setPassword(value)} 

        />
        {
            loading ? <ActivityIndicator size="small" color="#EF233C" style={{ marginTop:20 }} />
            : 
            <TouchableHighlight style={[ styles.btnGeneral, styles.btnRegistro ]}
            onPress={() => register()}>
                <Text style={{ color: "#FFFFFF" }}> Registrar </Text>
            </TouchableHighlight>
        }
        
    
        <Text style={ styles.text } onPress={() => navigation.push('Login')}>
            Já possui uma conta? Clique aqui!
        </Text>
    
    </View> 
    )
}

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
        marginTop: 50
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

    text: {
        textAlign: "center",
        color: "#FFFFFF",
        fontSize: 16,
        marginTop: 50
    }

});