import styled from 'styled-components';

export const Container = styled.div`
  height: 100vh;
  max-height: 700px;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;

  h1 {
    font-family: Quicksand;
    font-style: normal;
    font-weight: bold;
    font-size: 40px;
    line-height: 50px;
    text-align: center;

    color: #43DBB2;
  }

  .ant-spin-dot-item {
    background-color: #43DBB2;
  }

  section {
    width: 621px;
    height: 446px;
    overflow: scroll;
    background: #FFFFFF;
    border: 4px solid rgba(67, 219, 178, 0.25);
    box-sizing: border-box;
    backdrop-filter: blur(4px);

    border-radius: 50px;

    ::-webkit-scrollbar, 
    ::-webkit-scrollbar-track, 
    ::-webkit-scrollbar-thumb {
      display: none;
    }

    ul {
      display: flex;
      flex-direction: column;
      align-items: center;

      li {
        margin: 10px 0px;
        list-style-type: none;
        font-family: Quicksand;
        font-style: normal;
        font-weight: normal;
        font-size: 35px;
        line-height: 44px;
        text-align: center;

        color: #43DBB2;

        cursor: pointer;
      }
    }
  }

  button {
    width: 219px;
    height: 76px;
    border: none;
    background: #43DBB2;
    border-radius: 50px;

    font-family: Quicksand;
    font-style: normal;
    font-weight: bold;
    font-size: 30px;
    line-height: 37px;
    text-align: center;

    color: #FFFFFF;
  }

`;
