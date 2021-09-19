import React from 'react';
import styled from 'styled-components';

import Banner from '../banner-adm.png'

const Div = styled.div`
padding: 100px 50px 100px 100px;
`;
const Title = styled.h1`
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@100&display=swap');
font-family: 'Montserrat', sans-serif;
color: #f0f0;
`; 
const SubTitle = styled.h3`
font-family: 'Montserrat', sans-serif;
color: #f0f0;
    `;

export default () => {

  return (
    <>
        <div style={{backgroundImage:`url(${Banner})`}}>
            <Div>
                <Title>
                    Área do administrador
                </Title>
            </Div>
            <Div>
                <SubTitle>
                    Clique nas três barrinhas no cabeçalho para acessar as opções
                </SubTitle>
            </Div>
        </div>
        
    </>
    );
}
