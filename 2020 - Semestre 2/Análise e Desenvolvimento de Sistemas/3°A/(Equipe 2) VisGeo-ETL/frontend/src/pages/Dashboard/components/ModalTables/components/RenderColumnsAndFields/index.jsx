import React from 'react';

import { Content } from './styles';

const RenderColumnsAndFields = ({ columns, fields }) => (
  <Content>
    <>
      <h1>Colunas</h1>
      {columns.map((column) => (
        <section>
          <span>
            {column}
          </span>

          <select
            id={column}
            name="teste"
            title="teste"
          >
            <>
              <option>
                Escolha um campo
              </option>
              {fields.map((item) => (
                <option key={item} value={item}>
                  {item}
                </option>
              ))}
            </>
          </select>
        </section>
      ))}
    </>
  </Content>
);

export default RenderColumnsAndFields;
