import React from 'react';
import styled from 'styled-components';

import Banner from './banner-principal.png'
import RegisterButton from './ActionButtons/RegisterButton'

const Div = styled.div`
padding: 100px 50px 100px 100px;
`;
const Title = styled.h1`
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@100&display=swap');
font-family: 'Montserrat', sans-serif;
color: #fff;
`; 
const SubTitle = styled.h3`
font-family: 'Montserrat', sans-serif;
color: #fff;
    `;

export default () => {

    const Spam = ({ text1, text2 }) => (
        <div>
            <Title>
                {text1}
            </Title>
            <SubTitle>
                {text2}
            </SubTitle>
        </div>
    )

  return (
    <>
        <div style={{backgroundImage:`url(${Banner})`}}>
            <Div>
                <Spam text1={'Processo Seletivos '} text2={'Realize seu cadastro e participe das etapas online!'} />
            </Div>
            <Div>
                    <RegisterButton type={'user'} />
            </Div>
        </div>
        
    </>
    );
}
