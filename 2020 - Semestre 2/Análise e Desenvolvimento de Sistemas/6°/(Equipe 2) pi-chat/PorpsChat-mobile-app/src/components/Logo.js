import React, { memo } from 'react';
import { Image, StyleSheet } from 'react-native';

const Logo = () => (
  <Image source={require('../assets/logo_teste.png')} style={styles.image} />
);

const styles = StyleSheet.create({
  image: {
    width: 150,
    height: 150,
    marginBottom: 12,
  },
});

export default memo(Logo);