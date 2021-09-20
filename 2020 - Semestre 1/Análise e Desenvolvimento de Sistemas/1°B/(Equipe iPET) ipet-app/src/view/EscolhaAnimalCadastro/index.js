import React, { useEffect, useState } from 'react'
import {
    View,
    Text,
    ScrollView,
    TouchableHighlight,
    StyleSheet,
    AsyncStorage,
    Image 
} from 'react-native'
import { AntDesign } from '@expo/vector-icons';
import styled from 'styled-components/native';
import { Container, Header, Left, Body, Title } from 'native-base'
import cat from '../../../assets/cat.png'
import dog from '../../../assets/dog.png'

export default function Home({ navigation }) {

    const [ pets, setPet ] = useState([])

    return (

        <Container style={[{ marginTop: 0 }], styles.container}>
                <Row>
                    
                            <Box style={{ alignItems: "center" }} 
                            onPress={() => navigation.push('Form', { animal: 'Gato' })}
                            >
                                <Image source={cat} style={ styles.logo } />
                            </Box>

                            <Box style={{ alignItems : 'center' }} 
                            onPress={() => navigation.push('Form', { animal: 'Cão' })}
                            >
                                <Image source={dog} style={ styles.logo } />
                            </Box>
                    
                    
                </Row>
        </Container>    

    )
}


const Box = styled.TouchableHighlight`
    background-color: #FFFFFF;
    width: 100%;
    height: 170px;
    border-radius: 7px;
    box-shadow: 5px 5px 5px rgba(0,0,0,0.24);
    justify-content: center;
    margin-bottom: 20px
    
`;

const Row = styled.View`
    display: flex;
    flex-direction: column;
    width: 42%;
`;

const AddButton = styled.TouchableHighlight`
        align-items: center;
        justify-content: center;
        width: 70px;                                     
        bottom: 70px;                                            
        right: 20px;
        height: 70px;
        background-color: #FFFFFF;
        border-radius: 100px;
        box-shadow: 2px 2px 2px rgba(0,0,0,0.24);
`;


const styles = StyleSheet.create({
    container: {
        backgroundColor: "#8D99AE",
        padding: "3%",
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
    },
    petName: { 
        textAlign: 'center', 
        marginTop: 10 
    },
    logo: {
        width: 70,
        height: 70,
        marginBottom: 10
    }
});