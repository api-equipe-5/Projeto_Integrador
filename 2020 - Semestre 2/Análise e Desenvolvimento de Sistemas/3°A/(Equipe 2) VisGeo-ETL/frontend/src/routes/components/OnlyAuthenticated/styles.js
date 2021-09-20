import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background: #E5E5E5;

  height: 100vh;
  width: 100vw;

  h1 {
    font-family: Quicksand;
    font-style: normal;
    font-weight: bold;
    font-size: 40px;
  }
  
  .modalUnAuthUser {
    position: absolute;
    top: 10vw;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    height: 300px;
    background: white;
    padding: 60px;
    border-radius: 20px;
  }

  .buttons {
    display: flex;
    justify-content: center;
    align-items: flex-end;

    height: 100px;

    button {
      margin: 0 10px;
      padding: 10px 30px;
      width: 180px;

      background: #51DEB8;
      border-radius: 50px;
      border: 1px solid #FFF;

      font-family: Quicksand;
      font-style: normal;
      font-weight: bold;
      font-size: 20px;
      line-height: 44px;
      text-align: center;

      color: #FFFFFF;
      transition: .6s all;
    }

    button:hover {
      background: #FFFFFF;
      border: 1px solid #51DEB8;
      color: #51DEB8;

      transition: .6s all;
    }
  }
`;