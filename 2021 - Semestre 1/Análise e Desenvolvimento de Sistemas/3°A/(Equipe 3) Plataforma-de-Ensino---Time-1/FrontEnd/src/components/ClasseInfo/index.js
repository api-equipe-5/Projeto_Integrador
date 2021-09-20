import React from 'react';

import { Tabs, Card } from 'antd';

import faker from 'faker';

import * as styles from './styles';

const { TabPane } = Tabs;

export default function ClassesInfo() {
  faker.locale = 'pt_BR';
  return (
    <styles.Content>
      <Tabs size="large" style={{ marginBottom: 32 }} defaultActiveKey="1">
        <TabPane tab="Conteúdo" key="1">
          <Card
            title={faker.address.city()}
            style={{ width: '100%' }}
            bordered={false}
          >
            <Card title="Descrição" style={{ width: '100%' }} bordered={false}>
              {faker.lorem.paragraph()}
            </Card>
          </Card>
        </TabPane>
        <TabPane tab="Alunos" key="2">
          Alunos
        </TabPane>
        <TabPane tab="Comentários" key="3">
          Comentários
        </TabPane>
      </Tabs>
    </styles.Content>
  );
}
