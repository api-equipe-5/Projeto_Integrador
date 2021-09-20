import React,{useState, useEffect} from 'react';
import api from '../../services/api'

import Button from '@material-ui/core/Button';

import swal from 'sweetalert2';

export default ({type}) =>{
    const style = { backgroundColor:"white", margin:"10px"}
    const [employee, setEmployee] = useState({
      name: '',
      email: '',
      passoword: ''
    })

    const [user, setUser] = useState({
      name: '',
      email: '',
      passoword: '',
      number: ''
    })

    const [job, setJob] = useState({
      position: '',
      city: '',
      segment: ''
    })

    useEffect(() => {
      if(user.name !== '')
        api.post('http://localhost:5000/api/users', {user})
    }, [user])

    useEffect(() => {
      if(employee.name !== '')
        api.post('http://localhost:5000/api/employee', {employee})
    }, [employee])

    useEffect(() => {
      if(job.position !== '')
        api.post('http://localhost:5000/api/jobs', {job})
    }, [job])

    if(type === 'user') return (
        <Button style={style} onClick={() => registerUser(setUser,user)}>
            <strong>Cadastre-se</strong>
        </Button>
    )
    if(type === 'employee') return (
      <Button style={style} onClick={() => registerEmployee(setEmployee, employee)}>
            <strong>Cadastre um funcionário</strong>
        </Button>
    )
    if(type === 'job') return (
      <Button style={style} onClick={() => registerJob(setJob, job)}>
           <strong>Cadastre uma vaga</strong>
      </Button>
    )
}

const registerUser = async (setUser,user) =>{ 
    const { value: formValues } = await swal.fire({
        title: 'Cadastro',
        html:
          '<hr style="margin:1% 30%;border-top:4px solid #3085d6;border-radius:30px"/>' +
          '<form id="registe">' +
          '<input id="name" class="swal2-input" placeholder="Nome Completo:" /> <input id="email" class="swal2-input" type="email" placeholder="Email: exemple@exemple.com"/>' +
          '<input id="password" class="swal2-input" type="password" placeholder="Senha: "/> <input id="number" class="swal2-input" type="tel" placeholder="Telefone: "> <input id="url" class="swal2-input" type="url" placeholder="Link Rede Social: "/>' +
          'Funcionário da empresa? <input id="isWorker" class="swal2-input" type="checkbox" > Currículo: <input id="curriculum" class="swal2-input" type="image" > </form>',
        focusConfirm: true,
        preConfirm: () => {
          setUser({
            name: document.getElementById('name').value,
            email: document.getElementById('email').value,
            password: document.getElementById('password').value,
            number: document.getElementById('number').value
          })
          return 'Salvo com sucesso'
        }
    })
    if (formValues) {
        swal.fire(JSON.stringify(formValues)).then((value) => {
          
                if (value) window.console.log(user)
                
            })
      }
}

const registerEmployee = async (setEmployee, employee) =>{ 
    const { value: formValues } = await swal.fire({
        title: 'Cadastro de funcionario',
        html:
          '<input id="name" class="swal2-input" placeholder="Nome Completo:" />' +
          '<input id="email" class="swal2-input" type="email" placeholder="Email Institucional: ">' +
          '<input id="password" class="swal2-input" type="password" placeholder="Senha: ">' +
          '<input id="passwordConfirm" class="swal2-input" type="password" placeholder="Confirme a Senha: ">',
        focusConfirm: false,
        preConfirm: () => {
          if (document.getElementById('password').value === document.getElementById('passwordConfirm').value){
            setEmployee({
                name: document.getElementById('name').value,
                email: document.getElementById('email').value,
                password: document.getElementById('password').value,
              })
             return ('Salvo com sucesso')
            }
            else(
            swal.showValidationMessage(
              `As senhas não são iguais`
          )
        )
          
        }
    })
    if (formValues) {
        swal.fire(JSON.stringify(formValues)).then((value) => {
                if (value) window.console.log(employee)
                
            })
      }
}

const registerJob = async (setJob, job) => {
  const { value: formValues } = await swal.fire({
    title: 'Cadastro de vaga',
    html:
      '<input id="position" class="swal2-input" placeholder="Posição: Analista de sistema, Estagiario..." />' +
      '<input id="city" class="swal2-input" placeholder="Cidade: ">' +
      '<input id="segment" class="swal2-input" placeholder="Segmento: TI, Administração... ">',
    focusConfirm: false,
    preConfirm: () => {
        setJob({
            position: document.getElementById('position').value,
            city: document.getElementById('city').value,
            segment: document.getElementById('segment').value,
            active: 1,
          })
         return ('Salvo com sucesso')
   }    
})
if (formValues) {
    swal.fire(JSON.stringify(formValues)).then((value) => {
            if (value) window.console.log(job)
            
        })
  }
}

