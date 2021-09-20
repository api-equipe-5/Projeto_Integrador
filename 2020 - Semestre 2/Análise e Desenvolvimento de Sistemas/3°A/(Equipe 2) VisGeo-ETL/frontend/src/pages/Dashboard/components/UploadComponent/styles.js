import styled from 'styled-components';
import { Button as ButtonANTD } from 'antd';
import { BsArrowRight } from 'react-icons/bs';

export const ArrowRight = styled(BsArrowRight)`
  margin-top: -2px;
`;

export const Button = styled(ButtonANTD)`
  margin-top: 30px;
  padding: 0 20px;
  width: max-content;
  height: 76px;
  border: none;
  background: #43DBB2;
  border-radius: 50px;
  font-family: Quicksand;
  font-style: normal;
  font-weight: bold;
  font-size: 25px;
  line-height: 37px;
  text-align: center;
  color: #FFFFFF;
  border: 1px solid #FFFFFF;

  &:hover {
    border: 1px solid #43DBB2;
    background: #FFFFFF;
    color: #43DBB2;
  }

  &:focus {
    border: 1px solid #43DBB2;
    background: #FFFFFF;
    color: #43DBB2;
  }
`;

export const Container = styled.div`
  width: 100%;
  justify-content: center;
  align-items: center;
  display: flex;
  flex-direction: column;

  section {
    h1 {
      font-family: Quicksand;
      font-weight: bold;
      font-size: 30px;
      line-height: 50px;
      text-align: center;

      color: #43DBB2;

    }
  }

  section + section .fields-container {
    margin-top: 70px;
  }

  .fields-container {
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;

    margin: 20px 40px;
    width: 471px;
    min-height: 352px;
    max-height: max-content;

    background: #FFFFFF;
    border: 4px solid rgba(67, 219, 178, 0.25);
    border-radius: 50px;
    box-sizing: border-box; 

    &:hover {
      border: 4px solid #33AC91;
    }

    .ant-dropdown-trigger {
      display: flex;
      flex-direction: row;
      justify-content: center;
      align-items: center;
      
      font-size: 25px;
      color: #43DBB2;
      font-weight: 600;

      &:hover {
        text-decoration: none;
        color: #33AC91;
      }

      .down-arrow-menu {
        font-size: 20px;
        margin-left: 5px;
      }
    }

    

    span.title {
      font-family: Quicksand;
      font-style: normal;
      font-weight: bold;
      font-size: 25px;
      line-height: 37px;

      cursor: pointer;

      text-align: center;
      color: #43DBB2;
    }

    span.fields {
      font-family: Quicksand;
      font-style: normal;
      font-weight: normal;
      font-size: 25px;
      line-height: 44px;
      text-align: center;
      color: #43DBB2;
    }
  }

  .fields-search-container {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;

    width: 100%;
    height: 100%;

    &:hover {
      border: none;
    }
  }

  .handle-button {
    width: 260px;
    height: 70px;

    margin-top: 50px;

    color: #FFFFFF;
    font-size: 20px;
    font-weight: 600;

    background-color: #43DBB2;
    border: none;
    border-radius: 50px;

    transition: ease-in-out 0.2s;

    &:hover {
      background-color: #33AC91;
    }
  }
`;
