import axios from 'axios';

const API_URL = process.env.REACT_APP_API_URL;
const api = axios.create({
  baseURL: API_URL,
});

export const getCatalog = async ({
  dateInit,
  dateEnd,
  cloudCover,
  page = 1,
  bbox,
} = {}) => {
  const response = await api.get('api/v1/catalog', {
    params: { dateInit, dateEnd, cloudCover, page, bbox },
  });

  return response;
};

export const postCatalog = async ({
  dateInit,
  dateEnd,
  cloudCover,
  page = 1,
  geojson,
} = {}) => {
  const response = await api.post('api/v1/catalog/geojson', {
    dateInit,
    dateEnd,
    cloudCover,
    page,
    geojson,
  });
  return response;
};

export const postIds = async ({ dateInit, dateEnd, cloudCover, ids } = {}) => {
  const response = await api.post('api/v1/prepare-train', {
    dateInit,
    dateEnd,
    cloudCover,
    ids,
  });
  return response;
};
