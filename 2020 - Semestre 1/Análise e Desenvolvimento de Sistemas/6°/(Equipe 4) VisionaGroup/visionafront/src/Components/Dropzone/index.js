import React, { useCallback, useState } from 'react';
import { useDropzone } from 'react-dropzone';
import './style.scss';

const Dropzone = (props) => {
  const [files, setFiles] = useState([]);
  const { onGetFile = () => {}, mimeTypes = [] } = props;
  const onDrop = useCallback((acceptedFiles) => {
    setFiles(acceptedFiles);
    onGetFile(acceptedFiles);
  }, []);
  const { getRootProps, getInputProps } = useDropzone({
    onDrop,
    accept: mimeTypes.join(', '),
  });

  return (
    <div {...getRootProps()} className="DropzoneComponent">
      <input {...getInputProps()} />
      <p>
        Arraste e solte alguns arquivos aqui ou clique para selecionar os
        arquivos
      </p>
      <br />
      <ul>
        {files.map((f) => (
          <li key={f.name}>{f.name}</li>
        ))}
      </ul>
    </div>
  );
};
export default Dropzone;
