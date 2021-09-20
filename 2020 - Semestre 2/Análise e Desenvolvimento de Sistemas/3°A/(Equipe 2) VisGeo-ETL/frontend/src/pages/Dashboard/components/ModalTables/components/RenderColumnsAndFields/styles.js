import styled from 'styled-components';

export const Content = styled.section`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;


  h1 {
    align-self: end;
    padding-left: 100px;
    font-size: 30px;
    font-family: Quicksand;
    font-style: normal;
    font-weight: bold;
    line-height: 37px;
    text-align: center;
    color: #ffffff;
  }

  section {
    border-radius: 50px;
    background: #FFFFFF;
    box-sizing: border-box;

    width: 80%;
    display: flex;
    height: 70px;
    margin: 10px 0px;
    
    justify-content: space-between;
    padding-left: 40px;
    align-items: center;

    span {
      font-family: Quicksand;
      font-style: normal;
      font-weight: bold;
      line-height: 37px;
      text-align: center;
      color: #2F9184;
    }

    select {
      height: 100%;
      width: 300px;
      background: #51DEB8;
      border: 4px solid #51DEB8;
      box-sizing: border-box;
      padding-left: 40px;
      border-radius: 80px;
      font-family: Quicksand;
      font-style: normal;
      font-weight: bold;
      font-size: 20px;
      line-height: 31px;
      text-align: center;
      color: #FFFFFF;      

      optgroup {
        border: none;
        border-radius: 50px;
      }

      option {
        background: #DFFEF6;
        height: 50px;
        font-size: 25px;
        border-radius: 50px;
        line-height: 44px;
        text-align: center;
        color: #43DBB2;

      } 
    }
  }
`;
