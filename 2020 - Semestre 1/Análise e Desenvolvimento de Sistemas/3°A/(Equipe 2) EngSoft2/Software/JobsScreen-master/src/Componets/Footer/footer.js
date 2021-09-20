
import React from 'react';
import styled from 'styled-components';

import FacebookIcon from '@material-ui/icons/Facebook';
import LinkedInIcon from '@material-ui/icons/LinkedIn';
import TwitterIcon from '@material-ui/icons/Twitter';

import LogInButton from '../ActionButtons/LogInButton'

const Footer = styled.footer`
    left: 0;
    bottom: 0;
    width: 100%;
    height: auto;
    background-color: #3f51b5;
    color: white;
    text-align: center;
`;  
export default () => {

    return(
        <Footer>
            <div>
                <div style={{paddingTop:'10px'}}>
                    <FacebookIcon/>
                    <LinkedInIcon/>
                    <TwitterIcon/>
                </div>
                {window.location.pathname === '/' &&
                    <div style={{marginLeft:'80%'}}>
                        <LogInButton type={'employee'} />
                    </div>
                }
            </div>
        </Footer>
)
}