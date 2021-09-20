import styled from 'styled-components';

import { RiUploadCloud2Line } from 'react-icons/ri';
import { BsSearch } from 'react-icons/bs';

export const Container = styled.div`
  width: 100%;

  .upload-container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;

    margin: 40px;
    width: 350px;
    height: max-content;

    .dragger-props-custom {
      border: none;
      background: transparent;
    }

    button.upload-dash {
      margin: 16.5px 0px;
    }

    .upload-dash {
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      align-items: center;

      width: 100%;
      height: 250px;
      
      padding-top: 35px;
      padding-bottom: 35px;

      background: #FFFFFF;
      border: 4px solid rgba(67, 219, 178, 0.25);
      border-radius: 50px;

      cursor: pointer;
      transition: ease-in-out 0.2s;

      .search-desc {
        margin-bottom: 20px;
      }
      
      .upload-desc {
        text-align: center;

        font-size: 20px;
        font-weight: 600;
        color: rgba(67, 219, 178, 0.25);

        transition: ease-in-out 0.2s;
      }

      &:hover {
        border: 4px dashed #33AC91;

        .upload-icon {
          color: #33AC91;
        }

        .upload-desc {
          color: #33AC91;
        }
      }
    }

    .handle-button {
      width: 200px;
      height: 45px;

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
  }

  .upload-search-container {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;

    width: 100%;
    height: 100%;

    padding-right: 250px;
    padding-left: 250px;

    .search-dash {
      border: 4px solid rgba(67, 219, 178, 0.25);

      &:hover {
        border: 4px solid #33AC91 !important;
      }
      
    }
  }
`;

export const UploadIcon = styled(RiUploadCloud2Line)`
  font-size: 100px;
  color: rgba(67, 219, 178, 0.25);

  transition: ease-in-out 0.2s;
`;

export const SearchIcon = styled(BsSearch)`
  font-size: 80px;
  color: rgba(67, 219, 178, 0.25);

  transition: ease-in-out 0.2s;
`;
