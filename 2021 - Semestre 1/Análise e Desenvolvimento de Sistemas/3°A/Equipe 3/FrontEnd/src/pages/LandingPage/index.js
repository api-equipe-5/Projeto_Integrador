import React from 'react';
import { Carousel, Layout } from 'antd';
import * as styles from './styles';

import { Navbar } from '~/components/Navbar';

const { Header, Content } = Layout;

function LandingPage() {
  function onChange(a, b, c) {
    console.log(a, b, c);
  }

  const contentStyle = {
    height: '25rem',
    color: '#fff',
    lineHeight: '25rem',
    textAlign: 'center',
    background: '#364d79',
  };

  return (
    <Layout>
      <Header style={{ background: '#fff' }}>
        <Navbar />
      </Header>
      <Content>
        <Carousel autoplay afterChange={onChange}>
          <div>
            <h3 style={contentStyle}>1</h3>
          </div>
          <div>
            <h3 style={contentStyle}>2</h3>
          </div>
          <div>
            <h3 style={contentStyle}>3</h3>
          </div>
          <div>
            <h3 style={contentStyle}>4</h3>
          </div>
        </Carousel>

        <styles.About>
          <h1>Sobre</h1>
        </styles.About>

        <styles.WhoWeAre>
          <h1>Quem somos?</h1>
        </styles.WhoWeAre>

        <styles.Contact>
          <h1>Contato</h1>
        </styles.Contact>
      </Content>
    </Layout>
  );
}

export default LandingPage;
