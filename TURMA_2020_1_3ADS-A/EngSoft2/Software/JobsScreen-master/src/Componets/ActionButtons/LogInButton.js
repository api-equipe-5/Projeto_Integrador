import React from 'react';

import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';

import swal from 'sweetalert2';

export default ({type}) =>{
    if(type === 'user') return (
        <Button style={{ backgroundColor:"white", margin:"10px"}} onClick={() => logInUser()}>
            <strong>Entrar</strong>
        </Button>
    )
    if(type === 'employee') return (
        <Button style={{ background:"transparent", margin:"10px"}} onClick={() => logInEmployee()}>
            <Typography variant="caption" display="block" gutterBottom style={{color:'#ffff'}}>Entrar como Funcionario</Typography>
        </Button>
    )
}

const logInUser = async () =>{ 
    const { value: formValues } = await swal.fire({
        title: 'LogIn',
        html:
          '<input id="email" class="swal2-input" type="email" placeholder="Email: exemple@exemple.com">' +
          '<input id="password" class="swal2-input" type="password" placeholder="Senha: ">',
        focusConfirm: false,
        preConfirm: () => {
            return 'Logado com sucesso!'
        }
    })
    if (formValues) {
        swal.fire(JSON.stringify(formValues)).then((value) => {
                if (value) window.location.replace("/vagas")
                
            })
      }
}

const logInEmployee = async () =>{ 
    const { value: formValues } = await swal.fire({
        title: 'LogIn de funcionario',
        html:
          '<input id="email" class="swal2-input" type="email" placeholder="Email Institucional: ">' +
          '<input id="password" class="swal2-input" type="password" placeholder="Senha: ">',
        focusConfirm: false,
        preConfirm: () => {
          return 'Logado com sucesso!'
        }
    })
    if (formValues) {
        swal.fire(JSON.stringify(formValues)).then((value) => {
           if (value) window.location.replace("/admin/painel")    
            })
      }
}
