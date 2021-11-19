import React from 'react';
// import { useParams } from 'react-router-dom';

import { Layout, Row, Col, Breadcrumb } from 'antd';

import PrivateNavbar from '~/components/PrivateNavbar';
import ClassesInfo from '~/components/ClasseInfo';
import { useAuth } from '~/hooks/AuthContext';

const { Header, Content } = Layout;

export default function CursoInfo() {
  const { user } = useAuth();
  // const { idCurso } = useParams();

  return (
    <Layout style={{ height: '100vh' }} className="layout">
      <Header style={{ background: '#fff' }}>
        <PrivateNavbar />
      </Header>
      <Content style={{ padding: '0 50px' }}>
        <Row>
          <Col span="2" />
          <Col span="20">
            <Breadcrumb style={{ margin: '16px 0' }}>
              <Breadcrumb.Item>
                {user.isStudent === 'aluno' ? 'Aluno' : 'Professor'}
              </Breadcrumb.Item>
              <Breadcrumb.Item>Informações do Curso</Breadcrumb.Item>
            </Breadcrumb>
            <ClassesInfo />
          </Col>
          <Col span="2" />
        </Row>
      </Content>
    </Layout>
  );
}
