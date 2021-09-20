import { createGlobalStyle } from 'styled-components';

export default createGlobalStyle`
  * {
    margin: 0;
    padding: 0;
    outline: none !important;
    box-sizing: border-box;
  }

  body {
    background: #FFFFFF;
    -webkit-font-smoothing: antialiased;
  }

  body,
  input,
  button {
    font-family: Quicksand;
    font-weight: normal;
    font-size: 20px;
  }

  button {
    cursor: pointer;
  }

  .modal-dialog {
    display: flex;
    justify-content: center;
  }

  .ant-dropdown-menu {
    height: 250px;
    overflow: scroll;
    background: #FFFFFF;
    border: 4px solid rgba(67, 219, 178, 0.25);
    box-sizing: border-box;
    backdrop-filter: blur(4px);
    padding: 20px 10px;
    border-radius: 45px;

    ::-webkit-scrollbar, 
    ::-webkit-scrollbar-track, 
    ::-webkit-scrollbar-thumb {
      display: none;
    }
  }

  .ant-dropdown-menu-item {
    font-family: Quicksand;
    font-style: normal;
    font-weight: normal;
    font-size: 25px;
    line-height: 44px;
    text-align: center;
    border-radius: 45px;
    color: #43DBB2;
  }

  .ant-dropdown-menu-item:hover {
    background: #DFFEF6;
  }
`;
