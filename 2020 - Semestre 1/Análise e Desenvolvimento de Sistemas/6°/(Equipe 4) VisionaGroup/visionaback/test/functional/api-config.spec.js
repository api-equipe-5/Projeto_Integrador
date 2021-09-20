'use strict';

const { test, trait } = use('Test/Suite')('Api Config');

trait('Test/ApiClient');

test('checks if the app is building', async ({ client }) => {
  const response = await client.get('api/v1').end();
  response.assertStatus(200);
  response.assertJSON({ name: 'Detector de talhões' });
});
