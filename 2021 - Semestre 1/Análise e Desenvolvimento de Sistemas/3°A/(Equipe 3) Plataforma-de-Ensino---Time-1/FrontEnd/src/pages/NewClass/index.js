import React from 'react';

import { Layout, Breadcrumb, Row, Col } from 'antd';
import PrivateNavbar from '../../components/PrivateNavbar';
import NewClass from '~/components/NewClass';
import { useAuth } from '~/hooks/AuthContext';

const { Header, Content } = Layout;

function NewClassPage() {
  const { user } = useAuth();

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
              <Breadcrumb.Item>Novo Curso</Breadcrumb.Item>
            </Breadcrumb>
            <NewClass />
          </Col>
          <Col span="2" />
        </Row>
      </Content>
    </Layout>
  );
}

export default NewClassPage;
