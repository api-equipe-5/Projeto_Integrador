import { createGlobalStyle } from 'styled-components';

export default createGlobalStyle`
  @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');

  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    outline: 0;
  }

  :root {

    --primary-color: #3C8ACB;
    --secondary-color: #64C77C;
    --terciary-color: #17EAD9;
    --quartenary-color: #3969B7;
    --color-white: #ffffff;


    --color-danger: #D82143;


    --primary-initial-bg: #FFF;
    --secondary-initial-bg: #F5F5F5;


    --primary-initial-button: #3C8ACB;


    --primary-initial-text: #5F5959;
    --secondary-initial-text: #8F8F8F;
    --terciary-initial-text: #4BBF7D;


    --primary-initial-input: #D9D9D9;
  }

  html {
    @media (max-width: 1080px) {
      font-size: 93.75%;
    }

    @media (max-width: 720px) {
      font-size: 87.5%;
    }
  }

  body {
    background: var(--secondary-initial-bg);
    color: var(--primary-initial-text);
    -webkit-font-smoothing: antialised;
  }

  body, input, textarea, button {
    font-family: 'Poppins', sans-serif;
    font-weight: 400;
  }

  h1, h2, h3, h4, h5, h6, strong {
    font-weight: 600;
  }

  button {
    cursor: pointer;
    border: none;
  }

  a {
    text-decoration: none;
  }

  [disabled] {
    opacity: 0.6;
    cursor: not-allowed;
  }

  ::-webkit-scrollbar-button {
    height: 0;
    width: 0
  }
  ::-webkit-scrollbar-thumb {
    background: var(--primary-color);
    border: 8px #fff;
    border-radius: 10px
  }
  ::-webkit-scrollbar-thumb:hover {
    background: #9aaabe
  }
  ::-webkit-scrollbar-thumb:active {
    background: #9aaabe
  }
  ::-webkit-scrollbar-track {
    background: #d9e3f0;
    border: 9px #fff;
    border-radius: 10px;
    margin: 6px 0
  }
  ::-webkit-scrollbar-track:hover {
    background: #d9e3f0
  }
  ::-webkit-scrollbar-track:active {
    background: #d9e3f0
  }

  ::-webkit-scrollbar-corner {
    background: 0 0
  }

  ::-webkit-scrollbar {
    height: 8px;
    width: 8px
  }
`;
