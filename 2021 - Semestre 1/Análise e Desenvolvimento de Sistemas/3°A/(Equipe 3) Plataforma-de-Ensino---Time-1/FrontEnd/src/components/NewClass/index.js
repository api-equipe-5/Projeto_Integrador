import React from 'react';

import { Form, Input, Button, Card, Select } from 'antd';

import * as styles from './styles';

export default function NewClass() {
  const onFinish = (values) => {
    console.log('Success:', values);
  };

  const onFinishFailed = (errorInfo) => {
    console.log('Failed:', errorInfo);
  };

  return (
    <styles.Content>
      <Form
        name="basic"
        layout="vertical"
        initialValues={{
          remember: true,
        }}
        onFinish={onFinish}
        onFinishFailed={onFinishFailed}
      >
        <Card title="Dados do curso" style={{ width: '100%' }} bordered={false}>
          <Form.Item
            label="Nome do Curso:"
            name="courseName"
            style={{
              display: 'inline-block',
              width: '50%',
            }}
            rules={[
              {
                required: true,
                message: 'Por favor insira o nome do curso!',
              },
            ]}
          >
            <Input />
          </Form.Item>

          <Form.Item
            label="Categoria do Curso:"
            name="courseCategory"
            style={{
              display: 'inline-block',
              width: 'calc(50% - 8px)',
              marginLeft: '8px',
            }}
            rules={[
              {
                required: true,
                message: 'Por favor insira a categoria do curso!',
              },
            ]}
          >
            <Select>
              <Select.Option value="Bio">Biologia</Select.Option>
              <Select.Option value="Math">Matemática</Select.Option>
              <Select.Option value="Tech">Tecnologia</Select.Option>
            </Select>
          </Form.Item>

          <Form.Item
            label="Descrição do Curso:"
            name="couseDescription"
            style={{
              display: 'inline-block',
              width: '100%',
            }}
            rules={[
              {
                required: true,
                message: 'Por favor insira a descrição do curso!',
              },
            ]}
          >
            <Input.TextArea rows={2} />
          </Form.Item>
        </Card>

        {/* <Card
          title="Imagens do curso"
          style={{ width: '100%' }}
          bordered={false}
        > */}
        <Form.Item>
          <Button type="primary" htmlType="submit">
            Criar
          </Button>
        </Form.Item>
        {/* </Card> */}
      </Form>
    </styles.Content>
  );
}
