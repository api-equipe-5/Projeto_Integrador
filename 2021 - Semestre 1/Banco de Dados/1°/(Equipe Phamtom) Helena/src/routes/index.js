import React from 'react';

import {NavigationContainer} from '@react-navigation/native';
import {createStackNavigator} from '@react-navigation/stack';

import Main from '../pages/Main';
import BoasVindas from '../pages/BoasVindas';
import Pergunta from '../pages/Pergunta';
import ListaFuncoes from '../pages/ListaFuncoes';
import {navigationRef} from '../RootNavigation';

import exePontosTuristicos from '../pages/TelasFuncoes/exePontosTuristicos';
import exeOndeEstou from '../pages/TelasFuncoes/exeOndeEstou';
import exePrecoHoteis from '../pages/TelasFuncoes/exePrecoHoteis';
import exeRoteiro from '../pages/TelasFuncoes/exeRoteiro';
import exeClimaAtual from '../pages/TelasFuncoes/exeClimaAtual';
import exeSaibaMais from '../pages/TelasFuncoes/exeSaibaMais';
import exeTradutor from '../pages/TelasFuncoes/exeTradutor';
import exeConversorMedidas from '../pages/TelasFuncoes/exeConversorMedidas';
import exeConversorMoedas from '../pages/TelasFuncoes/exeConversorMoedas';
import construcao from '../pages/TelasFuncoes/construcao';

import FotoMapa from '../pages/TelasFuncoes/fotoMapa';
import NumeroRecepcao from '../pages/TelasFuncoes/numeroRecepcao';
import Previsao from '../pages/TelasFuncoes/previsao';

import MapaSJC from '../pages/Mapa/sjc';
import MapaJacarei from '../pages/Mapa/jacarei';
import ConversorMoedas from '../pages/ConversorMoedas';
import Calculadora from '../pages/Calculadora';
import RoteiroPessoal from '../pages/RoteiroPessoal/index';
import Weahter from '../components/index';
import Localizacao from '../pages/Localizacao/index';
import PontosTuristicos from '../pages/PontosTuristicos';
import Teste from '../pages/Teste';
import Tradutor from '../pages/Tradutor';
import ConversorMedidas from '../pages/ConversorMedidas';
import Hotel from '../pages/Hotel';
import JacareiPreco from '../pages/HotelPreco/jacareipreco';
import SjcPreco from '../pages/HotelPreco/sjcpreco';
import PlazaHotel from '../pages/HotelPreco/Sjc/plaza';
import NovoHotel from '../pages/HotelPreco/Sjc/novohotel';
import ibisSjc from '../pages/HotelPreco/Sjc/ibissjc';

import SaibaMais from '../pages/SaibaMais';
import SobreSJCampos from '../pages/SaibaMaisCidades/sobreSJCampos';


const Stack = createStackNavigator();

export default function Routes() {
  return (
    <NavigationContainer ref={navigationRef}>
      <Stack.Navigator
        screenOptions={{
          cardStyle: {
            backgroundColor: '#4c1482',
          },
          headerTransparent: true,
          headerTitle: '',
          headerTintColor: '#FFFFFF',
        }}>
        <Stack.Screen
          name="Home"
          component={Main}
          options={{headerShown: true}}
        />
        <Stack.Screen
          name="JacareiPreco"
          component={JacareiPreco}
          options={{headerShown: true}}
        />
        <Stack.Screen
          name="NovoHotel"
          component={NovoHotel}
          options={{headerShown: true}}
        />
        <Stack.Screen
          name="SjcPreco"
          component={SjcPreco}
          options={{headerShown: true}}
        />
        <Stack.Screen
          name="PlazaHotel"
          component={PlazaHotel}
          options={{headerShown: true}}
        />
        <Stack.Screen
          name="ibisSjc"
          component={ibisSjc}
          options={{headerShown: true}}
        />
        <Stack.Screen
          name="Hotel"
          component={Hotel}
          options={{headerShown: true}}
        />
        <Stack.Screen
          name="Pontos Turisticos"
          component={PontosTuristicos}
          options={{headerShown: true}}
        />
        <Stack.Screen
          name="Teste"
          component={Teste}
          options={{headerShown: true}}
        />
        <Stack.Screen
          name="Tradutor"
          component={Tradutor}
          options={{headerShown: true}}
        />
        <Stack.Screen name="Pergunta" component={Pergunta} />
        <Stack.Screen
          name="ListaFuncoes"
          component={ListaFuncoes}
          option={{headerShown: true}}

        />
        <Stack.Screen
          name="Localizacao"
          component={Localizacao}
          option={{headerShown: true}}
        />

        <Stack.Screen
          name="exeRoteiro"
          component={exeRoteiro}
          options={{
            headerShown: true,
          }}
        />

        <Stack.Screen
          name="exePontosTuristicos"
          component={exePontosTuristicos}
          options={{
            headerShown: true,
          }}
        />

        <Stack.Screen
          name="exeOndeEstou"
          component={exeOndeEstou}
          options={{
            headerShown: true,
          }}
        />

        <Stack.Screen
          name="exePrecoHoteis"
          component={exePrecoHoteis}
          options={{
            headerShown: true,
          }}
        />
        <Stack.Screen
          name="exeTradutor"
          component={exeTradutor}
          options={{
            headerShown: true,
          }}
        />

        <Stack.Screen
          name="exeClimaAtual"
          component={exeClimaAtual}
          options={{
            headerShown: true,
          }}
        />

        <Stack.Screen
          name="exeSaibaMais"
          component={exeSaibaMais}
          options={{
            headerShown: true,
          }}
        />

        <Stack.Screen
          name="exeConversorMedidas"
          component={exeConversorMedidas}
          options={{
            headerShown: true,
          }}
        />

        <Stack.Screen
          name="exeConversorMoedas"
          component={exeConversorMoedas}
          options={{
            headerShown: true,
          }}
        />

        <Stack.Screen
          name="Weather"
          component={Weahter}
          options={{
            headerShown: true,
          }}
        />

        <Stack.Screen
          name="construcao"
          component={construcao}
          options={{
            headerShown: true,
          }}
        />
        
        <Stack.Screen
          name="FotoMapa"
          component={FotoMapa}
          options={{
            headerShown: true,
          }}
        />
        
        <Stack.Screen
          name="NumeroRecepcao"
          component={NumeroRecepcao}
          options={{
            headerShown: true,
          }}
        />
        <Stack.Screen
          name="Previsao"
          component={Previsao}
          options={{
            headerShown: true,
          }}
        />
        
        <Stack.Screen
          name="MapaSJC"
          component={MapaSJC}
          options={{
            headerShown: true,
          }}
        />

        <Stack.Screen
          name="MapaJacarei"
          component={MapaJacarei}
          options={{
            headerShown: true,
          }}
        />
        <Stack.Screen
          name="ConversorMoedas"
          component={ConversorMoedas}
          options={{
            headerShown: true,
          }}
        />
        <Stack.Screen
          name="Calculadora"
          component={Calculadora}
          options={{headerShown: true}}
        />
        <Stack.Screen
          name="BoasVindas" 
          component={BoasVindas} 
        />
        <Stack.Screen
          name="RoteiroPessoal" 
          component={RoteiroPessoal} 
        />
        <Stack.Screen
          name="SaibaMais" 
          component={SaibaMais}
          options={{headerShown: true}}
        />
        <Stack.Screen
          name="sobreSJCampos" 
          component={SobreSJCampos} 
          options={{headerShown: true}}
        />

       <Stack.Screen
          name="ConversorMedidas"
          component={ConversorMedidas}
          options={{
            headerShown: true,
          }}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
