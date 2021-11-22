import * as React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import MaterialCommunityIcons from "react-native-vector-icons/MaterialCommunityIcons";

import LoginScreen from "./views/LoginScreen";
import ConversaScreen from "./views/ConversaScreen";
import ConfiguracoesScreen from "./views/ConfiguracoesScreen";
import AtividadesScreen from "./views/AtividadesScreen";
import DocumentosScreen from "./views/DocumentosScreen";
import ConversaParticularScreen from "./views/ConversaParticularScreen"

const Stack = createStackNavigator();
const Tab = createBottomTabNavigator();
const ConversaStack = createStackNavigator();

function App() {
  const isLoggedIn = true;
  const authScreens = {
    Login: LoginScreen,
    // SignUp: SignUpScreen,
  };

  function ConversasStackScreen() {
    return (
      <ConversaStack.Navigator
        screenOptions={{
          headerShown: false,
        }}
      >
        <ConversaStack.Screen name="Conversas" component={ConversaScreen} />
        <ConversaStack.Screen name="ConversaDetail" component={ConversaParticularScreen} />
      </ConversaStack.Navigator>
    );
  }

  return (
    <NavigationContainer>
      {isLoggedIn ? (
        <Tab.Navigator>
          <Tab.Screen
            options={{
              tabBarLabel: "Conversas",
              tabBarIcon: ({ color, size }) => (
                <MaterialCommunityIcons
                  name="message"
                  color={color}
                  size={size}
                />
              ),
            }}
            name="Conversas"
            component={ConversasStackScreen}
          />
          <Tab.Screen
            options={{
              tabBarLabel: "Arquivos",
              tabBarIcon: ({ color, size }) => (
                <MaterialCommunityIcons
                  name="file-document"
                  color={color}
                  size={size}
                />
              ),
            }}
            name="Documentos"
            component={DocumentosScreen}
          />
          <Tab.Screen
            options={{
              tabBarLabel: "Atividades",
              tabBarIcon: ({ color, size }) => (
                <MaterialCommunityIcons name="bell" color={color} size={size} />
              ),
            }}
            name="Atividades"
            component={AtividadesScreen}
          />
          <Tab.Screen
            options={{
              tabBarLabel: "Configurações",
              tabBarIcon: ({ color, size }) => (
                <MaterialCommunityIcons
                  name="cellphone-settings"
                  color={color}
                  size={size}
                />
              ),
            }}
            name="Configurações"
            component={ConfiguracoesScreen}
          />
        </Tab.Navigator>
      ) : (
        <Stack.Navigator
          screenOptions={{
            headerShown: false,
          }}
        >
          {Object.entries({
            // Use some screens conditionally based on some condition
            ...authScreens,
          }).map(([name, component]) => (
            <Stack.Screen name={name} component={component} />
          ))}
        </Stack.Navigator>
      )}
      <Stack.Screen name={"Login"} component={LoginScreen} />
    </NavigationContainer>
  );
}

export default App;
