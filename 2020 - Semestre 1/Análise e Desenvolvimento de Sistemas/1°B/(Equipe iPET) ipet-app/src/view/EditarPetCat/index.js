import React, { useState, useEffect } from 'react';
import { 
    StyleSheet,
    Text,
    ScrollView,
    View,
    TouchableHighlight
    } from 'react-native';
     
    import { TextInput } from 'react-native-paper';
     
    export default function App() {
      return (
        <ScrollView style={styles.container}>
            <View style={{ justifyContent: 'center', alignItems: 'center' }}>
                <TextInput style={{ backgroundColor:'#8D99AE', borderColor: '#FFFFFF', width: '90%' }}
                label="Nome do Pet"
                mode="outlined"
                />
     
                <TextInput style={{ backgroundColor:'#8D99AE', borderColor: '#FFFFFF', width: '90%' }}
                label="Tipo (Cão ou Gato)"
                mode="outlined"
                />
     
                <TextInput style={{ backgroundColor:'#8D99AE', borderColor: '#FFFFFF', width: '90%' }}
                label="Cor do Pet"
                mode="outlined"
                />
                
                <TextInput style={{ backgroundColor:'#8D99AE', borderColor: '#FFFFFF', width: '90%' }}
                label="Idade"
                mode="outlined"
                />
                
                <TextInput style={{ backgroundColor:'#8D99AE', borderColor: '#FFFFFF', width: '90%' }}
                label="Data de Nascimento"
                mode="outlined"
                />
                
                <TextInput style={{ backgroundColor:'#8D99AE', borderColor: '#FFFFFF', width: '90%' }}
                label="Raça"
                mode="outlined" 
                />
                
                <TextInput style={{ backgroundColor:'#8D99AE', borderColor: '#FFFFFF', width: '90%' }}
                label="Data de Castração"
                mode="outlined"
                />
                
                <TouchableHighlight style={[ styles.btnCadastrarPet ]}>
                <Text style={{ color:"#FFFFFF" }}> Atualizar Dados iPet </Text>
                </TouchableHighlight>
            </View>
        </ScrollView>
        );
    }
     
        const styles = StyleSheet.create({
            container: {
                flex: 1,
                backgroundColor: '#8D99AE',
                paddingTop: 20
            },
            
            btnCadastrarPet: {
            width:"90%",
            height:47,
            backgroundColor:"#EF233C",
            justifyContent:"center",
            alignItems:"center",
            borderWidth:1,
            borderColor:"#2B2D42",
            borderRadius:7,
            marginTop:10,
            marginBottom: 30
            }
        }
    );