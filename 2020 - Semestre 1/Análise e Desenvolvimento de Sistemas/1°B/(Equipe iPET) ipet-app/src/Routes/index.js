import { createAppContainer } from 'react-navigation';

import { createStackNavigator } from 'react-navigation-stack';

import Home from '../view/HomeScreen';
import First from '../view/FirstScreen/first';
import Login from '../view/Login';
import Registro from '../view/Registro';
import Form from '../view/Form';
import Profile from '../view/Profile';
import Vacinas from '../view/Vacinas';
import CadVacina from '../view/CadastroVacina';
import Parasitario from '../view/Parasitario';
import CadParasitario from '../view/CadastroParasitario';
import Vermifugo from '../view/Vermifugos'
import CadVermifugo from '../view/CadastroVermifugo';
import PickAnimal from '../view/EscolhaAnimalCadastro';
import Forgot from '../view/EsqueceuSenha';
import Reset from '../view/ResetarSenha';
import Change from '../view/TrocarSenha';
import UpdateDog from '../view/EditarPetDog';
import UpdateCat from '../view/EditarPetCat';
import Disease from '../view/Form/disease';

const Routes = createAppContainer(
    createStackNavigator({
        First: {
            screen: First,
            navigationOptions: 
            {
                headerShown: false,
            }
        },
        Login: {
            screen: Login,
            navigationOptions: 
            {
                headerShown: false,
            }
        },
        Registro: {
            screen: Registro,
            navigationOptions: 
            {
                headerShown: false,
            }
        },
        Home: {
            screen: Home,
            navigationOptions: 
            {
                headerShown: false,
            }
        },
        Form: {
            screen: Form,
            navigationOptions: 
            {
                headerTitle: 'Cadastre seu Pet',
                headerShown: true,
            }
        },
        Profile: {
            screen: Profile,
            navigationOptions: 
            {
                headerTitle: 'Perfil do Pet',
                headerShown: true
            }
        },
        Vacinas: {
            screen: Vacinas,
            navigationOptions: 
            {
                headerShown: true,
            }
        },
        CadVacina: {
            screen: CadVacina,
            navigationOptions: 
            {
                headerTitle: 'Cadastro de vacina',
                headerShown: true,
            }
        },
        Parasitario: {
            screen: Parasitario,
            navigationOptions:
            {
                headerShown: true,
            },
        },
        CadParasitario: {
            screen: CadParasitario,
            navigationOptions:
            {
                headerTitle: 'Cadastro de parasitário',
                headerShown: true,
            }
        },
        Vermifugo: {
            screen: Vermifugo,
            navigationOptions:
            {
                headerShown: true,
            }
        },
        CadVermifugo: {
            screen: CadVermifugo,
            navigationOptions:
            {
                headerShown: true,
            }
        },
        PickAnimal: {
            screen: PickAnimal,
            navigationOptions:
            {
                headerTitle: 'Escolha o tipo',
                headerShown: true,
            }
        },
        Forgot: {
            screen: Forgot,
            navigationOptions:
            {
                headerTitle: 'Esqueceu sua senha?',
                headerShown: true,
            }
        },
        Reset: {
            screen: Reset,
            navigationOptions:
            {
                headerTitle: 'Cadastre uma nova senha',
                headerShown: true,
            }
        },
        Change: {
            screen: Change,
            navigationOptions:
            {
                headerShown: false,
            }
        },
        UpdateDog: {
            screen: UpdateDog,
            navigationOptions:
            {
                headerTitle: 'Atualizar informações',
                headerShown: true,
            }
        },
        UpdateCat: {
            screen: UpdateCat,
            navigationOptions:
            {
                headerTitle: 'Atualizar informações',
                headerShown: true,
            }
        },
        Disease: {
            screen: Disease,
            navigationOptions:
            {
                headerTitle: 'Exemplo de Patologias',
                headerShown: true,
            }
        }

    })
);

export default Routes;