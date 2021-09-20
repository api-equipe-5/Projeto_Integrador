import React from 'react';
import { Link } from 'react-router-dom';

import faker from 'faker';

import { List, Card, Rate } from 'antd';
import { FiBookOpen } from 'react-icons/fi';

import * as styles from './styles';

const data = [
  {
    id: faker.datatype.uuid(),
    title: 'Title 1',
    description: 'blá blá',
    rating: 4,
  },
  {
    id: faker.datatype.uuid(),
    title: 'Title 2',
    description: 'blá blá 2',
    rating: 4.5,
  },
  {
    id: faker.datatype.uuid(),
    title: 'Title 3',
    description: 'blá blá 3',
    rating: 5,
  },
  {
    id: faker.datatype.uuid(),
    title: 'Title 4',
    description: 'blá blá 4',
    rating: 3,
  },
];

export default function ClassesList() {
  return (
    <styles.Content>
      <List
        grid={{
          gutter: 8,
          xs: 1,
          sm: 2,
          md: 3,
          lg: 4,
          xl: 5,
          xxl: 5,
        }}
        dataSource={data}
        renderItem={(item) => (
          <List.Item>
            <Link to={`/cursoInfo/${item.id}`}>
              <Card
                style={{ textAlign: 'center', borderRadius: '10px' }}
                hoverable
                title={item.title}
              >
                <div className="icon-category">
                  <FiBookOpen />
                </div>
                {item.description}
                <br />
                <Rate disabled allowHalf defaultValue={item.rating} />
              </Card>
            </Link>
          </List.Item>
        )}
      />
    </styles.Content>
  );
}
